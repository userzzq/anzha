package com.cdxp1688.dataservice.pay;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * 回调url配置
 * 
 * @author 胡辉煜
 */
public class CallbackUrls extends BaseEntity {
  private static final long serialVersionUID = -8101986425477134422L;
  private String            openid;
  private String            openidBack;
  private String            payNotify;
  private String            pay;
  private String            wxpay;

  public CallbackUrls() {
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getPayNotify() {
    return payNotify;
  }

  public void setPayNotify(String payNotify) {
    this.payNotify = payNotify;
  }

  public String getPay() {
    return pay;
  }

  public void setPay(String pay) {
    this.pay = pay;
  }

  public String getWxpay() {
    return wxpay;
  }

  public void setWxpay(String wxpay) {
    this.wxpay = wxpay;
  }

  public String getOpenidBack() {
    return openidBack;
  }

  public void setOpenidBack(String openidBack) {
    this.openidBack = openidBack;
  }

  public static CallbackUrls getTestCallbackUrls() {
    CallbackUrls callbackUrls = new CallbackUrls();
    callbackUrls.setOpenid("https://cdxp1688.com/testpay/pay/openidBack");
    callbackUrls.setOpenidBack("https://cdxp1688.com/testapp/#!/route/page/user/openidBack");
    callbackUrls.setPayNotify("https://cdxp1688.com/testpay/pay/notify");
    callbackUrls.setPay("https://cdxp1688.com/testpay/pay/payback");
    callbackUrls.setWxpay("https://cdxp1688.com/app/wxpay.html?%s");
    return callbackUrls;
  }
}
