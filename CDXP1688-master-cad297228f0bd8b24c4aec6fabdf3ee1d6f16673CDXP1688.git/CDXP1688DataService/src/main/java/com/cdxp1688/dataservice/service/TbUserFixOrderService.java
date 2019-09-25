package com.cdxp1688.dataservice.service;

import com.cdxp1688.dataservice.model.TbUserFixOrderModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbUserFixOrder服务
 * 
 * @author 胡辉煜
 */
public interface TbUserFixOrderService {

  /**
   * 师傅接单
   * 
   * @param model
   *              页面数据
   * @return 师傅接单结果
   * @throws Exception
   *                   处理发生异常
   */
  JsonMessage pickOrder(TbUserFixOrderModel model) throws Exception;

  /**
   * 师傅报价
   * 
   * @param model
   *              页面数据
   * @return 师傅报价结果
   * @throws Exception
   *                   处理发生异常
   */
  JsonMessage orderPrice(TbUserFixOrderModel model) throws Exception;

  /**
   * 师傅修改报价
   * 
   * @param model
   *              页面数据
   * @return 师傅修改报价结果
   * @throws Exception
   *                   处理发生异常
   */
  JsonMessage modifyOrderPrice(TbUserFixOrderModel model) throws Exception;

  /**
   * 师傅完成维修
   * 
   * @param model
   *              页面数据
   * @return 师傅完成维修结果
   * @throws Exception
   *                   处理发生异常
   */
  JsonMessage finishWork(TbUserFixOrderModel model) throws Exception;

  /**
   * 师傅完成订单
   * 
   * @param model
   *              页面数据
   * @return 师傅完成订单结果
   * @throws Exception
   *                   处理发生异常
   */
  JsonMessage finish(TbUserFixOrderModel model) throws Exception;

  /**
   * 查询师傅进行中的订单
   * 
   * @param model
   *              页面数据
   * @return 师傅的订单
   * @throws Exception
   *                   处理发生异常
   */
  JsonMessage queryByWorker(TbUserFixOrderModel model) throws Exception;

  /**
   * 查询师傅已完成的订单
   * 
   * @param model
   *              页面数据
   * @return 师傅的订单
   * @throws Exception
   *                   处理发生异常
   */
  JsonMessage queryByWorkerFinish(TbUserFixOrderModel model) throws Exception;
}
