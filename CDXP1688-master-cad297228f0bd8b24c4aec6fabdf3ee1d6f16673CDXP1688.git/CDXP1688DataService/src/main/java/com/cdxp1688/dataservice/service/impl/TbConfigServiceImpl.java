package com.cdxp1688.dataservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.cdxp1688.dataservice.dao.TbConfigDAO;
import com.cdxp1688.dataservice.entity.TbConfig;
import com.cdxp1688.dataservice.model.TbConfigModel;
import com.cdxp1688.dataservice.pay.CallbackUrls;
import com.cdxp1688.dataservice.pay.PayConfig;
import com.cdxp1688.dataservice.pay.WxConfig;
import com.cdxp1688.dataservice.pay.WxPayInfo;
import com.cdxp1688.dataservice.service.TbConfigService;
import com.cdxp1688.dataservice.sms.SmsConfig;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.JsonUtil;
import com.cdxp1688.dataservice.utils.PageBean;

/**
 * TbConfig的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbConfigServiceImpl implements TbConfigService {
  @Autowired
  private TbConfigDAO tbConfigDAO;

  @Override
  public JsonMessage queryAll(TbConfigModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbConfig> list = (Page<TbConfig>) tbConfigDAO.queryAll();
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbConfigModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbConfig", tbConfigDAO.queryByKey(model.getTbConfig()));
    return message;
  }

  @Override
  public JsonMessage add(TbConfigModel model) throws Exception {
    int result = tbConfigDAO.add(model.getTbConfig());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbConfigModel model) throws Exception {
    int result = tbConfigDAO.delete(model.getTbConfig());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbConfigModel model) throws Exception {
    int result = tbConfigDAO.update(model.getTbConfig());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }

  @Override
  public SmsConfig querySmsConfig() throws Exception {
    TbConfig  config    = tbConfigDAO.querySmsConfig();
    SmsConfig smsConfig = JsonUtil.parse(config.getConfigValue(), SmsConfig.class);
    return smsConfig;
  }

  @Override
  public PayConfig queryPayConfig() throws Exception {
    TbConfig  config    = tbConfigDAO.queryPayConfig();
    PayConfig payConfig = JsonUtil.parse(config.getConfigValue(), PayConfig.class);
    return payConfig;
  }

  @Override
  public WxConfig queryWxConfig() throws Exception {
    TbConfig config   = tbConfigDAO.queryWxConfig();
    WxConfig wxConfig = JsonUtil.parse(config.getConfigValue(), WxConfig.class);
    return wxConfig;
  }

  @Override
  public CallbackUrls queryCallbackUrlsConfig() throws Exception {
    TbConfig     config       = tbConfigDAO.queryCallbackUrlsConfig();
    CallbackUrls callbackUrls = JsonUtil.parse(config.getConfigValue(), CallbackUrls.class);
    return callbackUrls;
  }

  @Override
  public WxPayInfo queryWxPayInfoConfig() throws Exception {
    TbConfig  config    = tbConfigDAO.queryWxPayInfo();
    WxPayInfo wxPayInfo = JsonUtil.parse(config.getConfigValue(), WxPayInfo.class);
    return wxPayInfo.clone();
  }
}
