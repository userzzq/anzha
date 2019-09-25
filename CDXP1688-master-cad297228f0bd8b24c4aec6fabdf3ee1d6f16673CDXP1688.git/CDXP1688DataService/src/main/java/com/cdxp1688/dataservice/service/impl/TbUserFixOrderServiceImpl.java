package com.cdxp1688.dataservice.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.cdxp1688.dataservice.dao.TbFixOrderDetailDAO;
import com.cdxp1688.dataservice.dao.TbUserFixInfoDAO;
import com.cdxp1688.dataservice.dao.TbUserFixOrderDAO;
import com.cdxp1688.dataservice.entity.TbFixOrderDetail;
import com.cdxp1688.dataservice.entity.TbUserFixInfo;
import com.cdxp1688.dataservice.entity.TbUserFixOrder;
import com.cdxp1688.dataservice.entity.TbWorker;
import com.cdxp1688.dataservice.exception.AppException;
import com.cdxp1688.dataservice.model.TbUserFixOrderModel;
import com.cdxp1688.dataservice.service.TbConfigService;
import com.cdxp1688.dataservice.service.TbUserFixOrderService;
import com.cdxp1688.dataservice.sms.SmsConfig;
import com.cdxp1688.dataservice.sms.SmsUtil;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.MyUtils;
import com.cdxp1688.dataservice.utils.PageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import top.huhuiyu.api.utils.StringUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class TbUserFixOrderServiceImpl implements TbUserFixOrderService {

  @Autowired
  private TbUserFixInfoDAO    tbUserFixInfoDAO;
  @Autowired
  private TbUserFixOrderDAO   tbUserFixOrderDAO;
  @Autowired
  private TbFixOrderDetailDAO tbFixOrderDetailDAO;
  @Autowired
  private TbConfigService     tbConfigService;
  @Autowired
  private SmsUtil             smsUtil;

  @Override
  public JsonMessage queryByWorker(TbUserFixOrderModel model) throws Exception {
    TbUserFixOrder order = model.getTbUserFixOrder();
    order.setWid(model.getWorker().getWid());
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbUserFixOrder> list = (Page<TbUserFixOrder>) tbUserFixOrderDAO.queryByWorker(order);
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByWorkerFinish(TbUserFixOrderModel model) throws Exception {
    TbUserFixOrder order = model.getTbUserFixOrder();
    order.setWid(model.getWorker().getWid());
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbUserFixOrder> list = (Page<TbUserFixOrder>) tbUserFixOrderDAO.queryByWorkerFinish(order);
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  @Transactional(isolation = Isolation.SERIALIZABLE)
  public JsonMessage pickOrder(TbUserFixOrderModel model) throws Exception {
    TbUserFixOrder order  = model.getTbUserFixOrder();
    TbWorker       worker = model.getWorker();
    // 校验订单
    TbUserFixInfo fixInfo = new TbUserFixInfo();
    fixInfo.setUfid(order.getUfid());
    fixInfo = tbUserFixInfoDAO.queryByKey(fixInfo);
    if (fixInfo == null) {
      return JsonMessage.getFail("订单不存在");
    }
    if (!TbUserFixInfoDAO.STATUS_10.equals(fixInfo.getStatus())) {
      return JsonMessage.getFail("订单状态不正确");
    }
    // 更新状态
    fixInfo.setStatus(TbUserFixInfoDAO.STATUS_11);
    int result = tbUserFixInfoDAO.updateStatus(fixInfo);
    if (result != 1) {
      throw AppException.getAppException(500, "更新订单状态失败");
    }
    // 添加师傅维修信息
    order.setWid(worker.getWid());
    order.setInfo(StringUtils.trim(order.getInfo()));
    result = tbUserFixOrderDAO.add(order);
    if (result != 1) {
      throw AppException.getAppException(500, "添加师傅维修信息失败");
    }
    // 短信通知用户
    SmsConfig           smsConfig = tbConfigService.querySmsConfig();
    Map<String, Object> params    = new HashMap<>();
    params.put("name", worker.getName());
    params.put("phone", worker.getPhone());
    smsUtil.send(smsConfig, fixInfo.getPhone(), smsConfig.getTemplate().getUserNotify(), params);
    return JsonMessage.getSuccess("接单成功");
  }

  @Override
  @Transactional(isolation = Isolation.SERIALIZABLE)
  public JsonMessage orderPrice(TbUserFixOrderModel model) throws Exception {
    TbUserFixOrder   order            = model.getTbUserFixOrder();
    TbWorker         worker           = model.getWorker();
    TbFixOrderDetail tbFixOrderDetail = model.getTbFixOrderDetail();
    tbFixOrderDetail.setDetail("维修费用");
    tbFixOrderDetail.setUfoid(order.getUfoid());
    order.setWid(worker.getWid());
    if (MyUtils.lqZero(tbFixOrderDetail.getPrice())) {
      return JsonMessage.getFail("价格必须输入且大于0");
    }
    // 查询订单信息
    order = tbUserFixOrderDAO.queryDetailByWorkerKey(order);
    if (order == null) {
      return JsonMessage.getFail("订单不存在");
    }
    if (!TbUserFixInfoDAO.STATUS_11.equals(order.getFixinfo().getStatus())) {
      return JsonMessage.getFail("订单状态不正确");
    }
    // 不要重复报价
    if (order.getPrice() != null) {
      return JsonMessage.getFail("不要重复报价");
    }
    int result = tbFixOrderDetailDAO.add(tbFixOrderDetail);
    if (result != 1) {
      throw AppException.getAppException(500, "添加维修价格失败");
    }
    // TbUserFixInfo fixInfo = new TbUserFixInfo();
    // fixInfo.setUfid(order.getUfid());
    // fixInfo.setStatus(TbUserFixInfoDAO.STATUS_13);
    // result = tbUserFixInfoDAO.updateStatus(fixInfo);
    // if (result != 1) {
    // throw AppException.getAppException(500, "修改订单状态失败");
    // }
    return JsonMessage.getSuccess("报价成功");
  }

  @Override
  public JsonMessage modifyOrderPrice(TbUserFixOrderModel model) throws Exception {
    TbUserFixOrder   order            = model.getTbUserFixOrder();
    TbWorker         worker           = model.getWorker();
    TbFixOrderDetail tbFixOrderDetail = model.getTbFixOrderDetail();
    tbFixOrderDetail.setDetail("维修费用");
    tbFixOrderDetail.setUfoid(order.getUfoid());
    order.setWid(worker.getWid());
    if (MyUtils.lqZero(tbFixOrderDetail.getPrice())) {
      return JsonMessage.getFail("价格必须输入且大于0");
    }
    // 查询订单信息
    order = tbUserFixOrderDAO.queryDetailByWorkerKey(order);
    if (order == null) {
      return JsonMessage.getFail("订单不存在");
    }
    if (!TbUserFixInfoDAO.STATUS_11.equals(order.getFixinfo().getStatus())) {
      return JsonMessage.getFail("订单状态不正确");
    }
    TbFixOrderDetail detail = tbFixOrderDetailDAO.querybyUfoid(tbFixOrderDetail);
    if (detail == null) {
      return JsonMessage.getFail("报价信息不存在");
    }
    detail.setPrice(tbFixOrderDetail.getPrice());
    int result = tbFixOrderDetailDAO.update(detail);
    if (result != 1) {
      throw AppException.getAppException(500, "修改报价失败");
    }
    return JsonMessage.getSuccess("修改报价成功");
  }

  @Override
  public JsonMessage finishWork(TbUserFixOrderModel model) throws Exception {
    TbUserFixOrder order  = model.getTbUserFixOrder();
    TbWorker       worker = model.getWorker();
    order.setWid(worker.getWid());
    // 查询订单信息
    order = tbUserFixOrderDAO.queryDetailByWorkerKey(order);
    if (order == null) {
      return JsonMessage.getFail("订单不存在");
    }
    if (!TbUserFixInfoDAO.STATUS_13.equals(order.getFixinfo().getStatus())) {
      return JsonMessage.getFail("订单状态不正确");
    }

    TbUserFixInfo fixInfo = new TbUserFixInfo();
    fixInfo.setUfid(order.getUfid());
    fixInfo.setStatus(TbUserFixInfoDAO.STATUS_14);
    int result = tbUserFixInfoDAO.updateStatus(fixInfo);
    if (result != 1) {
      throw AppException.getAppException(500, "修改订单状态失败");
    }
    return JsonMessage.getSuccess("维修完成");
  }

  @Override
  public JsonMessage finish(TbUserFixOrderModel model) throws Exception {
    TbUserFixOrder order  = model.getTbUserFixOrder();
    TbWorker       worker = model.getWorker();
    order.setWid(worker.getWid());
    // 查询订单信息
    order = tbUserFixOrderDAO.queryDetailByWorkerKey(order);
    if (order == null) {
      return JsonMessage.getFail("订单不存在");
    }
    if (!TbUserFixInfoDAO.STATUS_15.equals(order.getFixinfo().getStatus())) {
      return JsonMessage.getFail("订单状态不正确");
    }

    TbUserFixInfo fixInfo = new TbUserFixInfo();
    fixInfo.setUfid(order.getUfid());
    fixInfo.setStatus(TbUserFixInfoDAO.STATUS_99);
    int result = tbUserFixInfoDAO.updateStatus(fixInfo);
    if (result != 1) {
      throw AppException.getAppException(500, "修改订单状态失败");
    }
    return JsonMessage.getSuccess("订单完成");
  }

}
