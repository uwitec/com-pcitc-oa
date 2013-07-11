package com.pcitc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装从服务器获取的会议预定的数据
 * @author wuyuantao
 *
 */
public class MeetingBookData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String A1;
	private String A2;
	private String A3;
	private String A4;
	private String A5;
	private String C;
	private String D1;
	private String D2;
	private String Conference;
	private String B1;
	private String B2;
	private String B3;
	private String TelePresence;
	private String Training;

	private List<String> groups = null;
	private List<MeetingChildData> childs = null;

	public MeetingBookData() {
		groups = new ArrayList<String>();
		childs = new ArrayList<MeetingChildData>();
	}

	public String getA1() {
		return A1;
	}

	public void setA1(String a1) {
		A1 = a1;
	}

	public String getA2() {
		return A2;
	}

	public void setA2(String a2) {
		A2 = a2;
	}

	public String getA3() {
		return A3;
	}

	public void setA3(String a3) {
		A3 = a3;
	}

	public String getA4() {
		return A4;
	}

	public void setA4(String a4) {
		A4 = a4;
	}

	public String getA5() {
		return A5;
	}

	public void setA5(String a5) {
		A5 = a5;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getD1() {
		return D1;
	}

	public void setD1(String d1) {
		D1 = d1;
	}

	public String getD2() {
		return D2;
	}

	public void setD2(String d2) {
		D2 = d2;
	}

	public String getConference() {
		return Conference;
	}

	public void setConference(String conference) {
		Conference = conference;
	}

	public String getB1() {
		return B1;
	}

	public void setB1(String b1) {
		B1 = b1;
	}

	public String getB2() {
		return B2;
	}

	public void setB2(String b2) {
		B2 = b2;
	}

	public String getB3() {
		return B3;
	}

	public void setB3(String b3) {
		B3 = b3;
	}

	public String getTelePresence() {
		return TelePresence;
	}

	public void setTelePresence(String telePresence) {
		TelePresence = telePresence;
	}

	public String getTraining() {
		return Training;
	}

	public void setTraining(String training) {
		Training = training;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public void setChilds(List<MeetingChildData> childs) {
		this.childs = childs;
	}

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(String groupname) {
		groups.add(groupname);

	}

	public List<MeetingChildData> getChilds() {
		return childs;
	}

	public void setChilds(MeetingChildData childlist) {
		childs.add(childlist);
	}

	static public class MeetingChildData {
		String date;

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

	}
}
