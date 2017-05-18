<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src=./jquery.js></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="#" method="post" name="loginForm">
		<table align="center" id="loginTable">
			<tr>
				<td>账号：</td>
				<td><input name="account" type="text" id="userName"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input name="password" type="password" id="userPassword"></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="yanZhengMa" id="yan"></td>
				<td><img src="Verification?id=getVerificationCode&date=1" id="tupian"
					onclick="changeImage()" /></td>

				<td><lable id="tishi"></lable></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" value="登录" onclick="validate()">
					<a href="Register.jsp">注册</a></td>
			</tr>
		</table>
	</form>
</body>
</html>
<script type="text/javascript">
	function validate() {
		var account = document.loginForm.account.value;
		if (account == "") {
			alert("账号不能为空");
			 
			return;
		} else {
			var password = document.loginForm.password.value;
			if (password == "") {
				alert("密码不能为空");
				return;
			}
		}
		if (yanZhengCode() == false)
			return;
		if (yanZhengAccount() == false)
			return;
		window.location.href="Main.jsp";
	}

	function yanZhengCode() {

		var check = false;
		$.ajax({
			type : "get",
			url : "YanZhengCode",
			async : false,
			dataType : "html",
			data : {
				code : $("#yan").val()
			},
			success : function(data, status) {
				if (data == 1) {
					alert("验证码错误");
					changeImage();
					check = false;

				} else
					check = true;
			}
		});
		return check;

	}

/**
 * 通过ajax来登录
 */
	function yanZhengAccount() {
		var check = false;
		$.ajax({

			type : "post",
			url : "Verification?id=verificationAccount",
			async : false,
			dataType : "html",
			data : {
				account : $("#userName").val(),//账户
				password : $("#userPassword").val()//密码
			},
			success : function(data, status) {
				console.log(data);
				if (data == 2)
					check = true;
				else {
					if (data == 1)
						alert("用户名或密码错误");
					if (data == 0)
						alert("没有这个账户");
					check = false;
				}
			}

		});
		return check;
	}
/**
 *  通过改变图片的src的值来刷新图片
 */
	function changeImage() {
		var imag = $("#tupian");
		var src = imag.attr("src");
		var t = src.indexOf("&date=");
		src = src.substring(0, t + 1) +"date="+ new Date().getTime().toString();
		 console.log(src);
		imag.attr("src", src);
	}
</script>

<style>
#loginTable{
color : red;
background-color: gray;
padding: 20px;
position : absolute;
top: 300px;
left: 700px;
}

</style>


