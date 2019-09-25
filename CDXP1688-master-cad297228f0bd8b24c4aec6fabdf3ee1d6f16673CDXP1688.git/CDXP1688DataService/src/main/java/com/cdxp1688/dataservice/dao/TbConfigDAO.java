package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbConfig;

/**
 * TbConfig表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbConfigDAO {

  /**
   * 查询师傅在线模式信息
   * 
   * @return SmsConfig信息
   * @throws Exception
   *                   处理发生异常
   */
  TbConfig queryWorkerOnlineConfig() throws Exception;

  /**
   * 查询SmsConfig信息
   * 
   * @return SmsConfig信息
   * @throws Exception
   *                   处理发生异常
   */
  TbConfig querySmsConfig() throws Exception;

  /**
   * 查询微信配置信息
   * 
   * @return WxConfig信息
   * @throws Exception
   *                   处理发生异常
   */
  TbConfig queryWxConfig() throws Exception;

  /**
   * 查询回调url配置信息
   * 
   * @return CallbackUrls信息
   * @throws Exception
   *                   处理发生异常
   */
  TbConfig queryCallbackUrlsConfig() throws Exception;

  /**
   * 查询支付配置信息
   * 
   * @return 支付配置信息
   * @throws Exception
   *                   处理发生异常
   */
  TbConfig queryPayConfig() throws Exception;

  /**
   * 查询wx支付基础信息
   * 
   * @return wx支付基础信息
   * @throws Exception
   *                   处理发生异常
   */
  TbConfig queryWxPayInfo() throws Exception;

  /**
   * 查询文件上传服务器信息
   * 
   * @return 文件上传服务器信息
   * @throws Exception
   *                   处理发生异常
   */
  TbConfig queryUpfileConfig() throws Exception;

  /**
   * 查询全部TbConfig
   *
   * @return TbConfig的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbConfig> queryAll() throws Exception;

  /**
   * 按照主键查询TbConfig
   *
   * @param tbConfig主键信息
   * @return 主键查询TbConfig的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbConfig queryByKey(TbConfig tbConfig) throws Exception;

  /**
   * 添加TbConfig信息
   *
   * @param tbConfig信息
   * @return 添加tbConfig信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int add(TbConfig tbConfig) throws Exception;

  /**
   * 修改TbConfig信息
   *
   * @param tbConfig信息
   * @return 修改tbConfig信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int update(TbConfig tbConfig) throws Exception;

  /**
   * 删除TbConfig信息
   *
   * @param tbConfig信息
   * @return 删除tbConfig信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int delete(TbConfig tbConfig) throws Exception;

}
