package com.cdxp1688.dataservice.service.impl;

import java.io.OutputStream;
import java.util.List;
import java.util.UUID;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import com.cdxp1688.dataservice.base.ConstValues;
import com.cdxp1688.dataservice.dao.TbConfigDAO;
import com.cdxp1688.dataservice.dao.TbOssConfigDAO;
import com.cdxp1688.dataservice.dao.TbOssInfoDAO;
import com.cdxp1688.dataservice.dao.TbUserFixInfoDAO;
import com.cdxp1688.dataservice.dao.TbUserFixOrderDAO;
import com.cdxp1688.dataservice.dao.TbWorkerDAO;
import com.cdxp1688.dataservice.entity.TbOssConfig;
import com.cdxp1688.dataservice.entity.TbOssInfo;
import com.cdxp1688.dataservice.entity.TbUserFixInfo;
import com.cdxp1688.dataservice.entity.TbUserFixOrder;
import com.cdxp1688.dataservice.entity.TbWorker;
import com.cdxp1688.dataservice.exception.AppException;
import com.cdxp1688.dataservice.model.TbUserFixInfoModel;
import com.cdxp1688.dataservice.service.TbConfigService;
import com.cdxp1688.dataservice.service.TbUserFixInfoService;
import com.cdxp1688.dataservice.sms.SmsConfig;
import com.cdxp1688.dataservice.sms.SmsUtil;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.MyUtils;
import com.cdxp1688.dataservice.utils.PageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import top.huhuiyu.api.fileutil.FileUtil;
import top.huhuiyu.api.utils.StringUtils;

