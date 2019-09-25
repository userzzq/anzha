package com.cdxp1688.dataservice.entity;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * TbTokenInfo表
 * 
 * @author 胡辉煜
 *
 */
public class TbTokenInfo extends BaseEntity {

  private static final long serialVersionUID = 9125493745025571358L;
  
  private java.lang.String token;
  private java.lang.String infoKey;
  private java.lang.String info;
  private java.util.Date lastupdate;

  public TbTokenInfo() {
  }
  
  public java.lang.String getToken(){
    return token;
  }

  public void setToken(java.lang.String token){
    this.token=token;
  }

  public java.lang.String getInfoKey(){
    return infoKey;
  }

  public void setInfoKey(java.lang.String infoKey){
    this.infoKey=infoKey;
  }

  public java.lang.String getInfo(){
    return info;
  }

  public void setInfo(java.lang.String info){
    this.info=info;
  }

  public java.util.Date getLastupdate(){
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate){
    this.lastupdate=lastupdate;
  }


}
