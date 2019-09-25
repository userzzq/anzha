package com.cdxp1688.dataservice.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdxp1688.dataservice.auth.INeedAdminUser;
import com.cdxp1688.dataservice.model.TbPayRecodeModel;
import com.cdxp1688.dataservice.service.TbPayRecodeService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/adminpayrecode")
public class AdminPayRecodeController implements INeedAdminUser {
  @Autowired
  private TbPayRecodeService tbPayRecodeService;

  @RequestMapping("/add")
  public JsonMessage add(TbPayRecodeModel model) throws Exception {
    return tbPayRecodeService.add(model);
  }

  @RequestMapping("/queryWorker")
  public JsonMessage queryWorker(TbPayRecodeModel model) throws Exception {
    return tbPayRecodeService.queryWorker(model);
  }

  @RequestMapping("/queryByWorker")
  public JsonMessage queryByWorker(TbPayRecodeModel model) throws Exception {
    return tbPayRecodeService.queryByWorker(model);
  }
  
}
