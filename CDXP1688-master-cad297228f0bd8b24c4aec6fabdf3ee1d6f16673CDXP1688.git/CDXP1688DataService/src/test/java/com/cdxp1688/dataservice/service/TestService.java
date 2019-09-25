package com.cdxp1688.dataservice.service;

import com.cdxp1688.dataservice.model.TestModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * 测试用service
 * 
 * @author 胡辉煜
 *
 */
public interface TestService {
  /**
   * 查询TbToken信息
   * 
   * @param model 页面数据
   * @return TbToken信息
   * @throws Exception 处理发生异常
   */
  JsonMessage queryAllToken(TestModel model) throws Exception;
}
