package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbWorker;

/**
 * TbWorker表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbWorkerDAO {
  /**
   * 查询在线的TbWorker
   * 
   * @param worker
   *               过滤信息
   * @return TbWorker的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbWorker> queryOnline(TbWorker worker) throws Exception;

  /**
   * 查询全部TbWorker
   * 
   * @param worker
   *               过滤信息
   * @return TbWorker的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbWorker> queryAll(TbWorker worker) throws Exception;

  /**
   * 按照主键查询TbWorker
   *
   * @param tbWorker主键信息
   * @return 主键查询TbWorker的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbWorker queryByKey(TbWorker tbWorker) throws Exception;

  /**
   * 按照phone查询TbWorker
   *
   * @param tbWorker主键信息
   * @return 主键查询TbWorker的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbWorker queryByPhone(TbWorker tbWorker) throws Exception;

  /**
   * 添加TbWorker信息
   *
   * @param tbWorker信息
   * @return 添加tbWorker信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int add(TbWorker tbWorker) throws Exception;

  /**
   * 修改TbWorker的isEnable状态
   *
   * @param tbWorker信息
   * @return 修改TbWorker的isEnable状态的结果
   * @throws Exception
   *                   处理发生异常
   */
  int updateEnable(TbWorker tbWorker) throws Exception;

  /**
   * 修改TbWorker的inWork状态
   *
   * @param tbWorker信息
   * @return 修改TbWorker的isEnable状态的结果
   * @throws Exception
   *                   处理发生异常
   */
  int updateInWork(TbWorker tbWorker) throws Exception;

  /**
   * 修改TbWorker信息
   *
   * @param tbWorker信息
   * @return 修改tbWorker信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int update(TbWorker tbWorker) throws Exception;

  /**
   * 删除TbWorker信息
   *
   * @param tbWorker信息
   * @return 删除tbWorker信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int delete(TbWorker tbWorker) throws Exception;

  int modifyPwd(TbWorker tbWorker) throws Exception;

}
