package com.cdxp1688.dataservice.controller.admin;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdxp1688.dataservice.auth.INeedAdminUser;
import com.cdxp1688.dataservice.model.TbUserFixInfoModel;
import com.cdxp1688.dataservice.service.TbUserFixInfoService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/admin/userfixinfo")
public class UserFixInfoManageController implements INeedAdminUser {

  @Autowired
  private TbUserFixInfoService tbUserFixInfoService;

  @RequestMapping("/queryAll")
  public JsonMessage queryAll(TbUserFixInfoModel model) throws Exception {
    return tbUserFixInfoService.queryAll(model);
  }

  @RequestMapping("/queryObjectNamesByUserFixInfo")
  public JsonMessage queryObjectNamesByUserFixInfo(TbUserFixInfoModel model) throws Exception {
    return tbUserFixInfoService.queryObjectNamesByUserFixInfo(model);
  }

  @RequestMapping("/exportExcel")
  public void exportExcel(TbUserFixInfoModel model, HttpServletResponse response) throws Exception {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/vnd.ms-excel");
    response.addHeader("Content-Disposition", "attachment;filename=fixinfo.xls");
    tbUserFixInfoService.exportExcel(model, response.getOutputStream());
  }
}
