package com.cdxp1688.dataservice.entity;

import java.math.BigDecimal;
import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * TbUserFixOrder表
 * 
 * @author 胡辉煜
 */
public class TbUserFixOrder extends BaseEntity {

  private static final long serialVersionUID = -507893718972287718L;

  private java.lang.Integer ufoid;
  private java.lang.Integer wid;
  private java.lang.Integer ufid;
  private java.lang.String  info;
  private java.util.Date    lastupdate;
  private TbWorker          worker;
  private TbUserFixInfo     fixinfo;
  private int               detailCount;
  private BigDecimal        price;

  public TbUserFixOrder() {
  }

  public java.lang.Integer getUfoid() {
    return ufoid;
  }

  public void setUfoid(java.lang.Integer ufoid) {
    this.ufoid = ufoid;
  }

  public java.lang.Integer getWid() {
    return wid;
  }

  public void setWid(java.lang.Integer wid) {
    this.wid = wid;
  }

  public java.lang.Integer getUfid() {
    return ufid;
  }

  public void setUfid(java.lang.Integer ufid) {
    this.ufid = ufid;
  }

  public java.lang.String getInfo() {
    return info;
  }

  public void setInfo(java.lang.String info) {
    this.info = info;
  }

  public java.util.Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate) {
    this.lastupdate = lastupdate;
  }

  public TbWorker getWorker() {
    return worker;
  }

  public void setWorker(TbWorker worker) {
    this.worker = worker;
  }

  public TbUserFixInfo getFixinfo() {
    return fixinfo;
  }

  public void setFixinfo(TbUserFixInfo fixinfo) {
    this.fixinfo = fixinfo;
  }

  public int getDetailCount() {
    return detailCount;
  }

  public void setDetailCount(int detailCount) {
    this.detailCount = detailCount;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

}
