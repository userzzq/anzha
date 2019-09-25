package com.cdxp1688.dataservice.service;

import java.io.OutputStream;
import com.cdxp1688.dataservice.model.TbWorkerReportModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbWorkerReport的Service
 * 
 * @author 胡辉煜
 */
public interface TbWorkerReportService {

  /**
   * 修改TbWorkerReport信息
   * 
   * @param model
   *              页面提交数据
   * @return 修改TbWorkerReport信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage update(TbWorkerReportModel model) throws Exception;

  /**
   * 删除TbWorkerReport信息
   * 
   * @param model
   *              页面提交数据
   * @return 删除TbWorkerReport信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage delete(TbWorkerReportModel model) throws Exception;

  /**
   * 添加TbWorkerReport信息
   * 
   * @param model
   *              页面提交数据
   * @return 添加TbWorkerReport信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage add(TbWorkerReportModel model) throws Exception;

  /**
   * 按照主键查询TbWorkerReport信息
   * 
   * @param model
   *              页面提交数据
   * @return 主键查询TbWorkerReport信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryByKey(TbWorkerReportModel model) throws Exception;

  /**
   * 分页查询TbWorkerReport信息
   * 
   * @param model
   *              页面提交数据
   * @return 分页查询TbWorkerReport信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryAll(TbWorkerReportModel model) throws Exception;

  /**
   * 查询表单需要的信息
   * 
   * @param model
   *              页面提交数据
   * @return 查询表单需要的信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryFormInfo(TbWorkerReportModel model) throws Exception;

  /**
   * 分页查询woker的TbWorkerReport信息
   * 
   * @param model
   *              页面提交数据
   * @return 分页查询TbWorkerReport信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryByWid(TbWorkerReportModel model) throws Exception;

  /**
   * 导出excel
   * 
   * @param model
   *              页面提交数据
   * @param os
   *              输出流
   * @throws Exception
   *                   处理发生错误
   */
  void exportExcel(TbWorkerReportModel model, OutputStream os) throws Exception;

}
