package com.cdxp1688.dataservice.sms;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * 模板配置信息类
 * 
 * @author 胡辉煜
 */
public class PhoneTemplate extends BaseEntity {

  private static final long serialVersionUID = 4786155038043378764L;

  private String validateCode;
  private String workerNotify;
  private String userNotify;
  private String cancelOrder;
  private String findpwd;

  public PhoneTemplate() {
  }

  public String getValidateCode() {
    return validateCode;
  }

  public void setValidateCode(String validateCode) {
    this.validateCode = validateCode;
  }

  public String getWorkerNotify() {
    return workerNotify;
  }

  public void setWorkerNotify(String workerNotify) {
    this.workerNotify = workerNotify;
  }

  public String getUserNotify() {
    return userNotify;
  }

  public void setUserNotify(String userNotify) {
    this.userNotify = userNotify;
  }

  public String getCancelOrder() {
    return cancelOrder;
  }

  public void setCancelOrder(String cancelOrder) {
    this.cancelOrder = cancelOrder;
  }

  public String getFindpwd() {
    return findpwd;
  }

  public void setFindpwd(String findpwd) {
    this.findpwd = findpwd;
  }

}
