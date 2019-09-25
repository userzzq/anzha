package com.cdxp1688.dataservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cdxp1688.dataservice.dao.TbAdminUserDAO;
import com.cdxp1688.dataservice.dao.UtilsDAO;
import com.cdxp1688.dataservice.entity.TbAdminUser;
import com.cdxp1688.dataservice.entity.TbTokenInfo;
import com.cdxp1688.dataservice.model.TbAdminUserModel;
import com.cdxp1688.dataservice.service.TbAdminUserService;
import com.cdxp1688.dataservice.service.UtilService;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.MyUtils;
import com.cdxp1688.dataservice.utils.PageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * TbAdminUser的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbAdminUserServiceImpl implements TbAdminUserService {
  @Autowired
  private TbAdminUserDAO tbAdminUserDAO;
  @Autowired
  private UtilsDAO       utilsDAO;
  @Autowired
  private UtilService    utilService;

  @Override
  public JsonMessage login(TbAdminUserModel model) throws Exception {
    if (MyUtils.isEmpty(model.getTbAdminUser().getUsername())) {
      return JsonMessage.getFail("用户名必须填写");
    }
    if (MyUtils.isEmpty(model.getTbAdminUser().getPassword())) {
      return JsonMessage.getFail("密码必须填写");
    }
    TbAdminUser user = tbAdminUserDAO.login(model.getTbAdminUser());
    if (user == null) {
      return JsonMessage.getFail("用户名或者密码错误，或者账号被冻结，登录失败");
    }
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    utilsDAO.deleteAdminUser(tokenInfo);
    tokenInfo.setInfo(user.getAuid() + "");
    utilsDAO.addAdminUser(tokenInfo);
    return JsonMessage.getSuccess("登录成功");
  }

  @Override
  public JsonMessage logout(TbAdminUserModel model) throws Exception {
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    utilsDAO.deleteAdminUser(tokenInfo);
    return JsonMessage.getSuccess("登出成功");
  }

  @Override
  public JsonMessage modifyPwd(TbAdminUserModel model) throws Exception {
    TbAdminUser user  = model.getTbAdminUser();
    TbAdminUser suser = model.getAdminUser();
    user.setAuid(suser.getAuid());
    if (MyUtils.isEmpty(model.getOldPwd())) {
      return JsonMessage.getFail("旧密码必须填写");
    }
    if (!model.getOldPwd().equals(suser.getPassword())) {
      return JsonMessage.getFail("旧密码不正确");
    }
    if (MyUtils.isEmpty(user.getPassword())) {
      return JsonMessage.getFail("新密码必须填写");
    }
    if (user.getPassword().equals(suser.getPassword())) {
      return JsonMessage.getFail("密码一致无需修改。");
    }
    tbAdminUserDAO.modifyPwd(user);
    return JsonMessage.getSuccess("修改成功！");
  }

  @Override
  public JsonMessage queryTbAdminUser(TbAdminUserModel model) throws Exception {
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    TbAdminUser user      = utilService.queryTbAdminUser(tokenInfo);
    if (user != null) {
      user.setAuid(null);
      user.setPassword(null);
      user.setIsEnable(null);
    }
    return JsonMessage.getSuccess("").putData("user", user);
  }

  @Override
  public JsonMessage queryAll(TbAdminUserModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbAdminUser> list = (Page<TbAdminUser>) tbAdminUserDAO.queryAll();
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbAdminUserModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbAdminUser", tbAdminUserDAO.queryByKey(model.getTbAdminUser()));
    return message;
  }

  @Override
  public JsonMessage add(TbAdminUserModel model) throws Exception {
    int result = tbAdminUserDAO.add(model.getTbAdminUser());
    return result == 1 ? JsonMessage.getSuccess("添加数据成功") : JsonMessage.getFail("添加数据失败");
  }

  @Override
  public JsonMessage delete(TbAdminUserModel model) throws Exception {
    int result = tbAdminUserDAO.delete(model.getTbAdminUser());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbAdminUserModel model) throws Exception {
    int result = tbAdminUserDAO.update(model.getTbAdminUser());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
