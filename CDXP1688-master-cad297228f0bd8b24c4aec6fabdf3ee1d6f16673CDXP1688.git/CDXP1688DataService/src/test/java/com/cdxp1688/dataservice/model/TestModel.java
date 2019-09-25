package com.cdxp1688.dataservice.model;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TestEntity;

/**
 * 测试用model
 * 
 * @author 胡辉煜
 *
 */
public class TestModel extends BasePageModel {
  private static final long serialVersionUID = -5322671579046365036L;

  private String imageCode;
  private TestEntity testEntity;

  public TestModel() {
  }

  public String getImageCode() {
    return imageCode;
  }

  public void setImageCode(String imageCode) {
    this.imageCode = imageCode;
  }

  public TestEntity getTestEntity() {
    return testEntity;
  }

  public void setTestEntity(TestEntity testEntity) {
    this.testEntity = testEntity;
  }

}
