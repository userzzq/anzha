package com.cdxp1688.dataservice.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdxp1688.dataservice.auth.INeedAdminUser;
import com.cdxp1688.dataservice.model.TbAdminUserModel;
import com.cdxp1688.dataservice.service.TbAdminUserService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/adminuser")
public class AdminUserInfoController implements INeedAdminUser {
  @Autowired
  private TbAdminUserService tbAdminUserService;

  @RequestMapping("/modifyPwd")
  public JsonMessage modifyPwd(TbAdminUserModel model) throws Exception {
    return tbAdminUserService.modifyPwd(model);
  }

}
