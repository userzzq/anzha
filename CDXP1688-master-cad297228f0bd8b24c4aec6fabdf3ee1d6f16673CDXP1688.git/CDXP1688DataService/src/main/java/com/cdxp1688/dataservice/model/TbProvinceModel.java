package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbProvince;

/**
 * TbProvince的Model
 * 
 * @author 胡辉煜
 *
 */
public class TbProvinceModel extends BasePageModel {

  private static final long serialVersionUID = 5162180176415256433L;

  private TbProvince tbProvince=new TbProvince();
  
  public TbProvinceModel() {
  }

  public TbProvince getTbProvince() {
    return tbProvince;
  }

  public void setTbProvince(TbProvince tbProvince) {
    this.tbProvince = tbProvince;
  }
  
}
