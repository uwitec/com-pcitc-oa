package com.pcitc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import android.text.format.DateFormat;

/**
 * time工具
 * 
 * @author rushun.zhang
 * @createdate 2013-7-03 下午13:04:06
 * @Description
 */
public class TimeUtil {
	public static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
	public static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年MM月dd日 E"); // E表示星期几
	public static SimpleDateFormat sdf4 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss"); // 精确到小时

	public static String parseDate(SimpleDateFormat sdf, String date) {

		try {
			return sdf.format(sdf.parse(date)).toString();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 获取日期字符串的方法
	 * 
	 * @param dateTaken
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String getDateString(long dateTaken) {
		// return DateFormat.format("yyyy-MM-dd kk.mm.ss",
		// dateTaken).toString();
		String dateString = DateFormat.format("yyyy-MM-dd", dateTaken)
				.toString();

		return dateString;
	}

}
