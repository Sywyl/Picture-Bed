
package io.ymq.fm.model.po;


import io.ymq.fm.model.base.BasePo;

public class SysConfigPo extends BasePo {
	private static final long serialVersionUID = 1L;
	//alias
	public static final String TABLE_ALIAS = "SysConfig";
	

	//columns START
    /**
     * 系统配置ID       db_column: config_id   
     */ 	
	private Long configId;
    /**
     * key       db_column: config_key   
     */ 	
	private String configKey;
    /**
     * value       db_column: config_value   
     */ 	
	private String configValue;
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


	
	
	public Long getConfigId() {
		return this.configId;
	}
	
	public void setConfigId(Long value) {
		this.configId = value;
	}
	
	
	public String getConfigKey() {
		return this.configKey;
	}
	
	public void setConfigKey(String value) {
		this.configKey = value;
	}
	
	
	public String getConfigValue() {
		return this.configValue;
	}
	
	public void setConfigValue(String value) {
		this.configValue = value;
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

