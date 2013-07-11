package com.pcitc.activity;

import com.pcitc.utils.ActivityStackControlUtil;
import com.pcitc.utils.Exit;
import com.pcitc.widget.BadgeView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 主界面
 * @author rushun.zhang
 *
 */
public class FeatureListActivity extends AbstractActivity {
	private String ItemText[] = { "请假审批", "项目审批", "其他审批", "会议预定", "资源申请", "个人设置" };
	private int ItemImage[] = { R.drawable.classfiedico1,
			R.drawable.classfiedico2, R.drawable.classfiedico3,
			R.drawable.six, R.drawable.classfiedico5, R.drawable.classfiedico4 };
	private BadgeView badge;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_featurelist);
		overrideParent();
		initUI();
	}

	
	@Override
	public void overrideParent() {
		// TODO Auto-generated method stub
		title_bar.setVisibility(View.GONE);
	}

	@Override
	public void initUI() {
		// TODO Auto-generated method stub
		ActivityStackControlUtil.add(this);
		GridView gridview = (GridView) findViewById(R.id.GridView);

		GridViewAdapter saItem = new GridViewAdapter();

		gridview.setAdapter(saItem);

		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				Intent it = new Intent();
				switch (arg2) {
				case 0:			//请假审批

					it.setClass(FeatureListActivity.this,
							LeavePendingListActivity.class);
					break;
				case 1:			//项目审批
					it.setClass(FeatureListActivity.this,
							PendingListActivity.class);
					break;
				case 2:			//其他审批
					it.setClass(FeatureListActivity.this,
							PendingListActivity.class);
					break;
				case 3:			//会议预定
					it.setClass(FeatureListActivity.this,
							MeetingRoomBookMainActivity.class);
					break;
				case 4:			//资源申请
					it.setClass(FeatureListActivity.this,
							PendingListActivity.class);
					break;
				case 5:			//个人设置
					it.setClass(FeatureListActivity.this,
							PendingListActivity.class);
					break;
				
				default:
					return;
				}
				startActivity(it);

			}
		});
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub

		super.onResume();

	}

	/*
	 * ============================================对话框提示退出========================
	 * ==
	 */

	/*@Override 
	public boolean onKeyDown(int keyCode, KeyEvent event) { // TODO
	  Auto-generated method stub return getCurrentActivity().onKeyDown(keyCode,
	  event); }

	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("提示")
					.setMessage("确定要退出吗?")
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface arg0,
										int arg1) {
									ActivityStackControlUtil.exitApp();
								}

							});
			builder.setNegativeButton("取消",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {

						}
					});
			builder.create().show();
			return false;

		} // else return super.dispatchKeyEvent(event);

	}*/

	/*
	 * =======================================再按一次退出==============================
	 */
	Exit exit = new Exit();

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {

			pressAgainExit();

			return true;

		}

		return super.onKeyDown(keyCode, event);

	}

	/**
	 * 
	 * 再按一次退出程序。
	 */

	private void pressAgainExit() {

		if (exit.isExit()) {
			ActivityStackControlUtil.exitApp();
			//finish();

		} else {

			Toast.makeText(getApplicationContext(), "再按一次退出程序",

			1000).show();

			exit.doExitInOneSecond();

		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		ActivityStackControlUtil.remove(this);
		super.onDestroy();
	}

	public class GridViewAdapter extends BaseAdapter {

		private LayoutInflater inflater;

		public GridViewAdapter() {
			// TODO Auto-generated constructor stub

			inflater = LayoutInflater.from(FeatureListActivity.this);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return ItemText.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return ItemText[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder;

			if (convertView == null) {
				convertView = inflater.inflate(R.layout.featurelsit_item, null);

				holder = new ViewHolder();
				holder.text = (TextView) convertView
						.findViewById(R.id.ItemText);
				holder.ItemImage = (ImageView) convertView
						.findViewById(R.id.ItemImage);
				badge = new BadgeView(FeatureListActivity.this,
						holder.ItemImage);
				badge.setBackgroundResource(R.drawable.mark_bg);
				badge.setTextColor(Color.BLACK);
				badge.setBadgePosition(BadgeView.POSITION_BOTTOM_RIGHT);

				holder.ItemImage.setImageResource(ItemImage[position]);
				holder.text.setText(ItemText[position]);

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			if (position == 0 || position == 1) {

				//badge.setTextSize(20);
				if (position == 0) {
					badge.setText(String.valueOf(position + 5));
				} else {
					badge.setText(String.valueOf(position + 3));
				}
				badge.show();
			} else {
				badge.hide();
			}
			return convertView;
		}

		class ViewHolder {
			TextView text;
			ImageView ItemImage;

		}
	}

	
}
