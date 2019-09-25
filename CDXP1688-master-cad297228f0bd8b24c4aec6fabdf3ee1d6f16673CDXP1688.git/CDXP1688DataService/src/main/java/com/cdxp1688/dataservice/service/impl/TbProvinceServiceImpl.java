package com.cdxp1688.dataservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.cdxp1688.dataservice.dao.TbProvinceDAO;
import com.cdxp1688.dataservice.entity.TbProvince;
import com.cdxp1688.dataservice.model.TbProvinceModel;
import com.cdxp1688.dataservice.service.TbProvinceService;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.PageBean;

/**
 * TbProvince的实现层
 * 
 * @author 胡辉煜
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbProvinceServiceImpl implements TbProvinceService {
  @Autowired
  private TbProvinceDAO tbProvinceDAO;

  @Override
  public JsonMessage queryAll(TbProvinceModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbProvince> list = (Page<TbProvince>) tbProvinceDAO.queryAll();
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbProvinceModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbProvince", tbProvinceDAO.queryByKey(model.getTbProvince()));
    return message;
  }

  @Override
  public JsonMessage add(TbProvinceModel model) throws Exception {
    int result = tbProvinceDAO.add(model.getTbProvince());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbProvinceModel model) throws Exception {
    int result = tbProvinceDAO.delete(model.getTbProvince());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbProvinceModel model) throws Exception {
    int result = tbProvinceDAO.update(model.getTbProvince());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
