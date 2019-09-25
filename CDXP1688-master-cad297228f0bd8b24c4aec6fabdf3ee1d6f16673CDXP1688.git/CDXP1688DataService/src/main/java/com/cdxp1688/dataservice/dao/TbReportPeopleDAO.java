package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbReportPeople;
import com.cdxp1688.dataservice.entity.TbWorkerReport;

/**
 * TbReportPeople表的dao
 * 
 * @author 胡辉煜
 *
 */
@Mapper
public interface TbReportPeopleDAO {

  /**
   * 查询wrid对应的TbReportPeople
   * 
   * @param report 报备信息
   * @return TbReportPeople的信息
   * @throws Exception 处理发生异常
   */
  List<TbReportPeople> queryByWrid(TbWorkerReport report) throws Exception;

  /**
   * 查询全部TbReportPeople
   *
   * @return TbReportPeople的信息
   * @throws Exception 处理发生异常
   */
  List<TbReportPeople> queryAll() throws Exception;

  /**
   * 按照主键查询TbReportPeople
   *
   * @param tbReportPeople主键信息
   * @return 主键查询TbReportPeople的结果
   * @throws Exception 处理发生异常
   */
  TbReportPeople queryByKey(TbReportPeople tbReportPeople) throws Exception;

  /**
   * 添加TbReportPeople信息
   *
   * @param tbReportPeople信息
   * @return 添加tbReportPeople信息的结果
   * @throws Exception 处理发生异常
   */
  int add(TbReportPeople tbReportPeople) throws Exception;

  /**
   * 修改TbReportPeople信息
   *
   * @param tbReportPeople信息
   * @return 修改tbReportPeople信息的结果
   * @throws Exception 处理发生异常
   */
  int update(TbReportPeople tbReportPeople) throws Exception;

  /**
   * 删除TbReportPeople信息
   *
   * @param tbReportPeople信息
   * @return 删除tbReportPeople信息的结果
   * @throws Exception 处理发生异常
   */
  int delete(TbReportPeople tbReportPeople) throws Exception;

}
