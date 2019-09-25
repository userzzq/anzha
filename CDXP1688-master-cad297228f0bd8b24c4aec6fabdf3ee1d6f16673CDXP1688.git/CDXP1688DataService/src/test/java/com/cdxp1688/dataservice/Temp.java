package com.cdxp1688.dataservice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.cdxp1688.dataservice.pay.CallbackUrls;
import com.cdxp1688.dataservice.pay.PayUtil;
import com.cdxp1688.dataservice.pay.WxConfig;
import com.cdxp1688.dataservice.pay.WxPayInfo;
import com.cdxp1688.dataservice.sms.PhoneTemplate;
import com.cdxp1688.dataservice.sms.SmsConfig;
import com.cdxp1688.dataservice.sms.SmsUtil;
import com.cdxp1688.dataservice.utils.JsonUtil;
import com.cdxp1688.dataservice.utils.MyUtils;
import top.huhuiyu.api.fileutil.Md5;

/**
 * 临时测试类
 * 
 * @author 胡辉煜
 */
public class Temp {
  public static void one() throws Exception {
    PhoneTemplate template = new PhoneTemplate();
    template.setValidateCode("SMS_154790153");
    SmsConfig smsConfig = new SmsConfig("Dysmsapi", "dysmsapi.aliyuncs.com", "cn-hangzhou", "cn-hangzhou", "LTAITTlZcoYVygXQ", "Pw6wWbgJQbBBko3pTL7rXsqDGeRU3O", "壹路巴巴服务平台");
    smsConfig.setTemplate(template);
    System.out.println(JsonUtil.stringify(smsConfig));
    SmsUtil             util = new SmsUtil();
    Map<String, Object> data = new HashMap<>(5);
    data.put("code", util.makeCode());
    SendSmsResponse response = util.send(smsConfig, "17758020840", smsConfig.getTemplate().getValidateCode(), data);
    System.out.println(String.format("%s,%s,%s", response.getMessage(), response.getCode(), response.getBizId()));
  }

  public static void two() throws Exception {
    System.out.println(MyUtils.isPhone("15973637383"));
    System.out.println(MyUtils.isPhone("125973637383"));
    System.out.println(MyUtils.isPhone(""));
    System.out.println(MyUtils.isPhone(null));
  }

  public static void three() throws Exception {
    System.out.println(UUID.randomUUID().toString());
    System.out.println(Md5.md5("123456"));
    System.out.println(Md5.md5("abcdef"));
    System.out.println(Md5.md5("admin-pwd"));
    System.out.println(Md5.md5("user-pwd"));
  }

  public static void four() throws Exception {
    WxConfig wxConfig = WxConfig.getTestWxConfig();
    System.out.println(JsonUtil.stringify(wxConfig));
    CallbackUrls callbackUrls = CallbackUrls.getTestCallbackUrls();
    System.out.println(JsonUtil.stringify(callbackUrls));

    WxPayInfo wxPayInfo = WxPayInfo.getTestWxPayInfo();
    System.out.println(JsonUtil.stringify(wxPayInfo));
  }

  public static void five() throws Exception {
    Map<String, String> map = JsonUtil.parse("{\"test\":\"123\",\"ddd\":\"abc\"}");
    System.out.println(map);
  }

  public static void six() throws Exception {
    String                  timestamp = new Date().getTime() / 1000 + "";
    String                  nonceStr  = UUID.randomUUID().toString().replaceAll("[-]", "");
    TreeMap<String, String> treeMap   = new TreeMap<>();
    treeMap.put("appid", "wxc108799082cbbae8");
    treeMap.put("nonceStr", nonceStr);
    treeMap.put("timeStamp", timestamp);
    treeMap.put("package", "prepay_id=12345678");
    treeMap.put("signType", "MD5");
    String mysign = PayUtil.processWxPaySign(treeMap, "cdxp1688payappkeyinfom1234567890");
    System.out.println(treeMap);
    System.out.println(mysign);
  }

  public static void main(String[] args) throws Exception {
    // Temp.one();
    // Temp.two();
    Temp.three();
    // Temp.four();
    // Temp.five();
    // Temp.six();
  }
}
