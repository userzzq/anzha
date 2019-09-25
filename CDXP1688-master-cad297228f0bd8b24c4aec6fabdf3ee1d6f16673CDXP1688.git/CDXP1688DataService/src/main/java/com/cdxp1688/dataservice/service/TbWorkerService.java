package com.cdxp1688.dataservice.service;

import java.io.OutputStream;
import com.cdxp1688.dataservice.model.TbWorkerModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbWorker的Service
 * 
 * @author 胡辉煜
 */
public interface TbWorkerService {

  /**
   * 修改TbWorker信息
   * 
   * @param model
   *              页面提交数据
   * @return 修改TbWorker信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage update(TbWorkerModel model) throws Exception;

  /**
   * 删除TbWorker信息
   * 
   * @param model
   *              页面提交数据
   * @return 删除TbWorker信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage delete(TbWorkerModel model) throws Exception;

  /**
   * 添加TbWorker信息
   * 
   * @param model
   *              页面提交数据
   * @return 添加TbWorker信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage add(TbWorkerModel model) throws Exception;

  /**
   * 按照主键查询TbWorker信息
   * 
   * @param model
   *              页面提交数据
   * @return 主键查询TbWorker信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryByKey(TbWorkerModel model) throws Exception;

  /**
   * 分页查询TbWorker信息
   * 
   * @param model
   *              页面提交数据
   * @return 分页查询TbWorker信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryAll(TbWorkerModel model) throws Exception;

  /**
   * 注册
   * 
   * @param model
   *              页面提交数据
   * @return 注册的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage reg(TbWorkerModel model) throws Exception;

  /**
   * 表单需要的相关信息查询
   * 
   * @param model
   *              页面提交数据
   * @return 表单需要的相关信息
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryFormInfo(TbWorkerModel model) throws Exception;

  /**
   * 登录
   * 
   * @param model
   *              页面提交数据
   * @return 登录的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage login(TbWorkerModel model) throws Exception;

  /**
   * 登出
   * 
   * @param model
   *              页面提交数据
   * @return 登出的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage logout(TbWorkerModel model) throws Exception;

  /**
   * 查询
   * 
   * @param model
   *              页面提交数据
   * @return 查询的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryWorker(TbWorkerModel model) throws Exception;

  /**
   * 修改TbWorker的isEnable状态
   * 
   * @param model
   *              页面提交数据
   * @return 修改TbWorker的isEnable状态的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage updateEnable(TbWorkerModel model) throws Exception;

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
  void exportExcel(TbWorkerModel model, OutputStream os) throws Exception;

  /**
   * 修改TbWorker的inWork状态
   * 
   * @param model
   *              页面提交数据
   * @return 修改TbWorker的inWork状态的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage updateInWork(TbWorkerModel model) throws Exception;

  JsonMessage modifyPwd(TbWorkerModel model) throws Exception;

}
