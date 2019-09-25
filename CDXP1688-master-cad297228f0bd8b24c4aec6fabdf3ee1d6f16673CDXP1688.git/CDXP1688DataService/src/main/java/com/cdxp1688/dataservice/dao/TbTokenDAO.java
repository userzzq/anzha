package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbToken;

/**
 * TbToken表的dao
 * 
 * @author 胡辉煜
 *
 */
@Mapper
public interface TbTokenDAO {
  /**
   * 查询全部TbToken
   *
   * @return TbToken的信息
   * @throws Exception 处理发生异常
   */
  List<TbToken> queryAll() throws Exception;
  
  /**
   * 按照主键查询TbToken
   *
   * @param tbToken主键信息
   * @return 主键查询TbToken的结果
   * @throws Exception 处理发生异常
   */
  TbToken queryByKey(TbToken tbToken) throws Exception;
  
  /**
   * 添加TbToken信息
   *
   * @param tbToken信息
   * @return 添加tbToken信息的结果
   * @throws Exception 处理发生异常
   */
  int add(TbToken tbToken) throws Exception;
  
  /**
   * 修改TbToken信息
   *
   * @param tbToken信息
   * @return 修改tbToken信息的结果
   * @throws Exception 处理发生异常
   */
  int update(TbToken tbToken) throws Exception;
  
  /**
   * 删除TbToken信息
   *
   * @param tbToken信息
   * @return 删除tbToken信息的结果
   * @throws Exception 处理发生异常
   */
  int delete(TbToken tbToken) throws Exception;

}
