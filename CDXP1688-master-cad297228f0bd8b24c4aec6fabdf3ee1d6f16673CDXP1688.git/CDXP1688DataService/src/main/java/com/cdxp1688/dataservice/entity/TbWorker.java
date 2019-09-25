package com.cdxp1688.dataservice.entity;

import java.math.BigDecimal;
import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * TbWorker表
 * 
 * @author 胡辉煜
 */
public class TbWorker extends BaseEntity {

  private static final long serialVersionUID = -1729293164194257117L;

  private java.lang.Integer wid;
  private java.lang.Integer wtid;
  private java.lang.Integer cid;
  private java.lang.String  address;
  private java.lang.String  phone;
  private java.lang.String  name;
  private java.lang.String  password;
  private java.lang.String  recommend;
  private java.lang.String  isEnable;
  private java.lang.String  inWork;
  private java.util.Date    lastupdate;
  private TbWorkerType      type;
  private BigDecimal        payTotal;
  private BigDecimal        total;

  public BigDecimal getPayTotal() {
    if (payTotal == null) {
      return new BigDecimal("0");
    }
    return payTotal;
  }

  public void setPayTotal(BigDecimal payTotal) {
    this.payTotal = payTotal;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public TbWorker() {
  }

  public java.lang.Integer getWid() {
    return wid;
  }

  public void setWid(java.lang.Integer wid) {
    this.wid = wid;
  }

  public java.lang.Integer getWtid() {
    return wtid;
  }

  public void setWtid(java.lang.Integer wtid) {
    this.wtid = wtid;
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

  public java.lang.String getRecommend() {
    return recommend;
  }

  public void setRecommend(java.lang.String recommend) {
    this.recommend = recommend;
  }

  public java.lang.String getIsEnable() {
    return isEnable;
  }

  public void setIsEnable(java.lang.String isEnable) {
    this.isEnable = isEnable;
  }

  public java.lang.String getInWork() {
    return inWork;
  }

  public void setInWork(java.lang.String inWork) {
    this.inWork = inWork;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

  public TbWorkerType getType() {
    return type;
  }

  public void setType(TbWorkerType type) {
    this.type = type;
  }

  public BigDecimal getNeedPay() {
    if (total == null) {
      return new BigDecimal("0.0");
    }
    if (payTotal == null) {
      return total;
    }
    return total.subtract(payTotal);
  }

}
