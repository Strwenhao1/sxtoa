<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/select.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<script type="text/javascript" src="editor/kindeditor.js"></script>
		<script type="text/javascript">
		$(document).ready(function(e) {
		    $(".select1").uedSelect({
				width : 345			  
			});
		});
	</script>
		<script>
			$(function () {
				$(":button").click(function () {
					$.ajax({
						type:"post",
						data:$("form").serialize(),
						url:"",
						success:function (msg) {
							alert(123)
						}

					})
				})
			})
		</script>
	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">个人平台</a></li>
				<li><a href="#">我的信息</a></li>
			</ul>
		</div>

		<div class="formbody">

			<div class="formtitle"><span>修改个人信息</span></div>
<form>

			<ul class="forminfo">
					<li>
						<label>联系方式</label>
						<input name="phone" type="text" class="dfinput" value="${sessionScope.employee.phone}" />
					</li>
					<li>
						<label>QQ号</label>
						<input name="qq" type="text" class="dfinput"  value="${sessionScope.employee.qq}" />
					</li>
					<li>
						<label>紧急联系人信息</label>
						<textarea name="emerContactPerson" cols="" rows="" class="textinput" value="" >${sessionScope.employee.emerContactPerson}</textarea>
					</li>				
					<li>
						<label>&nbsp;</label>
						<input name="" type="button" class="btn" value="确认保存" />
					</li>
			</ul>
</form>

		</div>

	</body>

</html>