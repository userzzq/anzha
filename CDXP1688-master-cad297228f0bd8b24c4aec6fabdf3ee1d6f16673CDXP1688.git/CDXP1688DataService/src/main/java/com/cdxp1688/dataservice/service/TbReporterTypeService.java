package com.cdxp1688.dataservice.service;

import com.cdxp1688.dataservice.model.TbReporterTypeModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbReporterType的Service
 * 
 * @author 胡辉煜
 *
 */
public interface TbReporterTypeService {

  /**
   * 修改TbReporterType信息
   * 
   * @param model 页面提交数据
   * @return 修改TbReporterType信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage update(TbReporterTypeModel model) throws Exception;

  /**
   * 删除TbReporterType信息
   * 
   * @param model 页面提交数据
   * @return 删除TbReporterType信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage delete(TbReporterTypeModel model) throws Exception;

  /**
   * 添加TbReporterType信息
   * 
   * @param model 页面提交数据
   * @return 添加TbReporterType信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage add(TbReporterTypeModel model) throws Exception;

  /**
   * 按照主键查询TbReporterType信息
   * 
   * @param model 页面提交数据
   * @return 主键查询TbReporterType信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryByKey(TbReporterTypeModel model) throws Exception;

  /**
   * 分页查询TbReporterType信息
   * 
   * @param model 页面提交数据
   * @return 分页查询TbReporterType信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryAll(TbReporterTypeModel model) throws Exception;

}
