package com.cdxp1688.dataservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.cdxp1688.dataservice.dao.TbReportPeopleDAO;
import com.cdxp1688.dataservice.entity.TbReportPeople;
import com.cdxp1688.dataservice.model.TbReportPeopleModel;
import com.cdxp1688.dataservice.service.TbReportPeopleService;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.PageBean;

/**
 * TbReportPeople的实现层
 * 
 * @author 胡辉煜
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbReportPeopleServiceImpl implements TbReportPeopleService {
  @Autowired
  private TbReportPeopleDAO tbReportPeopleDAO;

  @Override
  public JsonMessage queryAll(TbReportPeopleModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbReportPeople> list = (Page<TbReportPeople>) tbReportPeopleDAO.queryAll();
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbReportPeopleModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbReportPeople", tbReportPeopleDAO.queryByKey(model.getTbReportPeople()));
    return message;
  }

  @Override
  public JsonMessage add(TbReportPeopleModel model) throws Exception {
    int result = tbReportPeopleDAO.add(model.getTbReportPeople());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbReportPeopleModel model) throws Exception {
    int result = tbReportPeopleDAO.delete(model.getTbReportPeople());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbReportPeopleModel model) throws Exception {
    int result = tbReportPeopleDAO.update(model.getTbReportPeople());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
