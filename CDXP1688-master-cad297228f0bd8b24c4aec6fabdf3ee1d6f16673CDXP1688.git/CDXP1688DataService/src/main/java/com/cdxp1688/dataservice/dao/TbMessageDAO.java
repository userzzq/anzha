package com.cdxp1688.dataservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cdxp1688.dataservice.entity.TbMessage;

/**
 * TbMessage表的dao
 * 
 * @author 胡辉煜
 */
@Mapper
public interface TbMessageDAO {
  /**
   * 查询全部TbMessage
   *
   * @return TbMessage的信息
   * @throws Exception
   *                   处理发生异常
   */
  List<TbMessage> queryAll() throws Exception;

  /**
   * 按照主键查询TbMessage
   *
   * @param tbMessage主键信息
   * @return 主键查询TbMessage的结果
   * @throws Exception
   *                   处理发生异常
   */
  TbMessage queryByKey(TbMessage tbMessage) throws Exception;

  /**
   * 添加TbMessage信息
   *
   * @param tbMessage信息
   * @return 添加tbMessage信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int add(TbMessage tbMessage) throws Exception;

  /**
   * 修改TbMessage信息
   *
   * @param tbMessage信息
   * @return 修改tbMessage信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int update(TbMessage tbMessage) throws Exception;

  /**
   * 修改TbMessage的readed状态
   *
   * @param tbMessage信息
   * @return 修改TbMessage的readed状态的结果
   * @throws Exception
   *                   处理发生异常
   */
  int updateReaded(TbMessage tbMessage) throws Exception;

  /**
   * 删除TbMessage信息
   *
   * @param tbMessage信息
   * @return 删除tbMessage信息的结果
   * @throws Exception
   *                   处理发生异常
   */
  int delete(TbMessage tbMessage) throws Exception;

}
