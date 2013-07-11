package com.pcitc.activity;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.pcitc.entity.StartUpData;
import com.pcitc.entity.PcitcConstants;
import com.pcitc.utils.ActivityStackControlUtil;
import com.pcitc.utils.PcitcAsyncTask;
import com.pcitc.xmlparse.StartUpSaxParse;
import com.pcitc.xmlparse.GetInputStream;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 项目启动审批详情
 * 
 * @author rushun.zhan
 * 
 */
public class StartUpActivity extends AbstractActivity {

	private EditText[] edit = new EditText[19];
	private RadioButton radioyes, radiono;
	private Button yes, no;
	private StartUpData data = null;
	private String taskID;
	private String wfType;
	private String userId;
	private String wfId;
	private TextView title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_formlist);
		overrideParent();
		initUI();
	}

	@Override
	public void overrideParent() {
		// TODO Auto-generated method stub
		ActivityStackControlUtil.add(this);

		titleView.setText("项目审批详情");
		templateButtonLeft.setVisibility(View.VISIBLE);
		templateButtonRight.setVisibility(View.GONE);
	}

	protected void initdata(StartUpData data) {
		// TODO Auto-generated method stub
		title.setText(data.getTitle());
		edit[0].setText(data.getApplicantName());
		edit[1].setText(data.getApplicantDept());
		edit[2].setText(data.getProjectSource());
		edit[3].setText(data.getCustomerName());
		edit[4].setText(data.getProjectName());
		edit[5].setText(data.getTreatyGrounds());
		edit[6].setText(data.getProjContent());
		edit[7].setText(data.getStartTime());
		edit[8].setText(data.getEndTime());
		edit[9].setText(data.getConAmount());
		edit[10].setText(data.getConCost());
		edit[11].setText(data.getResource());
		edit[12].setText(data.getRiskAnalysis());
		edit[13].setText(data.getRecommendPM().substring(0,data.getRecommendPM().indexOf(",")));
		edit[14].setText(data.getRemarks());
		edit[15].setText(data.getAttachments());
		edit[16].setText(data.getAuthor() + ":" + data.getEditor() + "" + ":"
				+ data.getCreated());
		edit[17].setText(data.getAuthor() + ":" + data.getEditor() + "" + ":"
				+ data.getCreated());

		if (data.getHasPreSaleProj().equals("是")) {
			radioyes.setChecked(true);
		} else {
			radiono.setChecked(true);
		}
	}

	@Override
	public void initUI() {
		// TODO Auto-generated method stub
		Bundle bundle = getIntent().getBundleExtra("bundle");
		taskID = bundle.getString("TaskID");
		wfType = bundle.getString("WFType");
		userId = bundle.getString("UserID");
		wfId = bundle.getString("WFID");
		title = (TextView) findViewById(R.id.title);
		edit[0] = (EditText) findViewById(R.id.login_edit_username);// 申请人姓名
		edit[1] = (EditText) findViewById(R.id.login_edit_password);// 申请人部门
		edit[2] = (EditText) findViewById(R.id.pro_source_name);// 项目来源
		edit[3] = (EditText) findViewById(R.id.customer_name);// 顾客名称
		edit[4] = (EditText) findViewById(R.id.pro_name);// 项目名称
		edit[5] = (EditText) findViewById(R.id.sign_name);// 合同签署地
		edit[6] = (EditText) findViewById(R.id.maincontent_name);// 项目主要内容
		edit[7] = (EditText) findViewById(R.id.pro_date);// 启动日期
		edit[8] = (EditText) findViewById(R.id.enddate_name);// 结束日期
		edit[9] = (EditText) findViewById(R.id.estprice_name);// 预计合同款
		edit[10] = (EditText) findViewById(R.id.totalprice_name);// 预计总成本
		edit[11] = (EditText) findViewById(R.id.resneed_name);// 资源需求
		edit[12] = (EditText) findViewById(R.id.dangeraly_name);// 风险分析
		edit[13] = (EditText) findViewById(R.id.suggestmanager_name);// 项目经理
		edit[14] = (EditText) findViewById(R.id.demo_name);// 备注
		edit[15] = (EditText) findViewById(R.id.extra_name);// 附件
		edit[16] = (EditText) findViewById(R.id.input_name);// 审批意见
		edit[17] = (EditText) findViewById(R.id.historyinput_name);// 历史驳回
		edit[18] = (EditText) findViewById(R.id.owninput_name);// 填写意见
		radioyes = (RadioButton) findViewById(R.id.radioyes);
		radiono = (RadioButton) findViewById(R.id.radiono);
		yes = (Button) findViewById(R.id.yes);
		no = (Button) findViewById(R.id.no);

		yes.setOnClickListener(this);
		no.setOnClickListener(this);
		RequestData();

		templateButtonLeft.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
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
				String sugguest = edit[18].getText().toString();
				String str = "";
				try {
					str = URLEncoder.encode(sugguest, "utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				String url = PcitcConstants.IP
						+ "_layouts/InterFace/ProjectStartAudit.ashx?LoginName="
						+ LoginActivity.uName + "&FormID=" + data.getId()
						+ "&TaskID=" + taskID + "&AuditOpinion=" + str
						+ "&AuditType="+auditType+"&WFType=" + wfType;
				Log.i("TAG", "Y to button url:" + url);
				String s = GetInputStream.getString(url);
				
				return s;
			}

			@Override
			public void after(Object result) {
				// TODO Auto-generated method stub
				if (result != null && !result.equals("")) {
					if (((String) result).contains("True") || ((String) result).contains("true")) {
						Toast.makeText(StartUpActivity.this, "数据提交成功！", Toast.LENGTH_SHORT).show();
						StartUpActivity.this.finish();
					} else if (((String) result).contains("False") || ((String) result).contains("false")) {
						Toast.makeText(StartUpActivity.this, "数据提交失败！", Toast.LENGTH_SHORT).show();
						StartUpActivity.this.finish();
					} else {
						Toast.makeText(StartUpActivity.this, "数据提交失败！", Toast.LENGTH_SHORT).show();
					}
				}
			}};
			async.execute();
	}

	private void RequestData() {
		// TODO Auto-generated method stub
		PcitcAsyncTask asyncTask = new PcitcAsyncTask(this) {

			@Override
			public Object before(Object... params) throws Exception {
				// TODO Auto-generated method stub
				// 解析表单数据
				StartUpSaxParse parse = new StartUpSaxParse();

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

				if (result != null) {
					data = (StartUpData) result;
					initdata(data);
				}
			}
		};
		asyncTask.execute();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		ActivityStackControlUtil.remove(this);
		super.onDestroy();
	}
}
