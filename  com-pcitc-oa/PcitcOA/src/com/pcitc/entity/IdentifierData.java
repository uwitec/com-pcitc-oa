package com.pcitc.entity;

public class IdentifierData {
	
	
	public IdentifierData() {
		super();
		// TODO Auto-generated constructor stub
	}
	String Title; //标题
	
	String ApplicantName;		//申请人姓名
	String ApplicantDept;		//申请人部门
	String ApplicantDeptID;		//申请人部门编号 
	String ApplicationDate;		//申请时间 
	String CTTSingedPlace;		//合同签署地 
	String CTTType; 	    	//合同类型  
	String AuthorityL1;	    	//一级报销审批人 
	String AuthorityL2;	    	//二级报销审批人 
	String AuthorityL3;	    	//三级报销审批人  
	String ProjectManager;   	//项目经理姓名
	String PMEmail;	        	//项目经理Email 
	String PMID;	        	//项目经理ID 
	String MainProjectName;	   //	主项目名称 
	String MainProjectNum;	   	//主项目编号 
	String ContractName;  	//合同/项目名称
	String ProjectSummary;	  // 	项目简要说明
	String ProjectStartDate;   	//项目正式实施时间
	String ProjectdFinishedDate; //项目预计完成时间
	
	String ProjectdClosedDate;	//项目关闭时间 
	String SalesType;	    	//销售类型 
	String ProjectName;//项目名称
	String ProjectNumber;
	String Modified;
	String ProjectSource;	    //项目来源 
	String BusinessSort;	    //业务细分类 
	String ContentType;
	String Created;
	String ProjectType;	    	//项目类型
	String EstimatedCTTAmount;	//预估合同额
	String MaterialCharge;	    //料（成本）
	String BasicCharge;	    	//工（成本）
	String OtherCharge;	    	//费（成本）
	String BudgetTotal;	    	//预算合计
	String WfInstanctID;	    //WfInstanctID b467821a-5f0d-421a-8e55-9e64d05cbab7
	String WfStatus;	    	//WfStatus 待部门一级审核人审核
	String IsSplited;	    	//是否拆弹 
	String ID;//fromid
	String UIVersionString;
	String ContractNumber;	    //合同编号 
	String CompanyCode; 	    //公司代码 
	String CostCentral;	    	//成本中心 
	String Attachments;	//附件
	String LinkTitleNoMenu;
	String LinkTitle;
	String Author;
	String Editor;
	String TaskID;
	String UserID;
	String WFType;
	
	String Participants;	    //Participants 研发
	String Wfflag;	    	  //  Wfflag 
	String ProjectSort;	    	//项目分类 in
	String ChangePropertyWay;//转资方式
	String AttachName;	//附件名称
	String LabourCharge; //人工
	
	//===================================
	String CustomerName;       //顾客名称
	String RiskAnalysis;       //风险分析
	String Resource;            //资源需求
	String BusinessType;
	String SignDate;	    	//SignDate X
	String AppointmentDate;	  //  AppointmentDate X
	String WBSAssigner;	    	//WBS编号分配人 X
	String AssignDate;	    	//分配日期 X 
	String WBSNum;	    		//WBS元素编号 X
	String MainProjectNameFM;	//主项目名称（专员修改） X
	String MainProjectNumFM;	//主项目编号（专员修改） X
	String ProjectTypeFM;	    //项目类型（专员修改） X
	String ProjectSourceFM;	//项目来源（专员修改） X
	String SalesTypeFM;	    //销售类型（专员修改） X
	String IsBuildedWBS;	    //是否已创建WBS号 X
	String Budgetee;	    	//预算维护人 X
	String BudgetMaintainDate;	//预算维护日期 X
	String IncomePlan;	    	//收入计划 X
	String CostPlan;	    	//成本计划 X
	String WBSIssuedPerson;	  //  WBS下达人 X
	String WBSIssuedDate;	    //WBS下达日期 X
	String CustomerControlStatus;  //用户控制状态 X
	String IsWBSIssued;	    	//WBS下达状态 X
	String ClosedProDelRea;	    //项目关闭延迟原因 X
	String MountForm;	    	//MountForm X
	String Changed;	    		//Changed X
	String MaterialChargeFF;	  //  料（成本）（财务B岗） X
	String BasicChargeFF;	    	//工（成本）（财务B岗） X
	String OtherChargeFF;	    	//费（成本）（财务B岗） X
	String IsLocked;	    	//是否被锁定 X
	String Connected;	    	//关联项（用于新增和变更） X
	String ParentID;	    	//ParentID X
	String MainProjectRefID;	 //MainProjectRefID X
	String IsProMaudit;	    	//IsProMaudit X
	
	
	
