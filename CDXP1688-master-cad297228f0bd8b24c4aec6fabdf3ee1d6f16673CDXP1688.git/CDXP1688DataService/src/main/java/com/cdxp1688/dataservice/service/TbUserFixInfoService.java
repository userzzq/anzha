package com.cdxp1688.dataservice.service;

import java.io.OutputStream;
import org.springframework.web.multipart.MultipartFile;
import com.cdxp1688.dataservice.model.TbUserFixInfoModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbUserFixInfo的Service
 * 
 * @author 胡辉煜
 */
public interface TbUserFixInfoService {

  /**
   * 修改TbUserFixInfo信息
   * 
   * @param model
   *              页面提交数据
   * @return 修改TbUserFixInfo信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage update(TbUserFixInfoModel model) throws Exception;

  /**
   * 删除TbUserFixInfo信息
   * 
   * @param model
   *              页面提交数据
   * @return 删除TbUserFixInfo信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage delete(TbUserFixInfoModel model) throws Exception;

  /**
   * 添加TbUserFixInfo信息
   * 
   * @param model
   *              页面提交数据
   * @param files
   *              附件的维修图片
   * @return 添加TbUserFixInfo信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage add(TbUserFixInfoModel model, MultipartFile[] files) throws Exception;

  /**
   * 按照主键查询TbUserFixInfo信息
   * 
   * @param model
   *              页面提交数据
   * @return 主键查询TbUserFixInfo信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryByKey(TbUserFixInfoModel model) throws Exception;

  /**
   * 分页查询TbUserFixInfo信息
   * 
   * @param model
   *              页面提交数据
   * @return 分页查询TbUserFixInfo信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryAll(TbUserFixInfoModel model) throws Exception;

  /**
   * 按照用户查询进行中TbUserFixInfo信息
   * 
   * @param model
   *              页面提交数据
   * @return 按照用户查询TbUserFixInfo信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryByUser(TbUserFixInfoModel model) throws Exception;

  /**
   * 按照用户查询已完成TbUserFixInfo信息
   * 
   * @param model
   *              页面提交数据
   * @return 按照用户查询TbUserFixInfo信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryByUserFinish(TbUserFixInfoModel model) throws Exception;

  /**
   * 按照修理信息查询图片信息
   * 
   * @param model
   *              页面提交数据
   * @return 按照修理信息查询图片信的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryObjectNamesByUserFixInfo(TbUserFixInfoModel model) throws Exception;

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
  void exportExcel(TbUserFixInfoModel model, OutputStream os) throws Exception;

  /**
   * 查询下单中的信息
   * 
   * @param model
   *              页面提交数据
   * @return 下单中的信息
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryWorkerFixinfo(TbUserFixInfoModel model) throws Exception;

  /**
   * 取消订单
   * 
   * @param model
   *              页面提交数据
   * @return 取消订单的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage cancel(TbUserFixInfoModel model) throws Exception;

  /**
   * 支付订单
   * 
   * @param model
   *              页面提交数据
   * @return 支付订单的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage pay(TbUserFixInfoModel model) throws Exception;

  /**
   * 确定报价
   * 
   * @param model
   *              页面提交数据
   * @return 支付订单的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage price(TbUserFixInfoModel model) throws Exception;

}
