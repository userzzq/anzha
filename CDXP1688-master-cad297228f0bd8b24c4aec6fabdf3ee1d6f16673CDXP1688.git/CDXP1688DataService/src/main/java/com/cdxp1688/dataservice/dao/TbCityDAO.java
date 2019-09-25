package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbCity;

/**
 * TbCity表的dao
 * 
 * @author 胡辉煜
 *
 */
@Mapper
public interface TbCityDAO {
  /**
   * 查询全部TbCity
   *
   * @return TbCity的信息
   * @throws Exception 处理发生异常
   */
  List<TbCity> queryAll() throws Exception;
  
  /**
   * 按照主键查询TbCity
   *
   * @param tbCity主键信息
   * @return 主键查询TbCity的结果
   * @throws Exception 处理发生异常
   */
  TbCity queryByKey(TbCity tbCity) throws Exception;
  
  /**
   * 添加TbCity信息
   *
   * @param tbCity信息
   * @return 添加tbCity信息的结果
   * @throws Exception 处理发生异常
   */
  int add(TbCity tbCity) throws Exception;
  
  /**
   * 修改TbCity信息
   *
   * @param tbCity信息
   * @return 修改tbCity信息的结果
   * @throws Exception 处理发生异常
   */
  int update(TbCity tbCity) throws Exception;
  
  /**
   * 删除TbCity信息
   *
   * @param tbCity信息
   * @return 删除tbCity信息的结果
   * @throws Exception 处理发生异常
   */
  int delete(TbCity tbCity) throws Exception;

}
