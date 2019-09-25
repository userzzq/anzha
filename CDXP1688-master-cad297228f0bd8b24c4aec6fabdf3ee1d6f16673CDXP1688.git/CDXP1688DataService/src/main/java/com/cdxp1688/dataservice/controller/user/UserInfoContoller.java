package com.cdxp1688.dataservice.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdxp1688.dataservice.auth.INeedUser;
import com.cdxp1688.dataservice.model.TbUserModel;
import com.cdxp1688.dataservice.service.TbUserService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/user")
public class UserInfoContoller implements INeedUser {
  @Autowired
  private TbUserService tbUserService;

  @RequestMapping("/modify")
  public JsonMessage modify(TbUserModel model) throws Exception {
    return tbUserService.modify(model);
  }
}
