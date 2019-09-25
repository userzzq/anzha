package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbReporterType;

/**
 * TbReporterType表的dao
 * 
 * @author 胡辉煜
 *
 */
@Mapper
public interface TbReporterTypeDAO {
  /**
   * 查询全部TbReporterType
   *
   * @return TbReporterType的信息
   * @throws Exception 处理发生异常
   */
  List<TbReporterType> queryAll() throws Exception;
  
  /**
   * 按照主键查询TbReporterType
   *
   * @param tbReporterType主键信息
   * @return 主键查询TbReporterType的结果
   * @throws Exception 处理发生异常
   */
  TbReporterType queryByKey(TbReporterType tbReporterType) throws Exception;
  
  /**
   * 添加TbReporterType信息
   *
   * @param tbReporterType信息
   * @return 添加tbReporterType信息的结果
   * @throws Exception 处理发生异常
   */
  int add(TbReporterType tbReporterType) throws Exception;
  
  /**
   * 修改TbReporterType信息
   *
   * @param tbReporterType信息
   * @return 修改tbReporterType信息的结果
   * @throws Exception 处理发生异常
   */
  int update(TbReporterType tbReporterType) throws Exception;
  
  /**
   * 删除TbReporterType信息
   *
   * @param tbReporterType信息
   * @return 删除tbReporterType信息的结果
   * @throws Exception 处理发生异常
   */
  int delete(TbReporterType tbReporterType) throws Exception;

}
