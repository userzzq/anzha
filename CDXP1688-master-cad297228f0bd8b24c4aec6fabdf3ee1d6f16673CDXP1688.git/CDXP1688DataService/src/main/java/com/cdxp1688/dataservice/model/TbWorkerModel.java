package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbWorker;

/**
 * TbWorker的Model
 * 
 * @author 胡辉煜
 *
 */
public class TbWorkerModel extends BasePageModel {

  private static final long serialVersionUID = 5531472087712611377L;

  private String phoneCode;
  private TbWorker tbWorker = new TbWorker();

  public TbWorkerModel() {
  }

  public String getPhoneCode() {
    return phoneCode;
  }

  public void setPhoneCode(String phoneCode) {
    this.phoneCode = phoneCode;
  }

  public TbWorker getTbWorker() {
    return tbWorker;
  }

  public void setTbWorker(TbWorker tbWorker) {
    this.tbWorker = tbWorker;
  }

}
