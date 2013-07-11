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

import com.pcitc.entity.PendingListData;

import android.util.Log;



/**
 * 待处理列表数据的解析
 * 
 * @author
 * 
 */
public class PendingListSaxParse {
	public List<PendingListData> parse(InputStream is)
			throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance(); // 取得SAXParserFactory实例
		SAXParser parser = factory.newSAXParser(); // 从factory获取SAXParser实例
		MyHandler handler = new MyHandler(); // 实例化自定义Handler
		parser.parse(is, handler); // 根据自定义Handler规则解析输入流
		
		return handler.getDatas();

	}

	// 需要重写DefaultHandler的方法
	private class MyHandler extends DefaultHandler {

		private List<PendingListData> datas;
		private PendingListData data;
		private StringBuilder builder;

		// 返回解析后得到的Book对象集合
		public List<PendingListData> getDatas() {
			return datas;
		}

		@Override
		public void startDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.startDocument();
			datas = new ArrayList<PendingListData>();
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
			if (localName.equals("Data")) {
				data = new PendingListData();
			}
			builder.setLength(0); // 将字符长度设置为0 以便重新开始读取元素内的字符节点
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			// TODO Auto-generated method stub
			super.endElement(uri, localName, qName);
			Log.i("TAG", "LocalName:"+localName);
			if (localName.equals("TaskID")) {
				data.setProId(builder.toString());
			} else if (localName.equals("Proposer")) {
				data.setApplyName(builder.toString());
			} else if (localName.equals("AppDept")) {
				data.setApplyDepartment(builder.toString());
			} else if (localName.equals("SumbitTime")) {
				data.setApplyDate(builder.toString());
			} else if (localName.equals("TemplateName")) {
				data.setProcessName(builder.toString());
			} else if(localName.equals("WfInstanceID")){
				data.setWfID(builder.toString());
			}else if(localName.equals("UserID")){
				data.setUserID(builder.toString());
			}else if(localName.equals("WFType")){
				data.setWFType(builder.toString());
			}else if (localName.equals("Data")) {
				datas.add(data);
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
