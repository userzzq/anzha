package com.cdxp1688.dataservice.entity;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * TbCity表
 * 
 * @author 胡辉煜
 *
 */
public class TbCity extends BaseEntity {

  private static final long serialVersionUID = 7965357067748701696L;
  
  private java.lang.Integer cid;
  private java.lang.Integer pid;
  private java.lang.String city;
  private java.lang.String info;
  private java.util.Date lastupdate;

  public TbCity() {
  }
  
  public java.lang.Integer getCid(){
    return cid;
  }

  public void setCid(java.lang.Integer cid){
    this.cid=cid;
  }

  public java.lang.Integer getPid(){
    return pid;
  }

  public void setPid(java.lang.Integer pid){
    this.pid=pid;
  }

  public java.lang.String getCity(){
    return city;
  }

  public void setCity(java.lang.String city){
    this.city=city;
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
