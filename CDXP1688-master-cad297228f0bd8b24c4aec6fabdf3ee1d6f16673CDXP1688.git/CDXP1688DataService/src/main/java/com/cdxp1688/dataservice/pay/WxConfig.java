package com.cdxp1688.dataservice.pay;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * 微信开发相关配置
 * 
 * @author 胡辉煜
 */
public class WxConfig extends BaseEntity {

  private static final long serialVersionUID = -6279273174212134828L;

  /**
   * 微信开发的appid
   */
  private String appid;
  /**
   * 微信开发的secret
   */
  private String secret;
  /**
   * 商户id
   */
  private String mch_id;
  /**
   * 商户支付key
   */
  private String key;
  /**
   * 发起支付的url
   */
  private String payUrl;

  /**
   * 获取token的url模板
   */
  private String tokenUrl;

  /**
   * 获取openid的code的url模板
   */
  private String openidCodeUrl;
  /**
   * 获取openid的url模板
   */
  private String openidUrl;

  public WxConfig() {
  }

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
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

  public String getPayUrl() {
    return payUrl;
  }

  public void setPayUrl(String payUrl) {
    this.payUrl = payUrl;
  }

  public String getTokenUrl() {
    return tokenUrl;
  }

  public void setTokenUrl(String tokenUrl) {
    this.tokenUrl = tokenUrl;
  }

  public String getOpenidCodeUrl() {
    return openidCodeUrl;
  }

  public void setOpenidCodeUrl(String openidCodeUrl) {
    this.openidCodeUrl = openidCodeUrl;
  }

  public String getOpenidUrl() {
    return openidUrl;
  }

  public void setOpenidUrl(String openidUrl) {
    this.openidUrl = openidUrl;
  }

  public static WxConfig getTestWxConfig() {
    WxConfig config = new WxConfig();
    config.setAppid("wxc108799082cbbae8");
    config.setKey("cdxp1688payappkeyinfom1234567890");
    config.setMch_id("1512123271");
    config.setOpenidCodeUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=%s&appid=%s&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
    config.setOpenidUrl("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&grant_type=authorization_code&code=%s");
    config.setPayUrl("https://api.mch.weixin.qq.com/pay/unifiedorder");
    config.setSecret("f5b888f67dd0dfe2a36f1ce299e865be");
    config.setTokenUrl("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s");
    return config;
  }

}
