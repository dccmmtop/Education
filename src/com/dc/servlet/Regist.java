package com.dc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.DaoImpl.StudentDaoImpl;

/**
 * Servlet implementation class Regist
 */
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String account=request.getParameter("account");
		 String password=request.getParameter("password");
		 String sex=request.getParameter("sex");
		 String name=request.getParameter("userName");
		 System.out.println("ÕËºÅ£º"+account);
		 System.out.println("ÃÜÂë£º"+password);
		 System.out.println("ÐÔ±ð£º"+sex);
		 System.out.println("ÐÕÃû£º"+name);
		 StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
		 studentDaoImpl.add(account, password, sex, name);
	 
		 
	}

}
