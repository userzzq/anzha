package com.cdxp1688.dataservice.entity;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * TbReportPeople表
 * 
 * @author 胡辉煜
 *
 */
public class TbReportPeople extends BaseEntity {

  private static final long serialVersionUID = 8809909313431266215L;

  private java.lang.Integer rpid;
  private java.lang.Integer wrid;
  private java.lang.Integer rtid;
  private java.lang.String username;
  private java.lang.String phone;
  private java.util.Date lastupdate;
  private TbReporterType type;

  public TbReportPeople() {
  }

  public java.lang.Integer getRpid() {
    return rpid;
  }

  public void setRpid(java.lang.Integer rpid) {
    this.rpid = rpid;
  }

  public java.lang.Integer getWrid() {
    return wrid;
  }

  public void setWrid(java.lang.Integer wrid) {
    this.wrid = wrid;
  }

  public java.lang.Integer getRtid() {
    return rtid;
  }

  public void setRtid(java.lang.Integer rtid) {
    this.rtid = rtid;
  }

  public java.lang.String getUsername() {
    return username;
  }

  public void setUsername(java.lang.String username) {
    this.username = username;
  }

  public java.lang.String getPhone() {
    return phone;
  }

  public void setPhone(java.lang.String phone) {
    this.phone = phone;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

  public TbReporterType getType() {
    return type;
  }

  public void setType(TbReporterType type) {
    this.type = type;
  }

}
