package com.cdxp1688.dataservice.base;

import com.cdxp1688.dataservice.entity.TbAdminUser;
import com.cdxp1688.dataservice.entity.TbToken;
import com.cdxp1688.dataservice.entity.TbTokenInfo;
import com.cdxp1688.dataservice.entity.TbUser;
import com.cdxp1688.dataservice.entity.TbWorker;

/**
 * model层基类
 * 
 * @author 胡辉煜
 *
 */
public abstract class BaseModel extends BaseEntity {
  private static final long serialVersionUID = -6656820128981319905L;
  private String ip;
  private String token;
  private TbWorker worker;
  private TbAdminUser adminUser;
  private TbUser user;

  public BaseModel() {
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  /**
   * 获取token的委托方法
   * 
   * @return TbToken信息
   */
  public TbToken makeTbToken() {
    TbToken tbToken = new TbToken();
    tbToken.setToken(token);
    return tbToken;
  }

  /**
   * 获取tokeninfo的委托方法
   * 
   * @return TbTokenInfo信息
   */
  public TbTokenInfo makeTbTokenInfo() {
    TbTokenInfo tokenInfo = new TbTokenInfo();
    tokenInfo.setToken(token);
    return tokenInfo;
  }

  public TbWorker getWorker() {
    return worker;
  }

  public void setWorker(TbWorker worker) {
    this.worker = worker;
  }

  public TbAdminUser getAdminUser() {
    return adminUser;
  }

  public void setAdminUser(TbAdminUser adminUser) {
    this.adminUser = adminUser;
  }

  public TbUser getUser() {
    return user;
  }

  public void setUser(TbUser user) {
    this.user = user;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

}
