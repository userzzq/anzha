package com.cdxp1688.dataservice.service.impl;

import java.io.OutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cdxp1688.dataservice.base.ConstValues;
import com.cdxp1688.dataservice.dao.TbReportPeopleDAO;
import com.cdxp1688.dataservice.dao.TbReporterTypeDAO;
import com.cdxp1688.dataservice.dao.TbWorkerReportDAO;
import com.cdxp1688.dataservice.entity.TbReportPeople;
import com.cdxp1688.dataservice.entity.TbWorkerReport;
import com.cdxp1688.dataservice.exception.AppException;
import com.cdxp1688.dataservice.model.TbWorkerReportModel;
import com.cdxp1688.dataservice.service.TbWorkerReportService;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.MyUtils;
import com.cdxp1688.dataservice.utils.PageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import top.huhuiyu.api.utils.StringUtils;

/**
 * TbWorkerReport的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbWorkerReportServiceImpl implements TbWorkerReportService {
  @Autowired
  private TbWorkerReportDAO tbWorkerReportDAO;
  @Autowired
  private TbReporterTypeDAO tbReporterTypeDAO;
  @Autowired
  private TbReportPeopleDAO tbReportPeopleDAO;

  @Override
  public JsonMessage queryFormInfo(TbWorkerReportModel model) throws Exception {
    return JsonMessage.getSuccess("").putData("types", tbReporterTypeDAO.queryAll());
  }

  @Override
  public JsonMessage queryAll(TbWorkerReportModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    TbWorkerReport report = model.getTbWorkerReport();
    if (!MyUtils.isEmpty(report.getUsername())) {
      report.setUsername(MyUtils.getLikeStr(report.getUsername()));
    }
    if (!MyUtils.isEmpty(report.getPhone())) {
      report.setPhone(MyUtils.getLikeStr(report.getPhone()));
    }
    if (report.getWorker() != null && !MyUtils.isEmpty(report.getWorker().getName())) {
      report.getWorker().setName(MyUtils.getLikeStr(report.getWorker().getName()));
    }
    if (report.getWorker() != null && !MyUtils.isEmpty(report.getWorker().getPhone())) {
      report.getWorker().setPhone(MyUtils.getLikeStr(report.getWorker().getPhone()));
    }
    Page<TbWorkerReport> list = (Page<TbWorkerReport>) tbWorkerReportDAO.queryAll(report);
    for (TbWorkerReport tbWorkerReport : list) {
      tbWorkerReport.setPeoples(tbReportPeopleDAO.queryByWrid(tbWorkerReport));
    }
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public void exportExcel(TbWorkerReportModel model, OutputStream os) throws Exception {
    // 先写死输出100行
    int lines = 100;
    PageHelper.startPage(0, lines);
    TbWorkerReport report = model.getTbWorkerReport();
    if (!MyUtils.isEmpty(report.getUsername())) {
      report.setUsername(MyUtils.getLikeStr(report.getUsername()));
    }
    if (!MyUtils.isEmpty(report.getPhone())) {
      report.setPhone(MyUtils.getLikeStr(report.getPhone()));
    }
    if (report.getWorker() != null && !MyUtils.isEmpty(report.getWorker().getName())) {
      report.getWorker().setName(MyUtils.getLikeStr(report.getWorker().getName()));
    }
    if (report.getWorker() != null && !MyUtils.isEmpty(report.getWorker().getPhone())) {
      report.getWorker().setPhone(MyUtils.getLikeStr(report.getWorker().getPhone()));
    }
    List<TbWorkerReport> list = tbWorkerReportDAO.queryAll(report);
    for (TbWorkerReport tbWorkerReport : list) {
      tbWorkerReport.setPeoples(tbReportPeopleDAO.queryByWrid(tbWorkerReport));
    }
    // 输出excel
    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet    sheet    = workbook.createSheet();
    int          rownum   = 0;
    int          cols     = 10;
    // 输出表头
    HSSFRow  hssfRow = sheet.createRow(rownum++);
    HSSFCell cell    = hssfRow.createCell(0);
    cell.setCellValue("报备师傅");
    cell = hssfRow.createCell(1);
    cell.setCellValue("报备师傅电话");
    cell = hssfRow.createCell(2);
    cell.setCellValue("详细地址");
    cell = hssfRow.createCell(3);
    cell.setCellValue("业主姓名");
    cell = hssfRow.createCell(4);
    cell.setCellValue("联系方式");
    cell = hssfRow.createCell(5);
    cell.setCellValue("面积详情");
    cell = hssfRow.createCell(6);
    cell.setCellValue("开工日期");
    cell = hssfRow.createCell(7);
    cell.setCellValue("装修公司");
    cell = hssfRow.createCell(8);
    cell.setCellValue("相关人员信息");
    cell = hssfRow.createCell(9);
    cell.setCellValue("最后修改时间");
    // 输出内容
    for (TbWorkerReport row : list) {
      hssfRow = sheet.createRow(rownum++);
      cell = hssfRow.createCell(0);
      cell.setCellValue(StringUtils.trim(row.getWorker().getName()));
      cell = hssfRow.createCell(1);
      cell.setCellValue(StringUtils.trim(row.getWorker().getPhone()));
      cell = hssfRow.createCell(2);
      cell.setCellValue(StringUtils.trim(row.getAddress()));
      cell = hssfRow.createCell(3);
      cell.setCellValue(StringUtils.trim(row.getUsername()));
      cell = hssfRow.createCell(4);
      cell.setCellValue(StringUtils.trim(row.getPhone()));
      cell = hssfRow.createCell(5);
      cell.setCellValue(StringUtils.trim(row.getAreainfo()));
      cell = hssfRow.createCell(6);
      cell.setCellValue(ConstValues.SHORT_DATA_FORMAT.format(row.getOpendate()));
      cell = hssfRow.createCell(7);
      cell.setCellValue(StringUtils.trim(row.getDecorate()));
      cell = hssfRow.createCell(8);
      // 处理人员信息
      StringBuilder        sb = new StringBuilder();
      List<TbReportPeople> ps = row.getPeoples();
      for (TbReportPeople p : ps) {
        sb.append(String.format("%s-%s(%s)%n", p.getType().getTypeName(), p.getUsername(), p.getPhone()));
      }
      cell.setCellValue(sb.toString());
      cell = hssfRow.createCell(9);
      cell.setCellValue(ConstValues.DATA_FORMAT.format(row.getLastupdate()));
    }
    for (int i = 0; i < cols; i++) {
      sheet.autoSizeColumn(i);
    }
    workbook.write(os);
    workbook.close();
    os.close();

  }

  @Override
  public JsonMessage queryByWid(TbWorkerReportModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbWorkerReport> list = (Page<TbWorkerReport>) tbWorkerReportDAO.queryByWid(model.getWorker());
    for (TbWorkerReport tbWorkerReport : list) {
      tbWorkerReport.setPeoples(tbReportPeopleDAO.queryByWrid(tbWorkerReport));
    }
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("page", page);
    message.putData("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByKey(TbWorkerReportModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.putData("tbWorkerReport", tbWorkerReportDAO.queryByKey(model.getTbWorkerReport()));
    return message;
  }

  @Override
  public JsonMessage add(TbWorkerReportModel model) throws Exception {
    // 添加基本信息
    TbWorkerReport report = model.getTbWorkerReport();
    if (MyUtils.isEmpty(report.getAddress())) {
      return JsonMessage.getFail("地址必须填写");
    }
    if (MyUtils.isEmpty(report.getUsername())) {
      return JsonMessage.getFail("业主姓名必须填写");
    }
    if (!MyUtils.isPhone(report.getPhone())) {
      return JsonMessage.getFail("业主电话必须填写正确");
    }
    if (report.getOpendate() == null) {
      return JsonMessage.getFail("开工日期必须填写");
    }
    report.setAreainfo(MyUtils.trim(report.getAreainfo()));
    report.setDecorate(MyUtils.trim(report.getDecorate()));
    report.setWid(model.getWorker().getWid());
    report.setCid(265);
    int result = tbWorkerReportDAO.add(report);
    if (result != 1) {
      throw AppException.getAppException(500, "报备失败！");
    }
    List<TbReportPeople> peoples = model.getReportPeoples();
    for (TbReportPeople tbReportPeople : peoples) {
      tbReportPeople.setWrid(report.getWrid());
      tbReportPeopleDAO.add(tbReportPeople);
    }
    return JsonMessage.getSuccess("报备成功");
  }

  @Override
  public JsonMessage delete(TbWorkerReportModel model) throws Exception {
    int result = tbWorkerReportDAO.delete(model.getTbWorkerReport());
    return result == 1 ? JsonMessage.getSuccess("删除数据成功") : JsonMessage.getFail("删除数据失败");
  }

  @Override
  public JsonMessage update(TbWorkerReportModel model) throws Exception {
    int result = tbWorkerReportDAO.update(model.getTbWorkerReport());
    return result == 1 ? JsonMessage.getSuccess("修改数据成功") : JsonMessage.getFail("修改数据失败");
  }
}
