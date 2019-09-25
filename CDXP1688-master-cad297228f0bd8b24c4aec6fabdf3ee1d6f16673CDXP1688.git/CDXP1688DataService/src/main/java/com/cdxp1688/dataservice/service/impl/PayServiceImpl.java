package com.cdxp1688.dataservice.service.impl;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cdxp1688.dataservice.dao.TbFixOrderDetailDAO;
import com.cdxp1688.dataservice.dao.TbUserFixInfoDAO;
import com.cdxp1688.dataservice.entity.TbFixOrderDetail;
import com.cdxp1688.dataservice.entity.TbUserFixInfo;
import com.cdxp1688.dataservice.exception.AppException;
import com.cdxp1688.dataservice.pay.CallbackUrls;
import com.cdxp1688.dataservice.pay.H5PayResult;
import com.cdxp1688.dataservice.pay.MyHttpClient;
import com.cdxp1688.dataservice.pay.PayUtil;
import com.cdxp1688.dataservice.pay.UnifiedorderResult;
import com.cdxp1688.dataservice.pay.WxConfig;
import com.cdxp1688.dataservice.pay.WxPayInfo;
import com.cdxp1688.dataservice.service.PayService;
import com.cdxp1688.dataservice.service.TbConfigService;
import com.cdxp1688.dataservice.utils.JsonUtil;

/**
 * 支付相关服务
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PayServiceImpl implements PayService {

  private static final Logger log = LoggerFactory.getLogger(PayServiceImpl.class);

  @Autowired
  private TbConfigService     tbConfigService;
  @Autowired
  private TbFixOrderDetailDAO tbFixOrderDetailDAO;
  @Autowired
  private TbUserFixInfoDAO    tbUserFixInfoDAO;

  @Override
  public String getOpenidCodeUrl() throws Exception {
    WxConfig     wxConfig     = tbConfigService.queryWxConfig();
    CallbackUrls callbackUrls = tbConfigService.queryCallbackUrlsConfig();
    String       url          = String.format(wxConfig.getOpenidCodeUrl(), URLEncoder.encode(callbackUrls.getOpenid(), "UTF-8"), wxConfig.getAppid());
    return url;
  }

  @Override
  public String getOpenidUrl(String code) throws Exception {
    WxConfig wxConfig = tbConfigService.queryWxConfig();
    String   url      = String.format(wxConfig.getOpenidUrl(), wxConfig.getAppid(), wxConfig.getSecret(), code);
    return url;
  }

  @Override
  public String getOpenid(String code) throws Exception {
    String              result = MyHttpClient.getInstance().doGet(getOpenidUrl(code));
    Map<String, String> info   = JsonUtil.parse(result);
    return info.get("openid");
  }

  @Override
  public String getOrderUrl(String ip, int ufid) throws Exception {
    TbUserFixInfo info = new TbUserFixInfo();
    info.setUfid(ufid);
    TbFixOrderDetail detail = tbFixOrderDetailDAO.queryByUfid(info);
    BigDecimal       price  = BigDecimal.ZERO;
    if (detail != null) {
      price = detail.getPrice();
    }
    price = price.multiply(new BigDecimal(100)).setScale(0);
    WxConfig     config    = tbConfigService.queryWxConfig();
    CallbackUrls urls      = tbConfigService.queryCallbackUrlsConfig();
    WxPayInfo    wxPayInfo = tbConfigService.queryWxPayInfoConfig();
    wxPayInfo.setNonce_str(UUID.randomUUID().toString().replaceAll("[-]", ""));
    wxPayInfo.setOut_trade_no(UUID.randomUUID().toString().replaceAll("[-]", ""));
    wxPayInfo.setTotal_fee(price.toString());
    wxPayInfo.setSpbill_create_ip(ip);
    wxPayInfo.setTrade_type("MWEB");
    wxPayInfo.getScene_info().setType("Wap");
    log.debug("h5统一下单信息" + wxPayInfo);
    UnifiedorderResult result = PayUtil.processUnifiedOrder(config, urls, wxPayInfo);
    // 更新订单信息
    info.setOut_trade_no(wxPayInfo.getOut_trade_no());
    int updateresult = tbUserFixInfoDAO.updateOut_trade_no(info);
    if (updateresult != 1) {
      throw AppException.getAppException(500, "下单失败");
    }
    log.debug("h5统一下单结果：" + result);
    return result.getMweb_url() + "&redirect_url=" + URLEncoder.encode(urls.getPay(), "UTF-8");
  }

  @Override
  public UnifiedorderResult getWxOrderInfo(String ip, String openid, String price) throws Exception {
    WxConfig     config    = tbConfigService.queryWxConfig();
    CallbackUrls urls      = tbConfigService.queryCallbackUrlsConfig();
    WxPayInfo    wxPayInfo = tbConfigService.queryWxPayInfoConfig();
    wxPayInfo.setNonce_str(UUID.randomUUID().toString().replaceAll("[-]", ""));
    wxPayInfo.setOut_trade_no(UUID.randomUUID().toString().replaceAll("[-]", ""));
    wxPayInfo.setTotal_fee(price);
    wxPayInfo.setSpbill_create_ip(ip);
    wxPayInfo.setTrade_type("JSAPI");
    wxPayInfo.setOpenid(openid);
    wxPayInfo.setScene_info(null);
    UnifiedorderResult result = PayUtil.processWxUnifiedOrder(config, urls, wxPayInfo);
    return result;
  }

  @Override
  public String getWxOrderUrl(String ip, String openid, int ufid) throws Exception {
    WxConfig      config = tbConfigService.queryWxConfig();
    CallbackUrls  urls   = tbConfigService.queryCallbackUrlsConfig();
    TbUserFixInfo info   = new TbUserFixInfo();
    info.setUfid(ufid);
    TbFixOrderDetail detail = tbFixOrderDetailDAO.queryByUfid(info);
    BigDecimal       price  = BigDecimal.ZERO;
    if (detail != null) {
      price = detail.getPrice();
    }
    price = price.multiply(new BigDecimal(100)).setScale(0);
    UnifiedorderResult result = getWxOrderInfo(ip, openid, price.toString());
    String             params = PayUtil.processWxPayParams(result, config);
    return String.format(urls.getWxpay(), params);
  }

  @Override
  public String getOpenidBackUrl(String openid) throws Exception {
    CallbackUrls urls = tbConfigService.queryCallbackUrlsConfig();
    return String.format(urls.getOpenidBack(), openid);
  }

  @Override
  public void payNotice(String info) throws Exception {
    H5PayResult result = PayUtil.parseH5PayResult(info);
    log.debug("支付通知：" + result);
    if ("SUCCESS".equals(result.getResult_code())) {
      TbUserFixInfo tbUserFixInfo = new TbUserFixInfo();
      tbUserFixInfo.setOut_trade_no(result.getOut_trade_no());
      tbUserFixInfoDAO.updateOut_trade_noStatus(tbUserFixInfo);
    }
  }
}
