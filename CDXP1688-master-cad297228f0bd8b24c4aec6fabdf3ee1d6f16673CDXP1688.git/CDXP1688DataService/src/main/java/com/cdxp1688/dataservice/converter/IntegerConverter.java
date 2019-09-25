package com.cdxp1688.dataservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cdxp1688.dataservice.utils.MyUtils;

/**
 * Integer数值转换器
 * 
 * @author 胡辉煜
 *
 */
@Component
public class IntegerConverter implements Converter<String, Integer> {

  @Override
  public Integer convert(String source) {
    if (MyUtils.isEmpty(source)) {
      return null;
    }
    source = MyUtils.trim(source);
    try {
      return Integer.parseInt(source);
    } catch (Exception ex) {
    }
    return null;
  }

}
