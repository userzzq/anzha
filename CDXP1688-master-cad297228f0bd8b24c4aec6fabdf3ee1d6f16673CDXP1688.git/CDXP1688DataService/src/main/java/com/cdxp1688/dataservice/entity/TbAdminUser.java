package com.cdxp1688.dataservice.entity;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * TbAdminUser表
 * 
 * @author 胡辉煜
 *
 */
public class TbAdminUser extends BaseEntity {

  private static final long serialVersionUID = -2676286848065764228L;
  
  private java.lang.Integer auid;
  private java.lang.String username;
  private java.lang.String password;
  private java.lang.String nickname;
  private java.lang.String isEnable;
  private java.util.Date lastupdate;

  public TbAdminUser() {
  }
  
  public java.lang.Integer getAuid(){
    return auid;
  }

  public void setAuid(java.lang.Integer auid){
    this.auid=auid;
  }

  public java.lang.String getUsername(){
    return username;
  }

  public void setUsername(java.lang.String username){
    this.username=username;
  }

  public java.lang.String getPassword(){
    return password;
  }

  public void setPassword(java.lang.String password){
    this.password=password;
  }

  public java.lang.String getNickname(){
    return nickname;
  }

  public void setNickname(java.lang.String nickname){
    this.nickname=nickname;
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
