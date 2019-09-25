package com.cdxp1688.dataservice.controller.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdxp1688.dataservice.auth.INeedWorker;
import com.cdxp1688.dataservice.model.TbUserFixInfoModel;
import com.cdxp1688.dataservice.model.TbUserFixOrderModel;
import com.cdxp1688.dataservice.service.TbUserFixInfoService;
import com.cdxp1688.dataservice.service.TbUserFixOrderService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * Worker维修信息的控制器
 * 
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/workerfixinfo")
public class WorkerFixinfoController implements INeedWorker {
  @Autowired
  private TbUserFixInfoService  tbUserFixInfoService;
  @Autowired
  private TbUserFixOrderService tbUserFixOrderService;

  @RequestMapping("/queryWorkerFixinfo")
  public JsonMessage queryWorkerFixinfo(TbUserFixInfoModel model) throws Exception {
    return tbUserFixInfoService.queryWorkerFixinfo(model);
  }

  @RequestMapping("/queryOrder")
  public JsonMessage queryOrder(TbUserFixOrderModel model) throws Exception {
    return tbUserFixOrderService.queryByWorker(model);
  }

  @RequestMapping("/queryFinishOrder")
  public JsonMessage queryFinishOrder(TbUserFixOrderModel model) throws Exception {
    return tbUserFixOrderService.queryByWorkerFinish(model);
  }

  @RequestMapping("/pickOrder")
  public JsonMessage pickOrder(TbUserFixOrderModel model) throws Exception {
    return tbUserFixOrderService.pickOrder(model);
  }

  @RequestMapping("/orderPrice")
  public JsonMessage orderPrice(TbUserFixOrderModel model) throws Exception {
    return tbUserFixOrderService.orderPrice(model);
  }

  @RequestMapping("/modifyOrderPrice")
  public JsonMessage modifyOrderPrice(TbUserFixOrderModel model) throws Exception {
    return tbUserFixOrderService.modifyOrderPrice(model);
  }

  @RequestMapping("/finishWork")
  public JsonMessage finishWork(TbUserFixOrderModel model) throws Exception {
    return tbUserFixOrderService.finishWork(model);
  }

  @RequestMapping("/finish")
  public JsonMessage finish(TbUserFixOrderModel model) throws Exception {
    return tbUserFixOrderService.finish(model);
  }

  @RequestMapping("/queryObjectNamesByUserFixInfo")
  public JsonMessage queryObjectNamesByUserFixInfo(TbUserFixInfoModel model) throws Exception {
    return tbUserFixInfoService.queryObjectNamesByUserFixInfo(model);
  }

}
