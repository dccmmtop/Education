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
		 System.out.println("�˺ţ�"+account);
		 System.out.println("���룺"+password);
		 System.out.println("�Ա�"+sex);
		 System.out.println("������"+name);
		 StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
		 studentDaoImpl.add(account, password, sex, name);
	 
		 
	}

}