	public String getLabourCharge() {
		return LabourCharge;
	}
	public void setLabourCharge(String labourCharge) {
		LabourCharge = labourCharge;
	}
	public String getChangePropertyWay() {
		return ChangePropertyWay;
	}
	public void setChangePropertyWay(String changePropertyWay) {
		ChangePropertyWay = changePropertyWay;
	}
	public String getAttachName() {
		return AttachName;
	}
	public void setAttachName(String attachName) {
		AttachName = attachName;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getApplicantName() {
		return ApplicantName;
	}
	public void setApplicantName(String applicantName) {
		ApplicantName = applicantName;
	}
	public String getApplicantDept() {
		return ApplicantDept;
	}
	public void setApplicantDept(String applicantDept) {
		ApplicantDept = applicantDept;
	}
	public String getCTTSingedPlace() {
		return CTTSingedPlace;
	}
	public void setCTTSingedPlace(String cTTSingedPlace) {
		CTTSingedPlace = cTTSingedPlace;
	}
	public String getCTTType() {
		return CTTType;
	}
	public void setCTTType(String cTTType) {
		CTTType = cTTType;
	}
	public String getAuthorityL1() {
		return AuthorityL1;
	}
	public void setAuthorityL1(String authorityL1) {
		AuthorityL1 = authorityL1;
	}
	public String getAuthorityL2() {
		return AuthorityL2;
	}
	public void setAuthorityL2(String authorityL2) {
		AuthorityL2 = authorityL2;
	}
	public String getAuthorityL3() {
		return AuthorityL3;
	}
	public void setAuthorityL3(String authorityL3) {
		AuthorityL3 = authorityL3;
	}
	public String getProjectManager() {
		return ProjectManager;
	}
	public void setProjectManager(String projectManager) {
		ProjectManager = projectManager;
	}
	public String getPMEmail() {
		return PMEmail;
	}
	public void setPMEmail(String pMEmail) {
		PMEmail = pMEmail;
	}
	public String getPMID() {
		return PMID;
	}
	public void setPMID(String pMID) {
		PMID = pMID;
	}
	public String getMainProjectName() {
		return MainProjectName;
	}
	public void setMainProjectName(String mainProjectName) {
		MainProjectName = mainProjectName;
	}
	public String getMainProjectNum() {
		return MainProjectNum;
	}
	public void setMainProjectNum(String mainProjectNum) {
		MainProjectNum = mainProjectNum;
	}
	public String getContractName() {
		return ContractName;
	}
	public void setContractName(String contractName) {
		ContractName = contractName;
	}
	public String getProjectSummary() {
		return ProjectSummary;
	}
	public void setProjectSummary(String projectSummary) {
		ProjectSummary = projectSummary;
	}
	public String getProjectStartDate() {
		return ProjectStartDate;
	}
	public void setProjectStartDate(String projectStartDate) {
		ProjectStartDate = projectStartDate;
	}
	public String getProjectdFinishedDate() {
		return ProjectdFinishedDate;
	}
	public void setProjectdFinishedDate(String projectdFinishedDate) {
		ProjectdFinishedDate = projectdFinishedDate;
	}
	public String getProjectdClosedDate() {
		return ProjectdClosedDate;
	}
	public void setProjectdClosedDate(String projectdClosedDate) {
		ProjectdClosedDate = projectdClosedDate;
	}
	public String getSalesType() {
		return SalesType;
	}
	public void setSalesType(String salesType) {
		SalesType = salesType;
	}
	public String getProjectSource() {
		return ProjectSource;
	}
	public void setProjectSource(String projectSource) {
		ProjectSource = projectSource;
	}
	public String getBusinessSort() {
		return BusinessSort;
	}
	public void setBusinessSort(String businessSort) {
		BusinessSort = businessSort;
	}
	public String getProjectType() {
		return ProjectType;
	}
	public void setProjectType(String projectType) {
		ProjectType = projectType;
	}
	public String getEstimatedCTTAmount() {
		return EstimatedCTTAmount;
	}
	public void setEstimatedCTTAmount(String estimatedCTTAmount) {
		EstimatedCTTAmount = estimatedCTTAmount;
	}
	public String getMaterialCharge() {
		return MaterialCharge;
	}
	public void setMaterialCharge(String materialCharge) {
		MaterialCharge = materialCharge;
	}
	public String getBasicCharge() {
		return BasicCharge;
	}
	public void setBasicCharge(String basicCharge) {
		BasicCharge = basicCharge;
	}
	public String getOtherCharge() {
		return OtherCharge;
	}
	public void setOtherCharge(String otherCharge) {
		OtherCharge = otherCharge;
	}
	public String getBudgetTotal() {
		return BudgetTotal;
	}
	public void setBudgetTotal(String budgetTotal) {
		BudgetTotal = budgetTotal;
	}
	public String getWfInstanctID() {
		return WfInstanctID;
	}
	public void setWfInstanctID(String wfInstanctID) {
		WfInstanctID = wfInstanctID;
	}
	public String getWfStatus() {
		return WfStatus;
	}
	public void setWfStatus(String wfStatus) {
		WfStatus = wfStatus;
	}
	public String getIsSplited() {
		return IsSplited;
	}
	public void setIsSplited(String isSplited) {
		IsSplited = isSplited;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getEditor() {
		return Editor;
	}
	public void setEditor(String editor) {
		Editor = editor;
	}
	public String getTaskID() {
		return TaskID;
	}
	public void setTaskID(String taskID) {
		TaskID = taskID;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getWFType() {
		return WFType;
	}
	public void setWFType(String wFType) {
		WFType = wFType;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getRiskAnalysis() {
		return RiskAnalysis;
	}
	public void setRiskAnalysis(String riskAnalysis) {
		RiskAnalysis = riskAnalysis;
	}
	public String getResource() {
		return Resource;
	}
	public void setResource(String resource) {
		Resource = resource;
	}
	public String getApplicantDeptID() {
		return ApplicantDeptID;
	}
	public void setApplicantDeptID(String applicantDeptID) {
		ApplicantDeptID = applicantDeptID;
	}
	public String getBusinessType() {
		return BusinessType;
	}
	public void setBusinessType(String businessType) {
		BusinessType = businessType;
	}
	public String getApplicationDate() {
		return ApplicationDate;
	}
	public void setApplicationDate(String applicationDate) {
		ApplicationDate = applicationDate;
	}
	public String getParticipants() {
		return Participants;
	}
	public void setParticipants(String participants) {
		Participants = participants;
	}
	public String getWfflag() {
		return Wfflag;
	}
	public void setWfflag(String wfflag) {
		Wfflag = wfflag;
	}
	public String getSignDate() {
		return SignDate;
	}
	public void setSignDate(String signDate) {
		SignDate = signDate;
	}
	public String getAppointmentDate() {
		return AppointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		AppointmentDate = appointmentDate;
	}
	public String getWBSAssigner() {
		return WBSAssigner;
	}
	public void setWBSAssigner(String wBSAssigner) {
		WBSAssigner = wBSAssigner;
	}
	public String getAssignDate() {
		return AssignDate;
	}
	public void setAssignDate(String assignDate) {
		AssignDate = assignDate;
	}
	public String getCompanyCode() {
		return CompanyCode;
	}
	public void setCompanyCode(String companyCode) {
		CompanyCode = companyCode;
	}
	public String getCostCentral() {
		return CostCentral;
	}
	public void setCostCentral(String costCentral) {
		CostCentral = costCentral;
	}
	public String getWBSNum() {
		return WBSNum;
	}
	public void setWBSNum(String wBSNum) {
		WBSNum = wBSNum;
	}
	public String getMainProjectNameFM() {
		return MainProjectNameFM;
	}
	public void setMainProjectNameFM(String mainProjectNameFM) {
		MainProjectNameFM = mainProjectNameFM;
	}
	public String getMainProjectNumFM() {
		return MainProjectNumFM;
	}
	public void setMainProjectNumFM(String mainProjectNumFM) {
		MainProjectNumFM = mainProjectNumFM;
	}
	public String getProjectTypeFM() {
		return ProjectTypeFM;
	}
	public void setProjectTypeFM(String projectTypeFM) {
		ProjectTypeFM = projectTypeFM;
	}
	public String getProjectSourceFM() {
		return ProjectSourceFM;
	}
	public void setProjectSourceFM(String projectSourceFM) {
		ProjectSourceFM = projectSourceFM;
	}
	public String getSalesTypeFM() {
		return SalesTypeFM;
	}
	public void setSalesTypeFM(String salesTypeFM) {
		SalesTypeFM = salesTypeFM;
	}
	public String getIsBuildedWBS() {
		return IsBuildedWBS;
	}
	public void setIsBuildedWBS(String isBuildedWBS) {
		IsBuildedWBS = isBuildedWBS;
	}
	public String getBudgetee() {
		return Budgetee;
	}
	public void setBudgetee(String budgetee) {
		Budgetee = budgetee;
	}
	public String getBudgetMaintainDate() {
		return BudgetMaintainDate;
	}
	public void setBudgetMaintainDate(String budgetMaintainDate) {
		BudgetMaintainDate = budgetMaintainDate;
	}
	public String getIncomePlan() {
		return IncomePlan;
	}
	public void setIncomePlan(String incomePlan) {
		IncomePlan = incomePlan;
	}
	public String getCostPlan() {
		return CostPlan;
	}
	public void setCostPlan(String costPlan) {
		CostPlan = costPlan;
	}
	public String getWBSIssuedPerson() {
		return WBSIssuedPerson;
	}
	public void setWBSIssuedPerson(String wBSIssuedPerson) {
		WBSIssuedPerson = wBSIssuedPerson;
	}
	public String getWBSIssuedDate() {
		return WBSIssuedDate;
	}
	public void setWBSIssuedDate(String wBSIssuedDate) {
		WBSIssuedDate = wBSIssuedDate;
	}
	public String getCustomerControlStatus() {
		return CustomerControlStatus;
	}
	public void setCustomerControlStatus(String customerControlStatus) {
		CustomerControlStatus = customerControlStatus;
	}
	public String getIsWBSIssued() {
		return IsWBSIssued;
	}
	public void setIsWBSIssued(String isWBSIssued) {
		IsWBSIssued = isWBSIssued;
	}
	public String getProjectSort() {
		return ProjectSort;
	}
	public void setProjectSort(String projectSort) {
		ProjectSort = projectSort;
	}
	public String getClosedProDelRea() {
		return ClosedProDelRea;
	}
	public void setClosedProDelRea(String closedProDelRea) {
		ClosedProDelRea = closedProDelRea;
	}
	public String getMountForm() {
		return MountForm;
	}
	public void setMountForm(String mountForm) {
		MountForm = mountForm;
	}
	public String getChanged() {
		return Changed;
	}
	public void setChanged(String changed) {
		Changed = changed;
	}
	public String getMaterialChargeFF() {
		return MaterialChargeFF;
	}
	public void setMaterialChargeFF(String materialChargeFF) {
		MaterialChargeFF = materialChargeFF;
	}
	public String getBasicChargeFF() {
		return BasicChargeFF;
	}
	public void setBasicChargeFF(String basicChargeFF) {
		BasicChargeFF = basicChargeFF;
	}
	public String getOtherChargeFF() {
		return OtherChargeFF;
	}
	public void setOtherChargeFF(String otherChargeFF) {
		OtherChargeFF = otherChargeFF;
	}
	public String getIsLocked() {
		return IsLocked;
	}
	public void setIsLocked(String isLocked) {
		IsLocked = isLocked;
	}
	public String getConnected() {
		return Connected;
	}
	public void setConnected(String connected) {
		Connected = connected;
	}
	public String getContractNumber() {
		return ContractNumber;
	}
	public void setContractNumber(String contractNumber) {
		ContractNumber = contractNumber;
	}
	public String getParentID() {
		return ParentID;
	}
	public void setParentID(String parentID) {
		ParentID = parentID;
	}
	public String getMainProjectRefID() {
		return MainProjectRefID;
	}
	public void setMainProjectRefID(String mainProjectRefID) {
		MainProjectRefID = mainProjectRefID;
	}
	public String getIsProMaudit() {
		return IsProMaudit;
	}
	public void setIsProMaudit(String isProMaudit) {
		IsProMaudit = isProMaudit;
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getProjectNumber() {
		return ProjectNumber;
	}
	public void setProjectNumber(String projectNumber) {
		ProjectNumber = projectNumber;
	}
	public String getModified() {
		return Modified;
	}
	public void setModified(String modified) {
		Modified = modified;
	}
	public String getContentType() {
		return ContentType;
	}
	public void setContentType(String contentType) {
		ContentType = contentType;
	}
	public String getCreated() {
		return Created;
	}
	public void setCreated(String created) {
		Created = created;
	}
	public String getUIVersionString() {
		return UIVersionString;
	}
	public void setUIVersionString(String uIVersionString) {
		UIVersionString = uIVersionString;
	}
	public String getAttachments() {
		return Attachments;
	}
	public void setAttachments(String attachments) {
		Attachments = attachments;
	}
	public String getLinkTitleNoMenu() {
		return LinkTitleNoMenu;
	}
	public void setLinkTitleNoMenu(String linkTitleNoMenu) {
		LinkTitleNoMenu = linkTitleNoMenu;
	}
	public String getLinkTitle() {
		return LinkTitle;
	}
	public void setLinkTitle(String linkTitle) {
		LinkTitle = linkTitle;
	}
}
