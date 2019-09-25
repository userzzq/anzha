package com.cdxp1688.dataservice.utils;

import java.util.Map;
import com.alibaba.fastjson.JSON;

/**
 * Json工具类
 * 
 * @author 胡辉煜
 */
public class JsonUtil {

  /**
   * 转换对象为json字符串
   * 
   * @param obj
   *            java对象
   * @return json字符串
   * @throws Exception
   *                   转换发生异常
   */
  public static String stringify(Object obj) throws Exception {
    return JSON.toJSONString(obj);
  }

  /**
   * 转换json字符串为对象
   * 
   * @param json
   *             json字符串
   * @param c
   *             对象类型
   * @return 对象转换结果
   * @throws Exception
   *                   转换发生异常
   */
  public static <T> T parse(String json, Class<T> c) throws Exception {
    return JSON.parseObject(json, c);
  }

  /**
   * 转换json字符串为map
   * 
   * @param json
   *             json字符串
   * @return map
   * @throws Exception
   *                   转换发生异常
   */
  @SuppressWarnings("unchecked")
  public static Map<String, String> parse(String json) throws Exception {
    return JSON.parseObject(json, Map.class);
  }

}
