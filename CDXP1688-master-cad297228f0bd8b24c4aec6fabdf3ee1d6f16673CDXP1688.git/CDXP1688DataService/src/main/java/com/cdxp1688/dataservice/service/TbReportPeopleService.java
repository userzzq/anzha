package com.cdxp1688.dataservice.service;

import com.cdxp1688.dataservice.model.TbReportPeopleModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbReportPeople的Service
 * 
 * @author 胡辉煜
 *
 */
public interface TbReportPeopleService {

  /**
   * 修改TbReportPeople信息
   * 
   * @param model 页面提交数据
   * @return 修改TbReportPeople信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage update(TbReportPeopleModel model) throws Exception;

  /**
   * 删除TbReportPeople信息
   * 
   * @param model 页面提交数据
   * @return 删除TbReportPeople信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage delete(TbReportPeopleModel model) throws Exception;

  /**
   * 添加TbReportPeople信息
   * 
   * @param model 页面提交数据
   * @return 添加TbReportPeople信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage add(TbReportPeopleModel model) throws Exception;

  /**
   * 按照主键查询TbReportPeople信息
   * 
   * @param model 页面提交数据
   * @return 主键查询TbReportPeople信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryByKey(TbReportPeopleModel model) throws Exception;

  /**
   * 分页查询TbReportPeople信息
   * 
   * @param model 页面提交数据
   * @return 分页查询TbReportPeople信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryAll(TbReportPeopleModel model) throws Exception;

}
