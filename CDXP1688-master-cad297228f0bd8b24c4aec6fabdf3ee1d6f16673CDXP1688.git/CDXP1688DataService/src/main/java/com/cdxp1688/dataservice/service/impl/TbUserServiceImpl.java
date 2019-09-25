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
import com.cdxp1688.dataservice.dao.TbUserDAO;
import com.cdxp1688.dataservice.dao.UtilsDAO;
import com.cdxp1688.dataservice.entity.TbTokenInfo;
import com.cdxp1688.dataservice.entity.TbUser;
import com.cdxp1688.dataservice.model.TbUserModel;
import com.cdxp1688.dataservice.service.TbUserService;
import com.cdxp1688.dataservice.service.UtilService;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.MyUtils;
import com.cdxp1688.dataservice.utils.PageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import top.huhuiyu.api.utils.StringUtils;

/**
 * TbUser的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbUserServiceImpl implements TbUserService {
  @Autowired
  private TbUserDAO   tbUserDAO;
  @Autowired
  private UtilsDAO    utilsDAO;
  @Autowired
  private UtilService utilService;

  @Override
  public JsonMessage login(TbUserModel model) throws Exception {
    if (MyUtils.isEmpty(model.getTbUser().getPhone())) {
      return JsonMessage.getFail("电话必须填写");
    }
    if (MyUtils.isEmpty(model.getTbUser().getPassword())) {
      return JsonMessage.getFail("密码必须填写");
    }
    TbUser user = tbUserDAO.login(model.getTbUser());
    if (user == null) {
      return JsonMessage.getFail("用户不存在");
    }
    if (!UtilService.ENABLE.equalsIgnoreCase(user.getIsEnable())) {
      return JsonMessage.getFail(520, "账号冻结中");
    }

    if (user.getPassword().equals(model.getTbUser().getPassword())) {
      // 写入登录信息
      TbTokenInfo tokenInfo = model.makeTbTokenInfo();
      utilsDAO.deleteUser(tokenInfo);
      tokenInfo.setInfo(user.getUid() + "");
      utilsDAO.addUser(tokenInfo);
      return JsonMessage.getSuccess("登录成功");
    }
    return JsonMessage.getFail("密码错误，登陆失败");
  }

  @Override
  public JsonMessage reg(TbUserModel model) throws Exception {
    // 基本信息校验
    TbUser user = model.getTbUser();
    if (!MyUtils.isPhone(user.getPhone())) {
      return JsonMessage.getFail("电话号码信息不正确");
    }
    if (MyUtils.isEmpty(model.getPhoneCode())) {
      return JsonMessage.getFail("请填写电话校验码");
    }
    if (MyUtils.isEmpty(user.getPassword())) {
      return JsonMessage.getFail("请填写登录密码");
    }
    // 校验电话号码是否存在
    TbUser check = tbUserDAO.queryByPhone(user);
    if (check != null) {
      return JsonMessage.getFail("电话号码已经注册过了");
    }
    // 校验码是否正确
    if (!utilService.checkPhoneCode(user.getPhone(), model.getPhoneCode(), model.makeTbTokenInfo())) {
      return JsonMessage.getFail("电话校验码不正确");
    }
    // 没有姓名就用空字符串
    user.setName(MyUtils.trim(user.getName()));
    // 没有地址就用空字符串
    user.setAddress(MyUtils.trim(user.getAddress()));
    // 注册
    int result = tbUserDAO.add(user);
    return result == 1 ? JsonMessage.getSuccess("注册成功！") : JsonMessage.getFail("注册失败");
  }

  @Override
  public JsonMessage modify(TbUserModel model) throws Exception {
    // 基本信息校验
    TbUser user = model.getTbUser();
    user.setUid(model.getUser().getUid());
    // 没有密码就用原始的
    if (MyUtils.isEmpty(user.getPassword())) {
      user.setPassword(model.getUser().getPassword());
    }
    // 没有姓名就用空字符串
    user.setName(MyUtils.trim(user.getName()));
    // 没有地址就用空字符串
    user.setAddress(MyUtils.trim(user.getAddress()));
    int result = tbUserDAO.update(user);
    return result == 1 ? JsonMessage.getSuccess("修改成功！") : JsonMessage.getFail("修改失败");
  }

  @Override
  public JsonMessage modifyPwd(TbUserModel model) throws Exception {
    // 基本信息校验
    TbUser user = model.getTbUser();
    if (MyUtils.isEmpty(user.getPassword())) {
      return JsonMessage.getFail("新密码必须填写");
    }
    TbUser cuser = tbUserDAO.queryByPhone(user);
    if (cuser == null) {
      return JsonMessage.getFail("用户不存在");
    }
    // 校验码是否正确
    if (!utilService.checkFindPwd(cuser.getPhone(), model.getPhoneCode(), model.makeTbTokenInfo())) {
      return JsonMessage.getFail("电话校验码不正确");
    }
    cuser.setPassword(user.getPassword());
    int result = tbUserDAO.modifyPwd(cuser);
    return result == 1 ? JsonMessage.getSuccess("修改成功！") : JsonMessage.getFail("修改失败");
  }

  @Override
  public JsonMessage logout(TbUserModel model) throws Exception {
    utilsDAO.deleteUser(model.makeTbTokenInfo());
    return JsonMessage.getSuccess("安全退出成功");
  }

  @Override
  public JsonMessage queryUser(TbUserModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    TbUser      user    = utilsDAO.queryUser(model.makeTbTokenInfo());
    if (user != null) {
      user.setUid(null);
      user.setPassword(null);
      user.setIsEnable(null);
      message.putData("user", user);
    }
    return message;
  }

  @Override
  public JsonMessage queryAll(TbUserModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    TbUser user = model.getTbUser();
    if (!MyUtils.isEmpty(user.getPhone())) {
      user.setPhone(String.format("%%%s%%", MyUtils.trim(user.getPhone())));
    }
    if (!MyUtils.isEmpty(user.getName())) {
      user.setName(String.format("%%%s%%", MyUtils.trim(user.getName())));
    }
    Page<TbUser> list = (Page<TbUser>) tbUserDAO.queryAll(user);
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public void exportExcel(TbUserModel model, OutputStream os) throws Exception {
    // 先写死输出100行
    int lines = 100;
    PageHelper.startPage(0, lines);
    TbUser user = model.getTbUser();
    if (!MyUtils.isEmpty(user.getPhone())) {
      user.setPhone(String.format("%%%s%%", MyUtils.trim(user.getPhone())));
    }
    if (!MyUtils.isEmpty(user.getName())) {
      user.setName(String.format("%%%s%%", MyUtils.trim(user.getName())));
    }
    List<TbUser> list = tbUserDAO.queryAll(user);
    // 输出excel

    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet    sheet    = workbook.createSheet();
    int          rownum   = 0;
    int          cols     = 4;
    // 输出表头
    HSSFRow  hssfRow = sheet.createRow(rownum++);
    HSSFCell cell    = hssfRow.createCell(0);
    cell.setCellValue("姓名");
    cell = hssfRow.createCell(1);
    cell.setCellValue("电话");
    cell = hssfRow.createCell(2);
    cell.setCellValue("是否冻结");
    cell = hssfRow.createCell(3);
    cell.setCellValue("最后修改时间");
    // 输出内容
    for (TbUser row : list) {
      hssfRow = sheet.createRow(rownum++);
      cell = hssfRow.createCell(0);
      cell.setCellValue(StringUtils.trim(row.getName()));
      cell = hssfRow.createCell(1);
      cell.setCellValue(StringUtils.trim(row.getPhone()));
      String enable = ConstValues.ENABLE.equals(row.getIsEnable()) ? "启用中" : "已冻结";
      cell = hssfRow.createCell(2);
      cell.setCellValue(enable);
      cell = hssfRow.createCell(3);
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
  public JsonMessage updateEnable(TbUserModel model) throws Exception {
    int result = tbUserDAO.updateEnable(model.getTbUser());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }

  @Override
  public JsonMessage queryByKey(TbUserModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbUser", tbUserDAO.queryByKey(model.getTbUser()));
    return message;
  }

  @Override
  public JsonMessage add(TbUserModel model) throws Exception {
    int result = tbUserDAO.add(model.getTbUser());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbUserModel model) throws Exception {
    int result = tbUserDAO.delete(model.getTbUser());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbUserModel model) throws Exception {
    int result = tbUserDAO.update(model.getTbUser());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
