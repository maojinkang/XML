package com.Serlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.Achievementinfo;


/**
 * Servlet implementation class Ainfo
 */
@WebServlet("/Ainfo")
public class Ainfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ainfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int id = Integer.valueOf(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		Integer class_id = Integer.valueOf(request.getParameter("class_id"));
		Achievementinfo aa = Achievementinfo.findByID(id);
		if (type.equals("select")) {
			if (aa == null && class_id != 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('无成绩！！');");
				out.print("window.location='allStuendt.jsp?page=two';");
				out.print("</script>");
			} 
			if(aa==null && class_id==0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('无成绩！！');");
				out.print("window.location='index.jsp';");
				out.print("</script>");
			}
			if (aa != null) {
				request.setAttribute("CJinfo", aa);
				System.out.println(aa.toString());
				request.getRequestDispatcher("selectCJ.jsp").forward(request, response);
			}
		}
		if (type.equals("save")) {
			if (aa != null) {
				out.print("<script type='text/javascript'>");
				out.print("alert('已有成绩不能再次添加！！');");
				out.print("window.location='allStuendt.jsp?page=two';");
				out.print("</script>");
			} else {
				Achievementinfo info = getAchievementinfo(request, id);
				info.saveChenji();
				response.sendRedirect("allStuendt.jsp?page=two");
			}
		}
		if (type.equals("update")) {
			if (aa == null) {
				out.print("<script type='text/javascript'>");
				out.print("alert('该学生无成绩不能修改！！');");
				out.print("window.location='allStuendt.jsp?page=two';");
				out.print("</script>");
			} else {
				Achievementinfo info = getAchievementinfo(request, id);
				Achievementinfo.upDate(info, id);
				response.sendRedirect("allStuendt.jsp?page=two");
			}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private Achievementinfo getAchievementinfo(HttpServletRequest request, int id) {
		String a = request.getParameter("chinese");
		String b = request.getParameter("math");
		String c = request.getParameter("english");
		String d = request.getParameter("java");
		String e = request.getParameter("c");
		String f = request.getParameter("xml");

		return new Achievementinfo(0, a, b, c, d, e, f, id);

	}

}
