package com.cdxp1688.dataservice.service;

import com.cdxp1688.dataservice.model.TbOssInfoModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbOssInfo的Service
 * 
 * @author 胡辉煜
 */
public interface TbOssInfoService {

  /**
   * 通过主键查询url
   * 
   * @param model
   *              页面提交数据
   * @return 主键查询url
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage getOssUrl(TbOssInfoModel model) throws Exception;

  /**
   * 通过objectName查询url
   * 
   * @param model
   *              页面提交数据
   * @return objectName查询url
   * @throws Exception
   *                   处理发生错误
   */
  JsonMessage getOssObjUrl(TbOssInfoModel model) throws Exception;

}
