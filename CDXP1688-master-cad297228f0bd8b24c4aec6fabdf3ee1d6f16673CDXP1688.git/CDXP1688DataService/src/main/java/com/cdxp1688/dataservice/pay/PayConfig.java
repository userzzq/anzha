package com.cdxp1688.dataservice.pay;

import com.cdxp1688.dataservice.base.BaseEntity;

public class PayConfig extends BaseEntity {
  private static final long serialVersionUID = -2160374761368407637L;

  private String    appid;
  private String    mch_id;
  private String    key;
  private String    notify_url;
  private String    body;
  private String    trade_type;
  private SceneInfo scene_info;
  private String    payUrl;
  private String    backUrl;

  public PayConfig() {
  }

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getMch_id() {
    return mch_id;
  }

  public void setMch_id(String mch_id) {
    this.mch_id = mch_id;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getNotify_url() {
    return notify_url;
  }

  public void setNotify_url(String notify_url) {
    this.notify_url = notify_url;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getTrade_type() {
    return trade_type;
  }

  public void setTrade_type(String trade_type) {
    this.trade_type = trade_type;
  }

  public String getPayUrl() {
    return payUrl;
  }

  public void setPayUrl(String payUrl) {
    this.payUrl = payUrl;
  }

  public SceneInfo getScene_info() {
    return scene_info;
  }

  public void setScene_info(SceneInfo scene_info) {
    this.scene_info = scene_info;
  }

  public String getBackUrl() {
    return backUrl;
  }

  public void setBackUrl(String backUrl) {
    this.backUrl = backUrl;
  }

  public static PayConfig getTestPayConfig() {
    PayConfig config = new PayConfig();
    config.setPayUrl("https://api.mch.weixin.qq.com/pay/unifiedorder");
    config.setAppid("wxc108799082cbbae8");
    config.setBody("壹路巴巴-维修订单结算");
    config.setKey("cdxp1688payappkeyinfom1234567890");
    config.setMch_id("1512123271");
    config.setNotify_url("https://cdxp1688.com/pay/");
    config.setTrade_type("MWEB");
    config.setScene_info(SceneInfo.getTestSceneInfo());
    config.setBackUrl("http://127.0.0.1:20000/pay/payback");
    return config;
  }
}
