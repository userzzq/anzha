package com.cdxp1688.dataservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.cdxp1688.dataservice.dao.TbTokenDAO;
import com.cdxp1688.dataservice.entity.TbToken;
import com.cdxp1688.dataservice.model.TbTokenModel;
import com.cdxp1688.dataservice.service.TbTokenService;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.PageBean;

/**
 * TbToken的实现层
 * 
 * @author 胡辉煜
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbTokenServiceImpl implements TbTokenService {
  @Autowired
  private TbTokenDAO tbTokenDAO;

  @Override
  public JsonMessage queryAll(TbTokenModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbToken> list = (Page<TbToken>) tbTokenDAO.queryAll();
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbTokenModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbToken", tbTokenDAO.queryByKey(model.getTbToken()));
    return message;
  }

  @Override
  public JsonMessage add(TbTokenModel model) throws Exception {
    int result = tbTokenDAO.add(model.getTbToken());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbTokenModel model) throws Exception {
    int result = tbTokenDAO.delete(model.getTbToken());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbTokenModel model) throws Exception {
    int result = tbTokenDAO.update(model.getTbToken());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
