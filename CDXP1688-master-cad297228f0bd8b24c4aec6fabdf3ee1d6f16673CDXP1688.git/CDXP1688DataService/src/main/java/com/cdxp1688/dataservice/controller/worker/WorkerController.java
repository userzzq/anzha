package com.cdxp1688.dataservice.controller.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdxp1688.dataservice.model.TbWorkerModel;
import com.cdxp1688.dataservice.service.TbWorkerService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * Worker的控制器
 * 
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/worker")
public class WorkerController {
  @Autowired
  private TbWorkerService tbWorkerService;

  @RequestMapping("/queryFormInfo")
  public JsonMessage queryFormInfo(TbWorkerModel model) throws Exception {
    return tbWorkerService.queryFormInfo(model);
  }

  @RequestMapping("/reg")
  public JsonMessage reg(TbWorkerModel model) throws Exception {
    return tbWorkerService.reg(model);
  }

  @RequestMapping("/login")
  public JsonMessage login(TbWorkerModel model) throws Exception {
    // {"tbWorker.phone":"15115788049","tbWorker.password":"e10adc3949ba59abbe56e057f20f883e"}
    return tbWorkerService.login(model);
  }

  @RequestMapping("/logout")
  public JsonMessage logout(TbWorkerModel model) throws Exception {
    return tbWorkerService.logout(model);
  }

  @RequestMapping("/queryWorker")
  public JsonMessage queryWorker(TbWorkerModel model) throws Exception {
    return tbWorkerService.queryWorker(model);
  }

  @RequestMapping("/modifyPwd")
  public JsonMessage modifyPwd(TbWorkerModel model) throws Exception {
    return tbWorkerService.modifyPwd(model);
  }
}
