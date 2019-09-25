package com.cdxp1688.dataservice.entity;

import java.util.Date;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * TbToken表
 * 
 * @author 胡辉煜
 *
 */
public class TbToken extends BaseEntity {
  private static final long serialVersionUID = 7218008179098719025L;
  private String token;
  private Integer uid;
  private Date lastupdate;

  public TbToken() {
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
