package com.pcitc.xmlparse;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.pcitc.entity.IdentifierData;



import android.util.Log;
/**
 * 项目编号的解析类
 * @author rushun.zhang
 *
 */
public class IdentifierSaxParse {
	public IdentifierData parse(InputStream is)
			throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance(); // 取得SAXParserFactory实例
		SAXParser parser = factory.newSAXParser(); // 从factory获取SAXParser实例
		MyHandler handler = new MyHandler(); // 实例化自定义Handler
		parser.parse(is, handler); // 根据自定义Handler规则解析输入流
		
		return handler.getDatas();

	}

	// 需要重写DefaultHandler的方法
	private class MyHandler extends DefaultHandler {

		
		private IdentifierData data;
		private StringBuilder builder;

		// 返回解析后得到的Book对象集合
		public IdentifierData getDatas() {
			return data;
		}

		@Override
		public void startDocument() throws SAXException {
			super.startDocument();

			builder = new StringBuilder();
		}

		@Override
		public void endDocument() throws SAXException {
			super.endDocument();

		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			super.startElement(uri, localName, qName, attributes);
			if (localName.equals("PCITC_PNCN_FormInfo")||localName.equals("PCITC_PNDN_FormInfo")) {
				data = new IdentifierData();
			}
			builder.setLength(0); // 将字符长度设置为0 以便重新开始读取元素内的字符节点
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			// TODO Auto-generated method stub
			super.endElement(uri, localName, qName);
			Log.i("TAG", "LocalName:"+localName);
			if (localName.equals("Title")) {
				data.setTitle(builder.toString());
			} else if (localName.equals("ApplicantName")) {
				data.setApplicantName(builder.toString());
			} else if (localName.equals("ApplicantDept")) {
				data.setApplicantDept(builder.toString());
			} else if (localName.equals("ApplicantDeptID")) {
				data.setApplicantDeptID(builder.toString());
			} else if (localName.equals("ApplicationDate")) {
				data.setApplicationDate(builder.toString());
			} else if (localName.equals("CTTSingedPlace")) {
				data.setCTTSingedPlace(builder.toString());
			} else if (localName.equals("CTTType")) {
				data.setCTTType(builder.toString());
			} else if (localName.equals("AuthorityL1")) {
				data.setAuthorityL1(builder.toString());
			} else if (localName.equals("AuthorityL2")) {
				data.setAuthorityL2(builder.toString());
			}else if (localName.equals("AuthorityL3")) {
				data.setAuthorityL3(builder.toString());
			}  else if (localName.equals("ProjectManager")) {
				data.setProjectManager(builder.toString());
			} else if (localName.equals("PMEmail")) {
				data.setPMEmail(builder.toString());
			} else if (localName.equals("PMID")) {
				data.setPMID(builder.toString());
			} else if (localName.equals("MainProjectName")) {
				data.setMainProjectName(builder.toString());
			} else if (localName.equals("MainProjectNum")) {
				data.setMainProjectNum(builder.toString());
			} else if (localName.equals("ContractName")) {
				data.setContractName(builder.toString());
			}else if (localName.equals("ContractNumber")) {
				data.setContractName(builder.toString());
			} else if (localName.equals("CompanyCode")) {
				data.setContractName(builder.toString());
			} else if (localName.equals("CostCentral")) {
				data.setContractName(builder.toString());
			} else if (localName.equals("ProjectStartDate")) {
				data.setProjectStartDate(builder.toString());
			} else if (localName.equals("ProjectdFinishedDate")) {
				data.setProjectdFinishedDate(builder.toString());
			} else if (localName.equals("ProjectdClosedDate")) {
				data.setProjectdClosedDate(builder.toString());
			} else if (localName.equals("SalesType")) {
				data.setSalesType(builder.toString());
			} else if (localName.equals("ProjectSource")) {
				data.setProjectSource(builder.toString());
			} else if (localName.equals("ProjectSort")) {
				data.setProjectSort(builder.toString());
			}else if (localName.equals("ProjectSummary")) {
				data.setProjectSummary(builder.toString());
			} else if (localName.equals("BusinessSort")) {
				data.setBusinessSort(builder.toString());
			} else if (localName.equals("ProjectType")) {
				data.setProjectType(builder.toString());
			} else if (localName.equals("LabourCharge")) {
				data.setLabourCharge(builder.toString());
			}else if (localName.equals("EstimatedCTTAmount")) {
				data.setEstimatedCTTAmount(builder.toString());
			} else if (localName.equals("MaterialCharge")) {
				data.setMaterialCharge(builder.toString());
			}else if (localName.equals("BasicCharge")) {
				data.setBasicCharge(builder.toString());
			}else if (localName.equals("OtherCharge")) {
				data.setOtherCharge(builder.toString());
			}else if (localName.equals("BudgetTotal")) {
				data.setBudgetTotal(builder.toString());
			} else if (localName.equals("ProjectSort")) {
				data.setProjectSort(builder.toString());
			} else if (localName.equals("ProjectName")) {
				data.setProjectName(builder.toString());
			} else if (localName.equals("ProjectNumber")) {
				data.setProjectNumber(builder.toString());
			} else if (localName.equals("ID")) {
				data.setID(builder.toString());
			}  else if (localName.equals("ContentType")) {
				data.setContentType(builder.toString());
			}  else if (localName.equals("ChangePropertyWay")) {
				data.setChangePropertyWay(builder.toString());
			}  else if (localName.equals("Modified")) {
				data.setModified(builder.toString());
			}  else if (localName.equals("Created")) {
				data.setCreated(builder.toString());
			}  else if (localName.equals("Author")) {
				data.setAuthor(builder.toString());
			}  else if (localName.equals("Editor")) {
				data.setEditor(builder.toString());
			} else if (localName.equals("UIVersionString")) {
				data.setUIVersionString(builder.toString());
			} else if (localName.equals("Attachments")) {
				data.setAttachments(builder.toString());
			}else if (localName.equals("AttachName")) {
				data.setAttachName(builder.toString());
			} else if (localName.equals("LinkTitleNoMenu")) {
				data.setLinkTitleNoMenu(builder.toString());
			} else if (localName.equals("LinkTitle")) {
				data.setLinkTitle(builder.toString());
			} else if (localName.equals("TaskID")) {
				data.setTaskID(builder.toString());
			} else if (localName.equals("UserID")) {
				data.setUserID(builder.toString());
			} else if (localName.equals("WFType")) {
				data.setWFType(builder.toString());
			
			} else if (localName.equals("PCITC_PNCN_FormInfo")||localName.equals("PCITC_PNDN_FormInfo")) {
//				datas.add(data);
				//解析数据结束
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
