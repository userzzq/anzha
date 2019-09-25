package com.cdxp1688.dataservice.entity;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * 测试用实体
 * 
 * @author 胡辉煜
 *
 */
public class TestEntity extends BaseEntity {

  private static final long serialVersionUID = -3058506613576578417L;

  private String echo;
  private TbToken tbToken;

  public TestEntity() {
  }

  public String getEcho() {
    return echo;
  }

  public void setEcho(String echo) {
    this.echo = echo;
  }

  public TbToken getTbToken() {
    return tbToken;
  }

  public void setTbToken(TbToken tbToken) {
    this.tbToken = tbToken;
  }

}
