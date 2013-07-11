package com.pcitc.xmlparse;

import java.io.IOException;
import java.io.InputStream;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.pcitc.entity.StartUpData;

import android.util.Log;

public class StartUpSaxParse {
	public StartUpData parse(InputStream is) throws ParserConfigurationException,
			SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance(); // 取得SAXParserFactory实例
		SAXParser parser = factory.newSAXParser(); // 从factory获取SAXParser实例
		MyHandler handler = new MyHandler(); // 实例化自定义Handler
		parser.parse(is, handler); // 根据自定义Handler规则解析输入流

		return handler.getDatas();

	}

	// 需要重写DefaultHandler的方法
	private class MyHandler extends DefaultHandler {

		private StartUpData data;
		private StringBuilder builder;

		// 返回解析后得到的Book对象集合
		public StartUpData getDatas() {
			return data;
		}

		@Override
		public void startDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.startDocument();
			// data = new FormData();
			builder = new StringBuilder();
		}

		@Override
		public void endDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.endDocument();

		}

		
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			// TODO Auto-generated method stub
			super.startElement(uri, localName, qName, attributes);
			if (localName.equals("PCITC_PS_CFormInfo")) {
				data = new StartUpData();
			}
			builder.setLength(0); // 将字符长度设置为0 以便重新开始读取元素内的字符节点
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			// TODO Auto-generated method stub
			super.endElement(uri, localName, qName);
			Log.i("TAG", "LocalName:" + localName);
			if (localName.equals("Title")) {
				data.setTitle(builder.toString());
			} else if (localName.equals("ApplicantName")) {
				data.setApplicantName(builder.toString());
			} else if (localName.equals("ApplicantDept")) {
				data.setApplicantDept(builder.toString());
			} else if (localName.equals("ProjectSource")) {
				data.setProjectSource(builder.toString());
			} else if (localName.equals("BusinessType")) {
				data.setBusinessType(builder.toString());
			}else if (localName.equals("TreatyGrounds")) {
				data.setTreatyGrounds(builder.toString());
			} else if (localName.equals("CustomerName")) {
				data.setCustomerName(builder.toString());
			} else if (localName.equals("ProjectName")) {
				data.setProjectName(builder.toString());
			} else if (localName.equals("ProjContent")) {
				data.setProjContent(builder.toString());
			} else if (localName.equals("ProjContent")) {
				data.setProjContent(builder.toString());
			} else if (localName.equals("StartTime")) {
				data.setStartTime(builder.toString().substring(0, 10));
			} else if (localName.equals("EndTime")) {
				data.setEndTime(builder.toString().substring(0, 10));
			} else if (localName.equals("ConAmount")) {
				data.setConAmount(builder.toString());
			} else if (localName.equals("ConCost")) {
				data.setConCost(builder.toString());
			} else if (localName.equals("Resource")) {
				data.setResource(builder.toString());
			} else if (localName.equals("Remarks")) {
				data.setRemarks(builder.toString());
			} else if (localName.equals("RiskAnalysis")) {
				data.setRiskAnalysis(builder.toString());
			} else if (localName.equals("WfInstanceID")) {
				data.setWfInstanceID(builder.toString());
			} else if (localName.equals("WfStatus")) {
				data.setWfStatus(builder.toString());
			} else if (localName.equals("Participants")) {
				data.setParticipants(builder.toString());
			} else if (localName.equals("UserPost")) {
				data.setUserPost(builder.toString());
			} else if (localName.equals("ApplyTime")) {
				data.setApplyTime(builder.toString());
			} else if (localName.equals("WfFlag")) {
				data.setWfFlag(builder.toString());
			} else if (localName.equals("SpeProjectManager")) {
				data.setSpeProjectManager(builder.toString());
			} else if (localName.equals("Sign")) {
				data.setSign(builder.toString());
			} else if (localName.equals("Education")) {
				data.setEducation(builder.toString());
			} else if (localName.equals("PMQualification")) {
				data.setpMQualification(builder.toString());
			} else if (localName.equals("HSE")) {
				data.setHse(builder.toString());
			} else if (localName.equals("ProjInvolved")) {
				data.setProjInvolved(builder.toString());
			} else if (localName.equals("ProjectNum")) {
				data.setProjectNum(builder.toString());
			} else if (localName.equals("ProjClassify")) {
				data.setProjClassify(builder.toString());
			} else if (localName.equals("MountForm")) {
				data.setMountForm(builder.toString());
			} else if (localName.equals("Major")) {
				data.setMajor(builder.toString());
			} else if (localName.equals("SignDate")) {
				data.setSignDate(builder.toString());
			} else if (localName.equals("AppointmentDate")) {
				data.setAppointmentDate(builder.toString());
			} else if (localName.equals("ProjectSort")) {
				data.setProjectSort(builder.toString());
			} else if (localName.equals("HasPreSaleProj")) {
				data.setHasPreSaleProj(builder.toString());
			}else if (localName.equals("RecommendPM")) {
				data.setRecommendPM(builder.toString());
			} else if (localName.equals("IsClosed")) {
				data.setIsClosed(builder.toString());
			} else if (localName.equals("ID")) {
				data.setId(builder.toString());
			} else if (localName.equals("ContentType")) {
				data.setContentType(builder.toString());
			} else if (localName.equals("Modified")) {
				data.setModified(builder.toString());
			} else if (localName.equals("Created")) {
				data.setCreated(builder.toString());
			} else if (localName.equals("Author")) {
				data.setAuthor(builder.toString());
			} else if (localName.equals("Editor")) {
				data.setEditor(builder.toString());
			} else if (localName.equals("_UIVersionString")) {
				data.setuIVersionString(builder.toString());
			} else if (localName.equals("Attachments")) {
				data.setAttachments(builder.toString());
			} else if (localName.equals("LinkTitleNoMenu")) {
				data.setLinkTitleNoMenu(builder.toString());
			} else if (localName.equals("LinkTitle")) {
				data.setLinkTitle(builder.toString());
			} else if (localName.equals("TaskID")) {
				data.setTaskID(builder.toString());
			} else if (localName.equals("UserID")) {
				data.setUserID(builder.toString());
			} else if (localName.equals("WFType")) {
				data.setWfType(builder.toString());
			} else if (localName.equals("AttachName")) {
				data.setAttachName(builder.toString());
			} else if (localName.equals("PCITC_PS_CFormInfo")) {
				// datas.add(data);
				// 解析数据结束
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
