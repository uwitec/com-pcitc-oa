package com.pcitc.entity;
public class StartUpData {
	//表单中每条数据项属性名称
	String title;
	String applicantName;
	String applicantDept;
	String projectSource;
	String businessType;
	String customerName;
	String projectName;
	String projContent;
	String startTime;
	String endTime;
	String conAmount;
	String conCost;
	String resource;
	String remarks;
	String riskAnalysis;
	
	
	String wfInstanceID;
	String wfStatus;
	String participants;
	String userPost;
	String applyTime;
	String wfFlag;
	String speProjectManager;
	String sign;
	String education;
	String pMQualification;
	String hse;
	String projInvolved;
	String projectNum;
	String projClassify;
	String mountForm;
	String major;
	String signDate;
	String appointmentDate;
	String projectSort;
	String hasPreSaleProj;
	String isClosed;
	String contentType;
	String modified;
	String created;
	String author;
	String editor;
	String uIVersionString;
	String attachments;
	String linkTitleNoMenu;
	String linkTitle;
	String attachName;
	String id;	
	String taskID;
	String userID;
	String wfType;
	
	//-<PCITC_PS_CFormInfo>
	String Title;//标题
	String ApplicantName; ////申请人姓名
	String ApplicantDept;		//申请人部门
	String ProjectSource;//项目来源
	String BusinessType;//所属业务类型
	String CustomerName;//顾客名称
	String ProjectName;//项目名称
	String ProjContent;//项目主要内容
	String StartTime; //预计启动时间
	String EndTime;//预计结束时间
	String ConAmount;//预估合同款
	String ConCost; // 预估总成本
	String Resource;//资源需求
	String Remarks;//备注
	String RiskAnalysis;//风险分析
	String WfInstanceID;//eb403ea1-226a-4239-ae44-19b266241974
	String WfStatus;//待部门负责人审批
	String Participants;//yuxi.wang;;nancy.song;
	String UserPost;//申请人部门
	String ApplyTime;//申请时间 
	String WfFlag;
	String MountForm;//DH|E;
	String ReferDept;//相关事业部
	String ProjectSort;//项目分类 in
	String HasPreSaleProj;//
	String PreSaleProjNum;//售前项目编号
	String RecommendPM;//马长东,4,DAVID.MA,System.String[],vivian.zhao@pcitc.com</RecommendPM>
	String IsClosed;
	String TreatyGrounds;//合同签署地 
	String IsDraft;//>0</IsDraft>
	String ParentID;//>0</ParentID>
	String IsParentProject;//>-1</IsParentProject>
	String SuggestPartProj;//>1</SuggestPartProj>
	String ID;//>1072</ID>
	String ContentType;//>项目</ContentType>
	String Modified;//>2013-07-05T09:14:33+08:00</Modified>
	String Created;//>2013-07-05T09:14:33+08:00</Created>
	String Author;//>王玉玺</Author>
	String Editor;//>王玉玺</Editor>
	String UIVersionString;//>1.0</_UIVersionString>
	String Attachments;//附件个数
	String LinkTitleNoMenu;//>项目启动_王玉玺</LinkTitleNoMenu>
	String LinkTitle;//>项目启动_王玉玺</LinkTitle>
	String TaskID;//>19406</TaskID>
	String UserID;//>4</UserID>
	String WFType;//>C</WFType>
	String AttachName;//附件名称 >new 2.txt</AttachName>
	//</PCITC_PS_CFormInfo>
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "PCITC_PS_CForminfo [title=" + title + ", applicantName=" + applicantName
		+ ", applicantDept=" + applicantDept + ", projectSource="
		+ projectSource + ", businessType=" + businessType + "]";
	}
	public String getTreatyGrounds() {
		return TreatyGrounds;
	}

	public void setTreatyGrounds(String treatyGrounds) {
		TreatyGrounds = treatyGrounds;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskID() {
		return taskID;
	}

	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getWfType() {
		return wfType;
	}

	public void setWfType(String wfType) {
		this.wfType = wfType;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getApplicantDept() {
		return applicantDept;
	}
	public void setApplicantDept(String applicantDept) {
		this.applicantDept = applicantDept;
	}
	public String getProjectSource() {
		return projectSource;
	}
	public void setProjectSource(String projectSource) {
		this.projectSource = projectSource;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjContent() {
		return projContent;
	}
	public void setProjContent(String projContent) {
		this.projContent = projContent;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getConAmount() {
		return conAmount;
	}
	public void setConAmount(String conAmount) {
		this.conAmount = conAmount;
	}
	public String getConCost() {
		return conCost;
	}
	public void setConCost(String conCost) {
		this.conCost = conCost;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getRiskAnalysis() {
		return riskAnalysis;
	}
	public void setRiskAnalysis(String riskAnalysis) {
		this.riskAnalysis = riskAnalysis;
	}
	public String getWfInstanceID() {
		return wfInstanceID;
	}
	public void setWfInstanceID(String wfInstanceID) {
		this.wfInstanceID = wfInstanceID;
	}
	public String getWfStatus() {
		return wfStatus;
	}
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}
	public String getParticipants() {
		return participants;
	}
	public void setParticipants(String participants) {
		this.participants = participants;
	}
	public String getUserPost() {
		return userPost;
	}
	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public String getWfFlag() {
		return wfFlag;
	}
	public void setWfFlag(String wfFlag) {
		this.wfFlag = wfFlag;
	}
	public String getSpeProjectManager() {
		return speProjectManager;
	}
	public void setSpeProjectManager(String speProjectManager) {
		this.speProjectManager = speProjectManager;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getpMQualification() {
		return pMQualification;
	}
	public void setpMQualification(String pMQualification) {
		this.pMQualification = pMQualification;
	}
	public String getHse() {
		return hse;
	}
	public void setHse(String hse) {
		this.hse = hse;
	}
	public String getProjInvolved() {
		return projInvolved;
	}
	public void setProjInvolved(String projInvolved) {
		this.projInvolved = projInvolved;
	}
	public String getProjectNum() {
		return projectNum;
	}
	public void setProjectNum(String projectNum) {
		this.projectNum = projectNum;
	}
	public String getProjClassify() {
		return projClassify;
	}
	public void setProjClassify(String projClassify) {
		this.projClassify = projClassify;
	}
	public String getMountForm() {
		return mountForm;
	}
	public void setMountForm(String mountForm) {
		this.mountForm = mountForm;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSignDate() {
		return signDate;
	}
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getProjectSort() {
		return projectSort;
	}
	public void setProjectSort(String projectSort) {
		this.projectSort = projectSort;
	}
	public String getHasPreSaleProj() {
		return hasPreSaleProj;
	}
	public void setHasPreSaleProj(String hasPreSaleProj) {
		this.hasPreSaleProj = hasPreSaleProj;
	}
	public String getIsClosed() {
		return isClosed;
	}
	public void setIsClosed(String isClosed) {
		this.isClosed = isClosed;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getuIVersionString() {
		return uIVersionString;
	}
	public void setuIVersionString(String uIVersionString) {
		this.uIVersionString = uIVersionString;
	}
	public String getAttachments() {
		return attachments;
	}
	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	public String getLinkTitleNoMenu() {
		return linkTitleNoMenu;
	}
	public void setLinkTitleNoMenu(String linkTitleNoMenu) {
		this.linkTitleNoMenu = linkTitleNoMenu;
	}
	public String getLinkTitle() {
		return linkTitle;
	}
	public void setLinkTitle(String linkTitle) {
		this.linkTitle = linkTitle;
	}
	public String getAttachName() {
		return attachName;
	}
	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}
	
	public String getRecommendPM() {
		return RecommendPM;
	}
	public void setRecommendPM(String recommendPM) {
		RecommendPM = recommendPM;
	}

	
	

}