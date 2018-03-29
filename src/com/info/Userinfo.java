package com.info;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Userinfo {
	private int id;
	private String name;
	private String password;
	private String userType;

	public Userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Userinfo(String name, String password, String userType) {
		super();
		this.name = name;
		this.password = password;
		this.userType = userType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Userinfo [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

	/**
	 * 登录验证
	 * 
	 * @param username
	 * @param password
	 * @param userType
	 * @return
	 */
	public static int findUser(String username, String password, String userType) {
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/user_0.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element element : list) {
				String name = element.getChildText("name");
				String pwd = element.getChildText("password");
				String usertype = element.getChildText("userType");
				if (name.equals(username) && pwd.equals(password) && usertype.equals(userType)) {
					return Integer.parseInt(element.getAttributeValue("id"), 10);
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
		return 0;
	}

	public static String findName(int id) {
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/user_0.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element element : list) {
				String uid = element.getAttributeValue("id");
				if (uid.equals(id + "")) {
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

	public static int findID(String name) {
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/user_0.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element element : list) {
				String name1 = element.getChildText("name");
				if (name1.equals(name)) {
					return Integer.parseInt(element.getAttributeValue("id"), 10);
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
		return 0;
	}

	public static List<Userinfo> selectAll() {
		SAXBuilder sb = new SAXBuilder();
		List<Userinfo> list = null;
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/user_0.xml"));
			Element root = doc.getRootElement();
			list = new ArrayList<Userinfo>();
			List<Element> list1 = root.getChildren();
			for (Element element : list1) {
				if (element.getChildText("userType").equals("student")) {
					int id = Integer.valueOf(element.getAttributeValue("id"));
					String name = element.getChildText("name");
					Userinfo info = new Userinfo();
					info.setId(id);
					info.setName(name);
					list.add(info);
				}
			}
			return list;
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
		return list;
	}

	/**
	 * 存储用户
	 * 
	 * @throws FileNotFoundException
	 * @throws JDOMException
	 * @throws IOException
	 */
	public void saveUser() {
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/user_0.xml"));
			Element root = doc.getRootElement();
			Element user = new Element("user");
			Element username = new Element("name");
			Element pwd = new Element("password");
			Element usertype = new Element("userType");
			Attribute id = new Attribute("id", root.getContentSize() + "");
			username.addContent(name);
			pwd.addContent(password);
			usertype.addContent(userType);
			user.setAttribute(id);
			user.addContent(username);
			user.addContent(pwd);
			user.addContent(usertype);
			root.addContent(user);
			Format f = Format.getPrettyFormat();
			f.setEncoding("utf-8");
			XMLOutputter xmlout = new XMLOutputter();
			xmlout.output(doc, new FileOutputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/user_0.xml"));
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

	/**
	 * 更新密码
	 * 
	 * @param id
	 * @param new_pwd
	 * @return
	 */
	public static boolean updatePassword(int id, String new_pwd) {
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/user_0.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element element : list) {
				System.out.println(element.getAttributeValue("id"));
				if (element.getAttributeValue("id").equals(id + "")) {
					Element pwd = element.getChild("password");
					pwd.setText(new_pwd);
					Format f = Format.getPrettyFormat();
					f.setEncoding("utf-8");
					XMLOutputter xmlout = new XMLOutputter();
					xmlout.output(doc,
							new FileOutputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/user_0.xml"));
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
	 * 判断是否已有该用户名
	 * 
	 * @return
	 */
	public static boolean isExistName(String name) {
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		try {
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/user_0.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element element : list) {
				String name1 = element.getChildText("name");
				if (name1.equals(name)) {
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
			doc = sb.build(new FileInputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/user_0.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.getChildren();
			for (Element element : list) {
				int uid = Integer.valueOf(element.getAttributeValue("id"));
				if (uid == id) {
					element.removeChild("name");
					element.removeChild("password");
					element.removeChild("userType");
					element.removeAttribute("id");
					list.remove(element);
					Format f = Format.getPrettyFormat();
					f.setEncoding("utf-8");
					XMLOutputter xmlout = new XMLOutputter();
					xmlout.output(doc,
							new FileOutputStream("C:/Users/41436/eclipse-workspace/xml_1/src/com/xml/user_0.xml"));
					return;
				}
			}
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
