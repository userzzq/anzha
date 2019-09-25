package com.cdxp1688.dataservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdxp1688.dataservice.auth.INeedWorker;
import com.cdxp1688.dataservice.model.TestModel;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * 
 * @author 胡辉煜
 *
 */
@RestController
public class WorkerAuthController implements INeedWorker {

  @RequestMapping("/auth/worker")
  public JsonMessage index(TestModel model) throws Exception {
    return JsonMessage.getSuccess("测试通过").putData("worker", model.getWorker());
  }
}
