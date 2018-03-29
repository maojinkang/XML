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

public class UinfoBean {
	private int id;
	private int uid;
	private String name;
	private String sex;
	private String department;
	private String major;
	private String class_u;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getClass_u() {
		return class_u;
	}

	public void setClass_u(String class_u) {
		this.class_u = class_u;
	}

	public UinfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UinfoBean(int uid, String name, String sex, String department, String major, String class_u) {
		super();
		this.uid = uid;
		this.name = name;
		this.sex = sex;
		this.department = department;
		this.major = major;
		this.class_u = class_u;
	}

	@Override
	public String toString() {
		return "UinfoBean [id=" + id + ", uid=" + uid + ", name=" + name + ", sex=" + sex + ", department=" + department
				+ ", major=" + major + ", class_u=" + class_u + "]";
	}

	/**
	 * 存储个人信息
	 */
	public void save() {
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/uinfobean.xml"));
			Element root = doc.getRootElement();
			Element userinfobean = new Element("userinfobean");
			Element name1 = new Element("name");
			Element sex1 = new Element("sex");
			Element department1 = new Element("department");
			Element major1 = new Element("major");
			Element class1 = new Element("class");
			Attribute id1 = new Attribute("id", root.getContentSize() + "");
			Attribute uid1 = new Attribute("uid", uid + "");
			name1.addContent(name);
			sex1.addContent(sex);
			department1.addContent(department);
			major1.addContent(major);
			class1.addContent(class_u);
			userinfobean.setAttribute(id1);
			userinfobean.setAttribute(uid1);
			userinfobean.addContent(name1);
			userinfobean.addContent(sex1);
			userinfobean.addContent(department1);
			userinfobean.addContent(major1);
			userinfobean.addContent(class1);
			root.addContent(userinfobean);
			Format f = Format.getPrettyFormat();
			f.setEncoding("utf-8");
			XMLOutputter xmlout = new XMLOutputter();
			xmlout.output(doc,
					new FileOutputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/uinfobean.xml"));
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

	public static boolean isExist(int id) {
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/uinfobean.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element element : list) {
				String id1 = element.getAttributeValue("uid");
				if(id1.equals(id+"")) {
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
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static UinfoBean findUbyID(int id) {
		SAXBuilder sb = new SAXBuilder();
		List<UinfoBean> list = null;
		UinfoBean info = null;
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/uinfobean.xml"));
			Element root = doc.getRootElement();
			List<Element> list1 = root.getChildren();
			for (Element element : list1) {
				int uid = Integer.valueOf(element.getAttributeValue("uid"));
				if (uid == id) {
					String name = element.getChildText("name");
					String sex = element.getChildText("sex");
					String department = element.getChildText("department");
					String major = element.getChildText("major");
					String class_u = element.getChildText("class");
					info = new UinfoBean(uid, name, sex, department, major, class_u);
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

	/**
	 * 根据uid删除
	 * 
	 * @param id
	 */
	public static void deleteByID(int id) {
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/uinfobean.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element element : list) {
				int uid = Integer.valueOf(element.getAttributeValue("uid"));
				if (uid == id) {
					element.removeChild("name");
					element.removeChild("sex");
					element.removeChild("department");
					element.removeChild("major");
					element.removeChild("class");
					element.removeAttribute("id");
					element.removeAttribute("uid");
					list.remove(element);
					Format f = Format.getPrettyFormat();
					f.setEncoding("utf-8");
					XMLOutputter xmlout = new XMLOutputter();
					xmlout.output(doc,
							new FileOutputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/uinfobean.xml"));
					return;
				}
			}
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 更新数据
	 * 
	 * @param info
	 * @param id
	 * @return
	 */
	public static boolean upDate(String name1,String sex1, int id) {
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/uinfobean.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element element : list) {
				System.out.println(element.getAttributeValue("uid"));
				if (element.getAttributeValue("uid").equals(id + "")) {
					Element name = element.getChild("name");
					Element sex = element.getChild("sex");;
					name.setText(name1);
					sex.setText(sex1);
					Format f = Format.getPrettyFormat();
					f.setEncoding("utf-8");
					XMLOutputter xmlout = new XMLOutputter();
					xmlout.output(doc,
							new FileOutputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/uinfobean.xml"));
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
	
	public static String findName(int id){
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/uinfobean.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element element : list) {
				String uid = element.getAttributeValue("uid");
				if(uid.equals(id+"")) {
					return element.getChildText("name");
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
		return null;
	}
}
