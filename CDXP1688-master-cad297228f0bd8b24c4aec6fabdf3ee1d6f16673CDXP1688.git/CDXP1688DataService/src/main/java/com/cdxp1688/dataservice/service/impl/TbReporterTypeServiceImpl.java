package com.cdxp1688.dataservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.cdxp1688.dataservice.dao.TbReporterTypeDAO;
import com.cdxp1688.dataservice.entity.TbReporterType;
import com.cdxp1688.dataservice.model.TbReporterTypeModel;
import com.cdxp1688.dataservice.service.TbReporterTypeService;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.PageBean;

/**
 * TbReporterType的实现层
 * 
 * @author 胡辉煜
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbReporterTypeServiceImpl implements TbReporterTypeService {
  @Autowired
  private TbReporterTypeDAO tbReporterTypeDAO;

  @Override
  public JsonMessage queryAll(TbReporterTypeModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbReporterType> list = (Page<TbReporterType>) tbReporterTypeDAO.queryAll();
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbReporterTypeModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbReporterType", tbReporterTypeDAO.queryByKey(model.getTbReporterType()));
    return message;
  }

  @Override
  public JsonMessage add(TbReporterTypeModel model) throws Exception {
    int result = tbReporterTypeDAO.add(model.getTbReporterType());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbReporterTypeModel model) throws Exception {
    int result = tbReporterTypeDAO.delete(model.getTbReporterType());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbReporterTypeModel model) throws Exception {
    int result = tbReporterTypeDAO.update(model.getTbReporterType());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
