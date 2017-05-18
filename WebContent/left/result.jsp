<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src=../jquery.js></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="10" cellspacing="0">
	<tr><td colspan="5">你的选课结果如下</td></tr>
		<tr>
			<th>课程编号</th>
			<th>课程名称</th>
			<th>学分</th>
			<th>职工号</th>
			<th>教师</th>
		</tr>
		<%
			List<Object[]> list=null ;
			list= (List<Object[]>)session.getAttribute("xuanKeInfo");
			int len = 0;
			 if(list==null)
			{
				 /*这里有两种方式跳转到servelt来处理选课的信息，注意转发和重定向的区别，如果是重定向，相当于浏览器请求的，url会改变
				 如果是转发的方式，那么就要注意了。由于转发是服务器内部进行的，url
				 根本就没有发生变化，所以位置还是本页面的位置，当需要从servlet跳转时，跳转的相对路径不能是相对于servlet的路径，而是相对于本页面的路径。
				 如果是重定向的方式跳转到sevrlet中的，那么当前页面的位置就是这个servlet，当从servlet跳转的时候，跳转路径就应该是相对于servlet
				 的路径*/
				 
				//request.getRequestDispatcher("../xuanKeInfo?id=result").forward(request, response);
				response.sendRedirect("../xuanKeInfo?id=result");
				list= (List<Object[]>)session.getAttribute("xuanKeInfo");
			} 
			if (list != null)
				len = list.size();
			for (int i = 0; i < len; i++) {
		%>
		<tr>
			<td><%=list.get(i)[0]%></td>
			<td><%=list.get(i)[1]%></td>
			<td><%=list.get(i)[2]%></td>
			<td><%=list.get(i)[3]%></td>
			<td><%=list.get(i)[4]%></td>

		</tr>

		<%
			}
		%>


	</table>
</body>
</html>
<style>
.odd {
	background: #fff38f;
}

.even {
	background: #ffffee;
}
</style>
<script>
	$(function() {
		$("tr:odd").addClass("odd");
		$("tr:even").addClass("even");
	});
</script>

