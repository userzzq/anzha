package com.cdxp1688.dataservice.entity;

import java.util.List;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * TbWorkerReport表
 * 
 * @author 胡辉煜
 *
 */
public class TbWorkerReport extends BaseEntity {

  private static final long serialVersionUID = -5468561030855831545L;

  private java.lang.Integer wrid;
  private java.lang.Integer wid;
  private java.lang.Integer cid;
  private java.lang.String address;
  private java.lang.String username;
  private java.lang.String phone;
  private java.lang.String areainfo;
  private java.util.Date opendate;
  private java.lang.String decorate;
  private java.util.Date lastupdate;
  private List<TbReportPeople> peoples;
  private TbWorker worker;

  public TbWorkerReport() {
  }

  public java.lang.Integer getWrid() {
    return wrid;
  }

  public void setWrid(java.lang.Integer wrid) {
    this.wrid = wrid;
  }

  public java.lang.Integer getWid() {
    return wid;
  }

  public void setWid(java.lang.Integer wid) {
    this.wid = wid;
  }

  public java.lang.Integer getCid() {
    return cid;
  }

  public void setCid(java.lang.Integer cid) {
    this.cid = cid;
  }

  public java.lang.String getAddress() {
    return address;
  }

  public void setAddress(java.lang.String address) {
    this.address = address;
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

  public java.lang.String getAreainfo() {
    return areainfo;
  }

  public void setAreainfo(java.lang.String areainfo) {
    this.areainfo = areainfo;
  }

  public java.util.Date getOpendate() {
    return opendate;
  }

  public void setOpendate(java.util.Date opendate) {
    this.opendate = opendate;
  }

  public java.lang.String getDecorate() {
    return decorate;
  }

  public void setDecorate(java.lang.String decorate) {
    this.decorate = decorate;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

  public List<TbReportPeople> getPeoples() {
    return peoples;
  }

  public void setPeoples(List<TbReportPeople> peoples) {
    this.peoples = peoples;
  }

  public TbWorker getWorker() {
    return worker;
  }

  public void setWorker(TbWorker worker) {
    this.worker = worker;
  }

}
