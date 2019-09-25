package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbTokenInfo;

/**
 * TbTokenInfo表的dao
 * 
 * @author 胡辉煜
 *
 */
@Mapper
public interface TbTokenInfoDAO {
  /**
   * 查询全部TbTokenInfo
   *
   * @return TbTokenInfo的信息
   * @throws Exception 处理发生异常
   */
  List<TbTokenInfo> queryAll() throws Exception;
  
  /**
   * 按照主键查询TbTokenInfo
   *
   * @param tbTokenInfo主键信息
   * @return 主键查询TbTokenInfo的结果
   * @throws Exception 处理发生异常
   */
  TbTokenInfo queryByKey(TbTokenInfo tbTokenInfo) throws Exception;
  
  /**
   * 添加TbTokenInfo信息
   *
   * @param tbTokenInfo信息
   * @return 添加tbTokenInfo信息的结果
   * @throws Exception 处理发生异常
   */
  int add(TbTokenInfo tbTokenInfo) throws Exception;
  
  /**
   * 修改TbTokenInfo信息
   *
   * @param tbTokenInfo信息
   * @return 修改tbTokenInfo信息的结果
   * @throws Exception 处理发生异常
   */
  int update(TbTokenInfo tbTokenInfo) throws Exception;
  
  /**
   * 删除TbTokenInfo信息
   *
   * @param tbTokenInfo信息
   * @return 删除tbTokenInfo信息的结果
   * @throws Exception 处理发生异常
   */
  int delete(TbTokenInfo tbTokenInfo) throws Exception;

}
