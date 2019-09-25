package com.cdxp1688.dataservice.controller.admin;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdxp1688.dataservice.auth.INeedAdminUser;
import com.cdxp1688.dataservice.model.TbWorkerModel;
import com.cdxp1688.dataservice.service.TbWorkerService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/admin/worker")
public class WorkerManageController implements INeedAdminUser {
  @Autowired
  private TbWorkerService tbWorkerService;

  @RequestMapping("/queryAll")
  public JsonMessage queryAll(TbWorkerModel model) throws Exception {
    return tbWorkerService.queryAll(model);
  }

  @RequestMapping("/enable")
  public JsonMessage enable(TbWorkerModel model) throws Exception {
    model.getTbWorker().setIsEnable("y");
    return tbWorkerService.updateEnable(model);
  }

  @RequestMapping("/disable")
  public JsonMessage disable(TbWorkerModel model) throws Exception {
    model.getTbWorker().setIsEnable("n");
    return tbWorkerService.updateEnable(model);
  }

  @RequestMapping("/exportExcel")
  public void exportExcel(TbWorkerModel model, HttpServletResponse response) throws Exception {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/vnd.ms-excel");
    response.addHeader("Content-Disposition", "attachment;filename=worker.xls");
    tbWorkerService.exportExcel(model, response.getOutputStream());
  }
}
