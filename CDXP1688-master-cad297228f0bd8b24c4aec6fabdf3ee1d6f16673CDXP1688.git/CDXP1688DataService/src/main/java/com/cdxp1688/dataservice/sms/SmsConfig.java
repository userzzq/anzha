package com.cdxp1688.dataservice.sms;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * 短信配置信息类
 * 
 * @author 胡辉煜
 *
 */
public class SmsConfig extends BaseEntity {

  private static final long serialVersionUID = 1831297059639841846L;
  /**
   * 短信API产品名称（短信产品名固定，无需修改）
   */
  private String product;
  /**
   * 短信API产品域名（接口地址固定，无需修改）
   */
  private String domain;
  /**
   * 区域1
   */
  private String region1;
  /**
   * 区域2
   */
  private String region2;
  /**
   * 开发者id
   */
  private String accesskeyid;
  /**
   * 开发者认证
   */
  private String accesskeysecret;
  /**
   * 签名
   */
  private String sign;
  /**
   * 模板信息
   */
  private PhoneTemplate template;

  public SmsConfig() {
  }

  public SmsConfig(String product, String domain, String region1, String region2, String accesskeyid, String accesskeysecret, String sign) {
    this.product = product;
    this.domain = domain;
    this.region1 = region1;
    this.region2 = region2;
    this.accesskeyid = accesskeyid;
    this.accesskeysecret = accesskeysecret;
    this.sign = sign;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getRegion1() {
    return region1;
  }

  public void setRegion1(String region1) {
    this.region1 = region1;
  }

  public String getRegion2() {
    return region2;
  }

  public void setRegion2(String region2) {
    this.region2 = region2;
  }

  public String getAccesskeyid() {
    return accesskeyid;
  }

  public void setAccesskeyid(String accesskeyid) {
    this.accesskeyid = accesskeyid;
  }

  public String getAccesskeysecret() {
    return accesskeysecret;
  }

  public void setAccesskeysecret(String accesskeysecret) {
    this.accesskeysecret = accesskeysecret;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public PhoneTemplate getTemplate() {
    return template;
  }

  public void setTemplate(PhoneTemplate template) {
    this.template = template;
  }

}
