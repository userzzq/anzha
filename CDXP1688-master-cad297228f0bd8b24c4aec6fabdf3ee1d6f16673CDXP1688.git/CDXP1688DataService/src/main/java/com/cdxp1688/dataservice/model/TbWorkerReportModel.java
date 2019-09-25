package com.cdxp1688.dataservice.model;

import java.util.ArrayList;
import java.util.List;

import com.cdxp1688.dataservice.base.BasePageModel;
import com.cdxp1688.dataservice.entity.TbReportPeople;
import com.cdxp1688.dataservice.entity.TbWorkerReport;

/**
 * TbWorkerReport的Model
 * 
 * @author 胡辉煜
 *
 */
public class TbWorkerReportModel extends BasePageModel {

  private static final long serialVersionUID = -3648800109640271028L;

  private TbWorkerReport tbWorkerReport = new TbWorkerReport();
  private List<TbReportPeople> reportPeoples = new ArrayList<>();

  public TbWorkerReportModel() {
  }

  public TbWorkerReport getTbWorkerReport() {
    return tbWorkerReport;
  }

  public void setTbWorkerReport(TbWorkerReport tbWorkerReport) {
    this.tbWorkerReport = tbWorkerReport;
  }

  public List<TbReportPeople> getReportPeoples() {
    return reportPeoples;
  }

  public void setReportPeoples(List<TbReportPeople> reportPeoples) {
    this.reportPeoples = reportPeoples;
  }

}
