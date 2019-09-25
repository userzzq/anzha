package com.cdxp1688.dataservice.pay;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * 支付信息
 * 
 * @author 胡辉煜
 */
public class WxPayInfo extends BaseEntity implements Cloneable {
  private static final long serialVersionUID = -3743374903465814217L;

  private String    body;
  private String    trade_type;
  private SceneInfo scene_info;
  private String    nonce_str;
  private String    out_trade_no;
  private String    total_fee;
  private String    spbill_create_ip;
  private String    openid;

  public WxPayInfo() {
  }

  @Override
  public WxPayInfo clone() throws CloneNotSupportedException {
    return (WxPayInfo) super.clone();
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

  public SceneInfo getScene_info() {
    return scene_info;
  }

  public void setScene_info(SceneInfo scene_info) {
    this.scene_info = scene_info;
  }

  public String getNonce_str() {
    return nonce_str;
  }

  public void setNonce_str(String nonce_str) {
    this.nonce_str = nonce_str;
  }

  public String getOut_trade_no() {
    return out_trade_no;
  }

  public void setOut_trade_no(String out_trade_no) {
    this.out_trade_no = out_trade_no;
  }

  public String getTotal_fee() {
    return total_fee;
  }

  public void setTotal_fee(String total_fee) {
    this.total_fee = total_fee;
  }

  public String getSpbill_create_ip() {
    return spbill_create_ip;
  }

  public void setSpbill_create_ip(String spbill_create_ip) {
    this.spbill_create_ip = spbill_create_ip;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public static WxPayInfo getTestWxPayInfo() {
    WxPayInfo wxPayInfo = new WxPayInfo();
    SceneInfo info      = new SceneInfo();
    info.setWap_name("壹路巴巴");
    info.setWap_url("https://cdxp1688.com/app/");
    wxPayInfo.setScene_info(info);
    wxPayInfo.setBody("壹路巴巴-维修订单结算");
    return wxPayInfo;
  }
}
