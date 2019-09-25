package com.cdxp1688.dataservice.service;

import com.cdxp1688.dataservice.pay.UnifiedorderResult;

/**
 * 支付服务
 * 
 * @author 胡辉煜
 */
public interface PayService {

  /**
   * 获取openid的code信息的url
   * 
   * @return 获取openid的code信息的url
   * @throws Exception
   */
  String getOpenidCodeUrl() throws Exception;

  /**
   * 获取openid信息的url
   * 
   * @return 获取openid信息的url
   * @throws Exception
   */
  String getOpenidUrl(String code) throws Exception;

  /**
   * 获取openid信息
   * 
   * @param code
   *             校验code
   * @return openid信息
   * @throws Exception
   */
  String getOpenid(String code) throws Exception;

  String getOrderUrl(String ip,int ufid) throws Exception;

  UnifiedorderResult getWxOrderInfo(String ip, String openid, String price) throws Exception;

  String getWxOrderUrl(String ip, String openid, int ufid) throws Exception;

  String getOpenidBackUrl(String openid) throws Exception;

  void payNotice(String info) throws Exception;
}
