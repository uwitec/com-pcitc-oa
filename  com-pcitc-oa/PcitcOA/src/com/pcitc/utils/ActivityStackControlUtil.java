package com.pcitc.utils;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

/**
 * activity栈堆控制
 * 
 * @author rushun.zhang
 * @createdate 2013-6-20 
 * @Description
 */
public class ActivityStackControlUtil {
	private static List<Activity> activityList = new ArrayList<Activity>();

	public static void remove(Activity activity) {

		activityList.remove(activity);

	}

	public static void add(Activity activity) {

		activityList.add(activity);

	}

	public static void exitApp() {

		for (Activity activity : activityList) {
			System.out.println("======================");
			System.out.println(activity.getLocalClassName());
			activity.finish();

		}
		activityList.clear();
		android.os.Process.killProcess(android.os.Process.myPid());
		
	}
}
