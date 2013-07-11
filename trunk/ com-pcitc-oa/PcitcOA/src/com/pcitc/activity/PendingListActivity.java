package com.pcitc.activity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.pcitc.entity.PcitcConstants;
import com.pcitc.entity.PendingListData;
import com.pcitc.utils.ActivityStackControlUtil;
import com.pcitc.utils.PcitcAsyncTask;
import com.pcitc.xmlparse.GetInputStream;
import com.pcitc.xmlparse.PendingListSaxParse;

/**
 * 项目审批列表
 * 
 * @author rushun.zhang
 * 
 */
public class PendingListActivity extends AbstractActivity {

	private ListView pendingList;
	private MyListAdapter mAdapter = null;
	private int mStartPage = 0;
	private int mPagesize = PcitcConstants.PAGESIZE;
	private List<PendingListData> datas = null;
	private boolean IsLoad = false;
	private boolean IsFooter = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pendinglist);
		overrideParent();
		initUI();

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		getListData();
		super.onResume();
	}

	private void getListData() {
		// TODO Auto-generated method stub
		PcitcAsyncTask pcitcTask = new PcitcAsyncTask(PendingListActivity.this) {

			@Override
			public Object before(Object... params) throws Exception {
				// TODO Auto-generated method stub
				PendingListSaxParse parse = new PendingListSaxParse();

				// 获取待处理列表的URL
				String u = PcitcConstants.IP
						+ "_layouts/InterFace/NoDealTaskList.ashx?LoginName="
						+ LoginActivity.uName;
				Log.i("TAG", "PendList url------->" + u);
				InputStream is = GetInputStream.getInputStream(u);

				Object data = parse.parse(is);

				return data;
			}

			@Override
			public void after(Object result) {
				// TODO Auto-generated method stub

				if (null != result) {
					datas = (ArrayList<PendingListData>) result;

					initData(datas);
				}
			}
		};
		pcitcTask.execute();
	}

	protected void initData(List<PendingListData> datas) {
		// TODO Auto-generated method stub

		if (IsLoad) {
			if (mAdapter == null) {
				mAdapter = new MyListAdapter();
				pendingList.setAdapter(mAdapter);
			}
			IsLoad = false;
		} else {
			mAdapter = new MyListAdapter();
			pendingList.setAdapter(mAdapter);
		}

		int sum = datas.size();
		for (int i = 0; i < sum; i++) {
			// if(datas.get(i).getProcessName().equals("项目启动"))
			mAdapter.SetListData(datas.get(i));
		}

		mStartPage = mAdapter.getCount();

		mAdapter.notifyDataSetChanged();
	}

	@Override
	public void overrideParent() {
		// TODO Auto-generated method stub
		ActivityStackControlUtil.add(this);

		titleView.setText("项目审批表");
		templateButtonLeft.setVisibility(View.VISIBLE);
		templateButtonRight.setVisibility(View.GONE);
	}

	@Override
	public void initUI() {
		// TODO Auto-generated method stub
		pendingList = (ListView) findViewById(R.id.listview);
		pendingList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				final PendingListData data = datas.get(arg2);
				// 审核单签表单状况，是否过期
				PcitcAsyncTask pcitc = new PcitcAsyncTask(
						PendingListActivity.this) {

					@Override
					public Object before(Object... params) throws Exception {
						// TODO Auto-generated method stub
						String checkListUrl = PcitcConstants.IP
								+ "_layouts/InterFace/FormCheckStatus.ashx?TaskID="
								+ data.getProId();
						String s = GetInputStream.getString(checkListUrl);

						System.out.println("=========表单是否过期===========");
						System.out.println(s);
						return s;
					}

					@Override
					public void after(Object result) {
						// TODO Auto-generated method stub
						if (result == null || result.equals("")) {
							Toast.makeText(PendingListActivity.this, "网络访问出错！",
									Toast.LENGTH_SHORT).show();
							return;
						} else if (((String) result).contains("True")
								|| ((String) result).contains("true")) {
							Toast.makeText(PendingListActivity.this,
									"该待办已过期，无法再进行审批！", Toast.LENGTH_SHORT)
									.show();
							return;
						} else if (((String) result).contains("False")
								|| ((String) result).contains("false")) {
							if (data.getProcessName()
									.equals(PendingListActivity.this
											.getString(R.string.project_startup_im))) {

								Intent it = new Intent();
								it.setClass(PendingListActivity.this,
										StartUpActivity.class);
								Bundle bundle = new Bundle();
								bundle.putString("WFID", data.getWfID());
								bundle.putString("UserID", data.getUserID());
								bundle.putString("WFType", data.getWFType());
								bundle.putString("TaskID", data.getProId());

								it.putExtra("bundle", bundle);
								startActivity(it);
							} else if (data
									.getProcessName()
									.equals(PendingListActivity.this
											.getString(R.string.project_num_type_im))
									|| data.getProcessName()
											.equals(PendingListActivity.this
													.getString(R.string.project_num_type_re))
									|| data.getProcessName()
											.equals(PendingListActivity.this
													.getString(R.string.project_num_type_in))) {

								Intent it = new Intent();
								it.setClass(PendingListActivity.this,
										IdentifierActivity.class);
								Bundle bundle = new Bundle();
								bundle.putString("WFID", data.getWfID());
								bundle.putString("UserID", data.getUserID());
								bundle.putString("WFType", data.getWFType());
								bundle.putString("TaskID", data.getProId());
								bundle.putString("ProcessType",
										data.getProcessName());
								it.putExtra("bundle", bundle);
								startActivity(it);
							}

						}
					}
				};
				pcitc.execute();
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

	class MyListAdapter extends BaseAdapter {
		private List<PendingListData> mData = null;
		private LayoutInflater mInflater;

		public MyListAdapter() {
			mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			mData = new ArrayList<PendingListData>();
		}

		public void DelCurrItem(int pos) {
			mData.remove(pos);
		}

		public void SetListData(PendingListData data) {
			mData.add(data);
			mAdapter.notifyDataSetChanged();
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mData.size();
		}

		@Override
		public PendingListData getItem(int position) {
			// TODO Auto-generated method stub
			return mData.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			final int pos = position;
			SearchViewHolder holder = null;
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.list_item, null);
				convertView.setBackgroundColor(Color.WHITE);
				holder = new SearchViewHolder();
				holder.textView1 = (TextView) convertView
						.findViewById(R.id.text1);
				holder.textView2 = (TextView) convertView
						.findViewById(R.id.text2);
				holder.textView3 = (TextView) convertView
						.findViewById(R.id.text3);
				holder.textView4 = (TextView) convertView
						.findViewById(R.id.text4);
				holder.textView5 = (TextView) convertView
						.findViewById(R.id.text5);
				holder.textView1.setTextColor(Color.BLACK);
				holder.textView2.setTextColor(Color.BLACK);
				holder.textView3.setTextColor(Color.BLACK);
				holder.textView4.setTextColor(Color.BLACK);
				holder.textView5.setTextColor(Color.BLACK);
				holder.textView1.setText(mData.get(pos).getProId());
				holder.textView2.setText(mData.get(pos).getApplyName());
				holder.textView3.setText(mData.get(pos).getProcessName());
				holder.textView4.setText(mData.get(pos).getApplyDepartment());
				holder.textView5.setText(mData.get(pos).getApplyDate());

				if (position % 2 != 0) {
					convertView.setBackgroundColor(Color.argb(250, 224, 243,
							250));
				} else {

					convertView.setBackgroundColor(Color.argb(250, 255, 255,
							255));

				}
				convertView.setTag(holder);

			} else {
				holder = (SearchViewHolder) convertView.getTag();
			}

			return convertView;
		}

	}

	static class SearchViewHolder {
		private TextView textView1 = null;
		private TextView textView2 = null;
		private TextView textView3 = null;
		private TextView textView4 = null;
		private TextView textView5 = null;

	}
}
