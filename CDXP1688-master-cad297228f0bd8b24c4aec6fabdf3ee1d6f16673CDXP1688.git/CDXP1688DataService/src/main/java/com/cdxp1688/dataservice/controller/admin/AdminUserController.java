package com.cdxp1688.dataservice.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdxp1688.dataservice.model.TbAdminUserModel;
import com.cdxp1688.dataservice.service.TbAdminUserService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * 
 * @author 胡辉煜
 *
 */
@RestController
@RequestMapping("/adminuser")
public class AdminUserController {
  @Autowired
  private TbAdminUserService tbAdminUserService;

  @RequestMapping("/logout")
  public JsonMessage logout(TbAdminUserModel model) throws Exception {
    return tbAdminUserService.logout(model);
  }

  @RequestMapping("/login")
  public JsonMessage login(TbAdminUserModel model) throws Exception {
    return tbAdminUserService.login(model);
  }

  @RequestMapping("/queryTbAdminUser")
  public JsonMessage queryTbAdminUser(TbAdminUserModel model) throws Exception {
    return tbAdminUserService.queryTbAdminUser(model);
  }
}
