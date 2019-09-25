package com.cdxp1688.dataservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.cdxp1688.dataservice.dao.TbTokenInfoDAO;
import com.cdxp1688.dataservice.entity.TbTokenInfo;
import com.cdxp1688.dataservice.model.TbTokenInfoModel;
import com.cdxp1688.dataservice.service.TbTokenInfoService;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.PageBean;

/**
 * TbTokenInfo的实现层
 * 
 * @author 胡辉煜
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbTokenInfoServiceImpl implements TbTokenInfoService {
  @Autowired
  private TbTokenInfoDAO tbTokenInfoDAO;

  @Override
  public JsonMessage queryAll(TbTokenInfoModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbTokenInfo> list = (Page<TbTokenInfo>) tbTokenInfoDAO.queryAll();
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbTokenInfoModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbTokenInfo", tbTokenInfoDAO.queryByKey(model.getTbTokenInfo()));
    return message;
  }

  @Override
  public JsonMessage add(TbTokenInfoModel model) throws Exception {
    int result = tbTokenInfoDAO.add(model.getTbTokenInfo());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbTokenInfoModel model) throws Exception {
    int result = tbTokenInfoDAO.delete(model.getTbTokenInfo());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbTokenInfoModel model) throws Exception {
    int result = tbTokenInfoDAO.update(model.getTbTokenInfo());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
