package com.cdxp1688.dataservice.entity;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * TbReporterType表
 * 
 * @author 胡辉煜
 *
 */
public class TbReporterType extends BaseEntity {

  private static final long serialVersionUID = 7691095545625109358L;
  
  private java.lang.Integer rtid;
  private java.lang.String typeName;
  private java.lang.String typeInfo;
  private java.lang.String isEnable;
  private java.util.Date lastupdate;

  public TbReporterType() {
  }
  
  public java.lang.Integer getRtid(){
    return rtid;
  }

  public void setRtid(java.lang.Integer rtid){
    this.rtid=rtid;
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
