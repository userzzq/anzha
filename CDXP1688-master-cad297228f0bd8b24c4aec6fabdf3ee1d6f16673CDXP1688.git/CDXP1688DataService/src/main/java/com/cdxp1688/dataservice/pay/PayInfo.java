package com.cdxp1688.dataservice.pay;

import java.util.UUID;
import com.cdxp1688.dataservice.base.BaseEntity;

public class PayInfo extends BaseEntity {
  private static final long serialVersionUID = -7755101911322333049L;

  private String nonce_str;
  private String out_trade_no;
  private String total_fee;
  private String spbill_create_ip;

  public PayInfo() {
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

  public static PayInfo getTestPayInfo() {
    PayInfo info = new PayInfo();
    info.setNonce_str(UUID.randomUUID().toString().replaceAll("[-]", ""));
    info.setOut_trade_no(UUID.randomUUID().toString().replaceAll("[-]", ""));
    info.setTotal_fee("1");
    info.setSpbill_create_ip("127.0.0.1");
    return info;
  }

}
