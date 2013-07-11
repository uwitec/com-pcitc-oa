package com.pcitc.entity;
/**
 * 待处理实体类 
 * @author 
 *
 */
public class PendingListData {
	
	//申请编号
	String proId;
	//申请人姓名
	String applyName;
	//申请人所属部门
	String applyDepartment;
	//申请日期
	String applyDate;
	//流程名称
	String processName;
	
	String userID;
	
	String wfType;
	
	String wfID;
	
	@Override
	public String toString() {
		return "PendingListData [proId=" + proId + ", applyName=" + applyName
				+ ", applyDepartment=" + applyDepartment + ", applyDate="
				+ applyDate + ", processName=" + processName + ", userID="
				+ userID + ", wfType=" + wfType + ", wfID=" + wfID + "]";
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getWFType() {
		return wfType;
	}
	public void setWFType(String wfType) {
		this.wfType = wfType;
	}
	public String getWfID() {
		return wfID;
	}
	public void setWfID(String wfID) {
		this.wfID = wfID;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public String getApplyDepartment() {
		return applyDepartment;
	}
	public void setApplyDepartment(String applyDepartment) {
		this.applyDepartment = applyDepartment;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
}
