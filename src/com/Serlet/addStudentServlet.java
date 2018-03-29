package com.Serlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.UinfoBean;
import com.info.Userinfo;

/**
 * Servlet implementation class addStudentServlet
 */
@WebServlet("/addStudentServlet")
public class addStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStudentServlet() {
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
		String DEPARTMENT = request.getParameter("DEPARTMENT");
		String MAJOR = request.getParameter("MAJOR");
		String CLASS = request.getParameter("CLASS");
		int n = Integer.valueOf(request.getParameter("n"));
		String n1 = request.getParameter("n1");
		PrintWriter out = response.getWriter();
		for(int i=0;i<n;i++) {
			int nn = Integer.valueOf(n1);
			Userinfo info = new Userinfo(nn+"", "123456", "student");
			info.saveUser();
			n1 = nn+1+"";
			int id =Userinfo.findID(nn+"");
			UinfoBean info2 = new UinfoBean(id, null, null, DEPARTMENT, MAJOR, CLASS);
			info2.save();
		}
		out.print("<script type='text/javascript'>");
		out.print("alert('Ìí¼Ó³É¹¦£¡');");
		out.print("window.location='index.jsp';");
		out.print("</script>");
	}

}
