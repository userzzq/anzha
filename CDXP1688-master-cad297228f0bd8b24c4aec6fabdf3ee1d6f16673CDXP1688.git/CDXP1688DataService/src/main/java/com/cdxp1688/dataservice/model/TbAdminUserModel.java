package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbAdminUser;

/**
 * TbAdminUser的Model
 * 
 * @author 胡辉煜
 *
 */
public class TbAdminUserModel extends BasePageModel {

  private static final long serialVersionUID = -5886287729403535159L;

  private TbAdminUser tbAdminUser = new TbAdminUser();
  private String oldPwd = "";

  public TbAdminUserModel() {
  }

  public TbAdminUser getTbAdminUser() {
    return tbAdminUser;
  }

  public void setTbAdminUser(TbAdminUser tbAdminUser) {
    this.tbAdminUser = tbAdminUser;
  }

  public String getOldPwd() {
    return oldPwd;
  }

  public void setOldPwd(String oldPwd) {
    this.oldPwd = oldPwd;
  }

}
