package com.dc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YanZhengCode
 */
public class YanZhengCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String yanZhnengCode=request.getParameter("code");
		 response.setContentType("html/text");
		 response.setCharacterEncoding("utf-8");
		 PrintWriter out=response.getWriter();
	     System.out.println("���������֤�룺"+yanZhnengCode);
	     System.out.println("��ȷ����֤�룺 "+request.getSession().getAttribute("Verification"));
		 if(yanZhnengCode.equals(request.getSession().getAttribute("Verification").toString())) {
			 out.print("0");
		 }
		 else 
			 {
			 System.out.println("��֤���������");
			 out.print("1");
			 }
		 
	}

}
