package com.cdxp1688.dataservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdxp1688.dataservice.entity.TbWorker;
import com.cdxp1688.dataservice.entity.TbWorkerReport;

/**
 * TbWorkerReport表的dao
 * 
 * @author 胡辉煜
 *
 */
@Mapper
public interface TbWorkerReportDAO {

  /**
   * 按照wid查询TbWorkerReport
   * 
   * @param worker worker信息
   * @return TbWorkerReport的信息
   * @throws Exception 处理发生异常
   */
  List<TbWorkerReport> queryByWid(TbWorker worker) throws Exception;

  /**
   * 查询全部TbWorkerReport
   * 
   * @param report 查询参数
   * @return TbWorkerReport的信息
   * @throws Exception 处理发生异常
   */
  List<TbWorkerReport> queryAll(TbWorkerReport report) throws Exception;

  /**
   * 按照主键查询TbWorkerReport
   *
   * @param tbWorkerReport主键信息
   * @return 主键查询TbWorkerReport的结果
   * @throws Exception 处理发生异常
   */
  TbWorkerReport queryByKey(TbWorkerReport tbWorkerReport) throws Exception;

  /**
   * 添加TbWorkerReport信息
   *
   * @param tbWorkerReport信息
   * @return 添加tbWorkerReport信息的结果
   * @throws Exception 处理发生异常
   */
  int add(TbWorkerReport tbWorkerReport) throws Exception;

  /**
   * 修改TbWorkerReport信息
   *
   * @param tbWorkerReport信息
   * @return 修改tbWorkerReport信息的结果
   * @throws Exception 处理发生异常
   */
  int update(TbWorkerReport tbWorkerReport) throws Exception;

  /**
   * 删除TbWorkerReport信息
   *
   * @param tbWorkerReport信息
   * @return 删除tbWorkerReport信息的结果
   * @throws Exception 处理发生异常
   */
  int delete(TbWorkerReport tbWorkerReport) throws Exception;

}
