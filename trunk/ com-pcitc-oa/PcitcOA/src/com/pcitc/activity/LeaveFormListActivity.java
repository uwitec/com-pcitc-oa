package com.pcitc.activity;

import com.pcitc.utils.ActivityStackControlUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
/**
 * 请假详情表
 * @author rushun.zhang
 *
 */
public class LeaveFormListActivity extends AbstractActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.applyforleave);
		overrideParent();
		initUI();
	}
	@Override
	public void overrideParent() {
		// TODO Auto-generated method stub
		ActivityStackControlUtil.add(this);

		titleView.setText("请假申请详情");
		templateButtonLeft.setVisibility(View.VISIBLE);
		templateButtonRight.setVisibility(View.GONE);
	}

	@Override
	public void initUI() {
		// TODO Auto-generated method stub
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
