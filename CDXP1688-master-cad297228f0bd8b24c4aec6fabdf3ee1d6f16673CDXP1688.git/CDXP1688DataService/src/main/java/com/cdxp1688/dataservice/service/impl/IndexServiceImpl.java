package com.cdxp1688.dataservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdxp1688.dataservice.dao.UtilsDAO;
import com.cdxp1688.dataservice.model.IndexModel;
import com.cdxp1688.dataservice.service.IndexService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * 首页服务层实现
 * 
 * @author 胡辉煜
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class IndexServiceImpl implements IndexService {
  @Autowired
  private UtilsDAO utilsDAO;

  @Override
  public JsonMessage index(IndexModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess(model.getEcho());
    message.putData("now", utilsDAO.queryTime()).putData("ip", model.getIp());
    return message;
  }
}
