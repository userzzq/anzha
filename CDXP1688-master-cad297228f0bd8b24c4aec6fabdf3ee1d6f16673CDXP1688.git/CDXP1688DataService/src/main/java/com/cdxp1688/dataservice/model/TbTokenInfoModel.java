package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbTokenInfo;

/**
 * TbTokenInfo的Model
 * 
 * @author 胡辉煜
 *
 */
public class TbTokenInfoModel extends BasePageModel {

  private static final long serialVersionUID = 5337919279084233043L;

  private TbTokenInfo tbTokenInfo=new TbTokenInfo();
  
  public TbTokenInfoModel() {
  }

  public TbTokenInfo getTbTokenInfo() {
    return tbTokenInfo;
  }

  public void setTbTokenInfo(TbTokenInfo tbTokenInfo) {
    this.tbTokenInfo = tbTokenInfo;
  }
  
}
