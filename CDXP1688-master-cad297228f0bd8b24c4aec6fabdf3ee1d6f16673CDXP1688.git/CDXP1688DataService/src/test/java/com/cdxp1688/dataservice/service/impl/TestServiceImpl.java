package com.cdxp1688.dataservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.cdxp1688.dataservice.dao.TestDAO;
import com.cdxp1688.dataservice.entity.TbToken;
import com.cdxp1688.dataservice.model.TestModel;
import com.cdxp1688.dataservice.service.TbConfigService;
import com.cdxp1688.dataservice.service.TestService;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.PageBean;

/**
 * 测试用service实现
 * 
 * @author 胡辉煜
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TestServiceImpl implements TestService {
  @Autowired
  private TestDAO testDAO;
  @Autowired
  private TbConfigService tbConfigService;

  @Override
  public JsonMessage queryAllToken(TestModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbToken> list = (Page<TbToken>) testDAO.queryAllToken();
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("list", list);
    message.putData("page", page);
    message.putData("smsConfig", tbConfigService.querySmsConfig());
    return message;
  }

}
