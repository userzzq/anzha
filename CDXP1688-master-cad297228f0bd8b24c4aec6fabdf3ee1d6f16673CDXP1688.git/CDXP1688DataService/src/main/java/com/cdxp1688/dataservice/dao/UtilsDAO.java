package com.cdxp1688.dataservice.dao;

import java.util.Date;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbAdminUser;
import com.cdxp1688.dataservice.entity.TbToken;
import com.cdxp1688.dataservice.entity.TbTokenInfo;
import com.cdxp1688.dataservice.entity.TbUser;
import com.cdxp1688.dataservice.entity.TbWorker;

/**
 * 工具类dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface UtilsDAO {
  /**
   * 查询数据库当前时间
   * 
   * @return 数据库当前时间
   * @throws Exception
   *                   处理发生异常
   */
  Date queryTime() throws Exception;

  /**
   * 查询token
   * 
   * @param token
   *              token信息
   * @return token信息
   * @throws Exception
   *                   处理发生异常
   */
  TbToken queryToken(TbToken token) throws Exception;

  /**
   * 添加token
   * 
   * @param token
   *              token信息
   * @return 添加token的结果
   * @throws Exception
   *                   处理发生异常
   */
  int addToken(TbToken token) throws Exception;

  /**
   * 更新token
   * 
   * @param token
   *              token信息
   * @return 更新token的结果
   * @throws Exception
   *                   处理发生异常
   */
  int updateToken(TbToken token) throws Exception;

  /**
   * 删除所有过期token
   * 
   * @return 删除所有过期token的结果
   * @throws Exception
   *                   处理发生异常
   */
  int deleteTokens() throws Exception;

  /**
   * 删除所有过期的TokenInfo
   * 
   * @return 删除所有过期TokenInfo的结果
   * @throws Exception
   *                   处理发生异常
   */
  int deleteTokenInfos() throws Exception;

  /**
   * 添加图片校验码
   * 
   * @param tokenInfo
   *                  带图片校验码的tokenInfo信息
   * @return 添加图片校验码的结果
   * @throws Exception
   *                   处理发生异常
   */
  int addImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 查询图片校验码
   * 
   * @param tokenInfo
   *                  带图片校验码的tokenInfo信息
   * @return 查询图片校验码的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbTokenInfo queryImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 更新图片校验码
   * 
   * @param tokenInfo
   *                  带图片校验码的tokenInfo信息
   * @return 更新图片校验码的结果
   * @throws Exception
   *                   处理发生异常
   */
  int updateImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 删除图片校验码
   * 
   * @param tokenInfo
   *                  带图片校验码的tokenInfo信息
   * @return 删除图片校验码的结果
   * @throws Exception
   *                   处理发生异常
   */
  int deleteImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 添加电话校验码
   * 
   * @param tokenInfo
   *                  带电话校验码的tokenInfo信息
   * @return 添加电话校验码的结果
   * @throws Exception
   *                   处理发生异常
   */
  int addPhoneCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 查询电话校验码
   * 
   * @param tokenInfo
   *                  带电话校验码的tokenInfo信息
   * @return 查询电话校验码的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbTokenInfo queryPhoneCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 删除电话校验码
   * 
   * @param tokenInfo
   *                  带电话校验码的tokenInfo信息
   * @return 删除电话校验码的结果
   * @throws Exception
   *                   处理发生异常
   */
  int deletePhoneCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 删除过期电话校验码
   * 
   * @return 删除过期电话校验码的结果
   * @throws Exception
   *                   处理发生异常
   */
  int deletePhoneCodes() throws Exception;

  /**
   * 添加找回密码电话校验码
   * 
   * @param tokenInfo
   *                  带电话校验码的tokenInfo信息
   * @return 添加电话校验码的结果
   * @throws Exception
   *                   处理发生异常
   */
  int addFindPwd(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 查询找回密码电话校验码
   * 
   * @param tokenInfo
   *                  带电话校验码的tokenInfo信息
   * @return 查询电话校验码的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbTokenInfo queryFindPwd(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 删除找回密码电话校验码
   * 
   * @param tokenInfo
   *                  带电话校验码的tokenInfo信息
   * @return 删除电话校验码的结果
   * @throws Exception
   *                   处理发生异常
   */
  int deleteFindPwd(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 删除过期找回密码电话校验码
   * 
   * @return 删除过期电话校验码的结果
   * @throws Exception
   *                   处理发生异常
   */
  int deleteFindPwds() throws Exception;

  /**
   * 添加Worker
   * 
   * @param tokenInfo
   *                  带Worker的tokenInfo信息
   * @return 添加Worker的结果
   * @throws Exception
   *                   处理发生异常
   */
  int addWorker(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 查询Worker
   * 
   * @param tokenInfo
   *                  带Worker的tokenInfo信息
   * @return 查询Worker的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbWorker queryWorker(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 删除Worker
   * 
   * @param tokenInfo
   *                  带Worker的tokenInfo信息
   * @return 删除过期电话校验码的结果
   * @throws Exception
   *                   处理发生异常
   */
  int deleteWorker(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 添加AdminUser
   * 
   * @param tokenInfo
   *                  带AdminUser的tokenInfo信息
   * @return 添加AdminUser的结果
   * @throws Exception
   *                   处理发生异常
   */
  int addAdminUser(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 查询AdminUser
   * 
   * @param tokenInfo
   *                  带AdminUser的tokenInfo信息
   * @return 查询AdminUser的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbAdminUser queryAdminUser(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 删除AdminUser
   * 
   * @param tokenInfo
   *                  带AdminUser的tokenInfo信息
   * @return 删除过期电话校验码的结果
   * @throws Exception
   *                   处理发生异常
   */
  int deleteAdminUser(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 添加User
   * 
   * @param tokenInfo
   *                  带User的tokenInfo信息
   * @return 添加User的结果
   * @throws Exception
   *                   处理发生异常
   */
  int addUser(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 查询User
   * 
   * @param tokenInfo
   *                  带User的tokenInfo信息
   * @return 查询User的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbUser queryUser(TbTokenInfo tokenInfo) throws Exception;

  /**
   * 删除User
   * 
   * @param tokenInfo
   *                  带User的tokenInfo信息
   * @return 删除过期电话校验码的结果
   * @throws Exception
   *                   处理发生异常
   */
  int deleteUser(TbTokenInfo tokenInfo) throws Exception;
}
