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
		<script type="text/javascript">
			$(function(){
				$.ajax({
					type:"post",
					dataType:"json",
					url:"expenseController",
					data:"method=findAllExpense",
					success:function (msg) {
						console.log(msg)
						$("#mbody").empty()
						for (var expense in msg){
							var p = "\t\t\t\t\t<tr>\n" +
									"\t\t\t\t\t\t<td>\n" +
									"\t\t\t\t\t\t\t<input name=\"\" type=\"checkbox\" value=\"\" />\n" +
									"\t\t\t\t\t\t</td>\n" +
									"\t\t\t\t\t\t<td>"+msg[expense].realname+"</td>\n" +
									"\t\t\t\t\t\t<td>"+msg[expense].totalamount+"</td>\n" +
									"\t\t\t\t\t\t<td>"+msg[expense].exptime+"</td>\n" +
									"\t\t\t\t\t\t<td>"+msg[expense].expdesc+"</td>\n" +
									"\t\t\t\t\t\t<td><a href=\"expenseController?method=findByCondition&expid="+msg[expense].expid+"\" class=\"tablelink\"> 查看具体报销项</a></td>\n" +
									"\t\t\t\t\t\t<td> <a href=\"expenseImg.html\" class=\"tablelink\">查看所附图片</a></td>\n"
							if (msg[expense].nextauditor=='${sessionScope.employee.empId}'&&msg[expense].status<5){
								p+="\t\t\t\t\t\t<td><a href=\"javascript:open('audit.jsp?expid="+msg[expense].expid+"','','width=500,height=230,left=300,top=300,location=0,scrollbars=0,resizable=0')\" class=\"tablelink\">审核</a>  <a href=\"auditHistory.html\" class=\"tablelink\">查看审核记录</a></td>\n" +
										"\t\t\t\t\t</tr>"
							}else {
								p+="\t\t\t\t\t\t<td><a href=\"javascript:open('audit.jsp','','width=500,height=230,left=300,top=300,location=0,scrollbars=0,resizable=0')\" class=\"tablelink\"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"auditHistory.html\" onclick='searchFor("+msg[expense].expid+")' class=\"tablelink\">查看审核记录</a></td>\n"+
								"\t\t\t\t\t</tr>"

							}
							$("#mbody").append(p)

						}
					}
				})


			})

			function searchFor(expid) {
				sessionStorage.setItem("expid", expid)
				// localStorage.setItem("expid",expid)
			}
		</script>

	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">报销管理</a></li>
				<li><a href="#">待审报销</a></li>
			</ul>
		</div>

		<div class="rightinfo">

			<div class="formtitle1"><span>待审报销</span></div>

			<table class="tablelist">
				<thead>
					<tr>
						<th>
							<input name="" type="checkbox" value="" checked="checked" />
						</th>
						<th>报销人<i class="sort"><img src="images/px.gif" /></i></th>
						<th>报销总额</th>
						<th>报销时间</th>
						<th>总备注信息</th>
						<th>查看具体报销项</th>
						<th>查看所附图片</th>
						<th>审核</th>
					</tr>
				</thead>
				<tbody id="mbody">

				</tbody>
			</table>

		</div>

		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>

	</body>

</html>