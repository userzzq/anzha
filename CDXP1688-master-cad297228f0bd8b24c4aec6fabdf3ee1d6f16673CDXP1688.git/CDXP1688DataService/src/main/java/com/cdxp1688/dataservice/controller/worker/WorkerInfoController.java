package com.cdxp1688.dataservice.controller.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdxp1688.dataservice.auth.INeedWorker;
import com.cdxp1688.dataservice.model.TbPayRecodeModel;
import com.cdxp1688.dataservice.model.TbWorkerModel;
import com.cdxp1688.dataservice.service.TbPayRecodeService;
import com.cdxp1688.dataservice.service.TbWorkerService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * Worker的控制器
 * 
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/worker")
public class WorkerInfoController implements INeedWorker {
  @Autowired
  private TbWorkerService tbWorkerService;

  @Autowired
  private TbPayRecodeService tbPayRecodeService;

  @RequestMapping("/inwork")
  public JsonMessage inwork(TbWorkerModel model) throws Exception {
    model.getWorker().setInWork("y");
    return tbWorkerService.updateInWork(model);
  }

  @RequestMapping("/notinwork")
  public JsonMessage notinwork(TbWorkerModel model) throws Exception {
    model.getWorker().setInWork("n");
    return tbWorkerService.updateInWork(model);
  }

  @RequestMapping("/queryPay")
  public JsonMessage queryPay(TbPayRecodeModel model) throws Exception {
    model.getTbPayRecode().setWid(model.getWorker().getWid());
    return tbPayRecodeService.queryWorkerPay(model);
  }
}
