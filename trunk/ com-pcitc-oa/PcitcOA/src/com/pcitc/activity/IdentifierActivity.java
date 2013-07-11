package com.pcitc.activity;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.pcitc.entity.IdentifierData;
import com.pcitc.entity.PcitcConstants;
import com.pcitc.utils.ActivityStackControlUtil;
import com.pcitc.utils.PcitcAsyncTask;
import com.pcitc.utils.TimeUtil;
import com.pcitc.xmlparse.GetInputStream;
import com.pcitc.xmlparse.IdentifierSaxParse;

/**
 * 项目编号申请 部门负责人审批
 * 
 * @author rushun.zhang
 * 
 */
public class IdentifierActivity extends AbstractActivity {

	private IdentifierData datas = null;
	private String taskID;
	private String wfType;
	private String userId;
	private String wfId;
	private String ProcessType;
	private EditText[] eTexts;
	private RadioButton radioyes, radiono, radioyess, radionoo;
	private Button yes, no;
	private TextView title, tv_dept, tv_signplace, tv_mainprojectname,
			tv_mianprojectnum,tv_totalcost,tv_totaltime;
	private TableRow tr_contracttype, tr_small_pro, tr_big_proname,
			tr_big_pronum, tr_big_promaager, before, tr_markettupe,
			tr_prosource,tr_project_x,tr_total_l,tr_conamount,tr_zhuanzi;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projectnum_first);

		overrideParent();
		initUI();
	}

	@Override
	public void overrideParent() {
		// TODO Auto-generated method stub
		ActivityStackControlUtil.add(this);

		titleView.setText("项目编号申请详情");
		templateButtonLeft.setVisibility(View.VISIBLE);
		templateButtonRight.setVisibility(View.GONE);
	}

	protected void initData(IdentifierData datas2) {
		// TODO Auto-generated method stub
		title.setText(datas2.getTitle());
		eTexts[0].setText(datas2.getApplicantName());// 申请人姓名
		eTexts[1].setText(datas2.getApplicantDept());// 申请人岗位
		eTexts[2].setText(datas2.getCTTSingedPlace());// 合同签署地
		eTexts[3].setText(datas2.getCTTType());// 合同类型
		eTexts[4].setText(datas2.getAuthorityL1());// 一级审批人
		eTexts[5].setText(datas2.getAuthorityL2());// 二级审批人
		eTexts[6].setText(datas2.getAuthorityL3());// 三级审批人
		eTexts[7].setText(datas2.getMainProjectName());// 主项目名称
		eTexts[8].setText(datas2.getMainProjectNum());// 主项目编号
		eTexts[9].setText(datas2.getContractName());// 合同名称
		eTexts[10].setText(datas2.getProjectManager());// 项目经理姓名
		String parseDate = TimeUtil.parseDate(TimeUtil.sdf1, datas2.getProjectStartDate());
		String parseDate1 = TimeUtil.parseDate(TimeUtil.sdf1,datas2.getProjectdFinishedDate());
		String parseDate2 = TimeUtil.parseDate(TimeUtil.sdf1,datas2.getProjectdClosedDate());
		eTexts[11].setText(parseDate);// 正式实施时间
		eTexts[12].setText(parseDate1);// 预计完成时间
		eTexts[13].setText(parseDate2);// 预计关闭时间
		eTexts[14].setText(datas2.getProjectType());// 销售类型
		eTexts[15].setText(datas2.getProjectSource());// 项目来源
		eTexts[16].setText(datas2.getBusinessSort());// 业务细分类
		eTexts[17].setText(datas2.getEstimatedCTTAmount());// 预计合同款
		eTexts[18].setText(datas2.getMaterialCharge());// 料
		if (ProcessType.equals(this.getString(R.string.project_num_type_re))||ProcessType.equals(this.getString(R.string.project_num_type_in))) {
			eTexts[19].setText(datas2.getLabourCharge());// 人工
		}else {
			eTexts[19].setText(datas2.getBasicCharge());// 工
		}
		eTexts[20].setText(datas2.getOtherCharge());// 费
		eTexts[21].setText(datas2.getBudgetTotal());// 预算合计
		eTexts[22].setText(datas2.getProjectSummary());// 项目简要说明
		eTexts[23].setText(datas2.getAuthor() + ":" + datas2.getEditor() + ""
				+ ":" + datas2.getCreated());// 审批意见
		eTexts[24].setText(datas2.getAuthor() + ":" + datas2.getEditor() + ""
				+ ":" + datas2.getCreated());// 历史相关被驳回申请
		// eTexts[25].setText(datas2.getContractNumber());//项目编号
		// eTexts[26].setText(datas2.getCostCentral());//成本中心
		// eTexts[27].setText(datas2.getCompanyCode());//公司代码
		if (datas2.getAttachName() != null) {
			eTexts[29].setText( datas2.getAttachName());// 附件
		} else {
			eTexts[29].setText("无");// 附件
		}
		
		// eTexts[30].setText(datas2.getAttachments());//子项目经理
		// eTexts[31].setText(datas2.getAttachments());//大项目名称
		// eTexts[32].setText(datas2.getAttachments());//大项目编号
		// eTexts[33].setText(datas2.getAttachments());//大项目经理
		eTexts[34].setText(datas2.getChangePropertyWay());
	}

	@Override
	public void initUI() {

		Bundle bundle = getIntent().getBundleExtra("bundle");
		taskID = bundle.getString("TaskID");
		wfType = bundle.getString("WFType");
		userId = bundle.getString("UserID");
		wfId = bundle.getString("WFID");
		ProcessType = bundle.getString("ProcessType");

		title = (TextView) findViewById(R.id.title);
		tv_dept = (TextView) findViewById(R.id.tv_dept);
		tv_signplace = (TextView) findViewById(R.id.tv_signplace);
		tv_totalcost= (TextView) findViewById(R.id.tv_totalcost);
		tv_totaltime= (TextView) findViewById(R.id.tv_totaltime);
		
		tr_contracttype = (TableRow) findViewById(R.id.tr_contracttype);
		tr_small_pro = (TableRow) findViewById(R.id.tr_small_pro);
		tr_big_proname = (TableRow) findViewById(R.id.tr_big_proname);
		tr_big_pronum = (TableRow) findViewById(R.id.tr_big_pronum);
		tr_big_promaager = (TableRow) findViewById(R.id.tr_big_promaager);
		before = (TableRow) findViewById(R.id.before);
		tr_markettupe = (TableRow) findViewById(R.id.tr_markettupe);
		tr_prosource = (TableRow) findViewById(R.id.tr_prosource);
		tr_project_x = (TableRow) findViewById(R.id.tr_project_x);
		tr_total_l = (TableRow) findViewById(R.id.tr_total_l);
		tr_conamount = (TableRow) findViewById(R.id.tr_conamount);
		tr_zhuanzi= (TableRow) findViewById(R.id.tr_zhuanzi);
		
		tv_mainprojectname = (TextView) findViewById(R.id.tv_mainprojectname);
		tv_mianprojectnum = (TextView) findViewById(R.id.tv_mianprojectnum);
		
		eTexts = new EditText[35];
		eTexts[0] = (EditText) findViewById(R.id.appname);// 申请人姓名
		eTexts[1] = (EditText) findViewById(R.id.appdept);// 申请人岗位
		eTexts[2] = (EditText) findViewById(R.id.signplace);// 合同签署地
		eTexts[3] = (EditText) findViewById(R.id.contracttype);// 合同类型
		eTexts[4] = (EditText) findViewById(R.id.firstexamine);// 一级审批人
		eTexts[5] = (EditText) findViewById(R.id.secondexamine);// 二级审批人
		eTexts[6] = (EditText) findViewById(R.id.thirdexamine);// 三级审批人
		eTexts[7] = (EditText) findViewById(R.id.mainproname);// 子项目名称
		eTexts[8] = (EditText) findViewById(R.id.mainpronum);// 子项目编号
		eTexts[9] = (EditText) findViewById(R.id.contactname);// 合同名称
		eTexts[10] = (EditText) findViewById(R.id.projectname);// 项目经理姓名
		eTexts[11] = (EditText) findViewById(R.id.startdate);// 正式实施时间
		eTexts[12] = (EditText) findViewById(R.id.enddate);// 预计完成时间
		eTexts[13] = (EditText) findViewById(R.id.closedate);// 预计关闭时间
		eTexts[14] = (EditText) findViewById(R.id.markettype);// 销售类型
		eTexts[15] = (EditText) findViewById(R.id.projectsource);// 项目来源
		eTexts[16] = (EditText) findViewById(R.id.businesssplit);// 业务细分类
		eTexts[17] = (EditText) findViewById(R.id.conamount);// 预计合同款
		eTexts[18] = (EditText) findViewById(R.id.totalsource);// 料
		eTexts[19] = (EditText) findViewById(R.id.totaltime);// 工
		eTexts[20] = (EditText) findViewById(R.id.totalcost);// 费
		eTexts[21] = (EditText) findViewById(R.id.costestimate);// 预算合计
		eTexts[22] = (EditText) findViewById(R.id.briefintroduction);// 项目简要说明
		eTexts[23] = (EditText) findViewById(R.id.input_name);// 审批意见
		eTexts[24] = (EditText) findViewById(R.id.historyinput_name);// 历史相关被驳回申请
		// eTexts[25] = (EditText) findViewById(R.id.projectnum);//项目编号
		// eTexts[26] = (EditText) findViewById(R.id.costcenter);//成本中心
		// eTexts[27] = (EditText) findViewById(R.id.companynum);//公司代码
		eTexts[28] = (EditText) findViewById(R.id.owninput_name);// 您的意见
		eTexts[29] = (EditText) findViewById(R.id.attachment);// 附件

		eTexts[30] = (EditText) findViewById(R.id.small_projectmanager);// 子项目经理
		eTexts[31] = (EditText) findViewById(R.id.big_projectname);// 大项目名称
		eTexts[32] = (EditText) findViewById(R.id.big_projectnum);// 大项目编号
		eTexts[33] = (EditText) findViewById(R.id.big_projectmanager);// 大项目经理
		eTexts[34] = (EditText) findViewById(R.id.et_zhuanzi);// 转资方式
		
		radioyes = (RadioButton) findViewById(R.id.radioyes);
		radiono = (RadioButton) findViewById(R.id.radiono);
		// 项目类型
		radioyess = (RadioButton) findViewById(R.id.radioyess);
		radionoo = (RadioButton) findViewById(R.id.radionoo);

		yes = (Button) findViewById(R.id.yes);
		no = (Button) findViewById(R.id.no);

		yes.setOnClickListener(this);
		no.setOnClickListener(this);

		if (ProcessType.equals(this.getString(R.string.project_num_type_re))||ProcessType.equals(this.getString(R.string.project_num_type_in))) {
			tv_dept.setText("申请人部门");
			tv_signplace.setText("成本发生地");
			tv_mainprojectname.setText("主项目名称");
			tv_mianprojectnum.setText("主项目编号");
			tv_totalcost.setText("费用");
			tv_totaltime.setText("人工");
			tr_contracttype.setVisibility(View.GONE);
			tr_small_pro.setVisibility(View.GONE);
			tr_big_proname.setVisibility(View.GONE);
			tr_big_pronum.setVisibility(View.GONE);
			tr_big_promaager.setVisibility(View.GONE);
			before.setVisibility(View.GONE);
			tr_markettupe.setVisibility(View.GONE);
			tr_prosource.setVisibility(View.GONE);
			tr_project_x.setVisibility(View.GONE);
			tr_total_l.setVisibility(View.GONE);
			tr_conamount.setVisibility(View.GONE);
			tr_zhuanzi.setVisibility(View.VISIBLE);
		}

		templateButtonLeft.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		RequestData();
	}

	private void RequestData() {
		// TODO Auto-generated method stub

		PcitcAsyncTask asyncTask = new PcitcAsyncTask(this) {

			@Override
			public Object before(Object... params) throws Exception {
				// TODO Auto-generated method stub
				// 解析表单数据
				IdentifierSaxParse parse = new IdentifierSaxParse();

				// 获取表单数据的URL

				String smsURL = PcitcConstants.IP
						+ "_layouts/InterFace/FormDataList.ashx?WFID=" + wfId
						+ "&UserID=" + userId + "&WFType=" + wfType
						+ "&TaskID=" + taskID;

				Log.i("TAG", "url:===>" + smsURL);
				InputStream is = GetInputStream.getInputStream(smsURL);
				Object data = parse.parse(is); // 获取表单数据
				return data;
			}

			@Override
			public void after(Object result) {
				// TODO Auto-generated method stub
				if (result != null && !result.equals("")) {
					datas = (IdentifierData) result;
					initData(datas);
				}

			}

		};
		asyncTask.execute(null);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.yes:
			submitData("1");
			break;
		case R.id.no:
			submitData("0");
			break;
		default:
			break;
		}
		super.onClick(arg0);
	}

	private void submitData(final String auditType) {
		PcitcAsyncTask async = new PcitcAsyncTask(this) {

			@Override
			public Object before(Object... params) throws Exception {
				// TODO Auto-generated method stub
				String sugguest = eTexts[28].getText().toString();
				String str = "";
				try {
					str = URLEncoder.encode(sugguest, "utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 提交表单验证的URL
				String smsURL = PcitcConstants.IP
						+ "_layouts/InterFace/ProjectNumberAuditAdd.ashx?LoginName="
						+ LoginActivity.uName + "&FormID=" + datas.getID()
						+ "&TaskID=" + taskID + "&AuditOpinion=" + str
						+ "&AuditType=" + auditType + "&WFType=" + wfType;
				Log.i("TAG", "url:===>" + smsURL);
				String s = GetInputStream.getString(smsURL);

				return s;
			}

			@Override
			public void after(Object result) {
				// TODO Auto-generated method stub
				if (result != null && !result.equals("")) {
					if (((String) result).contains("True")
							|| ((String) result).contains("true")) {
						Toast.makeText(IdentifierActivity.this, "数据提交成功！",
								Toast.LENGTH_SHORT).show();
						IdentifierActivity.this.finish();
					} else if (((String) result).contains("False")
							|| ((String) result).contains("false")) {
						Toast.makeText(IdentifierActivity.this, "数据提交失败！",
								Toast.LENGTH_SHORT).show();
						IdentifierActivity.this.finish();
					} else {
						Toast.makeText(IdentifierActivity.this, "数据提交失败！",
								Toast.LENGTH_SHORT).show();
					}
				}
			}
		};
		async.execute();
	}
	@Override
	protected void onDestroy() {
		ActivityStackControlUtil.remove(this);
		super.onDestroy();
	}
}
