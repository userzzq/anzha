package com.cdxp1688.dataservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdxp1688.dataservice.auth.INeedUser;
import com.cdxp1688.dataservice.model.TestModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * 
 * @author 胡辉煜
 *
 */
@RestController
public class UserAuthController implements INeedUser {

  @RequestMapping("/auth/user")
  public JsonMessage index(TestModel model) throws Exception {
    return JsonMessage.getSuccess("测试通过").putData("user", model.getUser());
  }
}
