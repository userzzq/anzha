package com.cdxp1688.dataservice.entity;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * TbUser表
 * 
 * @author 胡辉煜
 */
public class TbUser extends BaseEntity {

  private static final long serialVersionUID = -6355265634317824629L;

  private java.lang.Integer uid;
  private java.lang.String  phone;
  private java.lang.String  password;
  private java.lang.String  name;
  private java.lang.String  address;
  private java.lang.String  isEnable;
  private java.util.Date    lastupdate;

  public TbUser() {
  }

  public java.lang.Integer getUid() {
    return uid;
  }

  public void setUid(java.lang.Integer uid) {
    this.uid = uid;
  }

  public java.lang.String getPhone() {
    return phone;
  }

  public void setPhone(java.lang.String phone) {
    this.phone = phone;
  }

  public java.lang.String getPassword() {
    return password;
  }

  public void setPassword(java.lang.String password) {
    this.password = password;
  }

  public java.lang.String getName() {
    return name;
  }

  public void setName(java.lang.String name) {
    this.name = name;
  }

  public java.lang.String getAddress() {
    return address;
  }

  public void setAddress(java.lang.String address) {
    this.address = address;
  }

  public java.lang.String getIsEnable() {
    return isEnable;
  }

  public void setIsEnable(java.lang.String isEnable) {
    this.isEnable = isEnable;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
