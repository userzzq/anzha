package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbUserFixInfo;

/**
 * TbUserFixInfo的Model
 * 
 * @author 胡辉煜
 */
public class TbUserFixInfoModel extends BasePageModel {

  private static final long serialVersionUID = -573066927313852464L;

  private TbUserFixInfo tbUserFixInfo = new TbUserFixInfo();

  public TbUserFixInfoModel() {
  }

  public TbUserFixInfo getTbUserFixInfo() {
    return tbUserFixInfo;
  }

  public void setTbUserFixInfo(TbUserFixInfo tbUserFixInfo) {
    this.tbUserFixInfo = tbUserFixInfo;
  }

}
