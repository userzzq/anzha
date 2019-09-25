package com.cdxp1688.dataservice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cdxp1688.dataservice.auth.INeedAdminUser;
import com.cdxp1688.dataservice.auth.INeedUser;
import com.cdxp1688.dataservice.auth.INeedWorker;
import com.cdxp1688.dataservice.base.BaseModel;
import com.cdxp1688.dataservice.entity.TbAdminUser;
import com.cdxp1688.dataservice.entity.TbToken;
import com.cdxp1688.dataservice.entity.TbUser;
import com.cdxp1688.dataservice.entity.TbWorker;
import com.cdxp1688.dataservice.service.UtilService;
import com.cdxp1688.dataservice.utils.IpUtils;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * 控制器token切面
 * 
 * @author 胡辉煜
 *
 */
@Aspect
@Component
public class ControllerToken extends BaseControllerAop {

  private static final int NEED_WORKER = 1000;
  private static final int NEED_ADMIN = 1001;
  private static final int NEED_USER = 1002;

  private static final Logger log = LoggerFactory.getLogger(ControllerToken.class);

  @Autowired
  private UtilService utilService;

  private BaseModel getBaseModel(ProceedingJoinPoint pjp) throws Exception {
    BaseModel model = null;
    Object[] args = pjp.getArgs();
    for (Object arg : args) {
      if (arg instanceof BaseModel) {
        model = (BaseModel) arg;
        break;
      }
    }
    return model;
  }

  private TbToken processToken(ProceedingJoinPoint pjp) throws Exception {
    BaseModel model = getBaseModel(pjp);
    if (model != null) {
      // 处理ip
      ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
      model.setIp(IpUtils.getIpAddr(requestAttributes.getRequest()));
      TbToken token = model.makeTbToken();
      // 校验并更新token信息
      token = utilService.checkToken(token);
      model.setToken(token.getToken());
      return token;
    }
    return null;
  }

  private boolean processAuthWorker(ProceedingJoinPoint pjp) throws Exception {
    if (!(pjp.getTarget() instanceof INeedWorker)) {
      return true;
    }
    BaseModel model = getBaseModel(pjp);
    if (model == null) {
      return true;
    }
    TbWorker worker = utilService.querTbWorker(model.makeTbTokenInfo());
    log.debug(String.format("woker=====>%s", worker));
    if (worker == null) {
      return false;
    }
    model.setWorker(worker);
    return true;
  }

  private boolean processAuthAdminUser(ProceedingJoinPoint pjp) throws Exception {
    if (!(pjp.getTarget() instanceof INeedAdminUser)) {
      return true;
    }
    BaseModel model = getBaseModel(pjp);
    if (model == null) {
      return true;
    }
    TbAdminUser adminUser = utilService.queryTbAdminUser(model.makeTbTokenInfo());
    log.debug(String.format("adminUser=====>", adminUser));
    if (adminUser == null) {
      return false;
    }
    model.setAdminUser(adminUser);
    return true;
  }

  private boolean processAuthUser(ProceedingJoinPoint pjp) throws Exception {
    if (!(pjp.getTarget() instanceof INeedUser)) {
      return true;
    }
    BaseModel model = getBaseModel(pjp);
    if (model == null) {
      return true;
    }
    TbUser user = utilService.queryTbUser(model.makeTbTokenInfo());
    log.debug(String.format("user=====>", user));
    if (user == null) {
      return false;
    }
    model.setUser(user);
    return true;
  }

  @Around("controller()")
  public Object around(ProceedingJoinPoint pjp) throws Throwable {
    log.debug("控制器切面token处理");
    TbToken token = processToken(pjp);
    log.debug(String.format("token信息：%s", token));
    if (!processAuthWorker(pjp)) {
      return JsonMessage.getFail(NEED_WORKER, "需要登录");
    }
    if (!processAuthAdminUser(pjp)) {
      return JsonMessage.getFail(NEED_ADMIN, "需要登录");
    }
    if (!processAuthUser(pjp)) {
      return JsonMessage.getFail(NEED_USER, "需要登录");
    }
    Object result = pjp.proceed();
    // 如果应答为JsonMessage且token存在就应答回去
    if (token != null && result instanceof JsonMessage) {
      JsonMessage message = (JsonMessage) result;
      message.setToken(token.getToken());
    }
    return result;
  }

}
