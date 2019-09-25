package com.cdxp1688.dataservice.entity;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * TbProvince表
 * 
 * @author 胡辉煜
 *
 */
public class TbProvince extends BaseEntity {

  private static final long serialVersionUID = 5176587750937025402L;
  
  private java.lang.Integer pid;
  private java.lang.String province;
  private java.lang.String info;
  private java.util.Date lastupdate;

  public TbProvince() {
  }
  
  public java.lang.Integer getPid(){
    return pid;
  }

  public void setPid(java.lang.Integer pid){
    this.pid=pid;
  }

  public java.lang.String getProvince(){
    return province;
  }

  public void setProvince(java.lang.String province){
    this.province=province;
  }

  public java.lang.String getInfo(){
    return info;
  }

  public void setInfo(java.lang.String info){
    this.info=info;
  }

  public java.util.Date getLastupdate(){
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate){
    this.lastupdate=lastupdate;
  }


}
