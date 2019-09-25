package com.cdxp1688.dataservice.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cdxp1688.dataservice.entity.TbTokenInfo;
import com.cdxp1688.dataservice.model.TestModel;
import com.cdxp1688.dataservice.service.TestService;
import com.cdxp1688.dataservice.service.UtilService;
import com.cdxp1688.dataservice.utils.JsonMessage;
import com.cdxp1688.dataservice.utils.MyUtils;

/**
 * 测试用controller
 * 
 * @author 胡辉煜
 *
 */
@RestController
@RequestMapping("/test")
public class TestController {
  /**
   * 文件上传目录
   */
  public static final String UPLOAD_DIR = "/uploadfiles/";

  private static final Logger log = LoggerFactory.getLogger(TestController.class);

  @Autowired
  private TestService testService;
  @Autowired
  private UtilService utilService;

  @RequestMapping("/queryAllToken")
  public JsonMessage queryAllToken(TestModel model) throws Exception {
    return testService.queryAllToken(model);
  }

  @RequestMapping("/checkImageCode")
  public JsonMessage checkImageCode(TestModel model) throws Exception {
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    tokenInfo.setInfo(model.getImageCode());
    boolean result = utilService.checkImageCode(tokenInfo);
    return result ? JsonMessage.getSuccess("图片校验码正确") : JsonMessage.getFail("图片校验码错误");
  }

  @RequestMapping("/upload")
  public JsonMessage upload(TestModel model, MultipartFile[] files) throws Exception {
    if (files == null || files.length <= 0) {
      return JsonMessage.getFail("没有上传文件！");
    }
    List<String> fileinfos = new ArrayList<>();
    for (MultipartFile file : files) {
      if (file.isEmpty()) {
        continue;
      }
      String fileinfo = String.format("%s,%s,%s", file.getContentType(), file.getOriginalFilename(), file.getSize());
      fileinfos.add(fileinfo);
      log.debug(fileinfo);

      File savefile = new File(System.getProperty("user.dir") + UPLOAD_DIR, UUID.randomUUID().toString() + MyUtils.getExtName(file.getOriginalFilename()));
      if (!savefile.getParentFile().exists()) {
        savefile.getParentFile().mkdirs();
      }
      InputStream is = file.getInputStream();
      OutputStream os = new FileOutputStream(savefile);
      byte[] bytes = new byte[8 * 1024];
      int len = is.read(bytes);
      while (len > 0) {
        os.write(bytes, 0, len);
        os.flush();
        len = is.read(bytes);
      }
      is.close();
      os.close();
    }
    JsonMessage message = JsonMessage.getSuccess("上传成功！");
    message.putData("echo", model.getTestEntity()).putData("fileinfos", fileinfos);
    return message;
  }

}
