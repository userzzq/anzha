package com.cdxp1688.dataservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.cdxp1688.dataservice.exception.AppException;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * controller层全局错误处理器 <br>
 * ControllerAdvice注解表示是控制器层拦截处理（aop-面向切面编程）<br>
 * ExceptionHandler注解表示方法为错误处理器，参数是错误的类型
 * 
 * @author 胡辉煜
 *
 */
@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {

  private static final Logger log = LoggerFactory.getLogger(MyExceptionHandler.class);

  @ExceptionHandler(Exception.class)
  public JsonMessage handleException(Exception ex) {
    log.error("服务器发生错误：", ex);
    // 处理应用程序自定义异常
    if (ex instanceof AppException) {
      AppException appException = (AppException) ex;
      return JsonMessage.getFail(appException.getCode(), appException.getMessage());
    }
    if (ex instanceof NoHandlerFoundException) {
      return JsonMessage.getFail(404, "资源不存在");
    }
    if (ex instanceof MaxUploadSizeExceededException) {
      return JsonMessage.getFail(413, "文件大小超过上传限制");
    }
    return JsonMessage.getFail("服务器忙，请稍后重试！");
  }

}
