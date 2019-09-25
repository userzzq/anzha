package com.cdxp1688.dataservice.service.impl;

import java.io.OutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cdxp1688.dataservice.base.ConstValues;
import com.cdxp1688.dataservice.dao.TbWorkerDAO;
import com.cdxp1688.dataservice.dao.TbWorkerTypeDAO;
import com.cdxp1688.dataservice.dao.UtilsDAO;
import com.cdxp1688.dataservice.entity.TbTokenInfo;
import com.cdxp1688.dataservice.entity.TbWorker;
import com.cdxp1688.dataservice.model.TbWorkerModel;
import com.cdxp1688.dataservice.service.TbWorkerService;
import com.cdxp1688.dataservice.service.UtilService;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.MyUtils;
import com.cdxp1688.dataservice.utils.PageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import top.huhuiyu.api.utils.StringUtils;

/**
 * TbWorker的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbWorkerServiceImpl implements TbWorkerService {

  @Autowired
  private TbWorkerDAO     tbWorkerDAO;
  @Autowired
  private UtilsDAO        utilsDAO;
  @Autowired
  private TbWorkerTypeDAO tbWokerTypeDAO;
  @Autowired
  private UtilService     utilService;

  @Override
  public JsonMessage queryFormInfo(TbWorkerModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("types", tbWokerTypeDAO.queryAll());
    return message;
  }

  @Override
  public JsonMessage login(TbWorkerModel model) throws Exception {
    // 基本信息校验
    TbWorker worker = model.getTbWorker();
    if (!MyUtils.isPhone(worker.getPhone())) {
      return JsonMessage.getFail("电话号码信息不正确");
    }
    if (MyUtils.isEmpty(worker.getPassword())) {
      return JsonMessage.getFail("请填写登录密码");
    }
    TbWorker check = tbWorkerDAO.queryByPhone(worker);
    if (check == null) {
      return JsonMessage.getFail("电话号码不存在");
    }
    if (!UtilService.ENABLE.equalsIgnoreCase(check.getIsEnable())) {
      return JsonMessage.getFail(520, "账号冻结中");
    }
    if (check.getPassword().equals(worker.getPassword())) {
      // 写入登录信息
      TbTokenInfo tokenInfo = model.makeTbTokenInfo();
      utilsDAO.deleteWorker(tokenInfo);
      tokenInfo.setInfo(check.getWid() + "");
      utilsDAO.addWorker(tokenInfo);
      return JsonMessage.getSuccess("登录成功");
    }
    return JsonMessage.getFail("密码错误，登陆失败");
  }

  @Override
  public JsonMessage logout(TbWorkerModel model) throws Exception {
    utilsDAO.deleteWorker(model.makeTbTokenInfo());
    return JsonMessage.getSuccess("安全退出成功");
  }

  @Override
  public JsonMessage queryWorker(TbWorkerModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    TbWorker    worker  = utilsDAO.queryWorker(model.makeTbTokenInfo());
    if (worker != null) {
      worker.setWid(null);
      worker.setPassword(null);
      worker.setIsEnable(null);
      message.putData("worker", worker);
    }
    return message;
  }

  @Override
  public JsonMessage reg(TbWorkerModel model) throws Exception {
    // 基本信息校验
    TbWorker worker = model.getTbWorker();
    if (!MyUtils.isPhone(worker.getPhone())) {
      return JsonMessage.getFail("电话号码信息不正确");
    }
    if (MyUtils.isEmpty(model.getPhoneCode())) {
      return JsonMessage.getFail("请填写电话校验码");
    }
    if (worker.getWtid() == null || worker.getWtid() < 1) {
      return JsonMessage.getFail("请选择职业类型");
    }
    if (MyUtils.isEmpty(worker.getName())) {
      return JsonMessage.getFail("请填写姓名");
    }
    if (MyUtils.isEmpty(worker.getPassword())) {
      return JsonMessage.getFail("请填写登录密码");
    }
    if (MyUtils.isEmpty(worker.getAddress())) {
      return JsonMessage.getFail("请填写详细地址");
    }
    // 强制城市信息为常德265（需要通过地图api初始化城市选择，可以考虑将省份城市信息放置在前端）
    worker.setCid(265);
    // 校验电话号码是否存在
    TbWorker check = tbWorkerDAO.queryByPhone(worker);
    if (check != null) {
      return JsonMessage.getFail("电话号码已经注册过了");
    }
    // 校验码是否正确
    if (!utilService.checkPhoneCode(worker.getPhone(), model.getPhoneCode(), model.makeTbTokenInfo())) {
      return JsonMessage.getFail("电话校验码不正确");
    }
    // 注册
    // worker.setPassword(Md5.md5(worker.getPassword()));
    int result = tbWorkerDAO.add(worker);
    return result == 1 ? JsonMessage.getSuccess("注册成功！") : JsonMessage.getFail("注册失败");
  }

  @Override
  public JsonMessage queryAll(TbWorkerModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    TbWorker tbWorker = model.getTbWorker();
    if (!MyUtils.isEmpty(tbWorker.getPhone())) {
      tbWorker.setPhone(String.format("%%%s%%", tbWorker.getPhone()));
    }
    if (!MyUtils.isEmpty(tbWorker.getName())) {
      tbWorker.setName(String.format("%%%s%%", tbWorker.getName()));
    }
    Page<TbWorker> list = (Page<TbWorker>) tbWorkerDAO.queryAll(model.getTbWorker());
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public void exportExcel(TbWorkerModel model, OutputStream os) throws Exception {
    // 先写死输出100行
    int lines = 100;
    PageHelper.startPage(0, lines);
    TbWorker tbWorker = model.getTbWorker();
    if (!MyUtils.isEmpty(tbWorker.getPhone())) {
      tbWorker.setPhone(String.format("%%%s%%", tbWorker.getPhone()));
    }
    if (!MyUtils.isEmpty(tbWorker.getName())) {
      tbWorker.setName(String.format("%%%s%%", tbWorker.getName()));
    }
    List<TbWorker> list = tbWorkerDAO.queryAll(tbWorker);
    // 输出excel
    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet    sheet    = workbook.createSheet();
    int          rownum   = 0;
    int          cols     = 6;
    // 输出表头
    HSSFRow  hssfRow = sheet.createRow(rownum++);
    HSSFCell cell    = hssfRow.createCell(0);
    cell.setCellValue("姓名");
    cell = hssfRow.createCell(1);
    cell.setCellValue("电话");
    cell = hssfRow.createCell(2);
    cell.setCellValue("职业类型");
    cell = hssfRow.createCell(3);
    cell.setCellValue("详细地址");
    cell = hssfRow.createCell(4);
    cell.setCellValue("是否冻结");
    cell = hssfRow.createCell(5);
    cell.setCellValue("最后修改时间");
    // 输出内容
    for (TbWorker row : list) {
      hssfRow = sheet.createRow(rownum++);
      cell = hssfRow.createCell(0);
      cell.setCellValue(StringUtils.trim(row.getName()));
      cell = hssfRow.createCell(1);
      cell.setCellValue(StringUtils.trim(row.getPhone()));
      cell = hssfRow.createCell(2);
      cell.setCellValue(StringUtils.trim(row.getType().getTypeName()));
      cell = hssfRow.createCell(3);
      cell.setCellValue(StringUtils.trim(row.getAddress()));
      String enable = ConstValues.ENABLE.equals(row.getIsEnable()) ? "启用中" : "已冻结";
      cell = hssfRow.createCell(4);
      cell.setCellValue(enable);
      cell = hssfRow.createCell(5);
      cell.setCellValue(ConstValues.DATA_FORMAT.format(row.getLastupdate()));
    }
    for (int i = 0; i < cols; i++) {
      sheet.autoSizeColumn(i);
    }
    workbook.write(os);
    workbook.close();
    os.close();
  }

  @Override
  public JsonMessage modifyPwd(TbWorkerModel model) throws Exception {
    // 基本信息校验
    TbWorker worker = model.getTbWorker();
    if (MyUtils.isEmpty(worker.getPassword())) {
      return JsonMessage.getFail("新密码必须填写");
    }
    TbWorker cworker = tbWorkerDAO.queryByPhone(worker);
    if (cworker == null) {
      return JsonMessage.getFail("用户不存在");
    }
    // 校验码是否正确
    if (!utilService.checkFindPwd(cworker.getPhone(), model.getPhoneCode(), model.makeTbTokenInfo())) {
      return JsonMessage.getFail("电话校验码不正确");
    }
    cworker.setPassword(worker.getPassword());
    int result = tbWorkerDAO.modifyPwd(cworker);
    return result == 1 ? JsonMessage.getSuccess("修改成功！") : JsonMessage.getFail("修改失败");
  }

  @Override
  public JsonMessage queryByKey(TbWorkerModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbWorker", tbWorkerDAO.queryByKey(model.getTbWorker()));
    return message;
  }

  @Override
  public JsonMessage add(TbWorkerModel model) throws Exception {
    int result = tbWorkerDAO.add(model.getTbWorker());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbWorkerModel model) throws Exception {
    int result = tbWorkerDAO.delete(model.getTbWorker());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbWorkerModel model) throws Exception {
    int result = tbWorkerDAO.update(model.getTbWorker());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }

  @Override
  public JsonMessage updateEnable(TbWorkerModel model) throws Exception {
    int result = tbWorkerDAO.updateEnable(model.getTbWorker());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }

  @Override
  public JsonMessage updateInWork(TbWorkerModel model) throws Exception {
    int result = tbWorkerDAO.updateInWork(model.getWorker());
    return result == 1 ? JsonMessage.getSuccess("修改状态成功") : JsonMessage.getFail("修改状态失败");
  }
}
