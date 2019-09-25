package com.cdxp1688.dataservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdxp1688.dataservice.entity.TbToken;

/**
 * 测试用dao
 * 
 * @author 胡辉煜
 *
 */
@Mapper
public interface TestDAO {
  /**
   * 查询TbToken信息
   * 
   * @return TbToken信息
   * @throws Exception 处理发生异常
   */
  List<TbToken> queryAllToken() throws Exception;
}
