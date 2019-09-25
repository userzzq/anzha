package com.cdxp1688.dataservice.controller;

import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdxp1688.dataservice.model.TbOssInfoModel;
import com.cdxp1688.dataservice.model.UtilModel;
import com.cdxp1688.dataservice.service.TbOssInfoService;
import com.cdxp1688.dataservice.service.UtilService;
import com.cdxp1688.dataservice.utils.ImageCode;
import com.cdxp1688.dataservice.utils.IpUtils;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * 工具类控制器
 * 
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/util")
public class UtilController {
  @Autowired
  private TbOssInfoService tbOssInfoService;

  @Autowired
  private UtilService utilService;

  @RequestMapping("/validate.jpg")
  public void imageCode(UtilModel model, HttpServletResponse response) throws Exception {
    // {}
    // 自定义应答类型为图片
    response.setContentType("image/jpeg");
    // 获取图片校验码
    String code = utilService.makeImageCode(model);
    // 将图片通过response输出
    OutputStream os = response.getOutputStream();
    ImageIO.write(ImageCode.makeImage(code), "jpeg", os);
    os.close();
  }

  @RequestMapping("/sendPhoneCode")
  public JsonMessage sendPhoneCode(UtilModel model) throws Exception {
    return utilService.sendPhoneCode(model);
  }

  @RequestMapping("/sendFindPwd")
  public JsonMessage sendFindPwd(UtilModel model) throws Exception {
    return utilService.sendFindPwd(model);
  }

  @RequestMapping("/sendWorkerFindPwd")
  public JsonMessage sendWorkerFindPwd(UtilModel model) throws Exception {
    return utilService.sendWorkerFindPwd(model);
  }

  @RequestMapping("/getOssObjUrl")
  public void getOssObjUrl(TbOssInfoModel model, HttpServletResponse response) throws Exception {
    JsonMessage message = tbOssInfoService.getOssObjUrl(model);
    if (message.isSuccess()) {
      response.sendRedirect(message.getMessage());
    }
    else {
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      response.getWriter().println(message.getMessage());
    }
  }

  @RequestMapping("/ip")
  public JsonMessage ip(UtilModel model, HttpServletRequest request) throws Exception {
    return JsonMessage.getSuccess(IpUtils.getIpAddr(request));
  }
}
