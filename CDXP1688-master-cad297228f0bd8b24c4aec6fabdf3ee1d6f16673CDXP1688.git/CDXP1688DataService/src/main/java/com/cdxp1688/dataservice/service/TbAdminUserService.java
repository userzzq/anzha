package com.cdxp1688.dataservice.service;

import com.cdxp1688.dataservice.model.TbAdminUserModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbAdminUser的Service
 * 
 * @author 胡辉煜
 *
 */
public interface TbAdminUserService {

  /**
   * 修改TbAdminUser信息
   * 
   * @param model 页面提交数据
   * @return 修改TbAdminUser信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage update(TbAdminUserModel model) throws Exception;

  /**
   * 删除TbAdminUser信息
   * 
   * @param model 页面提交数据
   * @return 删除TbAdminUser信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage delete(TbAdminUserModel model) throws Exception;

  /**
   * 添加TbAdminUser信息
   * 
   * @param model 页面提交数据
   * @return 添加TbAdminUser信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage add(TbAdminUserModel model) throws Exception;

  /**
   * 按照主键查询TbAdminUser信息
   * 
   * @param model 页面提交数据
   * @return 主键查询TbAdminUser信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryByKey(TbAdminUserModel model) throws Exception;

  /**
   * 分页查询TbAdminUser信息
   * 
   * @param model 页面提交数据
   * @return 分页查询TbAdminUser信息的结果
   * @throws Exception 处理发生错误
   */
  JsonMessage queryAll(TbAdminUserModel model) throws Exception;

  /**
   * 查询登录用户信息
   * 
   * @param model 页面提交数据
   * @return 登录用户信息
   * @throws Exception 处理发生错误
   */
  JsonMessage queryTbAdminUser(TbAdminUserModel model) throws Exception;

  /**
   * 登出
   * 
   * @param model 页面提交数据
   * @return 登出结果
   * @throws Exception 处理发生错误
   */
  JsonMessage logout(TbAdminUserModel model) throws Exception;

  /**
   * 登录
   * 
   * @param model 页面提交数据
   * @return 登录结果
   * @throws Exception 处理发生错误
   */
  JsonMessage login(TbAdminUserModel model) throws Exception;

  /**
   * 密码修改
   * 
   * @param model 页面提交数据
   * @return 密码修改结果
   * @throws Exception 处理发生错误
   */
  JsonMessage modifyPwd(TbAdminUserModel model) throws Exception;

}
