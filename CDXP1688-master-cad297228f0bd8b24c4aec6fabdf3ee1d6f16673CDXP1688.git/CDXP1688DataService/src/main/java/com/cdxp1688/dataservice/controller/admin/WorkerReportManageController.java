package com.cdxp1688.dataservice.controller.admin;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdxp1688.dataservice.auth.INeedAdminUser;
import com.cdxp1688.dataservice.model.TbWorkerReportModel;
import com.cdxp1688.dataservice.service.TbWorkerReportService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/admin/workerReport")
public class WorkerReportManageController implements INeedAdminUser {
  @Autowired
  private TbWorkerReportService tbWorkerReportService;

  @RequestMapping("/queryAll")
  public JsonMessage queryAll(TbWorkerReportModel model) throws Exception {
    return tbWorkerReportService.queryAll(model);
  }

  @RequestMapping("/exportExcel")
  public void exportExcel(TbWorkerReportModel model, HttpServletResponse response) throws Exception {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/vnd.ms-excel");
    response.addHeader("Content-Disposition", "attachment;filename=report.xls");
    tbWorkerReportService.exportExcel(model, response.getOutputStream());
  }
}
