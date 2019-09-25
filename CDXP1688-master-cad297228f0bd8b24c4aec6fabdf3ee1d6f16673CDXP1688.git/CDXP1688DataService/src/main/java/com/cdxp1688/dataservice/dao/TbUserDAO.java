package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbUser;

/**
 * TbUser表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbUserDAO {

  /**
   * 登录
   *
   * @param tbUser信息
   * @return 登录的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbUser login(TbUser tbUser) throws Exception;

  /**
   * 查询全部TbUser
   * 
   * @param user
   *             tbUser信息
   * @return TbUser的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbUser> queryAll(TbUser user) throws Exception;

  /**
   * 按照主键查询TbUser
   *
   * @param tbUser主键信息
   * @return 主键查询TbUser的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbUser queryByKey(TbUser tbUser) throws Exception;

  /**
   * 按照phone查询TbUser
   *
   * @param tbUser
   *               带phone的tbUser信息
   * @return phone查询TbUser的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbUser queryByPhone(TbUser tbUser) throws Exception;

  /**
   * 添加TbUser信息
   *
   * @param tbUser信息
   * @return 添加tbUser信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int add(TbUser tbUser) throws Exception;

  /**
   * 修改TbUser的isEnable信息
   *
   * @param tbUser信息
   * @return 修改tbUser的isEnable信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int updateEnable(TbUser tbUser) throws Exception;

  /**
   * 修改TbUser信息
   *
   * @param tbUser信息
   * @return 修改tbUser信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int update(TbUser tbUser) throws Exception;

  /**
   * 删除TbUser信息
   *
   * @param tbUser信息
   * @return 删除tbUser信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int delete(TbUser tbUser) throws Exception;

  int modifyPwd(TbUser tbUser) throws Exception;

}
