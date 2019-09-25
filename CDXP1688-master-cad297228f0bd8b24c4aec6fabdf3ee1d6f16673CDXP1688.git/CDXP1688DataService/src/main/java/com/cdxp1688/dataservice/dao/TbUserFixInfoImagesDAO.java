package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbUserFixInfoImages;

/**
 * TbUserFixInfoImages表的dao
 * 
 * @author 胡辉煜
 *
 */
@Mapper
public interface TbUserFixInfoImagesDAO {
  /**
   * 查询全部TbUserFixInfoImages
   *
   * @return TbUserFixInfoImages的信息
   * @throws Exception 处理发生异常
   */
  List<TbUserFixInfoImages> queryAll() throws Exception;
  
  /**
   * 按照主键查询TbUserFixInfoImages
   *
   * @param tbUserFixInfoImages主键信息
   * @return 主键查询TbUserFixInfoImages的结果
   * @throws Exception 处理发生异常
   */
  TbUserFixInfoImages queryByKey(TbUserFixInfoImages tbUserFixInfoImages) throws Exception;
  
  /**
   * 添加TbUserFixInfoImages信息
   *
   * @param tbUserFixInfoImages信息
   * @return 添加tbUserFixInfoImages信息的结果
   * @throws Exception 处理发生异常
   */
  int add(TbUserFixInfoImages tbUserFixInfoImages) throws Exception;
  
  /**
   * 修改TbUserFixInfoImages信息
   *
   * @param tbUserFixInfoImages信息
   * @return 修改tbUserFixInfoImages信息的结果
   * @throws Exception 处理发生异常
   */
  int update(TbUserFixInfoImages tbUserFixInfoImages) throws Exception;
  
  /**
   * 删除TbUserFixInfoImages信息
   *
   * @param tbUserFixInfoImages信息
   * @return 删除tbUserFixInfoImages信息的结果
   * @throws Exception 处理发生异常
   */
  int delete(TbUserFixInfoImages tbUserFixInfoImages) throws Exception;

}
