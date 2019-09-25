package com.cdxp1688.dataservice.converter;

import org.springframework.core.convert.converter.Converter;

import com.cdxp1688.dataservice.utils.MyUtils;

/**
 * 字符串转换器（去空）
 * 
 * @author 胡辉煜
 *
 */
public class StringConverter implements Converter<String, String> {

  @Override
  public String convert(String source) {
    return MyUtils.trim(source);
  }

}
