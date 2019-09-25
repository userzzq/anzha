package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbConfig;

/**
 * TbConfig的Model
 * 
 * @author 胡辉煜
 *
 */
public class TbConfigModel extends BasePageModel {

  private static final long serialVersionUID = 4441431674289638666L;

  private TbConfig tbConfig=new TbConfig();
  
  public TbConfigModel() {
  }

  public TbConfig getTbConfig() {
    return tbConfig;
  }

  public void setTbConfig(TbConfig tbConfig) {
    this.tbConfig = tbConfig;
  }
  
}
