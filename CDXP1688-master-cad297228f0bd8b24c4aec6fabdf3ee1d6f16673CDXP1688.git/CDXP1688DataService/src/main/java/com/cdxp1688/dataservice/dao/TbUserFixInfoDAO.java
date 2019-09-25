package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbUserFixInfo;

/**
 * TbUserFixInfo表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbUserFixInfoDAO {

  /**
   * 已经下单
   */
  String STATUS_10 = "10";

  /**
   * 已经接单
   */
  String STATUS_11 = "11";
  /**
   * 用户取消
   */
  String STATUS_12 = "12";
  /**
   * 已经定价
   */
  String STATUS_13 = "13";
  /**
   * 维修完成
   */
  String STATUS_14 = "14";
  /**
   * 已经支付
   */
  String STATUS_15 = "15";
  /**
   * 订单完成
   */
  String STATUS_99 = "99";

  /**
   * 查询用户进行中订单
   * 
   * @param fixInfo
   *                用户信息
   * @return TbUserFixInfo的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbUserFixInfo> queryByUser(TbUserFixInfo fixInfo) throws Exception;

  /**
   * 查询用户已完成订单
   * 
   * @param fixInfo
   *                用户信息
   * @return TbUserFixInfo的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbUserFixInfo> queryByUserFinish(TbUserFixInfo fixInfo) throws Exception;

  /**
   * 查询全部TbUserFixInfo
   * 
   * @param tbUserFixInfo信息
   * @return TbUserFixInfo的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbUserFixInfo> queryAll(TbUserFixInfo tbUserFixInfo) throws Exception;

  /**
   * 查询下单的TbUserFixInfo
   * 
   * @param tbUserFixInfo信息
   * @return TbUserFixInfo的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbUserFixInfo> queryWorkerFixinfo(TbUserFixInfo tbUserFixInfo) throws Exception;

  /**
   * 按照主键查询TbUserFixInfo
   *
   * @param tbUserFixInfo主键信息
   * @return 主键查询TbUserFixInfo的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbUserFixInfo queryByKey(TbUserFixInfo tbUserFixInfo) throws Exception;

  /**
   * 按照主键和用户查询TbUserFixInfo
   *
   * @param tbUserFixInfo主键信息
   * @return 主键和用户查询TbUserFixInfo的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbUserFixInfo queryByUserKey(TbUserFixInfo tbUserFixInfo) throws Exception;

  /**
   * 添加TbUserFixInfo信息
   *
   * @param tbUserFixInfo信息
   * @return 添加tbUserFixInfo信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int add(TbUserFixInfo tbUserFixInfo) throws Exception;

  /**
   * 修改TbUserFixInfo信息
   *
   * @param tbUserFixInfo信息
   * @return 修改tbUserFixInfo信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int update(TbUserFixInfo tbUserFixInfo) throws Exception;

  /**
   * 修改TbUserFixInfo的图片列表
   *
   * @param tbUserFixInfo信息
   * @return 修改TbUserFixInfo的图片列表结果
   * @throws Exception
   *                   处理发生异常
   */
  int updateImages(TbUserFixInfo tbUserFixInfo) throws Exception;

  /**
   * 删除TbUserFixInfo信息
   *
   * @param tbUserFixInfo信息
   * @return 删除tbUserFixInfo信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int delete(TbUserFixInfo tbUserFixInfo) throws Exception;

  /**
   * 修改TbUserFixInfo的订单状态
   *
   * @param tbUserFixInfo信息
   * @return 修改TbUserFixInfo的图片列表结果
   * @throws Exception
   *                   处理发生异常
   */
  int updateStatus(TbUserFixInfo tbUserFixInfo) throws Exception;

  int updateOut_trade_no(TbUserFixInfo tbUserFixInfo) throws Exception;

  int updateOut_trade_noStatus(TbUserFixInfo tbUserFixInfo) throws Exception;

}
