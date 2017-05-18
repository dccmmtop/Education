<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src=./jquery.js></script>
<title>Insert title here</title>
</head>
<body>
	<form action="Regist" method="post">
		<table align="center" id="table">

			<tr>
				<td>账号：</td>
				<td><input type="text" name="account" id="userAccount"></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="userName" id="userName"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="userPassword"
					id="userPassword"></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="okPassword" id="okPassword"></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><input type="radio" name="sex" id="sex" value="m">男
					&nbsp; <input type="radio" name="sex" id="sex" value="w">女
					&nbsp;</td>
			</tr>
			<tr>
				<td><input type="button" value="提交" onclick="tijiao()"></td>
			</tr>
		</table>

	</form>

</body>
</html>
<script type="text/javascript">
	function tijiao() {
		if ($("#userAccount").val().trim().length <= 0) {
			alert("用户名不能为空");
			return;
		}
		if ($("#userName").val().trim().length <= 0) {
			alert("姓名不能为空");
			return;
		}

		//console.log("密码不能为空");
		if ($("#userPassword").val().trim().length <= 0) {
			alert("密码不能为空");
			return;
		}
		if ($("#userPassword").val().trim() != $("#okPassword").val()) {
			alert("两次密码不同");
			return;
		}
		if ($("input[name='sex']:checked").val() == null) {
			alert("请选择性别");
			return;
		}
		if (yanZhenguserAccount() == false)
			return;
		if (zhuce() == false)
			return;
		alert("注册成功，点击确定后跳转到登录界面");
		window.location.href="login.jsp";
		

	}

	function yanZhenguserAccount() {
		var check = false;

		$.ajax({
			type : "post",
			async : false,
			url : "login",
			dataType : "html",
			data : {
				account : $("#userAccount").val()
			},
			success : function(data, atatus) {
				if (data != 0) {
					alert("用户名已被占用");
					$("#userAccount").val("");
					$("#userAccount").focus();

				} else
					check = true;
			}

		});
		return check;
	}

	function zhuce() {
		var check = true;
		$.ajax({
			type : "post",
			async : false,
			url : "Regist",
			dataType : "html",
			data : {
				account : $("#userAccount").val(),
				password : $("#userPassword").val(),
				sex: $("input[name='sex']:checked").val(),
				userName : $("#userName").val()
			},
 			success : function(data, status) {
 		        console.log(status);
 				alert(status);
			}
		});
		return check;
	}
</script>
