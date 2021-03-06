package com.cdxp1688.dataservice.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.cdxp1688.dataservice.service.UtilService;

/**
 * 定时任务
 * 
 * @author 胡辉煜
 */
@Component
public class ScheduleTask {

  private static final Logger log = LoggerFactory.getLogger(ScheduleTask.class);

  @Autowired
  private UtilService utilService;

  @Scheduled(initialDelay = 3 * 1000, fixedDelay = 5 * 60 * 1000)
  public void deleteTokens() {
    try {
      log.debug("正在删除过期的token");
      int result = utilService.deleteTokens();
      log.debug(String.format("删除过期的token完成，数量为：%s", result));
    }
    catch (Exception ex) {
      log.error("删除过期的token发生错误", ex);
    }
  }

  @Scheduled(initialDelay = 10 * 1000, fixedDelay = 3 * 60 * 1000)
  public void deletePhoneCode() {
    try {
      log.debug("正在删除过期的电话校验码");
      int result = utilService.deletePhoneCodes();
      log.debug(String.format("删除过期的电话校验码完成，数量为：%s", result));
      log.debug("正在删除过期的找回密码电话校验码");
      result = utilService.deleteFindPwds();
      log.debug(String.format("删除过期的找回密码电话校验码完成，数量为：%s", result));
    }
    catch (Exception ex) {
      log.error("删除过期的电话校验码发生错误", ex);
    }
  }
}
