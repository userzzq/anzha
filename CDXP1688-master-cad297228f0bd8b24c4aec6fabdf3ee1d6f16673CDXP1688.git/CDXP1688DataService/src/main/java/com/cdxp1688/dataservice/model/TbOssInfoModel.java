package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbOssInfo;

/**
 * TbOssInfo的Model
 * 
 * @author 胡辉煜
 */
public class TbOssInfoModel extends BasePageModel {

  private static final long serialVersionUID = 5485168198030413233L;

  private TbOssInfo tbOssInfo = new TbOssInfo();

  public TbOssInfoModel() {
  }

  public TbOssInfo getTbOssInfo() {
    return tbOssInfo;
  }

  public void setTbOssInfo(TbOssInfo tbOssInfo) {
    this.tbOssInfo = tbOssInfo;
  }

}
