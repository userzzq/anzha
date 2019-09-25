package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbCity;

/**
 * TbCity的Model
 * 
 * @author 胡辉煜
 *
 */
public class TbCityModel extends BasePageModel {

  private static final long serialVersionUID = 6173403898870522270L;

  private TbCity tbCity=new TbCity();
  
  public TbCityModel() {
  }

  public TbCity getTbCity() {
    return tbCity;
  }

  public void setTbCity(TbCity tbCity) {
    this.tbCity = tbCity;
  }
  
}
