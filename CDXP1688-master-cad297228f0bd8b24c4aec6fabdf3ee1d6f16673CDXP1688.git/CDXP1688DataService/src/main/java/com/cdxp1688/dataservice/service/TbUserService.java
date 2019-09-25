package com.cdxp1688.dataservice.service;

import java.io.OutputStream;
import com.cdxp1688.dataservice.model.TbUserModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbUser的Service
 * 
 * @author 胡辉煜
 */
public interface TbUserService {

  /**
   * 修改TbUser信息
   * 
   * @param model
   *              页面提交数据
   * @return 修改TbUser信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage update(TbUserModel model) throws Exception;

  /**
   * 删除TbUser信息
   * 
   * @param model
   *              页面提交数据
   * @return 删除TbUser信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage delete(TbUserModel model) throws Exception;

  /**
   * 添加TbUser信息
   * 
   * @param model
   *              页面提交数据
   * @return 添加TbUser信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage add(TbUserModel model) throws Exception;

  /**
   * 按照主键查询TbUser信息
   * 
   * @param model
   *              页面提交数据
   * @return 主键查询TbUser信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryByKey(TbUserModel model) throws Exception;

  /**
   * 分页查询TbUser信息
   * 
   * @param model
   *              页面提交数据
   * @return 分页查询TbUser信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryAll(TbUserModel model) throws Exception;

  /**
   * 查询TbUser信息
   * 
   * @param model
   *              页面提交数据
   * @return 查询TbUser信息的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage queryUser(TbUserModel model) throws Exception;

  /**
   * 用户登出
   * 
   * @param model
   *              页面提交数据
   * @return 用户登出的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage logout(TbUserModel model) throws Exception;

  /**
   * 用户登录
   * 
   * @param model
   *              页面提交数据
   * @return 用户登录的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage login(TbUserModel model) throws Exception;

  /**
   * 用户注册
   * 
   * @param model
   *              页面提交数据
   * @return 用户注册的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage reg(TbUserModel model) throws Exception;

  /**
   * 用户信息修改
   * 
   * @param model
   *              页面提交数据
   * @return 用户信息修改的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage modify(TbUserModel model) throws Exception;

  /**
   * 用户isEnable修改
   * 
   * @param model
   *              页面提交数据
   * @return 用户isEnable修改的结果
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage updateEnable(TbUserModel model) throws Exception;

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
  void exportExcel(TbUserModel model, OutputStream os) throws Exception;

  JsonMessage modifyPwd(TbUserModel model) throws Exception;

}
