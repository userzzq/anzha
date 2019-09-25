package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbProvince;

/**
 * TbProvince表的dao
 * 
 * @author 胡辉煜
 *
 */
@Mapper
public interface TbProvinceDAO {
  /**
   * 查询全部TbProvince
   *
   * @return TbProvince的信息
   * @throws Exception 处理发生异常
   */
  List<TbProvince> queryAll() throws Exception;
  
  /**
   * 按照主键查询TbProvince
   *
   * @param tbProvince主键信息
   * @return 主键查询TbProvince的结果
   * @throws Exception 处理发生异常
   */
  TbProvince queryByKey(TbProvince tbProvince) throws Exception;
  
  /**
   * 添加TbProvince信息
   *
   * @param tbProvince信息
   * @return 添加tbProvince信息的结果
   * @throws Exception 处理发生异常
   */
  int add(TbProvince tbProvince) throws Exception;
  
  /**
   * 修改TbProvince信息
   *
   * @param tbProvince信息
   * @return 修改tbProvince信息的结果
   * @throws Exception 处理发生异常
   */
  int update(TbProvince tbProvince) throws Exception;
  
  /**
   * 删除TbProvince信息
   *
   * @param tbProvince信息
   * @return 删除tbProvince信息的结果
   * @throws Exception 处理发生异常
   */
  int delete(TbProvince tbProvince) throws Exception;

}
