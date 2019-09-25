package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbUser;

/**
 * TbUser的Model
 * 
 * @author 胡辉煜
 *
 */
public class TbUserModel extends BasePageModel {

  private static final long serialVersionUID = 5504823705133885784L;

  private TbUser tbUser = new TbUser();
  private String phoneCode;

  public TbUserModel() {
  }

  public TbUser getTbUser() {
    return tbUser;
  }

  public void setTbUser(TbUser tbUser) {
    this.tbUser = tbUser;
  }

  public String getPhoneCode() {
    return phoneCode;
  }

  public void setPhoneCode(String phoneCode) {
    this.phoneCode = phoneCode;
  }

}
