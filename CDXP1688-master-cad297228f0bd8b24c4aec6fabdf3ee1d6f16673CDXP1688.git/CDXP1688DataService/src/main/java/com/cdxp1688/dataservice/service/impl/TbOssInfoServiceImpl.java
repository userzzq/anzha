package com.cdxp1688.dataservice.service.impl;

import java.net.URL;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.cdxp1688.dataservice.dao.TbOssConfigDAO;
import com.cdxp1688.dataservice.dao.TbOssInfoDAO;
import com.cdxp1688.dataservice.dao.UtilsDAO;
import com.cdxp1688.dataservice.entity.TbOssConfig;
import com.cdxp1688.dataservice.entity.TbOssInfo;
import com.cdxp1688.dataservice.model.TbOssInfoModel;
import com.cdxp1688.dataservice.service.TbOssInfoService;
import com.cdxp1688.dataservice.utils.JsonMessage;

/**
 * TbOssInfo的实现层
 * 
 * @author 胡辉煜
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbOssInfoServiceImpl implements TbOssInfoService {
  @Autowired
  private TbOssInfoDAO   tbOssInfoDAO;
  @Autowired
  private TbOssConfigDAO tbOssConfigDAO;
  @Autowired
  private UtilsDAO       utilsDAO;

  @Override
  public JsonMessage getOssObjUrl(TbOssInfoModel model) throws Exception {
    TbOssInfo ossInfo = model.getTbOssInfo();
    ossInfo = tbOssInfoDAO.queryByObjectName(ossInfo);
    if (ossInfo == null) {
      return JsonMessage.getFail("资源不存在");
    }
    // 获取oss信息
    TbOssConfig config = new TbOssConfig();
    config.setOcid(ossInfo.getOcid());
    config = tbOssConfigDAO.queryByKey(config);
    if (config == null) {
      return JsonMessage.getFail("配置信息不存在");
    }
    OSSClientBuilder ocb        = new OSSClientBuilder();
    OSS              ossClient  = ocb.build(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
    Date             expiration = new Date(utilsDAO.queryTime().getTime() + config.getExpiration());
    URL              url        = ossClient.generatePresignedUrl(config.getBucketName(), ossInfo.getObjectName(), expiration);
    ossClient.shutdown();
    return JsonMessage.getSuccess(url.toString());
  }

  @Override
  public JsonMessage getOssUrl(TbOssInfoModel model) throws Exception {
    TbOssInfo ossInfo = model.getTbOssInfo();
    ossInfo = tbOssInfoDAO.queryByKey(ossInfo);
    if (ossInfo == null) {
      return JsonMessage.getFail("资源不存在");
    }
    // 获取oss信息
    TbOssConfig config = new TbOssConfig();
    config.setOcid(ossInfo.getOcid());
    config = tbOssConfigDAO.queryByKey(config);
    if (config == null) {
      return JsonMessage.getFail("配置信息不存在");
    }
    OSSClientBuilder ocb        = new OSSClientBuilder();
    OSS              ossClient  = ocb.build(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
    Date             expiration = new Date(utilsDAO.queryTime().getTime() + config.getExpiration());
    URL              url        = ossClient.generatePresignedUrl(config.getBucketName(), ossInfo.getObjectName(), expiration);
    ossClient.shutdown();
    return JsonMessage.getSuccess(url.toString());
  }

}
