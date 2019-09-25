package com.cdxp1688.dataservice.exception;

/**
 * AppException-应用程序自定义异常（需要指定code和message，也可以附加token）
 * 
 * @author 胡辉煜
 *
 */
public class AppException extends Exception {
  private static final long serialVersionUID = 5637178894222363011L;

  private int code = 500;
  private String token = "";

  public AppException(int code, String message) {
    super(message);
    this.code = code;
  }

  public static AppException getAppException(int code, String message) {
    return new AppException(code, message);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getToken() {
    return token;
  }

  public AppException setToken(String token) {
    this.token = token;
    return this;
  }

}
