package com.cdxp1688.dataservice.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.cdxp1688.dataservice.auth.INeedUser;
import com.cdxp1688.dataservice.model.TbUserFixInfoModel;
import com.cdxp1688.dataservice.service.TbUserFixInfoService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/userfixinfo")
public class UserFixInfoController implements INeedUser {
  @Autowired
  private TbUserFixInfoService tbUserFixInfoService;

  @RequestMapping("/fix")
  public JsonMessage fix(TbUserFixInfoModel model, MultipartFile[] files) throws Exception {
    // 我要修
    model.getTbUserFixInfo().setFixtype("10");
    return tbUserFixInfoService.add(model, files);
  }

  @RequestMapping("/wash")
  public JsonMessage wash(TbUserFixInfoModel model, MultipartFile[] files) throws Exception {
    // 我要洗
    model.getTbUserFixInfo().setFixtype("11");
    return tbUserFixInfoService.add(model, files);
  }

  @RequestMapping("/install")
  public JsonMessage install(TbUserFixInfoModel model, MultipartFile[] files) throws Exception {
    // 我要装
    model.getTbUserFixInfo().setFixtype("12");
    return tbUserFixInfoService.add(model, files);
  }

  @RequestMapping("/query")
  public JsonMessage query(TbUserFixInfoModel model) throws Exception {
    return tbUserFixInfoService.queryByUser(model);
  }

  @RequestMapping("/queryFinish")
  public JsonMessage queryFinish(TbUserFixInfoModel model) throws Exception {
    return tbUserFixInfoService.queryByUserFinish(model);
  }

  @RequestMapping("/cancelOrder")
  public JsonMessage cancelOrder(TbUserFixInfoModel model) throws Exception {
    return tbUserFixInfoService.cancel(model);
  }

  @RequestMapping("/price")
  public JsonMessage price(TbUserFixInfoModel model) throws Exception {
    return tbUserFixInfoService.price(model);
  }

  @RequestMapping("/pay")
  public JsonMessage pay(TbUserFixInfoModel model) throws Exception {
    return tbUserFixInfoService.pay(model);
  }

}
