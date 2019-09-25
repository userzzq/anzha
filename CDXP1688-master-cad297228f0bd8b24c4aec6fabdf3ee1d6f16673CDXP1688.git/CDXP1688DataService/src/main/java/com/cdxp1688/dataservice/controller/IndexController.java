package com.cdxp1688.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdxp1688.dataservice.model.IndexModel;
import com.cdxp1688.dataservice.service.IndexService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * 首页
 * 
 * @author 胡辉煜
 *
 */
@RestController
public class IndexController {
  @Autowired
  private IndexService indexService;

  @RequestMapping("")
  public JsonMessage index(IndexModel model) throws Exception {
    // {"echo":"abc-123"}
    return indexService.index(model);
  }
}
