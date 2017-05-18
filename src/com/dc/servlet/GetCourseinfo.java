package com.dc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.DaoImpl.CourseDaoImpl;

/**
 * Servlet implementation class GetCourseinfo
 */
public class GetCourseinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Object[]>courseinfo=new CourseDaoImpl().getAllCourse();
		 request.setAttribute("courseInfo", courseinfo);
		 request.getRequestDispatcher("./left/xuanke.jsp").forward(request, response);
	}

}
