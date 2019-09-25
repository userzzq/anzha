package com.cdxp1688.dataservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cdxp1688.dataservice.utils.MyUtils;

/**
 * Double数值转换器
 * 
 * @author 胡辉煜
 *
 */
@Component
public class DoubleConverter implements Converter<String, Double> {

  @Override
  public Double convert(String source) {
    if (MyUtils.isEmpty(source)) {
      return null;
    }
    source = MyUtils.trim(source);
    try {
      return Double.valueOf(source);
    } catch (Exception ex) {
    }
    return null;
  }

}
