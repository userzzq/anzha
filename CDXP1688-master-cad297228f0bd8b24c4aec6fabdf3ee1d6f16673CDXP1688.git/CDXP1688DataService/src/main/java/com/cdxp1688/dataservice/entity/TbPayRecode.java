package com.cdxp1688.dataservice.entity;

import top.huhuiyu.api.utils.mybase.BaseEntity;

/**
 * TbPayRecode表
 * 
 * @author 胡辉煜
 *
 */
public class TbPayRecode extends BaseEntity {

  private static final long serialVersionUID = -7392074158900750900L;
  
  private java.lang.Integer prid;
  private java.lang.Integer wid;
  private java.math.BigDecimal price;
  private java.util.Date lastupdate;

  public TbPayRecode() {
  }
  
  public java.lang.Integer getPrid(){
    return prid;
  }

  public void setPrid(java.lang.Integer prid){
    this.prid=prid;
  }

  public java.lang.Integer getWid(){
    return wid;
  }

  public void setWid(java.lang.Integer wid){
    this.wid=wid;
  }

  public java.math.BigDecimal getPrice(){
    return price;
  }

  public void setPrice(java.math.BigDecimal price){
    this.price=price;
  }

  public java.util.Date getLastupdate(){
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate){
    this.lastupdate=lastupdate;
  }


}
