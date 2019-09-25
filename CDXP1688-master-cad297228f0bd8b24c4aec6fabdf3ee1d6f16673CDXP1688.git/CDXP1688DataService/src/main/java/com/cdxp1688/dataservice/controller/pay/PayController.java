package com.cdxp1688.dataservice.controller.pay;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdxp1688.dataservice.service.PayService;
import top.huhuiyu.api.utils.JsonUtil;

@RestController
@RequestMapping("/pay")
public class PayController {

  private static final Logger log = LoggerFactory.getLogger(PayController.class);
  @Autowired
  private PayService          payService;

  public String getParameters(HttpServletRequest request) throws Exception {
    StringBuilder         sb  = new StringBuilder();
    Map<String, String[]> map = request.getParameterMap();
    for (Map.Entry<String, String[]> entry : map.entrySet()) {
      sb.append(entry.getKey() + "====" + JsonUtil.stringify(entry.getValue()) + "<br>");
    }
    return sb.toString();
  }

  @RequestMapping("/payback")
  public void payback(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/plain");
    String info = readData(request);
    log.debug("支付回调：" + info);
    response.getWriter().println("支付回调：<br>");
    response.getWriter().println(info);
  }

  @RequestMapping("/notify")
  public void notify(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/plain");
    String info = readData(request);
    payService.payNotice(info);
  }

  public static String readData(HttpServletRequest request) {
    BufferedReader br = null;
    try {
      StringBuilder result = new StringBuilder();
      br = request.getReader();
      for (String line; (line = br.readLine()) != null;) {
        if (result.length() > 0) {
          result.append("\n");
        }
        result.append(line);
      }

      return result.toString();
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
    finally {
      if (br != null)
        try {
          br.close();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
    }
  }

}
