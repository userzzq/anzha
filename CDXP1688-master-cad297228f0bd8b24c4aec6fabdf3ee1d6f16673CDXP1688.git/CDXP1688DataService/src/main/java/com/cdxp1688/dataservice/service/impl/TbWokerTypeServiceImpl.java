package com.cdxp1688.dataservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.cdxp1688.dataservice.dao.TbWorkerTypeDAO;
import com.cdxp1688.dataservice.entity.TbWorkerType;
import com.cdxp1688.dataservice.model.TbWokerTypeModel;
import com.cdxp1688.dataservice.service.TbWokerTypeService;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.PageBean;

/**
 * TbWokerType的实现层
 * 
 * @author 胡辉煜
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbWokerTypeServiceImpl implements TbWokerTypeService {
  @Autowired
  private TbWorkerTypeDAO tbWokerTypeDAO;

  @Override
  public JsonMessage queryAll(TbWokerTypeModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbWorkerType> list = (Page<TbWorkerType>) tbWokerTypeDAO.queryAll();
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbWokerTypeModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbWokerType", tbWokerTypeDAO.queryByKey(model.getTbWorkerType()));
    return message;
  }

  @Override
  public JsonMessage add(TbWokerTypeModel model) throws Exception {
    int result = tbWokerTypeDAO.add(model.getTbWorkerType());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbWokerTypeModel model) throws Exception {
    int result = tbWokerTypeDAO.delete(model.getTbWorkerType());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbWokerTypeModel model) throws Exception {
    int result = tbWokerTypeDAO.update(model.getTbWorkerType());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
