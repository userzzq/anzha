package com.cdxp1688.dataservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.cdxp1688.dataservice.dao.TbCityDAO;
import com.cdxp1688.dataservice.entity.TbCity;
import com.cdxp1688.dataservice.model.TbCityModel;
import com.cdxp1688.dataservice.service.TbCityService;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.PageBean;

/**
 * TbCity的实现层
 * 
 * @author 胡辉煜
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbCityServiceImpl implements TbCityService {
  @Autowired
  private TbCityDAO tbCityDAO;

  @Override
  public JsonMessage queryAll(TbCityModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbCity> list = (Page<TbCity>) tbCityDAO.queryAll();
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbCityModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbCity", tbCityDAO.queryByKey(model.getTbCity()));
    return message;
  }

  @Override
  public JsonMessage add(TbCityModel model) throws Exception {
    int result = tbCityDAO.add(model.getTbCity());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbCityModel model) throws Exception {
    int result = tbCityDAO.delete(model.getTbCity());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbCityModel model) throws Exception {
    int result = tbCityDAO.update(model.getTbCity());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
