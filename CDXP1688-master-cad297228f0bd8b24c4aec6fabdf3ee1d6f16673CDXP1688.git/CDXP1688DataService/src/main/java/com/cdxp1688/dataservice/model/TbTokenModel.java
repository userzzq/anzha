package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbToken;

/**
 * TbToken的Model
 * 
 * @author 胡辉煜
 *
 */
public class TbTokenModel extends BasePageModel {

  private static final long serialVersionUID = -8305757174635626115L;

  private TbToken tbToken=new TbToken();
  
  public TbTokenModel() {
  }

  public TbToken getTbToken() {
    return tbToken;
  }

  public void setTbToken(TbToken tbToken) {
    this.tbToken = tbToken;
  }
  
}
