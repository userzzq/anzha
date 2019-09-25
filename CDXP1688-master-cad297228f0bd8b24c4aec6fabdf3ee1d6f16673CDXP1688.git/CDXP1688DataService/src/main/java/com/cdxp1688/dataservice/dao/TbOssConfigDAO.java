package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbOssConfig;

/**
 * TbOssConfig表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbOssConfigDAO {

  /**
   * 按照图片的TbOssConfig
   *
   * @return 主键查询TbOssConfig的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbOssConfig queryImages() throws Exception;

  /**
   * 查询全部TbOssConfig
   *
   * @return TbOssConfig的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbOssConfig> queryAll() throws Exception;

  /**
   * 按照主键查询TbOssConfig
   *
   * @param tbOssConfig主键信息
   * @return 主键查询TbOssConfig的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbOssConfig queryByKey(TbOssConfig tbOssConfig) throws Exception;

  /**
   * 添加TbOssConfig信息
   *
   * @param tbOssConfig信息
   * @return 添加tbOssConfig信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int add(TbOssConfig tbOssConfig) throws Exception;

  /**
   * 修改TbOssConfig信息
   *
   * @param tbOssConfig信息
   * @return 修改tbOssConfig信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int update(TbOssConfig tbOssConfig) throws Exception;

  /**
   * 删除TbOssConfig信息
   *
   * @param tbOssConfig信息
   * @return 删除tbOssConfig信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int delete(TbOssConfig tbOssConfig) throws Exception;

}
