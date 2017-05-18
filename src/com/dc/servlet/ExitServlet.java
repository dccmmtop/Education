package com.dc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ExitServlet
 */
public class ExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 String user=(String)session.getAttribute("user");
		 System.out.println(user+"退出系统");
		 session.removeAttribute("user");
		 session.removeAttribute("xuanKeInfo");
		 System.out.println(session.getAttribute("user"));
		 PrintWriter out=response.getWriter();
		 //退回到登录界面，而不是在框架中显示登录界面
		 out.print("<script> top.window.location.href='login.jsp'</script>");
		 //与上一句效果一样
		// out.print("<script> parent.window.location.href='login.jsp'</script>");
		 //退出系统后还是在框架中
	//	 response.sendRedirect("login.jsp");
		
	}

}
