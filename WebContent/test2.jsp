<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./jquery.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form id="form1" action="#">
		可用元su <input type="text" name="add" value="可用文本框"><br> 不可用元素<input
			name="email" value="不可用文本框" disabled="disabled"><br>
		可用元素<input name="che" value="可用文本框"><br> 不可用元素<input
			name="name" value="不可用文本框" disabled="disabled"><br>
			
			 多选框<br>
			 
		<input type="checkbox" name="newsletter" checked="checked"
			value="test1">test1<br> <input type="checkbox"
			name="newsletter" value="test2">test2<br> 
			<input
			type="checkbox" name="newsletter" value="test3">test3<br>
		<input type="checkbox" name="newsletter" checked="checked"
			value="test4">test4<br> <input type="checkbox"
			name="newsletter" value="test5">test5<br>
		<div></div>
		<br> <br> 下拉列表1：<br> <select name="test"
			multiple="multiple" style="height: 100px">
			<option>浙江</option>
			<option selected="selected">湖南</option> 
			<option>北京</option>
			<option selected="selected">天津</option>
			<option>广州</option>
			<option>湖北</option>
		</select> <br> <br> 下拉列表2：<br> <select name="test2">
			<option>浙江</option>
			<option>湖南</option>
			<option selected="selected">北京</option>
			<option>天津</option>
			<option>广州</option>
			<option>湖北</option>
		</select>
	</form>
</body>
<script>
//$("#form1 input:enabled").val("here");
//$("#form1 input:disabled").val("here");

 
</script>












</html>