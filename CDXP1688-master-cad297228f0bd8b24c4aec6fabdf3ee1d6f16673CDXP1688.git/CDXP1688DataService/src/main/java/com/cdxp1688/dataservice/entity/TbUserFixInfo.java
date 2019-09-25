package com.cdxp1688.dataservice.entity;

import java.math.BigDecimal;
import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * TbUserFixInfo表
 * 
 * @author 胡辉煜
 */
public class TbUserFixInfo extends BaseEntity {

  private static final long serialVersionUID = 6709021114484036175L;

  private java.lang.Integer ufid;
  private java.lang.Integer uid;
  private java.lang.String  info;
  private java.lang.String  address;
  private java.lang.String  addressInfo;
  private java.lang.String  lat;
  private java.lang.String  lng;
  private java.lang.String  phone;
  private java.lang.String  images;
  private java.lang.String  fixtype;
  private java.lang.String  status;
  private java.util.Date    lastupdate;
  private TbUser            user;
  private TbWorker          worker;
  private BigDecimal        price;
  private String            out_trade_no;

  public TbUserFixInfo() {
  }

  public java.lang.Integer getUfid() {
    return ufid;
  }

  public void setUfid(java.lang.Integer ufid) {
    this.ufid = ufid;
  }

  public java.lang.Integer getUid() {
    return uid;
  }

  public void setUid(java.lang.Integer uid) {
    this.uid = uid;
  }

  public java.lang.String getInfo() {
    return info;
  }

  public void setInfo(java.lang.String info) {
    this.info = info;
  }

  public java.lang.String getAddress() {
    return address;
  }

  public void setAddress(java.lang.String address) {
    this.address = address;
  }

  public java.lang.String getAddressInfo() {
    return addressInfo;
  }

  public void setAddressInfo(java.lang.String addressInfo) {
    this.addressInfo = addressInfo;
  }

  public java.lang.String getLat() {
    return lat;
  }

  public void setLat(java.lang.String lat) {
    this.lat = lat;
  }

  public java.lang.String getLng() {
    return lng;
  }

  public void setLng(java.lang.String lng) {
    this.lng = lng;
  }

  public java.lang.String getPhone() {
    return phone;
  }

  public void setPhone(java.lang.String phone) {
    this.phone = phone;
  }

  public java.lang.String getImages() {
    return images;
  }

  public void setImages(java.lang.String images) {
    this.images = images;
  }

  public java.lang.String getFixtype() {
    return fixtype;
  }

  public void setFixtype(java.lang.String fixtype) {
    this.fixtype = fixtype;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String status) {
    this.status = status;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

  public TbUser getUser() {
    return user;
  }

  public void setUser(TbUser user) {
    this.user = user;
  }

  public TbWorker getWorker() {
    return worker;
  }

  public void setWorker(TbWorker worker) {
    this.worker = worker;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getOut_trade_no() {
    return out_trade_no;
  }

  public void setOut_trade_no(String out_trade_no) {
    this.out_trade_no = out_trade_no;
  }

}
