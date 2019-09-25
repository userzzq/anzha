package com.cdxp1688.dataservice.entity;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * TbWokerType表
 * 
 * @author 胡辉煜
 *
 */
public class TbWorkerType extends BaseEntity {

  private static final long serialVersionUID = -8376735086897646192L;
  
  private java.lang.Integer wtid;
  private java.lang.String typeName;
  private java.lang.String typeInfo;
  private java.lang.String isEnable;
  private java.util.Date lastupdate;

  public TbWorkerType() {
  }
  
  public java.lang.Integer getWtid(){
    return wtid;
  }

  public void setWtid(java.lang.Integer wtid){
    this.wtid=wtid;
  }

  public java.lang.String getTypeName(){
    return typeName;
  }

  public void setTypeName(java.lang.String typeName){
    this.typeName=typeName;
  }

  public java.lang.String getTypeInfo(){
    return typeInfo;
  }

  public void setTypeInfo(java.lang.String typeInfo){
    this.typeInfo=typeInfo;
  }

  public java.lang.String getIsEnable(){
    return isEnable;
  }

  public void setIsEnable(java.lang.String isEnable){
    this.isEnable=isEnable;
  }

  public java.util.Date getLastupdate(){
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate){
    this.lastupdate=lastupdate;
  }


}
