
<%@page import="java.util.List"%>
<%@page import="com.dc.DaoImpl.CourseDaoImpl"%>
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
	<%
		List<Object[]> list =new CourseDaoImpl().getAllCourse();
	%>
	<p>
		你可以选择的课程如下： <font color="red">(注：必须选满20学分，且不能多选)</font>
	</p>
	<form action="../xuanKeInfo?id=xuanKe" method="post" name="xuanke">
		<table border="1" cellpadding="10" cellspacing="0">
				<tr>
					<th>课程编号</th>
					<th>课程名称</th>
					<th>学号</th>
					<th>职工号</th>
					<th>授课老师</th>
					<th>选课</th>
				</tr>
				<%
					for (int j=0;j<list.size();j++)
					{
				%>
				<tr>
					<%
						for (int i=0;i<list.get(j).length;i++)
																																								{
					%>
					<td><%=list.get(j)[i]%></td>
					<%
						}
					%>
					<td><input type="checkbox" name="check" id="check"
						value="<%=list.get(j)[0]%>@<%=list.get(j)[1]%>@<%=list.get(j)[2]%>@<%=list.get(j)[3]%>@<%=list.get(j)[4]%>"></td>
				</tr>
				<%
					}
				%>
				 
		</table>
		 
		 
		<br>
		<br>
		
	</form>
		<input align="center" type="button" value="提交" onclick="tijiao()">

</body>
</html>
<style>
 
</style>
<script>
$("tr:odd").css("background","#fff38f");
$("tr:even").css("background","#ffffee");
function tijiao()
{
	///还没有实现检查此门课是否已经选过
	var score=0;
	var info=$("input[name='check']:checked").each(function(){
		score+=(Number)($(this).val().split("@")[2]);
	});
		console.log(score);
		if(score>20)
		{
			alert("所选分数超过20");
			return;
		}
		else if(score<20)
		{
			alert("所选分数不足20，请继续选课");
			return;
		}
		alert("选课成功");
		document.xuanke.submit();
}

</script>
