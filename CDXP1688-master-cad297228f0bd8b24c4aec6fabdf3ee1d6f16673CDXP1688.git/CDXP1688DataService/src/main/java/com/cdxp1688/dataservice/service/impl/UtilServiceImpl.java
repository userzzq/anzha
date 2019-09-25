package com.cdxp1688.dataservice.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cdxp1688.dataservice.dao.TbUserDAO;
import com.cdxp1688.dataservice.dao.TbWorkerDAO;
import com.cdxp1688.dataservice.dao.UtilsDAO;
import com.cdxp1688.dataservice.entity.TbAdminUser;
import com.cdxp1688.dataservice.entity.TbToken;
import com.cdxp1688.dataservice.entity.TbTokenInfo;
import com.cdxp1688.dataservice.entity.TbUser;
import com.cdxp1688.dataservice.entity.TbWorker;
import com.cdxp1688.dataservice.model.UtilModel;
import com.cdxp1688.dataservice.service.TbConfigService;
import com.cdxp1688.dataservice.service.UtilService;
import com.cdxp1688.dataservice.sms.SmsConfig;
import com.cdxp1688.dataservice.sms.SmsUtil;
import com.cdxp1688.dataservice.utils.ImageCode;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.MyUtils;

/**
 * 工具服务层实现
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UtilServiceImpl implements UtilService {
  private static final String PHONE_FORMAT_SPLIT = "###";
  private static final String PHONE_FORMAT       = "%s%s%s";
  @Autowired
  private SmsUtil             smsUtil;
  @Autowired
  private UtilsDAO            utilsDAO;
  @Autowired
  private TbUserDAO           tbUserDAO;
  @Autowired
  private TbWorkerDAO         tbWorkerDAO;
  @Autowired
  private TbConfigService     tbConfigService;

  @Override
  public String makeImageCode(UtilModel model) throws Exception {
    // 产生图片校验码
    String code = ImageCode.makeCode();
    // 获取token信息
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    // 判断图片校验码是否存在
    TbTokenInfo sinfo = utilsDAO.queryImageCode(tokenInfo);
    if (sinfo == null) {
      // 不存在就将图片code写入
      tokenInfo.setInfo(code);
      utilsDAO.addImageCode(tokenInfo);
    }
    else {
      // 存在就更新图片code
      sinfo.setInfo(code);
      utilsDAO.updateImageCode(sinfo);
    }
    return code;
  }

  @Override
  public boolean checkImageCode(TbTokenInfo tokenInfo) throws Exception {
    // code不存在就返回false
    if (MyUtils.isEmpty(tokenInfo.getInfo())) {
      return false;
    }
    // 获取数据库中code
    TbTokenInfo sinfo = utilsDAO.queryImageCode(tokenInfo);
    if (sinfo == null) {
      // 不存在就返回false
      return false;
    }
    // 删除数据库中的code（只能使用一次）
    utilsDAO.deleteImageCode(sinfo);
    // 返回数据库中code和传入的code比对结果
    return sinfo.getInfo().equalsIgnoreCase(tokenInfo.getInfo());
  }

  @Override
  public JsonMessage sendPhoneCode(UtilModel model) throws Exception {
    // 检测图片校验码是否正确
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    // 关闭图片校验码
    // tokenInfo.setInfo(model.getImageCode());
    // if (!checkImageCode(tokenInfo)) {
    // return JsonMessage.getFail("图片校验码不正确");
    // }
    // 校验电话号码格式
    if (!MyUtils.isPhone(model.getPhone())) {
      return JsonMessage.getFail("电话号码格式不正确");
    }
    // 如果电话校验码存在就不用再次发送
    TbTokenInfo phoneInfo = utilsDAO.queryPhoneCode(tokenInfo);
    if (phoneInfo == null) {
      return sendSmsCode(model, tokenInfo);
    }
    String phone = phoneInfo.getInfo().substring(0, phoneInfo.getInfo().indexOf(PHONE_FORMAT_SPLIT));
    if (phone.equals(model.getPhone())) {
      return JsonMessage.getFail("不用重复发送");
    }
    return sendSmsCode(model, tokenInfo);
  }

  @Override
  public JsonMessage sendFindPwd(UtilModel model) throws Exception {
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    if (!MyUtils.isPhone(model.getPhone())) {
      return JsonMessage.getFail("电话号码格式不正确");
    }
    // 校验电话号码是否存在
    TbUser check = new TbUser();
    check.setPhone(model.getPhone());
    check = tbUserDAO.queryByPhone(check);
    if (check == null) {
      return JsonMessage.getFail("用户不存在");
    }
    // 如果电话校验码存在就不用再次发送
    TbTokenInfo phoneInfo = utilsDAO.queryFindPwd(tokenInfo);
    if (phoneInfo == null) {
      return sendFindPwd(model, tokenInfo);
    }
    String phone = phoneInfo.getInfo().substring(0, phoneInfo.getInfo().indexOf(PHONE_FORMAT_SPLIT));
    if (phone.equals(model.getPhone())) {
      return JsonMessage.getFail("不用重复发送");
    }
    return sendFindPwd(model, tokenInfo);
  }

  @Override
  public JsonMessage sendWorkerFindPwd(UtilModel model) throws Exception {
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    if (!MyUtils.isPhone(model.getPhone())) {
      return JsonMessage.getFail("电话号码格式不正确");
    }
    // 校验电话号码是否存在
    TbWorker check = new TbWorker();
    check.setPhone(model.getPhone());
    check = tbWorkerDAO.queryByPhone(check);
    if (check == null) {
      return JsonMessage.getFail("用户不存在");
    }
    // 如果电话校验码存在就不用再次发送
    TbTokenInfo phoneInfo = utilsDAO.queryFindPwd(tokenInfo);
    if (phoneInfo == null) {
      return sendFindPwd(model, tokenInfo);
    }
    String phone = phoneInfo.getInfo().substring(0, phoneInfo.getInfo().indexOf(PHONE_FORMAT_SPLIT));
    if (phone.equals(model.getPhone())) {
      return JsonMessage.getFail("不用重复发送");
    }
    return sendFindPwd(model, tokenInfo);
  }

  @Override
  public boolean checkFindPwd(String phone, String code, TbTokenInfo tokenInfo) throws Exception {
    // 校验码是否正确
    TbTokenInfo check     = utilsDAO.queryFindPwd(tokenInfo);
    String      checkCode = String.format(PHONE_FORMAT, phone, PHONE_FORMAT_SPLIT, code);
    return check != null && checkCode.equals(check.getInfo());
  }

  @Override
  public boolean checkPhoneCode(String phone, String code, TbTokenInfo tokenInfo) throws Exception {
    // 校验码是否正确
    TbTokenInfo check     = utilsDAO.queryPhoneCode(tokenInfo);
    String      checkCode = String.format(PHONE_FORMAT, phone, PHONE_FORMAT_SPLIT, code);
    return check != null && checkCode.equals(check.getInfo());
  }

  private JsonMessage sendFindPwd(UtilModel model, TbTokenInfo tokenInfo) throws Exception {
    // 保存并发送
    String code = smsUtil.makeCode();
    // 信息是电话和code的合并结果
    tokenInfo.setInfo(String.format(PHONE_FORMAT, model.getPhone(), PHONE_FORMAT_SPLIT, code));
    SmsConfig           smsConfig = tbConfigService.querySmsConfig();
    Map<String, Object> data      = new HashMap<>(5);
    data.put("code", code);
    smsUtil.send(smsConfig, model.getPhone(), smsConfig.getTemplate().getFindpwd(), data);
    utilsDAO.deleteFindPwd(tokenInfo);
    utilsDAO.addFindPwd(tokenInfo);
    return JsonMessage.getSuccess("已经发送校验码");
  }

  private JsonMessage sendSmsCode(UtilModel model, TbTokenInfo tokenInfo) throws Exception {
    // 保存并发送
    String code = smsUtil.makeCode();
    // 信息是电话和code的合并结果
    tokenInfo.setInfo(String.format(PHONE_FORMAT, model.getPhone(), PHONE_FORMAT_SPLIT, code));
    SmsConfig           smsConfig = tbConfigService.querySmsConfig();
    Map<String, Object> data      = new HashMap<>(5);
    data.put("code", code);
    smsUtil.send(smsConfig, model.getPhone(), smsConfig.getTemplate().getValidateCode(), data);
    utilsDAO.deletePhoneCode(tokenInfo);
    utilsDAO.addPhoneCode(tokenInfo);
    return JsonMessage.getSuccess("已经发送校验码");
  }

  private TbToken newToken() throws Exception {
    TbToken token = new TbToken();
    token.setToken(UUID.randomUUID().toString());
    utilsDAO.addToken(token);
    return token;
  }

  @Override
  public TbToken checkToken(TbToken token) throws Exception {
    // 没有传入就返回新的
    if (token == null || MyUtils.isEmpty(token.getToken())) {
      return newToken();
    }
    // 数据库校验
    TbToken stoken = utilsDAO.queryToken(token);
    // 校验不通过就返回新的
    if (stoken == null) {
      return newToken();
    }
    // 通过就更新时间
    utilsDAO.updateToken(stoken);
    return stoken;
  }

  @Override
  public int deleteTokens() throws Exception {
    // 先删除tokeninfo
    utilsDAO.deleteTokenInfos();
    // 再删除token
    return utilsDAO.deleteTokens();
  }

  @Override
  public int deletePhoneCodes() throws Exception {
    return utilsDAO.deletePhoneCodes();
  }

  @Override
  public int deleteFindPwds() throws Exception {
    return utilsDAO.deleteFindPwds();
  }

  @Override
  public TbWorker querTbWorker(TbTokenInfo tokenInfo) throws Exception {
    return utilsDAO.queryWorker(tokenInfo);
  }

  @Override
  public TbAdminUser queryTbAdminUser(TbTokenInfo tokenInfo) throws Exception {
    return utilsDAO.queryAdminUser(tokenInfo);
  }

  @Override
  public TbUser queryTbUser(TbTokenInfo tokenInfo) throws Exception {
    return utilsDAO.queryUser(tokenInfo);
  }

}
