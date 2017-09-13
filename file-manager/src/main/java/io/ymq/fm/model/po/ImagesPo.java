
package io.ymq.fm.model.po;


import io.ymq.fm.model.base.BasePo;

public class ImagesPo extends BasePo {
	private static final long serialVersionUID = 1L;
	//alias
	public static final String TABLE_ALIAS = "Images";
	

	//columns START
    /**
     * 图像ID       db_column: images_id   
     */ 	
	private Integer imagesId;
    /**
     * 名称       db_column: name   
     */ 	
	private String name;
    /**
     * 宽       db_column: width   
     */ 	
	private Integer width;
    /**
     * 高       db_column: height   
     */ 	
	private Integer height;
    /**
     * 路径       db_column: url   
     */ 	
	private String url;
    /**
     * 备注       db_column: remark   
     */ 	
	private String remark;
    /**
     * 状态,0:启用，1:禁用       db_column: status   
     */ 	
	private Integer status;
    /**
     * 删除状态,0:未删除，1:删除        db_column: del_flag   
     */ 	
	private Integer delFlag;
    /**
     * 创建者       db_column: create_user   
     */ 	
	private Integer createUser;
    /**
     * 更新者       db_column: update_user   
     */ 	
	private Integer updateUser;
    /**
     * 创建时间       db_column: screate_time   
     */ 	
	private java.util.Date screateTime;
    /**
     * 更新时间       db_column: supdate_time
     */
	private java.util.Date supdateTime;
	//columns END




	public Integer getImagesId() {
		return this.imagesId;
	}
	
	public void setImagesId(Integer value) {
		this.imagesId = value;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	
	public Integer getWidth() {
		return this.width;
	}
	
	public void setWidth(Integer value) {
		this.width = value;
	}
	
	
	public Integer getHeight() {
		return this.height;
	}
	
	public void setHeight(Integer value) {
		this.height = value;
	}
	
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String value) {
		this.url = value;
	}
	
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String value) {
		this.remark = value;
	}
	
	
	public Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	
	public Integer getDelFlag() {
		return this.delFlag;
	}
	
	public void setDelFlag(Integer value) {
		this.delFlag = value;
	}
	
	
	public Integer getCreateUser() {
		return this.createUser;
	}
	
	public void setCreateUser(Integer value) {
		this.createUser = value;
	}
	
	
	public Integer getUpdateUser() {
		return this.updateUser;
	}
	
	public void setUpdateUser(Integer value) {
		this.updateUser = value;
	}
	
	
	public java.util.Date getScreateTime() {
		return this.screateTime;
	}
	
	public void setScreateTime(java.util.Date value) {
		this.screateTime = value;
	}
	
	
	public java.util.Date getSupdateTime() {
		return this.supdateTime;
	}
	
	public void setSupdateTime(java.util.Date value) {
		this.supdateTime = value;
	}
	

	

}

