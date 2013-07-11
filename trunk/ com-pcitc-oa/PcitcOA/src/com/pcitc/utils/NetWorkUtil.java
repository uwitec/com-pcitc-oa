package com.pcitc.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
/**
 * 网络工具类
 * @author rushun.zhang
 *
 */
public class NetWorkUtil {
	// true 得采用代理上网，false不需要
	public static boolean ONLYWAP;
	// true 没有网络，false有网络
	public static boolean NO_NETWORK;

	/**
	 * 获取网络连接NetworkInfo对象
	 * 
	 * @param context
	 * @return
	 */
	public static NetworkInfo getNetworkInfo(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netinfo = cm.getActiveNetworkInfo();
		return netinfo;
	}

	
	

	/**  
	 * 网络类型  
	 * 
	 * @param context
	 */
	public static void getNetWorkInfoType(Context context) {
		NetworkInfo networkinfo = getNetworkInfo(context);
		if (networkinfo != null) {
			Log.i("Pcitc", "有网络");
			NO_NETWORK = false;
			if (networkinfo.getTypeName() == "WIFI") {
				ONLYWAP = false;
			} 
			if (networkinfo.getTypeName().equalsIgnoreCase("MOBILE")) {
				if ("cmwap".equalsIgnoreCase(networkinfo.getExtraInfo())
						|| "3gwap".equalsIgnoreCase(networkinfo.getExtraInfo())
						|| "ctwap".equalsIgnoreCase(networkinfo.getExtraInfo())) {
					ONLYWAP = true;
				} else {
					ONLYWAP = false;
				}
			}  
		} else {
			Log.i("Pcitc", "无网络");
			NO_NETWORK = true;
		}
	}

	
}
