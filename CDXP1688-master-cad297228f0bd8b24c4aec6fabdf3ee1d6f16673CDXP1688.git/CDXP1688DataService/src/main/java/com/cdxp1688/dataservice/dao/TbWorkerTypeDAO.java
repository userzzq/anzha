package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbWorkerType;

/**
 * TbWokerType表的dao
 * 
 * @author 胡辉煜
 *
 */
@Mapper
public interface TbWorkerTypeDAO {
  /**
   * 查询全部TbWokerType
   *
   * @return TbWokerType的信息
   * @throws Exception 处理发生异常
   */
  List<TbWorkerType> queryAll() throws Exception;
  
  /**
   * 按照主键查询TbWokerType
   *
   * @param tbWokerType主键信息
   * @return 主键查询TbWokerType的结果
   * @throws Exception 处理发生异常
   */
  TbWorkerType queryByKey(TbWorkerType tbWokerType) throws Exception;
  
  /**
   * 添加TbWokerType信息
   *
   * @param tbWokerType信息
   * @return 添加tbWokerType信息的结果
   * @throws Exception 处理发生异常
   */
  int add(TbWorkerType tbWokerType) throws Exception;
  
  /**
   * 修改TbWokerType信息
   *
   * @param tbWokerType信息
   * @return 修改tbWokerType信息的结果
   * @throws Exception 处理发生异常
   */
  int update(TbWorkerType tbWokerType) throws Exception;
  
  /**
   * 删除TbWokerType信息
   *
   * @param tbWokerType信息
   * @return 删除tbWokerType信息的结果
   * @throws Exception 处理发生异常
   */
  int delete(TbWorkerType tbWokerType) throws Exception;

}
