package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BaseModel;

/**
 * 首页model层
 * 
 * @author 胡辉煜
 *
 */
public class IndexModel extends BaseModel {

  private static final long serialVersionUID = 1838955825297547990L;
  private String echo;

  public IndexModel() {
  }

  public String getEcho() {
    return echo;
  }

  public void setEcho(String echo) {
    this.echo = echo;
  }

}
