package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbPayRecode;
import com.cdxp1688.dataservice.entity.TbWorker;

/**
 * TbPayRecode的Model
 * 
 * @author 胡辉煜
 */
public class TbPayRecodeModel extends BasePageModel {

  private static final long serialVersionUID = 1520425171902794439L;

  private TbPayRecode tbPayRecode = new TbPayRecode();
  private TbWorker    tbWorker    = new TbWorker();

  public TbPayRecodeModel() {
  }

  public TbPayRecode getTbPayRecode() {
    return tbPayRecode;
  }

  public void setTbPayRecode(TbPayRecode tbPayRecode) {
    this.tbPayRecode = tbPayRecode;
  }

  public TbWorker getTbWorker() {
    return tbWorker;
  }

  public void setTbWorker(TbWorker tbWorker) {
    this.tbWorker = tbWorker;
  }

}
