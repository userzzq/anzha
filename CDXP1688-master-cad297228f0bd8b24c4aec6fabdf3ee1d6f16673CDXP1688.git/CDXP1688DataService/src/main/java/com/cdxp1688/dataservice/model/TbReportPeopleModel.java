package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbReportPeople;

/**
 * TbReportPeople的Model
 * 
 * @author 胡辉煜
 *
 */
public class TbReportPeopleModel extends BasePageModel {

  private static final long serialVersionUID = -5458003375281780880L;

  private TbReportPeople tbReportPeople=new TbReportPeople();
  
  public TbReportPeopleModel() {
  }

  public TbReportPeople getTbReportPeople() {
    return tbReportPeople;
  }

  public void setTbReportPeople(TbReportPeople tbReportPeople) {
    this.tbReportPeople = tbReportPeople;
  }
  
}
