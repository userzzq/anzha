package com.cdxp1688.dataservice.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdxp1688.dataservice.model.TbUserModel;
import com.cdxp1688.dataservice.service.TbUserService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private TbUserService tbUserService;

  @RequestMapping("/login")
  public JsonMessage login(TbUserModel model) throws Exception {
    return tbUserService.login(model);
  }

  @RequestMapping("/logout")
  public JsonMessage logout(TbUserModel model) throws Exception {
    return tbUserService.logout(model);
  }

  @RequestMapping("/queryUser")
  public JsonMessage queryUser(TbUserModel model) throws Exception {
    return tbUserService.queryUser(model);
  }

  @RequestMapping("/reg")
  public JsonMessage reg(TbUserModel model) throws Exception {
    return tbUserService.reg(model);
  }

  @RequestMapping("/modifyPwd")
  public JsonMessage modifyPwd(TbUserModel model) throws Exception {
    return tbUserService.modifyPwd(model);
  }

}
