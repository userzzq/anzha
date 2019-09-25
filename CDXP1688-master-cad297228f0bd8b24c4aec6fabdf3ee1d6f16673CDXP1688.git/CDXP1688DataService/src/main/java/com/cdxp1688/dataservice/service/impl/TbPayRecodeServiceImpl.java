package com.cdxp1688.dataservice.service.impl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cdxp1688.dataservice.dao.TbFixOrderDetailDAO;
import com.cdxp1688.dataservice.dao.TbPayRecodeDAO;
import com.cdxp1688.dataservice.entity.TbPayRecode;
import com.cdxp1688.dataservice.entity.TbWorker;
import com.cdxp1688.dataservice.model.TbPayRecodeModel;
import com.cdxp1688.dataservice.service.TbPayRecodeService;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.MyUtils;
import com.cdxp1688.dataservice.utils.PageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * TbPayRecode的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbPayRecodeServiceImpl implements TbPayRecodeService {
  @Autowired
  private TbPayRecodeDAO      tbPayRecodeDAO;
  @Autowired
  private TbFixOrderDetailDAO tbFixOrderDetailDAO;

  @Override
  public JsonMessage queryAll(TbPayRecodeModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbPayRecode> list = (Page<TbPayRecode>) tbPayRecodeDAO.queryAll();
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryWorker(TbPayRecodeModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    TbWorker tbWorker = model.getTbWorker();
    if (!MyUtils.isEmpty(tbWorker.getPhone())) {
      tbWorker.setPhone(String.format("%%%s%%", tbWorker.getPhone()));
    }
    if (!MyUtils.isEmpty(tbWorker.getName())) {
      tbWorker.setName(String.format("%%%s%%", tbWorker.getName()));
    }
    Page<TbWorker> list = (Page<TbWorker>) tbPayRecodeDAO.queryWorker(tbWorker);
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByWorker(TbPayRecodeModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbPayRecode> list = (Page<TbPayRecode>) tbPayRecodeDAO.queryByWorker(model.getTbPayRecode());
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryWorkerPay(TbPayRecodeModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbPayRecode> list = (Page<TbPayRecode>) tbPayRecodeDAO.queryByWorker(model.getTbPayRecode());
    page.setPageInfo(list);
    TbWorker worker = new TbWorker();
    worker.setWid(model.getTbPayRecode().getWid());
    worker = tbPayRecodeDAO.queryWorkerPay(worker);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    message.putData("worker", worker);
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbPayRecodeModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbPayRecode", tbPayRecodeDAO.queryByKey(model.getTbPayRecode()));
    return message;
  }

  @Override
  public JsonMessage add(TbPayRecodeModel model) throws Exception {
    TbPayRecode payRecode = model.getTbPayRecode();
    if (payRecode.getWid() == null) {
      return JsonMessage.getFail("请选择师傅信息");
    }
    if (MyUtils.lqZero(payRecode.getPrice())) {
      return JsonMessage.getFail("打款金额应该输入且大于0");
    }
    BigDecimal total = tbFixOrderDetailDAO.queryWorkerTotal(payRecode);
    if (total == null) {
      total = new BigDecimal("0");
    }
    if (MyUtils.lqZero(payRecode.getPrice())) {
      return JsonMessage.getFail("查无记录");
    }
    BigDecimal payTotal = tbPayRecodeDAO.queryWorkerTotal(payRecode);
    if (payTotal == null) {
      payTotal = new BigDecimal("0");
    }
    BigDecimal pay = total.subtract(payTotal);
    if (payRecode.getPrice().compareTo(pay) > 0) {
      return JsonMessage.getFail("超过未支付金额数");
    }
    int result = tbPayRecodeDAO.add(payRecode);
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbPayRecodeModel model) throws Exception {
    int result = tbPayRecodeDAO.delete(model.getTbPayRecode());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbPayRecodeModel model) throws Exception {
    int result = tbPayRecodeDAO.update(model.getTbPayRecode());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
