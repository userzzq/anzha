package com.cdxp1688.dataservice.service;

import com.cdxp1688.dataservice.model.TbWokerTypeModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbWokerType的Service
 * 
 * @author 胡辉煜
 *
 */
public interface TbWokerTypeService {

  /**
   * 修改TbWokerType信息
   * 
   * @param model 页面提交数据
   * @return 修改TbWokerType信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage update(TbWokerTypeModel model) throws Exception;

  /**
   * 删除TbWokerType信息
   * 
   * @param model 页面提交数据
   * @return 删除TbWokerType信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage delete(TbWokerTypeModel model) throws Exception;

  /**
   * 添加TbWokerType信息
   * 
   * @param model 页面提交数据
   * @return 添加TbWokerType信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage add(TbWokerTypeModel model) throws Exception;

  /**
   * 按照主键查询TbWokerType信息
   * 
   * @param model 页面提交数据
   * @return 主键查询TbWokerType信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryByKey(TbWokerTypeModel model) throws Exception;

  /**
   * 分页查询TbWokerType信息
   * 
   * @param model 页面提交数据
   * @return 分页查询TbWokerType信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryAll(TbWokerTypeModel model) throws Exception;

}
