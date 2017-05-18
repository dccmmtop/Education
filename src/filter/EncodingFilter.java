package filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter implements Filter
{

	/**
	 * Default constructor.
	 */
	public EncodingFilter()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy()
	{
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		request.setCharacterEncoding("utf-8");

		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse response2 = (HttpServletResponse) response;
		HttpSession session = request2.getSession();

		String path = request2.getServletPath();
		System.out.println("�����Ŀ��:" + path + "   " + new Date());
		// ���û�е�¼ ���ҷ��ʵĲ��ǵ�¼ҳ����ߵ�¼����ҳ�����ע����� ������֤���servletҲ���ڵ�¼����ҳ�� �����ض����ڵ�¼����
		if (session.getAttribute("user") == null && !path.endsWith("login.jsp")
				&& !path.endsWith("Verification") && !path.endsWith("Register.jsp")
				&& !path.endsWith("Regist") && !path.endsWith("jquery.js"))
		{
			response2.sendRedirect("login.jsp");
		} else
			// ����
			chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException
	{

	}

}
