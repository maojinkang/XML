package com.Serlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.Userinfo;


/**
 * Servlet implementation class UpDataPServlet
 */
@WebServlet("/UpDataPServlet")
public class UpDataPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpDataPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newPWD = request.getParameter("password");
		String olderPWD = request.getParameter("password2");
		String sverifyCode = (String) request.getSession().getAttribute("VALIDATECODE");
		String verifyCode = request.getParameter("verifyCode");
		PrintWriter out = response.getWriter();
		int id = (Integer)request.getSession().getAttribute("uid");
		String pwd = (String) request.getSession().getAttribute("password");
		if (!sverifyCode.equals(verifyCode)) {
			out.print("<script type='text/javascript'>");
			out.print("alert('请输入正确的验证码！');");
			out.print("window.location='upDataPassWord.jsp';");
			out.print("</script>");
		}else if(olderPWD.equals(pwd)) {
			Userinfo.updatePassword(id, newPWD);
			out.print("<script type='text/javascript'>");
			out.print("alert('密码修改成功，请重新登录！');");
			out.print("window.location='out.jsp';");
			out.print("</script>");
		}else {
			out.print("<script type='text/javascript'>");
			out.print("alert('原来的密码不相符！');");
			out.print("window.location='upDataPassWord.jsp';");
			out.print("</script>");
		}
	}

}
