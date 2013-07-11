package com.pcitc.activity;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


import com.pcitc.adapter.LeavePendingListAdapter;
import com.pcitc.adapter.PendingListAdapter;
import com.pcitc.utils.ActivityStackControlUtil;
/**
 * 请假列表
 * @author rushun.zhang
 *
 */
public class LeavePendingListActivity extends AbstractActivity {
	
	private ListView pendingList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leavelist);
		overrideParent();
		initUI();
	}

	@Override
	public void overrideParent() {
		// TODO Auto-generated method stub
		ActivityStackControlUtil.add(this);
		
		titleView.setText("请假审批表");
		templateButtonLeft.setVisibility(View.VISIBLE);
		templateButtonRight.setVisibility(View.GONE);
	}

	@Override
	public void initUI() {
		// TODO Auto-generated method stub
		
		pendingList = (ListView) findViewById(R.id.listview);
		ArrayList<String[]> lists = new ArrayList<String[]>();
		String[] s = { "序号", "申请人", "请假事由", "部门经理","申请日期" };
		String[] s1 = { "101", "赵鑫鑫", "ERP事业部",  "赵雯", "2013年1月7日"};
		String[] s2 = { "102", "赵鑫", "ERP事业部",  "赵雯","2013年2月11日" };
		String[] s3 = { "103", "赵鑫", "ERP事业部",  "赵雯","2011年7月7日" };
		String[] s4 = { "104", "赵鑫", "ERP事业部", "赵雯",  "2012年9月6日"};
		lists.add(s);
		lists.add(s1);
		lists.add(s2);
		lists.add(s3);
		lists.add(s4);

		PendingListAdapter adapter = new PendingListAdapter(this, lists);
		pendingList.setAdapter(adapter);
		pendingList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if(0!=arg2){
				Intent intent = new Intent(LeavePendingListActivity.this,
						LeaveFormListActivity.class);
				startActivity(intent);
				}
			}
		});
		templateButtonLeft.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		ActivityStackControlUtil.remove(this);
		super.onDestroy();
	}
}
