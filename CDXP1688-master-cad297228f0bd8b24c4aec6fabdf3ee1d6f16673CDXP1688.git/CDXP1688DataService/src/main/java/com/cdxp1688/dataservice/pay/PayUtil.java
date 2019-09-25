package com.cdxp1688.dataservice.pay;

import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import top.huhuiyu.api.fileutil.Md5;

public class PayUtil {

  public static String processWxPayParams(UnifiedorderResult order, WxConfig config) throws Exception {
    String                  timestamp = new Date().getTime() + "";
    TreeMap<String, String> treeMap   = new TreeMap<>();
    treeMap.put("appId", order.getAppid());
    treeMap.put("nonceStr", order.getNonce_str());
    treeMap.put("timeStamp", timestamp);
    treeMap.put("package", "prepay_id=" + order.getPrepay_id());
    treeMap.put("signType", "MD5");
    String sign = processWxPaySign(treeMap, config.getKey());
    treeMap.put("paySign", sign);
    StringBuilder sb = new StringBuilder();
    for (String key : treeMap.keySet()) {
      sb.append(key).append("=").append(URLEncoder.encode(treeMap.get(key), "UTF-8")).append("&");
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  public static String processWxPaySign(Map<String, String> map, String mkey) throws Exception {
    StringBuilder sb = new StringBuilder();
    for (String key : map.keySet()) {
      sb.append(key).append("=").append(map.get(key)).append("&");
    }
    sb.append("key=" + mkey);
    String sign = Md5.md5(sb.toString()).toUpperCase();
    return sign;
  }

  public static String processWxPaySign(UnifiedorderResult order, String timestamp, WxConfig config) throws Exception {
    TreeMap<String, String> treeMap = new TreeMap<>();
    treeMap.put("appid", order.getAppid());
    // treeMap.put("mch_id", config.getMch_id());
    treeMap.put("nonceStr", order.getNonce_str());
    treeMap.put("timeStamp", timestamp);
    treeMap.put("package", "prepay_id=" + order.getPrepay_id());
    treeMap.put("signType", "MD5");
    StringBuilder sb = new StringBuilder();
    for (String key : treeMap.keySet()) {
      sb.append(key).append("=").append(treeMap.get(key)).append("&");
    }
    sb.deleteCharAt(sb.length() - 1);
    String sign = Md5.md5(sb.toString()).toUpperCase();
    return sign;
  }

  public static String processWxPayXml(WxConfig config, CallbackUrls urls, WxPayInfo payInfo) throws Exception {
    TreeMap<String, String> treeMap = new TreeMap<>();
    treeMap.put("appid", config.getAppid());
    treeMap.put("mch_id", config.getMch_id());
    treeMap.put("nonce_str", payInfo.getNonce_str());
    treeMap.put("out_trade_no", payInfo.getOut_trade_no());
    treeMap.put("total_fee", payInfo.getTotal_fee());
    treeMap.put("spbill_create_ip", payInfo.getSpbill_create_ip());
    treeMap.put("notify_url", urls.getPayNotify());
    treeMap.put("body", payInfo.getBody());
    treeMap.put("trade_type", payInfo.getTrade_type());
    treeMap.put("openid", payInfo.getOpenid());
    treeMap.put("sign_type", "MD5");
    StringBuilder sb = new StringBuilder();
    for (String key : treeMap.keySet()) {
      sb.append(key).append("=").append(treeMap.get(key)).append("&");
    }
    sb.append("key=" + config.getKey());
    String sign = Md5.md5(sb.toString()).toUpperCase();
    treeMap.put("sign", sign);

    StringBuilder xml = new StringBuilder();
    xml.append("<xml>\n");
    for (Map.Entry<String, String> entry : treeMap.entrySet()) {
      xml.append("<" + entry.getKey() + ">").append(entry.getValue()).append("</" + entry.getKey() + ">\n");
    }
    xml.append("</xml>");
    return xml.toString();
  }

  public static UnifiedorderResult processWxUnifiedOrder(WxConfig config, CallbackUrls urls, WxPayInfo payInfo) throws Exception {
    String             xml                = processWxPayXml(config, urls, payInfo);
    MyHttpClient       client             = MyHttpClient.getInstance();
    String             result             = client.getRequestResult(client.doPost(config.getPayUrl(), xml));
    UnifiedorderResult unifiedorderResult = new UnifiedorderResult();
    Document           doc                = DocumentHelper.parseText(result);
    Element            rootElt            = doc.getRootElement(); // 获取根节点
    unifiedorderResult.setAppid(rootElt.elementText("appid"));
    unifiedorderResult.setMch_id(rootElt.elementText("mch_id"));
    unifiedorderResult.setMweb_url(rootElt.elementText("mweb_url"));
    unifiedorderResult.setNonce_str(rootElt.elementText("nonce_str"));
    unifiedorderResult.setPrepay_id(rootElt.elementText("prepay_id"));
    unifiedorderResult.setResult_code(rootElt.elementText("result_code"));
    unifiedorderResult.setReturn_code(rootElt.elementText("return_code"));
    unifiedorderResult.setReturn_msg(rootElt.elementText("return_msg"));
    unifiedorderResult.setSign(rootElt.elementText("sign"));
    unifiedorderResult.setTrade_type(rootElt.elementText("trade_type"));
    return unifiedorderResult;
  }

  public static String processXml(WxConfig config, CallbackUrls urls, WxPayInfo payInfo) throws Exception {
    TreeMap<String, String> treeMap = new TreeMap<>();
    treeMap.put("appid", config.getAppid());
    treeMap.put("mch_id", config.getMch_id());
    treeMap.put("nonce_str", payInfo.getNonce_str());
    treeMap.put("out_trade_no", payInfo.getOut_trade_no());
    treeMap.put("total_fee", payInfo.getTotal_fee());
    treeMap.put("spbill_create_ip", payInfo.getSpbill_create_ip());
    treeMap.put("notify_url", urls.getPayNotify());
    treeMap.put("body", payInfo.getBody());
    treeMap.put("trade_type", payInfo.getTrade_type());
    treeMap.put("scene_info", payInfo.getScene_info().json());
    StringBuilder sb = new StringBuilder();
    for (String key : treeMap.keySet()) {
      sb.append(key).append("=").append(treeMap.get(key)).append("&");
    }
    sb.append("key=" + config.getKey());
    String sign = Md5.md5(sb.toString()).toUpperCase();
    treeMap.put("sign", sign);

    StringBuilder xml = new StringBuilder();
    xml.append("<xml>\n");
    for (Map.Entry<String, String> entry : treeMap.entrySet()) {
      xml.append("<" + entry.getKey() + ">").append(entry.getValue()).append("</" + entry.getKey() + ">\n");
    }
    xml.append("</xml>");
    return xml.toString();
  }

  public static UnifiedorderResult processUnifiedOrder(WxConfig config, CallbackUrls urls, WxPayInfo payInfo) throws Exception {
    String             xml                = processXml(config, urls, payInfo);
    MyHttpClient       client             = MyHttpClient.getInstance();
    String             result             = client.getRequestResult(client.doPost(config.getPayUrl(), xml));
    UnifiedorderResult unifiedorderResult = new UnifiedorderResult();
    Document           doc                = DocumentHelper.parseText(result);
    Element            rootElt            = doc.getRootElement(); // 获取根节点
    unifiedorderResult.setAppid(rootElt.elementText("appid"));
    unifiedorderResult.setMch_id(rootElt.elementText("mch_id"));
    unifiedorderResult.setMweb_url(rootElt.elementText("mweb_url"));
    unifiedorderResult.setNonce_str(rootElt.elementText("nonce_str"));
    unifiedorderResult.setPrepay_id(rootElt.elementText("prepay_id"));
    unifiedorderResult.setResult_code(rootElt.elementText("result_code"));
    unifiedorderResult.setReturn_code(rootElt.elementText("return_code"));
    unifiedorderResult.setReturn_msg(rootElt.elementText("return_msg"));
    unifiedorderResult.setSign(rootElt.elementText("sign"));
    unifiedorderResult.setTrade_type(rootElt.elementText("trade_type"));
    return unifiedorderResult;
  }

  public static H5PayResult parseH5PayResult(String result) throws Exception {
    Document    doc         = DocumentHelper.parseText(result);
    Element     rootElt     = doc.getRootElement(); // 获取根节点
    H5PayResult h5PayResult = new H5PayResult();
    h5PayResult.setAppid(rootElt.elementText("appid"));
    h5PayResult.setBank_type(rootElt.elementText("bank_type"));
    h5PayResult.setCash_fee(rootElt.elementText("cash_fee"));
    h5PayResult.setIs_subscribe(rootElt.elementText("is_subscribe"));
    h5PayResult.setMch_id(rootElt.elementText("mch_id"));
    h5PayResult.setNonce_str(rootElt.elementText("nonce_str"));
    h5PayResult.setOpenid(rootElt.elementText("openid"));
    h5PayResult.setOut_trade_no(rootElt.elementText("out_trade_no"));
    h5PayResult.setResult_code(rootElt.elementText("result_code"));
    h5PayResult.setReturn_code(rootElt.elementText("return_code"));

    h5PayResult.setSign(rootElt.elementText("sign"));
    h5PayResult.setTime_end(rootElt.elementText("time_end"));
    h5PayResult.setTotal_fee(rootElt.elementText("total_fee"));
    h5PayResult.setTrade_type(rootElt.elementText("trade_type"));
    h5PayResult.setTransaction_id(rootElt.elementText("transaction_id"));
    return h5PayResult;
  }

  public static String packageOrderQueryXml(PayConfig config, PayInfo info) throws Exception {
    TreeMap<String, String> treeMap = new TreeMap<>();
    treeMap.put("appid", config.getAppid());
    treeMap.put("mch_id", config.getMch_id());
    treeMap.put("nonce_str", info.getNonce_str());
    treeMap.put("out_trade_no", info.getOut_trade_no());
    treeMap.put("total_fee", info.getTotal_fee());
    treeMap.put("spbill_create_ip", info.getSpbill_create_ip());
    treeMap.put("notify_url", config.getNotify_url());
    treeMap.put("body", config.getBody());
    treeMap.put("trade_type", config.getTrade_type());
    treeMap.put("scene_info", config.getScene_info().json());
    StringBuilder sb = new StringBuilder();
    for (String key : treeMap.keySet()) {
      sb.append(key).append("=").append(treeMap.get(key)).append("&");
    }
    sb.append("key=" + config.getKey());
    String sign = Md5.md5(sb.toString()).toUpperCase();
    treeMap.put("sign", sign);

    StringBuilder xml = new StringBuilder();
    xml.append("<xml>\n");
    for (Map.Entry<String, String> entry : treeMap.entrySet()) {
      xml.append("<" + entry.getKey() + ">").append(entry.getValue()).append("</" + entry.getKey() + ">\n");
    }
    xml.append("</xml>");
    return xml.toString();
  }

  public static UnifiedorderResult unifiedorder(PayConfig config, PayInfo info) throws Exception {
    String             xml                = packageOrderQueryXml(config, info);
    MyHttpClient       client             = MyHttpClient.getInstance();
    String             result             = client.getRequestResult(client.doPost(config.getPayUrl(), xml));
    UnifiedorderResult unifiedorderResult = new UnifiedorderResult();
    Document           doc                = DocumentHelper.parseText(result);
    Element            rootElt            = doc.getRootElement(); // 获取根节点
    unifiedorderResult.setAppid(rootElt.elementText("appid"));
    unifiedorderResult.setMch_id(rootElt.elementText("mch_id"));
    unifiedorderResult.setMweb_url(rootElt.elementText("mweb_url"));
    unifiedorderResult.setNonce_str(rootElt.elementText("nonce_str"));
    unifiedorderResult.setPrepay_id(rootElt.elementText("prepay_id"));
    unifiedorderResult.setResult_code(rootElt.elementText("result_code"));
    unifiedorderResult.setReturn_code(rootElt.elementText("return_code"));
    unifiedorderResult.setReturn_msg(rootElt.elementText("return_msg"));
    unifiedorderResult.setSign(rootElt.elementText("sign"));
    unifiedorderResult.setTrade_type(rootElt.elementText("trade_type"));
    return unifiedorderResult;
  }

}
