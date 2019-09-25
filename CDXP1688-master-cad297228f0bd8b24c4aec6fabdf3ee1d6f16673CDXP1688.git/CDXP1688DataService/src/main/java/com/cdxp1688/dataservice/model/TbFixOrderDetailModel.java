package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbFixOrderDetail;

/**
 * TbFixOrderDetail的Model
 * 
 * @author 胡辉煜
 *
 */
public class TbFixOrderDetailModel extends BasePageModel {

  private static final long serialVersionUID = -4869027609538461718L;

  private TbFixOrderDetail tbFixOrderDetail=new TbFixOrderDetail();
  
  public TbFixOrderDetailModel() {
  }

  public TbFixOrderDetail getTbFixOrderDetail() {
    return tbFixOrderDetail;
  }

  public void setTbFixOrderDetail(TbFixOrderDetail tbFixOrderDetail) {
    this.tbFixOrderDetail = tbFixOrderDetail;
  }
  
}
