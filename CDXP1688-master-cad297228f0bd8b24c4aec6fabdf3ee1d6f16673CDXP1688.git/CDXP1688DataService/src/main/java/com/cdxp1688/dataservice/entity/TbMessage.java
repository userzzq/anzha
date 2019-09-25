package com.cdxp1688.dataservice.entity;

import top.huhuiyu.api.utils.mybase.BaseEntity;

/**
 * TbMessage表
 * 
 * @author 胡辉煜
 *
 */
public class TbMessage extends BaseEntity {

  private static final long serialVersionUID = -107374216859790595L;
  
  private java.lang.Integer mid;
  private java.lang.String mtype;
  private java.lang.Integer uid;
  private java.lang.String info;
  private java.lang.String readed;
  private java.util.Date lastupdate;

  public TbMessage() {
  }
  
  public java.lang.Integer getMid(){
    return mid;
  }

  public void setMid(java.lang.Integer mid){
    this.mid=mid;
  }

  public java.lang.String getMtype(){
    return mtype;
  }

  public void setMtype(java.lang.String mtype){
    this.mtype=mtype;
  }

  public java.lang.Integer getUid(){
    return uid;
  }

  public void setUid(java.lang.Integer uid){
    this.uid=uid;
  }

  public java.lang.String getInfo(){
    return info;
  }

  public void setInfo(java.lang.String info){
    this.info=info;
  }

  public java.lang.String getReaded(){
    return readed;
  }

  public void setReaded(java.lang.String readed){
    this.readed=readed;
  }

  public java.util.Date getLastupdate(){
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate){
    this.lastupdate=lastupdate;
  }


}
