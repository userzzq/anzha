package com.cdxp1688.dataservice.service;

import com.cdxp1688.dataservice.model.TbCityModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbCity的Service
 * 
 * @author 胡辉煜
 *
 */
public interface TbCityService {

  /**
   * 修改TbCity信息
   * 
   * @param model 页面提交数据
   * @return 修改TbCity信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage update(TbCityModel model) throws Exception;

  /**
   * 删除TbCity信息
   * 
   * @param model 页面提交数据
   * @return 删除TbCity信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage delete(TbCityModel model) throws Exception;

  /**
   * 添加TbCity信息
   * 
   * @param model 页面提交数据
   * @return 添加TbCity信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage add(TbCityModel model) throws Exception;

  /**
   * 按照主键查询TbCity信息
   * 
   * @param model 页面提交数据
   * @return 主键查询TbCity信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryByKey(TbCityModel model) throws Exception;

  /**
   * 分页查询TbCity信息
   * 
   * @param model 页面提交数据
   * @return 分页查询TbCity信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryAll(TbCityModel model) throws Exception;

}
