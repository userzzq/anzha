package com.cdxp1688.dataservice.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 控制器切点定义
 * 
 * @author 胡辉煜
 *
 */
public abstract class BaseControllerAop {

  @Pointcut("execution(public * com.cdxp1688.dataservice.controller..*.*(..))")
  public void controller() {
  }

}
