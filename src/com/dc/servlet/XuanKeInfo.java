package com.dc.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dc.DaoImpl.ScoreImpl;

/**
 * Servlet implementation class XuanKeInfo
 */
public class XuanKeInfo extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String path = request.getParameter("id");
		System.out.println(path);
		if (path.equals("xuanKe"))
		{
			insertXuanKeInfo(request, response, session);
			getXuankeInfo(request, response, session);
			response.sendRedirect("./left/result.jsp");

		} else if (path.equals("result"))
		{
			getXuankeInfo(request, response, session);
			response.sendRedirect("./left/result.jsp");
		}
		else if(path.equals("score"))
		{
			getScore(request, response, session);
			System.out.println("score");
			response.sendRedirect("./score.jsp");
		}
	

	}

	/**
	 * �õ�ѧ��ѡ�ε���Ϣ
	 * 
	 * @param request
	 * @param response
	 * @param session
	 *            ���浽session��
	 */
	public void getXuankeInfo(HttpServletRequest request, HttpServletResponse response,
			HttpSession session)
	{
		String user = (String) session.getAttribute("user");
		// System.out.println(user);
		List<Object[]> list = new ScoreImpl().getXuankeInfo(user);
		session.setAttribute("xuanKeInfo", list);
	}

	/**
	 * ��ѧ��ѡ�ε���Ϣ�������ݿ�
	 * 
	 * @param request
	 * @param response
	 * @param session
	 *            ��session�л�ȡѧ����id
	 */
	public void insertXuanKeInfo(HttpServletRequest request, HttpServletResponse response,
			HttpSession session)
	{
		String courseId[] = request.getParameterValues("check");
		ScoreImpl scoreImpl = new ScoreImpl();
		String studentId = (String) session.getAttribute("user");
		scoreImpl.delete(studentId);
		for (String s : courseId)
		{
			String[] ss = s.split("@");
			scoreImpl.insert(studentId, ss[0], (float) -1);
			System.out.println(s);
		}
	}
	
	/**
	 * �õ�ѧ���ķ���
	 * @param request
	 * @param response
	 * @param session
	 */
	public void getScore(HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		String studentAccount=(String)session.getAttribute("user");
		List<Object[]>list=new ScoreImpl().getScore(studentAccount);
		session.setAttribute("score", list);
	}
	
	

}
