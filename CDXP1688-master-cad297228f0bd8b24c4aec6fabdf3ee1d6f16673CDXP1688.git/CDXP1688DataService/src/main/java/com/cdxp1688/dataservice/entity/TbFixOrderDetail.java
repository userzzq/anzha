package com.cdxp1688.dataservice.entity;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * TbFixOrderDetail表
 * 
 * @author 胡辉煜
 */
public class TbFixOrderDetail extends BaseEntity {

  private static final long serialVersionUID = -6179549861644096643L;

  private java.lang.Integer    fodid;
  private java.lang.Integer    ufoid;
  private java.lang.String     detail;
  private java.math.BigDecimal price;
  private java.util.Date       lastupdate;

  public TbFixOrderDetail() {
  }

  public java.lang.Integer getFodid() {
    return fodid;
  }

  public void setFodid(java.lang.Integer fodid) {
    this.fodid = fodid;
  }

  public java.lang.Integer getUfoid() {
    return ufoid;
  }

  public void setUfoid(java.lang.Integer ufoid) {
    this.ufoid = ufoid;
  }

  public java.lang.String getDetail() {
    return detail;
  }

  public void setDetail(java.lang.String detail) {
    this.detail = detail;
  }

  public java.math.BigDecimal getPrice() {
    return price;
  }

  public void setPrice(java.math.BigDecimal price) {
    this.price = price;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
