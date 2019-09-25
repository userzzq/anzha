package com.cdxp1688.dataservice.service;

import com.cdxp1688.dataservice.model.TbTokenInfoModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbTokenInfo的Service
 * 
 * @author 胡辉煜
 *
 */
public interface TbTokenInfoService {

  /**
   * 修改TbTokenInfo信息
   * 
   * @param model 页面提交数据
   * @return 修改TbTokenInfo信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage update(TbTokenInfoModel model) throws Exception;

  /**
   * 删除TbTokenInfo信息
   * 
   * @param model 页面提交数据
   * @return 删除TbTokenInfo信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage delete(TbTokenInfoModel model) throws Exception;

  /**
   * 添加TbTokenInfo信息
   * 
   * @param model 页面提交数据
   * @return 添加TbTokenInfo信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage add(TbTokenInfoModel model) throws Exception;

  /**
   * 按照主键查询TbTokenInfo信息
   * 
   * @param model 页面提交数据
   * @return 主键查询TbTokenInfo信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryByKey(TbTokenInfoModel model) throws Exception;

  /**
   * 分页查询TbTokenInfo信息
   * 
   * @param model 页面提交数据
   * @return 分页查询TbTokenInfo信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryAll(TbTokenInfoModel model) throws Exception;

}
