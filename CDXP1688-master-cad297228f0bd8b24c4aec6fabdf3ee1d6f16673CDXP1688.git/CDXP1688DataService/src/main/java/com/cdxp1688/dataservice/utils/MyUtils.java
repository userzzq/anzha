package com.cdxp1688.dataservice.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.regex.Pattern;
import org.springframework.web.multipart.MultipartFile;

/**
 * 工具类
 * 
 * @author 胡辉煜
 */
public class MyUtils {
  public static final BigDecimal ZERO           = new BigDecimal("0.0");
  public static final String     UPLOAD_DIR     = "/uploadfiles/";
  public static final String     FILE_EXT_SPLIT = ".";
  public static final String     PHONE_CHECK    = "^[1]\\d{10}$";
  public static final String     LIKE_FORMAT    = "%%%s%%";

  /**
   * 保存文件
   * 
   * @param multipartFile
   *                      上传文件
   * @param savefile
   *                      保存文件
   * @throws Exception
   *                   保存文件发生异常
   */
  public static void saveFile(MultipartFile multipartFile, File savefile) throws Exception {
    InputStream  is    = multipartFile.getInputStream();
    OutputStream os    = new FileOutputStream(savefile);
    byte[]       bytes = new byte[8 * 1024];
    int          len   = is.read(bytes);
    while (len > 0) {
      os.write(bytes, 0, len);
      os.flush();
      len = is.read(bytes);
    }
    is.close();
    os.close();
  }

  /**
   * 获取like查询字符
   * 
   * @param info
   *             信息字符
   * @return like查询字符
   */
  public static String getLikeStr(String info) {
    return String.format(LIKE_FORMAT, info);
  }

  /**
   * 判断是否是null或者是全部都是空白字符
   * 
   * @param value
   *              字符串
   * @return 是否是null或者是全部都是空白字符
   */
  public static boolean isEmpty(String value) {
    return value == null || "".equals(value.trim());
  }

  /**
   * 去掉头尾空白字符，null值也會返回成空字符串
   * 
   * @param value
   *              字符串
   * @return 去掉头尾空白字符的结果
   */
  public static String trim(String value) {
    if (isEmpty(value)) {
      return "";
    }
    return value.trim();
  }

  /**
   * 检查电话号码格式
   * 
   * @param phone
   *              电话号码
   * @return 是否是电话号码格式
   */
  public static boolean isPhone(String phone) {
    return isEmpty(phone) ? false : Pattern.matches(PHONE_CHECK, phone);
  }

  /**
   * 获取文件扩展名
   * 
   * @param filename
   *                 文件名称
   * @return 文件扩展名
   */
  public static String getExtName(String filename) {
    if (isEmpty(filename)) {
      return "";
    }
    filename = trim(filename);
    int index = filename.lastIndexOf(FILE_EXT_SPLIT);
    if (index == -1) {
      return "";
    }
    return filename.substring(index);
  }

  /**
   * dec是否小于等于0
   * 
   * @param dec
   *            比较数
   * @return 是否小于等于0
   */
  public static boolean lqZero(BigDecimal dec) {
    if (dec == null) {
      return true;
    }
    return ZERO.compareTo(dec) >= 0;
  }
}
