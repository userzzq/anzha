package com.cdxp1688.dataservice.base;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

/**
 * Entity和数据传输类型的对象的基础类，统一toString为json格式
 * 
 * @author 胡辉煜
 *
 */
public abstract class BaseEntity implements Serializable {

  private static final long serialVersionUID = -2560054102408339624L;

  @Override
  public String toString() {
    // 创建fastjson的json对象
    JSONObject json = new JSONObject();
    // 将当前实例以当前类的名称为key放入json对象中
    json.put(this.getClass().getName(), this);
    // 返回json格式字符串
    return json.toString();
  }

}
