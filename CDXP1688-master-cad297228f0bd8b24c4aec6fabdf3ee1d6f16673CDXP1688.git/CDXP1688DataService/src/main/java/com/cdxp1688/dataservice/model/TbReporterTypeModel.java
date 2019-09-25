package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbReporterType;

/**
 * TbReporterType的Model
 * 
 * @author 胡辉煜
 *
 */
public class TbReporterTypeModel extends BasePageModel {

  private static final long serialVersionUID = -6227215391712839099L;

  private TbReporterType tbReporterType=new TbReporterType();
  
  public TbReporterTypeModel() {
  }

  public TbReporterType getTbReporterType() {
    return tbReporterType;
  }

  public void setTbReporterType(TbReporterType tbReporterType) {
    this.tbReporterType = tbReporterType;
  }
  
}
