package com.cdxp1688.dataservice.service;

import com.cdxp1688.dataservice.model.TbPayRecodeModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbPayRecode的Service
 * 
 * @author 胡辉煜
 *
 */
public interface TbPayRecodeService {

  /**
   * 修改TbPayRecode信息
   * 
   * @param model 页面提交数据
   * @return 修改TbPayRecode信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage update(TbPayRecodeModel model) throws Exception;

  /**
   * 删除TbPayRecode信息
   * 
   * @param model 页面提交数据
   * @return 删除TbPayRecode信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage delete(TbPayRecodeModel model) throws Exception;

  /**
   * 添加TbPayRecode信息
   * 
   * @param model 页面提交数据
   * @return 添加TbPayRecode信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage add(TbPayRecodeModel model) throws Exception;

  /**
   * 按照主键查询TbPayRecode信息
   * 
   * @param model 页面提交数据
   * @return 主键查询TbPayRecode信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryByKey(TbPayRecodeModel model) throws Exception;

  /**
   * 分页查询TbPayRecode信息
   * 
   * @param model 页面提交数据
   * @return 分页查询TbPayRecode信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryAll(TbPayRecodeModel model) throws Exception;

  JsonMessage queryWorker(TbPayRecodeModel model) throws Exception;

  JsonMessage queryByWorker(TbPayRecodeModel model) throws Exception;

  JsonMessage queryWorkerPay(TbPayRecodeModel model) throws Exception;

}
