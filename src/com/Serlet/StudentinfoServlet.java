package com.Serlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.Achievementinfo;
import com.info.UinfoBean;
import com.info.Userinfo;

/**
 * Servlet implementation class StudentinfoServlet
 */
@WebServlet("/StudentinfoServlet")
public class StudentinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentinfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		int id = Integer.valueOf(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		/*if(type.equals("select")) {
			Studentinfo info = (new StudentinfoUtil()).getStudentinfo(id);
			request.setAttribute("studentinfo", info);
			request.getRequestDispatcher("Sinformation.jsp").forward(request, response);
		}*/
		if(type.equals("update")) {
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			UinfoBean.upDate(name, sex, id);
			out.print("<script type='text/javascript'>");
			out.print("alert('ÐÞ¸Ä³É¹¦£¡');");
			out.print("window.location='allStuendt.jsp';");
			out.print("</script>");
		}
		if(type.equals("delete")) {
			UinfoBean.deleteByID(id);
			if(UinfoBean.isExist(id)) {
				UinfoBean.deleteByID(id);
			}
			Achievementinfo.deleteByID(id);
			Userinfo.deleteByID(id);
			response.sendRedirect("allStuendt.jsp");
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
