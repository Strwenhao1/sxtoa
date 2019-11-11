<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script>
        function addDuty() {
            $.ajax({
                type:"post",
                url:"dutyController?method=findTodyDuty",

                success:function (msg) {
                    if(msg=='1'){
                        alert("签到失败，请勿重复签到")
                    }else {
                        alert("签到成功")
                    }
                }
            })
        }
        function updateDute() {
            $.ajax({
                type:"post",
                url:"dutyController?method=updateDuty",
                success:function (msg) {
                    if(msg=='1'){
                        alert("签退失败，请先签到")
                    }else{
                        alert("签退成功")
                    }
                }
            })
        }
    </script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">考勤管理</a></li>
    <li><a href="#">签到签退</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    	<li><label>&nbsp;</label><input name="addDuty" type="button" class="btn" onclick="addDuty()" value="签到"/> 每天签到一次，不可重复签到</li>
        <li><label>&nbsp;</label></li>
    	<li><label>&nbsp;</label></li>
      	<li><label>&nbsp;</label><input name="" type="button" class="btn" onclick="updateDute()" value="签退"/>可重复签退，以最后一次签退为准</li>
    </ul>
    
    
    </div>


</body>

</html>
