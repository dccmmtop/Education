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
			System.out.println("��֤����سɹ�");
		} else if (id.equals("verificationAccount")) {
			System.out.println("��֤��������ȷ");
			// �ж��˺������Ƿ���ȷ
			loginDaoImpl loginTool = new loginDaoImpl();
			String account = request.getParameter("account");
			System.out.println("��������˺� ��   " + account);
			int num = loginTool.accountNum(account.trim());// ������û������˺�
			PrintWriter out = response.getWriter();
			System.out.println(num + "  -----");
			HttpSession session = request.getSession();
			if (num == 0) {
				out.print("0");// ����״̬��,ajax��
				System.out.println("û������˻�");
			} else {
				String password1 = loginTool.getPassword(account);// �������˻������룬����Ƿ�ƥ��
				String password = request.getParameter("password");
				System.out.println("����������� ��   " + password);
				if (password1.equals(password)) {
					out.print("2");
					String newPassword = request.getParameter("newPassword");
					if (!StringUtils.isEmpty(newPassword))// �޸�������
					{
						loginTool.updataPassword(account, newPassword);
						System.out.println("�����޸ĳɹ�");
					} else// ��¼��
					{
						session.setAttribute("user", account);
						System.out.println("��¼�ɹ�");
					}

				} else {
					out.print("1");
					System.out.println("�������");
				}
			}
		}
	}

}
