package com.pcitc.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MeetingRoomBookSelectTimeRangeActivity extends AbstractActivity {

	private String textValue;
	private Button bt1;
	private Button bt3;
	private Button bt7;

	@Override
	public void overrideParent() {

		title_bar.setVisibility(View.VISIBLE);
		Intent intent = getIntent();
		textValue = intent.getStringExtra("textValue");
		titleView.setText(textValue);

		templateButtonLeft.setVisibility(View.VISIBLE);
		templateButtonRight.setVisibility(View.GONE);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.meeting_room_book_select_time_range);

		overrideParent();
		initUI();

	}

	@Override
	public void initUI() {
		bt1 = (Button) findViewById(R.id.bt1);
		bt1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(
						MeetingRoomBookSelectTimeRangeActivity.this)
						.setTitle("预定人详细信息：")
						.setItems(new String[] { "姓名：", "部门：", "邮箱：", "手机号：" },
								null).setNegativeButton("确定", null).show();

			}
		});
		bt3 = (Button) findViewById(R.id.bt3);
		bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(
						MeetingRoomBookSelectTimeRangeActivity.this)
				.setTitle("预定人详细信息：")
				.setItems(new String[] { "姓名：", "部门：", "邮箱：", "手机号：" },
						null).setNegativeButton("确定", null).show();
				
			}
		});
		bt7 = (Button) findViewById(R.id.bt7);
		bt7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(
						MeetingRoomBookSelectTimeRangeActivity.this)
				.setTitle("预定人详细信息：")
				.setItems(new String[] { "姓名：", "部门：", "邮箱：", "手机号：" },
						null).setNegativeButton("确定", null).show();
				
			}
		});

		templateButtonLeft.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}

}
