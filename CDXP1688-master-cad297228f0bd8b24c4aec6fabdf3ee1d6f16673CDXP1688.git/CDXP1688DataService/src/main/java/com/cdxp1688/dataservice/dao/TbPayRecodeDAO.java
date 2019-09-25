package com.cdxp1688.dataservice.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbPayRecode;
import com.cdxp1688.dataservice.entity.TbWorker;

/**
 * TbPayRecode表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbPayRecodeDAO {
  /**
   * 查询全部TbPayRecode
   *
   * @return TbPayRecode的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbPayRecode> queryAll() throws Exception;

  /**
   * 按照主键查询TbPayRecode
   *
   * @param tbPayRecode主键信息
   * @return 主键查询TbPayRecode的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbPayRecode queryByKey(TbPayRecode tbPayRecode) throws Exception;

  /**
   * 添加TbPayRecode信息
   *
   * @param tbPayRecode信息
   * @return 添加tbPayRecode信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int add(TbPayRecode tbPayRecode) throws Exception;

  /**
   * 修改TbPayRecode信息
   *
   * @param tbPayRecode信息
   * @return 修改tbPayRecode信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int update(TbPayRecode tbPayRecode) throws Exception;

  /**
   * 删除TbPayRecode信息
   *
   * @param tbPayRecode信息
   * @return 删除tbPayRecode信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int delete(TbPayRecode tbPayRecode) throws Exception;

  BigDecimal queryWorkerTotal(TbPayRecode tbPayRecode) throws Exception;

  List<TbWorker> queryWorker(TbWorker tbWorker) throws Exception;

  List<TbPayRecode> queryByWorker(TbPayRecode tbPayRecode) throws Exception;

  TbWorker queryWorkerPay(TbWorker tbWorker) throws Exception;

}
