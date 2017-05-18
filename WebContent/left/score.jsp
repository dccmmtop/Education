<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src=../jquery.js></script>
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<td colspan="5">分数：</td>
		</tr>
		<tr>
			<th>课程编号</th>
			<th>课程名称</th>
			<th>学分</th>
			<th>职工号</th>
			<th>授课教师</th>
		</tr>
		<c:if test="${empty score}">
			<jsp:forward page="../xuanKeInfo?id=score"/></c:if>
		<c:forEach var="i" items="${score}">
			<tr>
				<td>${i[0]}</td>
				<td>${i[1]}</td>
				<c:if test="${i[2].toString()=='-1.0'}">
					<td>未登分</td>
				</c:if>
				<c:if test="${i[2].toString()!='-1.0'}">
					<td>${i[2]}</td>
				</c:if>
				<td>${i[3]}</td>
				<td>${i[4]}</td>
			</tr>
		</c:forEach>
	</table>
</body>
<script>
$("tr:odd").css("background","#fff38f");
$("tr:even").css("background","#ffffee");
</script>

</html>
