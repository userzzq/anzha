package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbWorkerType;

/**
 * TbWokerType的Model
 * 
 * @author 胡辉煜
 *
 */
public class TbWokerTypeModel extends BasePageModel {

  private static final long serialVersionUID = 4309582129342535322L;

  private TbWorkerType tbWorkerType = new TbWorkerType();

  public TbWokerTypeModel() {
  }

  public TbWorkerType getTbWorkerType() {
    return tbWorkerType;
  }

  public void setTbWorkerType(TbWorkerType tbWorkerType) {
    this.tbWorkerType = tbWorkerType;
  }

}
