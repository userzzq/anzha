package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbFixOrderDetail;
import com.cdxp1688.dataservice.entity.TbUserFixOrder;

/**
 * TbUserFixOrder的Model
 * 
 * @author 胡辉煜
 */
public class TbUserFixOrderModel extends BasePageModel {

  private static final long serialVersionUID = -401269928474063359L;

  private TbUserFixOrder   tbUserFixOrder   = new TbUserFixOrder();
  private TbFixOrderDetail tbFixOrderDetail = new TbFixOrderDetail();

  public TbUserFixOrderModel() {
  }

  public TbUserFixOrder getTbUserFixOrder() {
    return tbUserFixOrder;
  }

  public void setTbUserFixOrder(TbUserFixOrder tbUserFixOrder) {
    this.tbUserFixOrder = tbUserFixOrder;
  }

  public TbFixOrderDetail getTbFixOrderDetail() {
    return tbFixOrderDetail;
  }

  public void setTbFixOrderDetail(TbFixOrderDetail tbFixOrderDetail) {
    this.tbFixOrderDetail = tbFixOrderDetail;
  }

}
