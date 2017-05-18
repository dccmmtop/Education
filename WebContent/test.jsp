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
	<p class="demo">demo</p>
	<div class="one" id="one">
		id为one，clas为one的div；
		<div class="mini">clas wei mini de div</div>
	</div>
	<div class="one" id="two" title="test">
		id 为two,class为one，title 为test的div
		<div class="mini" title="other">clas为mini title为other的div</div>
		<div class="mini" title="test">clas为mini title为test的div</div>
	</div>
	<div>
		<div class="mini">class wei mini</div>
		<div class="mini">class wei mini</div>
		<div class="mini">class wei mini</div>
		<div class="mini"></div>
	</div>
	<div>
		<div class="mini">class wei mini</div>
		<div class="mini">class wei mini</div>
		<div class="mini">class wei mini</div>
		<div class="mini" title="test">class wei mini title wei title de
			div</div>
	</div>

	<div style="display: none" >style wei none de div</div>
	<div class="hide">class wei hide de div</div>
	<div>
		bao han input de type wei "hide" de div <input type="hide" size="8">
	</div>
	<div>
		<span id="mover">zheng zai zhixing dong hua de span></span>
	</div>





</body>

<style>
div {
	width: 180px;
	height: 180px;
	margin: 5px;
	background: #aaa;
	border: #000 1px solid;
	float: left;
	font-size: 17px;
	font-family: verdana;
}

.mini {
	width: 60px;
	height: 60px;
	background-color: #bbb;
	font-size: 7px;
}

.hide {
	display: none;
}
</style>


<script type="text/javascript">
	//$("div").css("background","#bbfffa");
	//$("#one").css("background","#bbffaa");
	//$(".mini").css("background","#bbffab");
	//$("*").css("background","#fbffab");
	//$("body div").css("background","#bfffaa");
	//$("body > div ").css("background","red");
	/* $("div:odd").css("background","red");
	 $("div:even").css("background","red");
	 $("div:first").css("background","red"); */
	//$("div:eq(3)").css("background","red");
	//$("div:gt(3)").css("background","red");
	//$("div:contains(title)").css("background","red");
	//	$("div:empty").css("background","red");
	//$("div:hidden").show(1000);
	$("div[title=test]").css("background","red");
	
</script>


</html>
