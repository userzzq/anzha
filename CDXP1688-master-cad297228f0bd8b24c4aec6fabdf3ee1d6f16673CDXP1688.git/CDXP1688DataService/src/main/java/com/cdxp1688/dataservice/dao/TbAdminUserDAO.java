package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbAdminUser;

/**
 * TbAdminUser表的dao
 * 
 * @author 胡辉煜
 *
 */
@Mapper
public interface TbAdminUserDAO {
  /**
   * 查询全部TbAdminUser
   *
   * @return TbAdminUser的信息
   * @throws Exception 处理发生异常
   */
  List<TbAdminUser> queryAll() throws Exception;

  /**
   * 按照主键查询TbAdminUser
   *
   * @param tbAdminUser主键信息
   * @return 主键查询TbAdminUser的结果
   * @throws Exception 处理发生异常
   */
  TbAdminUser queryByKey(TbAdminUser tbAdminUser) throws Exception;

  /**
   * 添加TbAdminUser信息
   *
   * @param tbAdminUser信息
   * @return 添加tbAdminUser信息的结果
   * @throws Exception 处理发生异常
   */
  int add(TbAdminUser tbAdminUser) throws Exception;

  /**
   * 修改TbAdminUser信息
   *
   * @param tbAdminUser信息
   * @return 修改tbAdminUser信息的结果
   * @throws Exception 处理发生异常
   */
  int update(TbAdminUser tbAdminUser) throws Exception;

  /**
   * 删除TbAdminUser信息
   *
   * @param tbAdminUser信息
   * @return 删除tbAdminUser信息的结果
   * @throws Exception 处理发生异常
   */
  int delete(TbAdminUser tbAdminUser) throws Exception;

  /**
   * 登录查询
   *
   * @param tbAdminUser信息
   * @return 登录查询的结果
   * @throws Exception 处理发生异常
   */
  TbAdminUser login(TbAdminUser tbAdminUser) throws Exception;

  /**
   * 密码修改
   *
   * @param tbAdminUser信息
   * @return 密码修改的结果
   * @throws Exception 处理发生异常
   */
  int modifyPwd(TbAdminUser tbAdminUser) throws Exception;

}
