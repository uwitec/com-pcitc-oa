package com.pcitc.activity;

import com.pcitc.utils.ActivityStackControlUtil;
import com.pcitc.utils.NetWorkStatusReceiver;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 抽象activity
 * 
 * @author rushun.zhang
 * @createdate 2013-6-9 上午11:23:00
 * @Description
 */

@SuppressLint({ "ParserError", "ParserError" })
public abstract class AbstractActivity extends Activity implements
		OnClickListener {

	public TextView titleView; // 标题
	public LinearLayout mainBody; // 主体显示
	public RelativeLayout title_bar, title_bar_center;// 标题�?

	public Button templateButtonLeft; // 模板中左则图�?不使用模板时，此值为null;
	public Button templateButtonRight; // 模板中右则Button,不使用模板时，此值为null;
	private NetWorkStatusReceiver networkStatusBroadcast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.template);
		ActivityStackControlUtil.add(this);
		templateButtonLeft = (Button) findViewById(R.id.templateButtonLeft);
		templateButtonRight = (Button) findViewById(R.id.templateButtonRight);
		titleView = (TextView) findViewById(R.id.title_text);
		titleView.setText(R.string.softname);

		mainBody = (LinearLayout) findViewById(R.id.view_mainBody);
		title_bar = (RelativeLayout) findViewById(R.id.title_bar_gone);
		title_bar_center = (RelativeLayout) findViewById(R.id.title_bar_center);
		registerNetworkReceiver();
	}

	@Override
	public void setContentView(int layoutResID) {
		if (layoutResID == R.layout.template) {
			super.setContentView(layoutResID);
		} else {
			mainBody.removeAllViews();
			mainBody.addView(this.getLayoutInflater()
					.inflate(layoutResID, null),
					LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.FILL_PARENT);

		}
	}

	@Override
	public void setContentView(View view) {
		mainBody.removeAllViews();
		mainBody.addView(view);
	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		mainBody.removeAllViews();
		mainBody.addView(view, params);
	}
	/**
	 * 两个需要实现的抽象方法
	 */
	public abstract void overrideParent();

	public abstract void initUI();

	@Override
	protected void onDestroy() {
		mainBody = null;
		unRegisterNetworkReceiver();
		ActivityStackControlUtil.remove(this);
		super.onDestroy();
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

	private void registerNetworkReceiver() {

		networkStatusBroadcast = new NetWorkStatusReceiver();
		IntentFilter filter = new IntentFilter(
				ConnectivityManager.CONNECTIVITY_ACTION);
		this.registerReceiver(networkStatusBroadcast, filter);
	}

	private void unRegisterNetworkReceiver() {
		this.unregisterReceiver(networkStatusBroadcast);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub

		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub

		super.onResume();
	}

	private DisplayMetrics metric = new DisplayMetrics();

	public int getScreenWidth() {
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		return metric.widthPixels;
	}

	public int getScreenHeight() {
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		return metric.heightPixels;

	}

}
