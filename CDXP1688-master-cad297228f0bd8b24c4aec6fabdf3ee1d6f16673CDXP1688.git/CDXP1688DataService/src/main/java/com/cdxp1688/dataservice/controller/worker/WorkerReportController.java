package com.cdxp1688.dataservice.controller.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdxp1688.dataservice.auth.INeedWorker;
import com.cdxp1688.dataservice.model.TbWorkerReportModel;
import com.cdxp1688.dataservice.service.TbWorkerReportService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * 
 * @author 胡辉煜
 *
 */
@RestController
@RequestMapping("/workerReport")
public class WorkerReportController implements INeedWorker {

  @Autowired
  private TbWorkerReportService tbWorkerReportService;

  @RequestMapping("/report")
  public JsonMessage report(TbWorkerReportModel model) throws Exception {
    return tbWorkerReportService.add(model);
  }

  @RequestMapping("/queryFormInfo")
  public JsonMessage queryFormInfo(TbWorkerReportModel model) throws Exception {
    return tbWorkerReportService.queryFormInfo(model);
  }

  @RequestMapping("/reports")
  public JsonMessage reports(TbWorkerReportModel model) throws Exception {
    return tbWorkerReportService.queryByWid(model);
  }

}
