<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>审核报销单</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="js/jquery.js"></script>

        <script type="text/javascript">
			function submitForm(){
			    var serialize = $("form").serialize();
			    console.log(serialize)
                $.ajax({
                    type:"post",
                    data:serialize,
                    url:"auditingController?method=addAuditing",
                    success:function (msg) {
                        alert("审核完成"+msg)
						window.close()
                    }
                })
				
			}
			
		</script>

	</head>

	<body>

		<div class="formtitle"><span>审核报销单</span></div>
		<form >
			<ul class="forminfo">
				<input type="hidden" value="${param.expid}" name="expid">
				<li>
					<label>审核结果</label>
					<input value="2" name="result" type="radio" />通过
					<input value="3" name="result" type="radio" />拒绝
					<input value="4"  name="result" type="radio"/>打回
				</li>
				<li>
					<label>审核意见</label>
					<input name="auditdesc" type="text" class="dfinput" />
				</li>
				<li>
					<label>&nbsp;</label>
					<input onclick="submitForm()" type="button" class="btn" value="确认保存" />
				</li>
			</ul>
		</form>
	</body>

</html>