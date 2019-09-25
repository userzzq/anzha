package com.cdxp1688.dataservice.pay;

import com.alibaba.fastjson.JSONObject;
import com.cdxp1688.dataservice.base.BaseEntity;

public class SceneInfo extends BaseEntity {

  private static final long  serialVersionUID = -8575250862614428367L;
  public static final String KEY              = "h5_info";

  private String type;
  private String wap_url;
  private String wap_name;

  public SceneInfo() {
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getWap_url() {
    return wap_url;
  }

  public void setWap_url(String wap_url) {
    this.wap_url = wap_url;
  }

  public String getWap_name() {
    return wap_name;
  }

  public void setWap_name(String wap_name) {
    this.wap_name = wap_name;
  }

  public String json() {
    JSONObject json = new JSONObject();
    json.put(SceneInfo.KEY, this);
    return json.toJSONString();
  }

  public static SceneInfo getTestSceneInfo() {
    SceneInfo info = new SceneInfo();
    info.setType("Wap");
    info.setWap_name("壹路巴巴");
    info.setWap_url("https://cdxp1688.com/app/");
    return info;
  }

}
