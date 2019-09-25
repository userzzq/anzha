package com.cdxp1688.dataservice.base;

import com.cdxp1688.dataservice.utils.PageBean;

/**
 * 带分页信息的model基类
 * 
 * @author 胡辉煜
 *
 */
public class BasePageModel extends BaseModel {
  private static final long serialVersionUID = 3536263791411291995L;
  private PageBean page = new PageBean();

  public BasePageModel() {
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

}
