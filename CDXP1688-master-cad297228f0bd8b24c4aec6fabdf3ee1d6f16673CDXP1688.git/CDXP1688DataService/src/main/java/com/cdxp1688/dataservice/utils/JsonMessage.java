package com.cdxp1688.dataservice.utils;

import java.util.HashMap;
import java.util.Map;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * json缁熶竴搴旂瓟鏍煎紡锛堝彧瑕佹槸鏁版嵁搴旂瓟閮芥槸鐢ㄨ鏍煎紡锛�
 * 
 * @author 鑳¤緣鐓�
 *
 */
public class JsonMessage extends BaseEntity {

  private static final long serialVersionUID = 2878366922210895503L;
  public static final int OK = 200;
  public static final int ERROR = 500;
  /**
   * code:鏈嶅姟鍣ㄥ簲绛斾唬鐮侊紝200涓烘纭紝500涓洪敊璇紝鍏跺畠涓鸿嚜瀹氫箟锛岄粯璁�500
   */
  private int code = ERROR;
  /**
   * message锛氭湇鍔″櫒搴旂瓟淇℃伅锛岄粯璁や负绌�
   */
  private String message = "";
  /**
   * datas锛氭湇鍔″櫒搴旂瓟鏁版嵁鐨勯泦鍚�
   */
  private Map<String, Object> datas = new HashMap<>();
  /**
   * success锛氭湇鍔″櫒鏄惁姝ｇ‘搴旂瓟锛岄粯璁や负false
   */
  private boolean success = false;

  /**
   * 鏈嶅姟鍣╰oken淇℃伅
   */
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  /**
   * 闈欐�佸伐鍘傛柟娉曪紝鑾峰彇涓�涓狫sonMessage鐨勫疄渚�
   * 
   * @param success 鏄惁鎴愬姛搴旂瓟
   * @param code    鏈嶅姟鍣ㄥ簲绛攃ode
   * @param message 鏈嶅姟鍣ㄥ簲绛斾俊鎭�
   * @return JsonMessage鐨勫疄渚�
   */
  public static JsonMessage getMessage(boolean success, int code, String message) {
    JsonMessage json = new JsonMessage();
    json.setCode(code);
    json.setSuccess(success);
    json.setMessage(message);
    return json;
  }

  /**
   * 濮旀墭鏂规硶锛岃幏鍙栨垚鍔熺殑搴旂瓟
   * 
   * @param message 鎴愬姛鐨勬秷鎭�
   * @return JsonMessage鐨勫疄渚�
   */
  public static JsonMessage getSuccess(String message) {
    // 鎴愬姛搴旂瓟鐨剆uccess涓簍ure锛宑ode涓�200
    return JsonMessage.getMessage(true, OK, message);
  }

  /**
   * 濮旀墭鏂规硶锛岃幏鍙栨寚瀹氶敊璇痗ode鐨勫け璐ュ簲绛�
   * 
   * @param code    閿欒浠ｇ爜
   * @param message 閿欒娑堟伅
   * @return JsonMessage鐨勫疄渚�
   */
  public static JsonMessage getFail(int code, String message) {
    // 鎸囧畾code鐨勯敊璇簲绛�
    return JsonMessage.getMessage(false, code, message);
  }

  /**
   * 閿欒搴旂瓟鐨勫鎵樻柟娉�
   * 
   * @param message 閿欒娑堟伅
   * @return JsonMessage鐨勫疄渚�
   */
  public static JsonMessage getFail(String message) {
    return JsonMessage.getMessage(false, ERROR, message);
  }

  /**
   * 鏀剧疆搴旂瓟鏁版嵁
   * 
   * @param key  搴旂瓟key
   * @param data 搴旂瓟鏁版嵁
   * @return 褰撳墠瀹炰緥
   */
  public JsonMessage putData(String key, Object data) {
    datas.put(key, data);
    return this;
  }

  public JsonMessage() {
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Map<String, Object> getDatas() {
    return datas;
  }

  public void setDatas(Map<String, Object> datas) {
    this.datas = datas;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }
  
}
