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
			function searchFor(expid) {
				sessionStorage.setItem("expid", expid)
				// localStorage.setItem("expid",expid)
			}
		</script>


		<script>
			$(function () {
				$.ajax({
					type:"post",
					dataType:"json",
					url:"expenseController?method=findMyExpense",
					success:function (msg) {
						$("#mbody").empty()
						for (var expense in msg) {
							$("#mbody").append("<tr>\n" +
									"\t\t\t\t\t\t<td>\n" +
									"\t\t\t\t\t\t\t<input name=\"\" type=\"checkbox\" value=\"\" />\n" +
									"\t\t\t\t\t\t</td>\n" +
									"\t\t\t\t\t\t<td>"+msg[expense].expid+"</td>\n" +
									"\t\t\t\t\t\t<td>"+msg[expense].totalamount+"</td>\n" +
									"\t\t\t\t\t\t<td>"+msg[expense].exptime+"</td>\n" +
									"\t\t\t\t\t\t<td>"+msg[expense].expdesc+"</td>\n" +
									"\t\t\t\t\t\t<td><a href=\"expenseController?method=findByCondition&expid="+msg[expense].expid+"\" class=\"tablelink\"> 查看具体报销项</a></td>\n" +
									"\t\t\t\t\t\t<td> <a href=\"expenseImg.html\" class=\"tablelink\">查看所附图片</a></td>\n" +
									"\t\t\t\t\t\t<td>"+msg[expense].lastresult+"</td>\n" +
							"\t\t\t\t\t\t<td><a href=\"auditHistory.html\" onclick='searchFor("+msg[expense].expid+")' class=\"tablelink\">查看审核记录</a> </td>\n" +
							"\t\t\t\t\t</tr>"
						)
						}
					}
				})
			})
		</script>
	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">报销管理</a></li>
				<li><a href="#">我的报销</a></li>
			</ul>
		</div>

		<div class="rightinfo">

			<div class="formtitle1"><span>我的报销</span></div>

			<table class="tablelist">
				<thead>
					<tr>
						<th>
							<input name="" type="checkbox" value="" checked="checked" />
						</th>
						<th>编号</th>
						<th>报销总额</th>
						<th>报销时间</th>
						<th>总备注信息</th>
						<th>查看具体报销项</th>
						<th>查看所附图片</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="mbody">
<%--					<tr>--%>
<%--						<td>--%>
<%--							<input name="" type="checkbox" value="" />--%>
<%--						</td>--%>
<%--						<td>1</td>--%>
<%--						<td>5000</td>--%>
<%--						<td>2018-4-20</td>--%>
<%--						<td>院校支持到武汉</td>--%>
<%--						<td><a href="expenseDetail.html" class="tablelink"> 查看具体报销项</a></td>--%>
<%--						<td> <a href="expenseImg.html" class="tablelink">查看所附图片</a></td>--%>
<%--						<td>审核通过</td>--%>
<%--						<td><a href="#" class="tablelink">查看审核记录</a> </td>--%>
<%--					</tr>--%>

<%--					<tr>--%>
<%--						<td>--%>
<%--							<input name="" type="checkbox" value="" />--%>
<%--						</td>--%>
<%--						<td>2</td>--%>
<%--						<td>2000</td>--%>
<%--						<td>2018-04-23</td>--%>
<%--						<td>百战杯奖金</td>--%>
<%--						<td><a href="expenseDetail.html" class="tablelink"> 查看具体报销项</a></td>--%>
<%--						<td> <a href="expenseImg.html" class="tablelink">查看所附图片</a></td>--%>
<%--						<td>审核驳回</td>--%>
<%--						<td><a href="#" class="tablelink">删除</a> <a href="auditHistory.html" class="tablelink">查看审核记录</a>  </td>--%>
<%--					</tr>--%>

<%--					<tr>--%>
<%--						<td>--%>
<%--							<input name="" type="checkbox" value="" />--%>
<%--						</td>--%>
<%--						<td>3</td>--%>
<%--						<td>8000</td>--%>
<%--						<td>2018-4-25</td>--%>
<%--						<td>4月份水费支出</td>--%>
<%--						<td><a href="expenseDetail.html" class="tablelink"> 查看具体报销项</a></td>--%>
<%--						<td> <a href="expenseImg.html" class="tablelink">查看所附图片</a></td>--%>
<%--						<td> 未审核</td>--%>
<%--						<td><a href="#" class="tablelink">删除</a></td>--%>
<%--					</tr>--%>
				</tbody>
			</table>
 			<div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
		</div>

		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>

	</body>

</html>