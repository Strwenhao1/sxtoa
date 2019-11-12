<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>

		<script type="text/javascript">
			$(document).ready(function() {
				$(".click").click(function() {
					$(".tip").fadeIn(200);
				});
				$(".tiptop a").click(function() {
					$(".tip").fadeOut(200);
				});
				$(".sure").click(function() {
					$(".tip").fadeOut(100);
				});
				$(".cancel").click(function() {
					$(".tip").fadeOut(100);
				});
			});
		</script>

	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">报销管理</a></li>
				<li><a href="#">查看具体报销项</a></li>
			</ul>
		</div>

		<div class="rightinfo">

			<div class="formtitle1"><span>具体报销项</span></div>

			<table class="tablelist">
				<thead>
					<tr>
						<th>
							<input name="" type="checkbox" value="" checked="checked" />
						</th>
						<th>报销项编号<i class="sort"><img src="images/px.gif" /></i></th>
						<th>报销项类型</th>
						<th>报销项金额</th>
						<th>报销项说明</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${expenses}" var="ex">
					<tr>
						<td>
							<input name="" type="checkbox" value="" />
						</td>
						<td>${ex.itemid}</td>
						<td>
							<c:if test="${ex.type==1}">通信费用</c:if>
							<c:if test="${ex.type==2}">办公室耗材</c:if>
							<c:if test="${ex.type==3}">住宿费用</c:if>
							<c:if test="${ex.type==4}">房租水电</c:if>
							<c:if test="${ex.type==5}">其他</c:if>

						</td>
						<td>${ex.amount}</td>
						<td>${ex.itemdesc}</td>
					
					</tr>
				</c:forEach>
<%--				<option value="1">通信费用</option>--%>
<%--				<option value="2">办公室耗材</option>--%>
<%--				<option value="3">住宿费用</option>--%>
<%--				<option value="4">房租水电</option>--%>
<%--				<option value="5">其他</option>--%>

				</tbody>
			</table>

		</div>

		<input id="back" name="" type="button" class="btn" value="返回" />

		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>
		<script>
			$("#back").click(function () {

			})
		</script>
	</body>

</html>