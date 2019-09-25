package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbMessage;

/**
 * TbMessage的Model
 * 
 * @author 胡辉煜
 *
 */
public class TbMessageModel extends BasePageModel {

  private static final long serialVersionUID = 4584644698680891595L;

  private TbMessage tbMessage=new TbMessage();
  
  public TbMessageModel() {
  }

  public TbMessage getTbMessage() {
    return tbMessage;
  }

  public void setTbMessage(TbMessage tbMessage) {
    this.tbMessage = tbMessage;
  }
  
}
