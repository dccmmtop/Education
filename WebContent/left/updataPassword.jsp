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
	<form action="#" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" id=user></td>
			</tr>
			<tr>
				<td>原始密码：</td>
				<td><input type="password" id=oldPassword></td>
			</tr>
			<tr>
				<td>新密码：</td>
				<td><input type="password" id=newPassword></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button"
					onclick="tijiao()" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
<script>
	function tijiao() {
		var check = false;
		$.ajax({ 
			type : "post",
			url : "../Verification?id=verificationAccount",
			async : false,
			dataType : "html",
			data : {
				account : $("#user").val(),
				password : $("#oldPassword").val(),
				newPassword : $("#newPassword").val()
			},
			success : function(data, ststus) {
				if (data == 2)
					{
					check = true;
					alert("密码修改成功,点击确定前往登录界面")
					console.log("密码修改成功,点击确定前往登录界面");
					parent.window.location.href="../login.jsp";
					}
				else if (data == 1)
					alert("用户名或者密码错误");
				else if (data == 0)
					alert("没有这个账户");
			}
		});
	 
	}
</script>





</html>