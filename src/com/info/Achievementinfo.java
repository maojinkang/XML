package com.info;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Achievementinfo {
	private int id;
	private String chinese_A;
	private String math;
	private String english;
	private String java;
	private String c;
	private String xml;
	private int applicant_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChinese_A() {
		return chinese_A;
	}
	public void setChinese_A(String chinese_A) {
		this.chinese_A = chinese_A;
	}
	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getJava() {
		return java;
	}
	public void setJava(String java) {
		this.java = java;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public int getApplicant_id() {
		return applicant_id;
	}
	public void setApplicant_id(int applicant_id) {
		this.applicant_id = applicant_id;
	}
	@Override
	public String toString() {
		return "Achievementinfo [id=" + id + ", chinese_A=" + chinese_A + ", math=" + math + ", english=" + english
				+ ", java=" + java + ", c=" + c + ", xml=" + xml + ", applicant_id=" + applicant_id + "]";
	}
	public Achievementinfo(int id, String chinese_A, String math, String english, String java, String c, String xml,
			int applicant_id) {
		super();
		this.id = id;
		this.chinese_A = chinese_A;
		this.math = math;
		this.english = english;
		this.java = java;
		this.c = c;
		this.xml = xml;
		this.applicant_id = applicant_id;
	}
	public Achievementinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void saveChenji() {
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/Chenji.xml"));
			Element root = doc.getRootElement();
			Element chenji = new Element("chenji");
			Element chinese1 = new Element("chinese");
			Element math1 = new Element("math");
			Element english1 = new Element("english");
			Element java1 = new Element("java");
			Element c1 = new Element("c");
			Element xml1 = new Element("xml_c");
			
			Attribute id = new Attribute("id", root.getContentSize() + "");
			Attribute uid = new Attribute("uid", applicant_id + "");
			chinese1.addContent(chinese_A);
			math1.addContent(math);
			english1.addContent(english);
			java1.addContent(java);
			c1.addContent(c);
			xml1.addContent(xml);
			
			chenji.addContent(chinese1);
			chenji.addContent(math1);
			chenji.addContent(english1);
			chenji.addContent(java1);
			chenji.addContent(c1);
			chenji.addContent(xml1);
			
			chenji.setAttribute(id);
			chenji.setAttribute(uid);
			
			root.addContent(chenji);
			Format f = Format.getPrettyFormat();
			f.setEncoding("utf-8");
			XMLOutputter xmlout = new XMLOutputter();
			xmlout.output(doc, new FileOutputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/Chenji.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Achievementinfo findByID(int id) {
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		Achievementinfo info = null;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/Chenji.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element element : list) {
				String uid = element.getAttributeValue("uid");
				if (uid.equals(id + "")) {
					
					String chinese = element.getChildText("chinese");
					String math = element.getChildText("math");
					String english = element.getChildText("english");
					String java = element.getChildText("java");
					String c = element.getChildText("c");
					String xml_c = element.getChildText("xml_c");
					int id1 = Integer.valueOf(element.getAttributeValue("id"));
					info = new Achievementinfo(id1, chinese, math, english, java, c, xml_c, id);
					return info;
					
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}
	
	public static boolean upDate(Achievementinfo info,int id) {
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/Chenji.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element element : list) {
				String uid = element.getAttributeValue("uid");
				if (uid.equals(id + "")) {
					(element.getChild("chinese")).setText(info.getChinese_A());
					(element.getChild("math")).setText(info.getMath());
					(element.getChild("english")).setText(info.getEnglish());
					(element.getChild("java")).setText(info.getJava());
					(element.getChild("c")).setText(info.getC());
					(element.getChild("xml_c")).setText(info.getXml());
					Format f = Format.getPrettyFormat();
					f.setEncoding("utf-8");
					XMLOutputter xmlout = new XMLOutputter();
					xmlout.output(doc,
							new FileOutputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/Chenji.xml"));
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static void deleteByID(int id) {
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/Chenji.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element element : list) {
				int uid = Integer.valueOf(element.getAttributeValue("uid"));
				if (uid == id) {
					element.removeChild("chinese");
					element.removeChild("math");
					element.removeChild("english");
					element.removeChild("java");
					element.removeChild("c");
					element.removeChild("xml_c");
					element.removeAttribute("id");
					element.removeAttribute("uid");
					list.remove(element);
					Format f = Format.getPrettyFormat();
					f.setEncoding("utf-8");
					XMLOutputter xmlout = new XMLOutputter();
					xmlout.output(doc,
							new FileOutputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/Chenji.xml"));
					return;
				}
			}
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
