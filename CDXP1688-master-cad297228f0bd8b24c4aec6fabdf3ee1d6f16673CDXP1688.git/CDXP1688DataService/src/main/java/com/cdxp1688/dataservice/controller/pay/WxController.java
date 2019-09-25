package com.cdxp1688.dataservice.controller.pay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdxp1688.dataservice.service.PayService;
import com.cdxp1688.dataservice.utils.IpUtils;
import com.cdxp1688.dataservice.utils.JsonMessage;

@RestController
@RequestMapping("/wx")
public class WxController {

  private static final Logger log = LoggerFactory.getLogger(WxController.class);

  @Autowired
  private PayService payService;

  @RequestMapping("/openid")
  public void openid(HttpServletResponse response, HttpServletRequest request) throws Exception {
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    response.sendRedirect(payService.getOpenidCodeUrl());
  }

  @RequestMapping("/openidBack")
  public void openidBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.setCharacterEncoding("UTF-8");
    String code   = request.getParameter("code");
    String openid = payService.getOpenid(code);
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    response.sendRedirect(payService.getOpenidBackUrl(openid));
  }

  @RequestMapping("/toh5pay")
  public JsonMessage toh5pay(HttpServletResponse response, HttpServletRequest request) throws Exception {
    request.setCharacterEncoding("UTF-8");
    int    ufid = Integer.parseInt(request.getParameter("ufid"));
    String url  = payService.getOrderUrl(IpUtils.getIpAddr(request), ufid);
    log.info("h5pay链接信息:" + url);
    return JsonMessage.getSuccess(url);
  }

  @RequestMapping("/topay")
  public void topay(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    int    ufid   = Integer.parseInt(request.getParameter("ufid"));
    String openid = request.getParameter("openid");
    String ip     = IpUtils.getIpAddr(request);
    log.debug(String.format("%s,%s,%s", ufid, openid, ip));
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    response.sendRedirect(payService.getWxOrderUrl(ip, openid, ufid));
  }

}
