package com.pcitc.xmlparse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

import com.pcitc.entity.MeetingData;
import com.pcitc.entity.MeetingData.MeetingChildData;

/**
 * 待处理列表数据的解析
 * 
 * @author
 * 
 */
public class MeetingSaxParse {
	public List<MeetingChildData> parse(InputStream is)
			throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance(); // 取得SAXParserFactory实例
		SAXParser parser = factory.newSAXParser(); // 从factory获取SAXParser实例
		MyHandler handler = new MyHandler(); // 实例化自定义Handler
		parser.parse(is, handler); // 根据自定义Handler规则解析输入流

		return handler.getDatas();

	}

	// 需要重写DefaultHandler的方法
	private class MyHandler extends DefaultHandler {

		
		private MeetingData data2 ;
		
		private MeetingData.MeetingChildData data;
		private StringBuilder builder;
		private String[] dates;

		// 返回解析后得到的Book对象集合
		public List<MeetingChildData>  getDatas() {
			return data2.getChilds();
		}

		@Override
		public void startDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.startDocument();
			
			dates = new String[] { "Monday", "Tuesday", "Wednesday",
					"Thursday", "Friday", "Saturday", "Sunday", "NextMonday",
					"NextTuesday", "NextWednesday", "NextThursday",
					"NextFriday", "NextSaturday", "NextSunday" };
			builder = new StringBuilder();
		}

		@Override
		public void endDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.endDocument();

		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			// TODO Auto-generated method stub
			super.startElement(uri, localName, qName, attributes);
			if (localName.equals("Result")) {
				data = new MeetingData.MeetingChildData();
				data2 = new MeetingData();
				
			}
			builder.setLength(0); // 将字符长度设置为0 以便重新开始读取元素内的字符节点
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			// TODO Auto-generated method stub
			super.endElement(uri, localName, qName);
			Log.i("TAG", "LocalName:" + localName);
			for (int i = 0; i < dates.length; i++) {
				if (localName.equals(dates[i])) {
						data2.setGroups(builder.toString());
					} else if (localName.equals("A1")) {
						data.setA1(builder.toString());
					} else if (localName.equals("A2")) {
						data.setA2(builder.toString());
					} else if (localName.equals("A3")) {
						data.setA3(builder.toString());
					} else if (localName.equals("A4")) {
						data.setA4(builder.toString());
					} else if (localName.equals("A5")) {
						data.setA5(builder.toString());
					} else if (localName.equals("C")) {
						data.setC(builder.toString());
					} else if (localName.equals("D1")) {
						data.setD1(builder.toString());
					} else if (localName.equals("D2")) {
						data.setD2(builder.toString());
					} else if (localName.equals("CONFERENCE")) {
						data.setConference(builder.toString());
					} else if (localName.equals("B1")) {
						data.setB1(builder.toString());
					} else if (localName.equals("TELEPRESENCE")) {
						data.setTelePresence(builder.toString());
					} else if (localName.equals("B2")) {
						data.setB2(builder.toString());
					} else if (localName.equals("TRAINING")) {
						data.setTraining(builder.toString());
					} else if (localName.equals("B3")) {
						data.setB3(builder.toString());
					} else if (localName.equals(dates[i])) {
						data2.setChilds(data);
						
					}
			}
			
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			// TODO Auto-generated method stub
			super.characters(ch, start, length);
			builder.append(ch, start, length); // 将读取的字符数组追加到builder中
		}

	}
}
