package com.Serlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jdom.JDOMException;

import com.info.Userinfo;

/**
 * Servlet implementation class UserSerlet
 */
@WebServlet("/UserSerlet")
public class UserSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSerlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String type = request.getParameter("type");
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String userType = request.getParameter("userType");
		PrintWriter out = response.getWriter();
		
		if(type.equals("select")) {
			int id = Userinfo.findUser(username, pwd,userType);
			System.out.println(id);
			if(id!=0){
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", pwd);
				session.setAttribute("userType", userType);
				session.setAttribute("uid", id);
				response.sendRedirect("index.jsp");
			}
			if(id==0){
				out.print("<script type='text/javascript'>");
				out.print("alert(用户名、密码或身份错误！');");
				out.print("window.location='login.jsp';");
				out.print("</script>");
			}		
		}
		if(type.equals("add")) {
			if(!Userinfo.isExistName(username)) {
				Userinfo user = new Userinfo(username, pwd,userType);
				user.saveUser();
				response.sendRedirect("login.jsp");
			}else {
				out.print("<script type='text/javascript'>");
				out.print("alert('该用户已被注册！');");
				out.print("window.location='register.jsp';");
				out.print("</script>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
