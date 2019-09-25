package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BaseModel;

/**
 * 工具控制器的model
 * 
 * @author 胡辉煜
 *
 */
public class UtilModel extends BaseModel {
  private static final long serialVersionUID = 2826781514125236000L;

  private String phone;
  private String imageCode;

  public UtilModel() {
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getImageCode() {
    return imageCode;
  }

  public void setImageCode(String imageCode) {
    this.imageCode = imageCode;
  }

}
