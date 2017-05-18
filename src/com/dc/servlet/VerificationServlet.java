package com.dc.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.dc.DaoImpl.ScoreImpl;
import com.dc.DaoImpl.loginDaoImpl;
import com.dc.utils.ImageUtils;

/**
 * Servlet implementation class VerificationServlet
 */
public class VerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id.equals("getVerificationCode")) {
			HttpSession session = request.getSession();
			OutputStream os = response.getOutputStream();
			BufferedImage image = ImageUtils.getVerifyImage(session);
			ImageIO.write(image, "jpeg", os);
			os.flush();
			os.close();
			System.out.println("验证码加载成功");
		} else if (id.equals("verificationAccount")) {
			System.out.println("验证码输入正确");
			// 判断账号密码是否正确
			loginDaoImpl loginTool = new loginDaoImpl();
			String account = request.getParameter("account");
			System.out.println("你输入的账号 ：   " + account);
			int num = loginTool.accountNum(account.trim());// 查找有没有这个账号
			PrintWriter out = response.getWriter();
			System.out.println(num + "  -----");
			HttpSession session = request.getSession();
			if (num == 0) {
				out.print("0");// 返回状态码,ajax用
				System.out.println("没有这个账户");
			} else {
				String password1 = loginTool.getPassword(account);// 获得这个账户的密码，检查是否匹配
				String password = request.getParameter("password");
				System.out.println("你输入的密码 ：   " + password);
				if (password1.equals(password)) {
					out.print("2");
					String newPassword = request.getParameter("newPassword");
					if (!StringUtils.isEmpty(newPassword))// 修改密码用
					{
						loginTool.updataPassword(account, newPassword);
						System.out.println("密码修改成功");
					} else// 登录用
					{
						session.setAttribute("user", account);
						System.out.println("登录成功");
					}

				} else {
					out.print("1");
					System.out.println("密码错误");
				}
			}
		}
	}

}
