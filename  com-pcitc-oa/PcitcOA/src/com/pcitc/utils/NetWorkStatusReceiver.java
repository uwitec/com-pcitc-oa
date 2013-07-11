package com.pcitc.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
/**
 * 监听网络连接
 * @author rushun.zhang
 *
 */
public class NetWorkStatusReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("Pcitc", "网络状态监听");
		// 监听网络类型变化，并随时修改网络连接类型
		NetWorkUtil.getNetWorkInfoType(context);
	}

	
}