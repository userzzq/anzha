package com.cdxp1688.dataservice.entity;

import com.cdxp1688.dataservice.base.BaseEntity;

/**
 * TbUserFixInfoImages表
 * 
 * @author 胡辉煜
 *
 */
public class TbUserFixInfoImages extends BaseEntity {

  private static final long serialVersionUID = 4193779214412506132L;
  
  private java.lang.Integer imgid;
  private java.lang.Integer ufid;
  private java.lang.String filename;
  private java.lang.String contentType;
  private java.lang.Long filesize;
  private java.util.Date lastupdate;

  public TbUserFixInfoImages() {
  }
  
  public java.lang.Integer getImgid(){
    return imgid;
  }

  public void setImgid(java.lang.Integer imgid){
    this.imgid=imgid;
  }

  public java.lang.Integer getUfid(){
    return ufid;
  }

  public void setUfid(java.lang.Integer ufid){
    this.ufid=ufid;
  }

  public java.lang.String getFilename(){
    return filename;
  }

  public void setFilename(java.lang.String filename){
    this.filename=filename;
  }

  public java.lang.String getContentType(){
    return contentType;
  }

  public void setContentType(java.lang.String contentType){
    this.contentType=contentType;
  }

  public java.lang.Long getFilesize(){
    return filesize;
  }

  public void setFilesize(java.lang.Long filesize){
    this.filesize=filesize;
  }

  public java.util.Date getLastupdate(){
    return lastupdate;
  }

  public void setLastupdate(java.util.Date lastupdate){
    this.lastupdate=lastupdate;
  }


}
