package com.cdxp1688.dataservice.service;

import com.cdxp1688.dataservice.model.TbConfigModel;
import com.cdxp1688.dataservice.pay.CallbackUrls;
import com.cdxp1688.dataservice.pay.PayConfig;
import com.cdxp1688.dataservice.pay.WxConfig;
import com.cdxp1688.dataservice.pay.WxPayInfo;
import com.cdxp1688.dataservice.sms.SmsConfig;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbConfig的Service
 * 
 * @author 胡辉煜
 */
public interface TbConfigService {

  /**
   * 修改TbConfig信息
   * 
   * @param model
   *              页面提交数据
   * @return 修改TbConfig信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage update(TbConfigModel model) throws Exception;

  /**
   * 删除TbConfig信息
   * 
   * @param model
   *              页面提交数据
   * @return 删除TbConfig信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage delete(TbConfigModel model) throws Exception;

  /**
   * 添加TbConfig信息
   * 
   * @param model
   *              页面提交数据
   * @return 添加TbConfig信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage add(TbConfigModel model) throws Exception;

  /**
   * 按照主键查询TbConfig信息
   * 
   * @param model
   *              页面提交数据
   * @return 主键查询TbConfig信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryByKey(TbConfigModel model) throws Exception;

  /**
   * 分页查询TbConfig信息
   * 
   * @param model
   *              页面提交数据
   * @return 分页查询TbConfig信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryAll(TbConfigModel model) throws Exception;

  /**
   * 查询SmsConfig配置信息
   * 
   * @return SmsConfig配置信息
   * @throws Exception
   *                   处理发生错误
   */
  SmsConfig querySmsConfig() throws Exception;

  /**
   * 查询支付配置信息
   * 
   * @return 支付配置信息
   * @throws Exception
   *                   处理发生错误
   */
  PayConfig queryPayConfig() throws Exception;

  /**
   * 查询微信配置信息
   * 
   * @return 支付配置信息
   * @throws Exception
   *                   处理发生错误
   */
  WxConfig queryWxConfig() throws Exception;

  /**
   * 查询回调url配置信息
   * 
   * @return CallbackUrls信息
   * @throws Exception
   *                   处理发生错误
   */
  CallbackUrls queryCallbackUrlsConfig() throws Exception;

  WxPayInfo queryWxPayInfoConfig() throws Exception;

}
