package com.cdxp1688.dataservice.base;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public interface ConstValues {
  String           ENABLE            = "y";
  SimpleDateFormat DATA_FORMAT       = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  SimpleDateFormat SHORT_DATA_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

  Map<String, String> FIX_TYPES = new HashMap<String, String>() {
    private static final long serialVersionUID = -8877486151141865437L;

    {
      put("10", "我要修");
      put("11", "我要洗");
      put("12", "我要装");
    }
  };

  Map<String, String> FIX_STUTAS = new HashMap<String, String>() {
    private static final long serialVersionUID = -8877486151141865437L;

    {
      put("10", "已经下单");
      put("11", "已经接单");
      put("12", "已经取消");
      put("13", "已经完成");
      put("14", "其它");
    }
  };
}
