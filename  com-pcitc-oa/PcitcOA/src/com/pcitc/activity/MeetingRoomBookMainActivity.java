package com.pcitc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class MeetingRoomBookMainActivity extends AbstractActivity {

	private Spinner sp;
	private Button bt_A1;
	private Button bt_A2;
	private Button bt_A3;
	private Button bt_A4;
	private Button bt_A5;
	private Button bt_C;
	private Button bt_B1;
	private Button bt_B2;
	private Button bt_B3;
	// 所有日期字符串资源的ID数组
	private int[] msgIds = { R.string.choose_date_item0,
			R.string.choose_date_item1, R.string.choose_date_item2,
			R.string.choose_date_item3, R.string.choose_date_item4,
			R.string.choose_date_item5, R.string.choose_date_item6,
			R.string.choose_date_item7, R.string.choose_date_item8,
			R.string.choose_date_item9 };

	@Override
	public void overrideParent() {
		title_bar.setVisibility(View.VISIBLE);
		titleView.setText("会议预定");
		templateButtonLeft.setVisibility(View.VISIBLE);
		templateButtonRight.setVisibility(View.GONE);

	}

	@Override
	public void initUI() {

		bt_A1 = (Button) findViewById(R.id.bt_A1);

		bt_A1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("textViewValue", 11);
				intent.putExtra("textValue", "A1");
				// intent.setClass(MeetingRoomBookActivity.this,
				// ChooseTimeActivity.class);
				intent.setClass(MeetingRoomBookMainActivity.this,
						MeetingRoomBookSelectTimeRangeActivity.class);
				MeetingRoomBookMainActivity.this.startActivity(intent);

			}
		});
		bt_A2 = (Button) findViewById(R.id.bt_A2);
		
		bt_A2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("textViewValue", 11);
				intent.putExtra("textValue", "A2");
				// intent.setClass(MeetingRoomBookActivity.this,
				// ChooseTimeActivity.class);
				intent.setClass(MeetingRoomBookMainActivity.this,
						MeetingRoomBookSelectTimeRangeActivity.class);
				MeetingRoomBookMainActivity.this.startActivity(intent);
				
			}
		});
		bt_A3 = (Button) findViewById(R.id.bt_A3);
		
		bt_A3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("textViewValue", 11);
				intent.putExtra("textValue", "A3");
				// intent.setClass(MeetingRoomBookActivity.this,
				// ChooseTimeActivity.class);
				intent.setClass(MeetingRoomBookMainActivity.this,
						MeetingRoomBookSelectTimeRangeActivity.class);
				MeetingRoomBookMainActivity.this.startActivity(intent);
				
			}
		});
		bt_A4 = (Button) findViewById(R.id.bt_A4);
		
		bt_A4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("textViewValue", 11);
				intent.putExtra("textValue", "A4");
				// intent.setClass(MeetingRoomBookActivity.this,
				// ChooseTimeActivity.class);
				intent.setClass(MeetingRoomBookMainActivity.this,
						MeetingRoomBookSelectTimeRangeActivity.class);
				MeetingRoomBookMainActivity.this.startActivity(intent);
				
			}
		});
		bt_A5 = (Button) findViewById(R.id.bt_A5);
		
		bt_A5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("textViewValue", 11);
				intent.putExtra("textValue", "A5");
				// intent.setClass(MeetingRoomBookActivity.this,
				// ChooseTimeActivity.class);
				intent.setClass(MeetingRoomBookMainActivity.this,
						MeetingRoomBookSelectTimeRangeActivity.class);
				MeetingRoomBookMainActivity.this.startActivity(intent);
				
			}
		});
		bt_C = (Button) findViewById(R.id.bt_C);
		
		bt_C.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("textViewValue", 11);
				intent.putExtra("textValue", "C");
				// intent.setClass(MeetingRoomBookActivity.this,
				// ChooseTimeActivity.class);
				intent.setClass(MeetingRoomBookMainActivity.this,
						MeetingRoomBookSelectTimeRangeActivity.class);
				MeetingRoomBookMainActivity.this.startActivity(intent);
				
			}
		});
		bt_B1 = (Button) findViewById(R.id.bt_B1);
		
		bt_B1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("textViewValue", 11);
				intent.putExtra("textValue", "B1");
				// intent.setClass(MeetingRoomBookActivity.this,
				// ChooseTimeActivity.class);
				intent.setClass(MeetingRoomBookMainActivity.this,
						MeetingRoomBookSelectTimeRangeActivity.class);
				MeetingRoomBookMainActivity.this.startActivity(intent);
				
			}
		});
		bt_B2 = (Button) findViewById(R.id.bt_B2);
		
		bt_B2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("textViewValue", 11);
				intent.putExtra("textValue", "B2");
				// intent.setClass(MeetingRoomBookActivity.this,
				// ChooseTimeActivity.class);
				intent.setClass(MeetingRoomBookMainActivity.this,
						MeetingRoomBookSelectTimeRangeActivity.class);
				MeetingRoomBookMainActivity.this.startActivity(intent);
				
			}
		});
		bt_B3 = (Button) findViewById(R.id.bt_B3);
		
		bt_B3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("textViewValue", 11);
				intent.putExtra("textValue", "B3");
				// intent.setClass(MeetingRoomBookActivity.this,
				// ChooseTimeActivity.class);
				intent.setClass(MeetingRoomBookMainActivity.this,
						MeetingRoomBookSelectTimeRangeActivity.class);
				MeetingRoomBookMainActivity.this.startActivity(intent);
				
			}
		});
		

		templateButtonLeft.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
//		findViewById(R.id.meeting_book_base)
		
		
		

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.meeting_book);
		overrideParent();
		initUI();
		sp = (Spinner) findViewById(R.id.choose_date_spinner);

		BaseAdapter ba = new BaseAdapter() {

			public int getCount() {
				return 10; // 直接返回，一共十四个选项。
			}

			public Object getItem(int position) {
				return null;
			}

			public long getItemId(int position) {
				return 0;
			}

			public View getView(int position, View convertView, ViewGroup parent) {
				// 动态生成每个下拉项对应的View，每个下拉项View由LinearLayout
				// 中包含一个ImageView及一个TextView构成
				// 初始化LinearLayout
				LinearLayout ll = new LinearLayout(
						MeetingRoomBookMainActivity.this);
				ll.setOrientation(LinearLayout.HORIZONTAL);
				// 初始化TextView
				TextView tv = new TextView(MeetingRoomBookMainActivity.this);
				tv.setText(getResources().getText(msgIds[position]).toString()
						.trim());
				tv.setTextColor(getResources().getColor(R.color.black));
				tv.setTextSize(24);
				ll.addView(tv);
				return ll;
			}

		};

		// 为Spinner设置内容适配器
		sp.setAdapter(ba);
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				Toast.makeText(MeetingRoomBookMainActivity.this,
						"您选中了第：" + position + "个条目", Toast.LENGTH_SHORT).show();
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

	}

}
