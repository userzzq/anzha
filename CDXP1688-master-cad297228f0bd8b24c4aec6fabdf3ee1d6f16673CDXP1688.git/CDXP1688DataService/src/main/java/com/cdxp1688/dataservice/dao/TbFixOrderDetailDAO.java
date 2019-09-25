package com.cdxp1688.dataservice.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbFixOrderDetail;
import com.cdxp1688.dataservice.entity.TbPayRecode;
import com.cdxp1688.dataservice.entity.TbUserFixInfo;

/**
 * TbFixOrderDetail表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbFixOrderDetailDAO {
  /**
   * 查询全部TbFixOrderDetail
   *
   * @return TbFixOrderDetail的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbFixOrderDetail> queryAll() throws Exception;

  /**
   * 按照主键查询TbFixOrderDetail
   *
   * @param tbFixOrderDetail主键信息
   * @return 主键查询TbFixOrderDetail的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbFixOrderDetail queryByKey(TbFixOrderDetail tbFixOrderDetail) throws Exception;

  /**
   * 按照ufoid查询TbFixOrderDetail
   *
   * @param tbFixOrderDetail信息
   * @return ufoid查询TbFixOrderDetail的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbFixOrderDetail querybyUfoid(TbFixOrderDetail tbFixOrderDetail) throws Exception;

  TbFixOrderDetail queryByUfid(TbUserFixInfo tbUserFixInfo) throws Exception;

  /**
   * 添加TbFixOrderDetail信息
   *
   * @param tbFixOrderDetail信息
   * @return 添加tbFixOrderDetail信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int add(TbFixOrderDetail tbFixOrderDetail) throws Exception;

  /**
   * 修改TbFixOrderDetail信息
   *
   * @param tbFixOrderDetail信息
   * @return 修改tbFixOrderDetail信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int update(TbFixOrderDetail tbFixOrderDetail) throws Exception;

  /**
   * 删除TbFixOrderDetail信息
   *
   * @param tbFixOrderDetail信息
   * @return 删除tbFixOrderDetail信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int delete(TbFixOrderDetail tbFixOrderDetail) throws Exception;

  BigDecimal queryWorkerTotal(TbPayRecode tbPayRecode) throws Exception;

}
