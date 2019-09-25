package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbUserFixOrder;

/**
 * TbUserFixOrder表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbUserFixOrderDAO {
  /**
   * 查询全部TbUserFixOrder
   *
   * @return TbUserFixOrder的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbUserFixOrder> queryAll() throws Exception;

  /**
   * 查询worker的进行中TbUserFixOrder
   * 
   * @param tbUserFixOrder信息
   * @return TbUserFixOrder的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbUserFixOrder> queryByWorker(TbUserFixOrder tbUserFixOrder) throws Exception;

  /**
   * 查询worker的已完成TbUserFixOrder
   * 
   * @param tbUserFixOrder信息
   * @return TbUserFixOrder的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbUserFixOrder> queryByWorkerFinish(TbUserFixOrder tbUserFixOrder) throws Exception;

  /**
   * 按照主键查询TbUserFixOrder
   *
   * @param tbUserFixOrder主键信息
   * @return 主键查询TbUserFixOrder的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbUserFixOrder queryByKey(TbUserFixOrder tbUserFixOrder) throws Exception;

  /**
   * 按照ufid查询TbUserFixOrder
   *
   * @param tbUserFixOrder信息
   * @return ufid查询TbUserFixOrder的结果
   * @throws Exception
   *                   处理发生异常
   */

  TbUserFixOrder queryByUfid(TbUserFixOrder tbUserFixOrder) throws Exception;

  /**
   * 按照ufid查询TbUserFixOrder详细信息
   *
   * @param tbUserFixOrder详细信息
   * @return ufid查询TbUserFixOrder详细的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbUserFixOrder queryDetailByKey(TbUserFixOrder tbUserFixOrder) throws Exception;

  /**
   * 按照ufid和worker查询TbUserFixOrder详细信息
   *
   * @param tbUserFixOrder详细信息
   * @return ufid和worker查询TbUserFixOrder详细的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbUserFixOrder queryDetailByWorkerKey(TbUserFixOrder tbUserFixOrder) throws Exception;

  /**
   * 添加TbUserFixOrder信息
   *
   * @param tbUserFixOrder信息
   * @return 添加tbUserFixOrder信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int add(TbUserFixOrder tbUserFixOrder) throws Exception;

  /**
   * 修改TbUserFixOrder信息
   *
   * @param tbUserFixOrder信息
   * @return 修改tbUserFixOrder信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int update(TbUserFixOrder tbUserFixOrder) throws Exception;

  /**
   * 删除TbUserFixOrder信息
   *
   * @param tbUserFixOrder信息
   * @return 删除tbUserFixOrder信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int delete(TbUserFixOrder tbUserFixOrder) throws Exception;

}