/**
 * TbUserFixInfo的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbUserFixInfoServiceImpl implements TbUserFixInfoService {

  private static final Logger log = LoggerFactory.getLogger(TbUserFixInfoServiceImpl.class);

  @Autowired
  private TbUserFixInfoDAO tbUserFixInfoDAO;
  // @Autowired
  // private TbUserFixInfoImagesDAO tbUserFixInfoImagesDAO;
  @Autowired
  private TbOssConfigDAO    tbOssConfigDAO;
  @Autowired
  private TbOssInfoDAO      tbOssInfoDAO;
  @Autowired
  private TbWorkerDAO       tbWorkerDAO;
  @Autowired
  private TbConfigService   tbConfigService;
  @Autowired
  private TbConfigDAO       tbConfigDAO;
  @Autowired
  private SmsUtil           smsUtil;
  @Autowired
  private TbUserFixOrderDAO tbUserFixOrderDAO;

  @Override
  public JsonMessage queryObjectNamesByUserFixInfo(TbUserFixInfoModel model) throws Exception {
    TbUserFixInfo   fixInfo = model.getTbUserFixInfo();
    List<TbOssInfo> list    = tbOssInfoDAO.queryObjectNamesByUserFixInfo(fixInfo);
    JsonMessage     message = JsonMessage.getSuccess("").putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByUser(TbUserFixInfoModel model) throws Exception {
    TbUserFixInfo fixInfo = model.getTbUserFixInfo();
    fixInfo.setUid(model.getUser().getUid());
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbUserFixInfo> list = (Page<TbUserFixInfo>) tbUserFixInfoDAO.queryByUser(fixInfo);
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByUserFinish(TbUserFixInfoModel model) throws Exception {
    TbUserFixInfo fixInfo = model.getTbUserFixInfo();
    fixInfo.setUid(model.getUser().getUid());
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbUserFixInfo> list = (Page<TbUserFixInfo>) tbUserFixInfoDAO.queryByUserFinish(fixInfo);
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryWorkerFixinfo(TbUserFixInfoModel model) throws Exception {
    TbUserFixInfo fixInfo = model.getTbUserFixInfo();
    PageBean      page    = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbUserFixInfo> list = (Page<TbUserFixInfo>) tbUserFixInfoDAO.queryWorkerFixinfo(fixInfo);
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryAll(TbUserFixInfoModel model) throws Exception {
    TbUserFixInfo fixInfo = model.getTbUserFixInfo();
    if (!MyUtils.isEmpty(fixInfo.getPhone())) {
      fixInfo.setPhone(MyUtils.getLikeStr(MyUtils.trim(fixInfo.getPhone())));
    }

    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbUserFixInfo> list = (Page<TbUserFixInfo>) tbUserFixInfoDAO.queryAll(fixInfo);
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public void exportExcel(TbUserFixInfoModel model, OutputStream os) throws Exception {
    // 先写死输出100行
    int lines = 100;
    PageHelper.startPage(0, lines);

    TbUserFixInfo fixInfo = model.getTbUserFixInfo();
    if (!MyUtils.isEmpty(fixInfo.getPhone())) {
      fixInfo.setPhone(MyUtils.getLikeStr(MyUtils.trim(fixInfo.getPhone())));
    }
    List<TbUserFixInfo> list = tbUserFixInfoDAO.queryAll(fixInfo);
    // 输出excel
    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet    sheet    = workbook.createSheet();
    int          rownum   = 0;
    int          cols     = 8;
    // 输出表头
    HSSFRow  hssfRow = sheet.createRow(rownum++);
    HSSFCell cell    = hssfRow.createCell(0);
    cell.setCellValue("用户姓名");
    cell = hssfRow.createCell(1);
    cell.setCellValue("叫修需求");
    cell = hssfRow.createCell(2);
    cell.setCellValue("维修类型");
    cell = hssfRow.createCell(3);
    cell.setCellValue("业主电话");
    cell = hssfRow.createCell(4);
    cell.setCellValue("维修状态");
    cell = hssfRow.createCell(5);
    cell.setCellValue("维修师傅");
    cell = hssfRow.createCell(6);
    cell.setCellValue("地址");
    cell = hssfRow.createCell(7);
    cell.setCellValue("订单时间");
    // 输出内容
    for (TbUserFixInfo row : list) {
      hssfRow = sheet.createRow(rownum++);
      cell = hssfRow.createCell(0);
      String username = row.getUser() == null ? "" : StringUtils.trim(row.getUser().getName());
      cell.setCellValue(username);
      cell = hssfRow.createCell(1);
      cell.setCellValue(StringUtils.trim(row.getInfo()));
      cell = hssfRow.createCell(2);
      cell.setCellValue(ConstValues.FIX_TYPES.get(row.getFixtype()));
      cell = hssfRow.createCell(3);
      cell.setCellValue(StringUtils.trim(row.getPhone()));
      cell = hssfRow.createCell(4);
      cell.setCellValue(ConstValues.FIX_STUTAS.get(row.getStatus()));
      cell = hssfRow.createCell(5);
      cell.setCellValue("");
      cell = hssfRow.createCell(6);
      cell.setCellValue(StringUtils.trim(row.getAddress()));
      cell = hssfRow.createCell(7);
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
  public JsonMessage queryByKey(TbUserFixInfoModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbUserFixInfo", tbUserFixInfoDAO.queryByKey(model.getTbUserFixInfo()));
    return message;
  }

  @Override
  public JsonMessage add(TbUserFixInfoModel model, MultipartFile[] files) throws Exception {
    TbUserFixInfo userFixInfo = model.getTbUserFixInfo();
    // 数据检查
    if (!MyUtils.isPhone(userFixInfo.getPhone())) {
      return JsonMessage.getFail("请填写正确格式的电话");
    }
    if (MyUtils.isEmpty(userFixInfo.getInfo())) {
      return JsonMessage.getFail("请填写报修信息");
    }
    // 可选参数不能是null
    userFixInfo.setAddressInfo(MyUtils.trim(userFixInfo.getAddressInfo()));
    // 已经下单
    userFixInfo.setStatus("10");
    // 下单用户
    userFixInfo.setUid(model.getUser().getUid());
    // 基本信息保存
    int result = tbUserFixInfoDAO.add(userFixInfo);
    if (result != 1) {
      throw AppException.getAppException(500, "添加数据失败");
    }
    // 图片信息保存
    if (files != null && files.length > 0) {
      // 使用oss保存图片
      TbOssConfig config = tbOssConfigDAO.queryImages();
      // 图片ids
      String ids  = "";
      String join = ",";
      for (MultipartFile multipartFile : files) {
        if (multipartFile == null || multipartFile.isEmpty()) {
          continue;
        }
        // 文件名称
        String filename = UUID.randomUUID().toString() + FileUtil.getExtName(multipartFile.getOriginalFilename());
        // 数据库信息
        TbOssInfo ossInfo = new TbOssInfo();
        ossInfo.setOcid(config.getOcid());
        ossInfo.setFileinfo(StringUtils.trim(ossInfo.getFileinfo()));
        ossInfo.setObjectName(filename);
        ossInfo.setFilename(multipartFile.getOriginalFilename());
        ossInfo.setContentType(multipartFile.getContentType());
        ossInfo.setFilesize(multipartFile.getSize());
        result = tbOssInfoDAO.add(ossInfo);
        if (result != 1) {
          throw AppException.getAppException(500, "保存图片失败！");
        }
        ids += join + ossInfo.getOiid();
        // oss存储
        OSSClientBuilder ocb       = new OSSClientBuilder();
        OSS              ossClient = ocb.build(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
        PutObjectResult  putResult = ossClient.putObject(config.getBucketName(), filename, multipartFile.getInputStream());
        log.debug(String.format("ETag:%s,RequestId:%s,ClientCRC:%s,ServerCRC:%s", putResult.getETag(), putResult.getRequestId(), putResult.getClientCRC(), putResult.getServerCRC()));
        ossClient.shutdown();
      }

      if (ids.length() > 0) {
        ids = ids.substring(1);
        userFixInfo.setImages(ids);
        result = tbUserFixInfoDAO.updateImages(userFixInfo);
      }
      if (result != 1) {
        throw AppException.getAppException(500, "处理图片信息发生错误");
      }
      log.debug("ids=====>" + ids);
    }

    // 需要给在线师傅发送短信
    String    onlineModel = tbConfigDAO.queryWorkerOnlineConfig().getConfigValue();
    SmsConfig smsConfig   = tbConfigService.querySmsConfig();
    TbWorker  worker      = new TbWorker();
    worker.setIsEnable("y");
    if ("inwork".equalsIgnoreCase(onlineModel)) {
      worker.setInWork("y");
    }
    List<TbWorker> workers = tbWorkerDAO.queryOnline(worker);
    for (TbWorker tbWorker : workers) {
      smsUtil.send(smsConfig, tbWorker.getPhone(), smsConfig.getTemplate().getWorkerNotify(), null);
    }
    // ====================================================================
    // for (MultipartFile multipartFile : files) {
    // if (multipartFile == null || multipartFile.isEmpty()) {
    // continue;
    // }
    // // 保存文件
    // String filename = UUID.randomUUID().toString() + MyUtils.getExtName(multipartFile.getOriginalFilename());
    // File savefile = new File(System.getProperty("user.dir") + MyUtils.UPLOAD_DIR, filename);
    // // 确保目录存在
    // if (!savefile.getParentFile().exists()) {
    // savefile.getParentFile().mkdirs();
    // }
    // // 输出文件
    // MyUtils.saveFile(multipartFile, savefile);
    // // 保存图片数据
    // TbUserFixInfoImages images = new TbUserFixInfoImages();
    // images.setUfid(userFixInfo.getUfid());
    // images.setFilename(filename);
    // images.setContentType(multipartFile.getContentType());
    // images.setFilesize(multipartFile.getSize());
    // tbUserFixInfoImagesDAO.add(images);
    // }
    return JsonMessage.getSuccess("添加数据成功");
  }

  @Override
  public JsonMessage delete(TbUserFixInfoModel model) throws Exception {
    int result = tbUserFixInfoDAO.delete(model.getTbUserFixInfo());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbUserFixInfoModel model) throws Exception {
    int result = tbUserFixInfoDAO.update(model.getTbUserFixInfo());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }

  @Override
  public JsonMessage cancel(TbUserFixInfoModel model) throws Exception {
    TbUserFixInfo fixInfo = model.getTbUserFixInfo();
    fixInfo.setUid(model.getUser().getUid());
    fixInfo = tbUserFixInfoDAO.queryByUserKey(fixInfo);
    // 更改订单状态
    if (fixInfo == null) {
      return JsonMessage.getFail("订单不存在");
    }
    if (!TbUserFixInfoDAO.STATUS_10.equals(fixInfo.getStatus()) && !TbUserFixInfoDAO.STATUS_11.equals(fixInfo.getStatus())) {
      return JsonMessage.getFail("订单无法取消");
    }
    fixInfo.setStatus(TbUserFixInfoDAO.STATUS_12);
    int result = tbUserFixInfoDAO.updateStatus(fixInfo);
    if (result != 1) {
      throw AppException.getAppException(500, "订单状态修改失败");
    }
    TbUserFixOrder order = new TbUserFixOrder();
    order.setUfid(fixInfo.getUfid());
    order = tbUserFixOrderDAO.queryByUfid(order);
    // 已经接单需要通知师傅用户订单已经取消
    if (order != null && order.getWorker() != null) {
      SmsConfig smsConfig = tbConfigService.querySmsConfig();
      smsUtil.send(smsConfig, order.getWorker().getPhone(), smsConfig.getTemplate().getCancelOrder(), null);
    }
    return JsonMessage.getSuccess("取消订单成功");
  }

  @Override
  public JsonMessage price(TbUserFixInfoModel model) throws Exception {
    TbUserFixInfo fixInfo = model.getTbUserFixInfo();
    fixInfo.setUid(model.getUser().getUid());
    fixInfo = tbUserFixInfoDAO.queryByUserKey(fixInfo);
    // 更改订单状态
    if (fixInfo == null) {
      return JsonMessage.getFail("订单不存在");
    }
    if (!TbUserFixInfoDAO.STATUS_11.equals(fixInfo.getStatus())) {
      return JsonMessage.getFail("订单状态异常");
    }
    fixInfo.setStatus(TbUserFixInfoDAO.STATUS_13);
    int result = tbUserFixInfoDAO.updateStatus(fixInfo);
    if (result != 1) {
      throw AppException.getAppException(500, "订单状态修改失败");
    }
    return JsonMessage.getSuccess("已经确认定价");
  }

  @Override
  @Transactional(isolation = Isolation.SERIALIZABLE)
  public JsonMessage pay(TbUserFixInfoModel model) throws Exception {
    TbUserFixInfo fixInfo = model.getTbUserFixInfo();
    fixInfo.setUid(model.getUser().getUid());
    fixInfo = tbUserFixInfoDAO.queryByUserKey(fixInfo);
    // 更改订单状态
    if (fixInfo == null) {
      return JsonMessage.getFail("订单不存在");
    }
    if (!TbUserFixInfoDAO.STATUS_14.equals(fixInfo.getStatus())) {
      return JsonMessage.getFail("订单状态异常");
    }
    // 需要支付信息确认
    fixInfo.setStatus(TbUserFixInfoDAO.STATUS_15);
    int result = tbUserFixInfoDAO.updateStatus(fixInfo);
    if (result != 1) {
      throw AppException.getAppException(500, "订单状态修改失败");
    }
    return JsonMessage.getSuccess("订单支付成功");
  }
}
