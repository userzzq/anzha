package com.cdxp1688.dataservice.service;

import com.cdxp1688.dataservice.model.IndexModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * 首页服务
 * 
 * @author 胡辉煜
 *
 */
public interface IndexService {

  /**
   * 首页
   * 
   * @param model 页面数据
   * @return 应答结果
   * @throws Exception 处理发生异常
   */
  JsonMessage index(IndexModel model) throws Exception;
}
