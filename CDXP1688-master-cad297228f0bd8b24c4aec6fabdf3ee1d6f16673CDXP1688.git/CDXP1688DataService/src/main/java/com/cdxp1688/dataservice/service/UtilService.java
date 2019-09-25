package com.cdxp1688.dataservice.service;

import com.cdxp1688.dataservice.entity.TbAdminUser;
import com.cdxp1688.dataservice.entity.TbToken;
import com.cdxp1688.dataservice.entity.TbTokenInfo;
import com.cdxp1688.dataservice.entity.TbUser;
import com.cdxp1688.dataservice.entity.TbWorker;
import com.cdxp1688.dataservice.model.UtilModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * 工具类服务
 * 
 * @author 胡辉煜
 *
 */
public interface UtilService {
  /**
   * n-冻结
   */
  public static final String DISABLE = "n";
  /**
   * y-启用
   */
  public static final String ENABLE = "y";

  /**
   * -生成图片校验码
   * 
   * @param model 页面数据
   * @return 图片校验码
   * @throws Exception 处理发生异常
   */
  String makeImageCode(UtilModel model) throws Exception;

  /**
   * 校验图片校验码是否正确，服务器端的图片校验码只能使用一次
   * 
   * @param tokenInfo 带图片校验码信息的TbTokenInfo
   * @return 图片校验码是否正确
   * @throws Exception 处理发生异常
   */
  boolean checkImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 检查token是否存在，不存在就返回新的
   * 
   * @param token token信息
   * @return token是否存在
   * @throws Exception 处理发生异常
   */
  TbToken checkToken(TbToken token) throws Exception;

  /**
   * 删除所有过期token
   * 
   * @return 删除所有过期token的结果
   * @throws Exception 处理发生异常
   */
  int deleteTokens() throws Exception;

  /**
   * 发送电话校验码
   * 
   * @param model 页面数据
   * @return 发送电话校验码的结果
   * @throws Exception 处理发生异常
   */
  JsonMessage sendPhoneCode(UtilModel model) throws Exception;

  /**
   * 检查电话校验码
   * 
   * @param phone     电话
   * @param code      校验码
   * @param tokenInfo token信息
   * @return 检查电话校验码结果
   * @throws Exception 处理发生异常
   */
  boolean checkPhoneCode(String phone, String code, TbTokenInfo tokenInfo) throws Exception;

  /**
   * 删除所有过期电话校验码
   * 
   * @return 删除所有过期电话校验码的结果
   * @throws Exception 处理发生异常
   */
  int deletePhoneCodes() throws Exception;

  /**
   * 查询TbWoker
   * 
   * @param tokenInfo token信息
   * @return 查询TbWoker的结果
   * @throws Exception 处理发生异常
   */
  TbWorker querTbWorker(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 查询TbAdminUser
   * 
   * @param tokenInfo token信息
   * @return 查询TbAdminUser的结果
   * @throws Exception 处理发生异常
   */
  TbAdminUser queryTbAdminUser(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 查询TbUser
   * 
   * @param tokenInfo token信息
   * @return 查询User的结果
   * @throws Exception 处理发生异常
   */
  TbUser queryTbUser(TbTokenInfo tokenInfo) throws Exception;

  int deleteFindPwds() throws Exception;

  boolean checkFindPwd(String phone, String code, TbTokenInfo tokenInfo) throws Exception;

  JsonMessage sendFindPwd(UtilModel model) throws Exception;

  JsonMessage sendWorkerFindPwd(UtilModel model) throws Exception;

}
