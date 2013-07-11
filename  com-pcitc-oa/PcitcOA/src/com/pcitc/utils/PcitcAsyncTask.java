package com.pcitc.utils;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import com.pcitc.activity.LoginActivity;
import com.pcitc.activity.R;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
/**
 * 异步加载
 * @author rushun.zhang
 *
 * @param <Params>
 * @param <Progress>
 * @param <Result>
 */
public abstract class PcitcAsyncTask<Params, Progress, Result> extends
		AsyncTask<Params, Progress, Result> implements
		PcitcTask<Params, Progress, Result> {
	public final static int ERROR = 4;
	public final static int TIME_OUT = 6; // 超时
	private Context mContext = null;
	private ProgressDialog progress;
	private final PcitcHandler sHandler = new PcitcHandler();

	public PcitcAsyncTask(Context context) {
		mContext = context;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		// 没有网络
		if (NetWorkUtil.NO_NETWORK) {
			Toast.makeText(mContext,
					mContext.getString(R.string.not_network),500).show();
			cancel(false);
			return;
		}
		if (null == progress) {
			progress = new ProgressDialog(mContext);
			progress.setIndeterminate(true);
		}
		progress.setMessage(mContext.getString(R.string.please_wait));
		progress.show();
		

	}

	@Override
	protected Result doInBackground(Params... params) {
		try {
			return before(params);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.what = TIME_OUT;
			sHandler.handleMessage(msg);
			cancel(false);
		} catch (SocketException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.what = TIME_OUT;
			sHandler.handleMessage(msg);
			cancel(false);
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.what = TIME_OUT;
			sHandler.handleMessage(msg);
			cancel(false);
		} catch (Exception e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.what = ERROR;
			sHandler.handleMessage(msg);
			cancel(false);
		}
		return null;
	}

	@Override
	protected void onPostExecute(Result result) {
		super.onPostExecute(result);
		after(result);
		progress.dismiss();
		mContext = null;
	}

	@Override
	protected void onCancelled() {
		super.onCancelled();

	}

	private class PcitcHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case ERROR:

				Toast.makeText(mContext, R.string.error, 1).show();
				break;
			case TIME_OUT:
				Toast.makeText(mContext, R.string.time_out, 1).show();
				break;

			}
		}
	}
}