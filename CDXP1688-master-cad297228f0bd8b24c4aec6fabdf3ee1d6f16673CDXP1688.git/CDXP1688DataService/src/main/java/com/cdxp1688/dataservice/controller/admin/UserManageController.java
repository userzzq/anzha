package com.cdxp1688.dataservice.controller.admin;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdxp1688.dataservice.auth.INeedAdminUser;
import com.cdxp1688.dataservice.model.TbUserModel;
import com.cdxp1688.dataservice.service.TbUserService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/admin/user")
public class UserManageController implements INeedAdminUser {

  @Autowired
  private TbUserService tbUserService;

  @RequestMapping("/queryAll")
  public JsonMessage queryAll(TbUserModel model) throws Exception {
    return tbUserService.queryAll(model);
  }

  @RequestMapping("/enable")
  public JsonMessage enable(TbUserModel model) throws Exception {
    model.getTbUser().setIsEnable("y");
    return tbUserService.updateEnable(model);
  }

  @RequestMapping("/disable")
  public JsonMessage disable(TbUserModel model) throws Exception {
    model.getTbUser().setIsEnable("n");
    return tbUserService.updateEnable(model);
  }

  @RequestMapping("/exportExcel")
  public void exportExcel(TbUserModel model, HttpServletResponse response) throws Exception {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/vnd.ms-excel");
    response.addHeader("Content-Disposition", "attachment;filename=user.xls");
    tbUserService.exportExcel(model, response.getOutputStream());
  }

}
