package com.cdxp1688.dataservice.service;

import com.cdxp1688.dataservice.model.TbTokenModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbToken的Service
 * 
 * @author 胡辉煜
 *
 */
public interface TbTokenService {

  /**
   * 修改TbToken信息
   * 
   * @param model 页面提交数据
   * @return 修改TbToken信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage update(TbTokenModel model) throws Exception;

  /**
   * 删除TbToken信息
   * 
   * @param model 页面提交数据
   * @return 删除TbToken信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage delete(TbTokenModel model) throws Exception;

  /**
   * 添加TbToken信息
   * 
   * @param model 页面提交数据
   * @return 添加TbToken信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage add(TbTokenModel model) throws Exception;

  /**
   * 按照主键查询TbToken信息
   * 
   * @param model 页面提交数据
   * @return 主键查询TbToken信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryByKey(TbTokenModel model) throws Exception;

  /**
   * 分页查询TbToken信息
   * 
   * @param model 页面提交数据
   * @return 分页查询TbToken信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryAll(TbTokenModel model) throws Exception;

}
