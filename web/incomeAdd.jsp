<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/select.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    <script type="text/javascript" src="editor/kindeditor.js"></script>
    <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>

    <script type="text/javascript">
        $(document).ready(function (e) {
            $(".select1").uedSelect({
                width: 345
            });

        });
    </script>
    <script type="text/javascript">
      function addIncome() {
          $.ajax({
              type:"post",
              url:"incomeController?method=addIncome",
              data:$("form").serialize(),
              success:function (msg) {
                  console.log(msg)
              }
          })
      }
    </script>
    <script type="text/javascript">

    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">收支管理</a></li>
        <li><a href="#">添加收入</a></li>
    </ul>
</div>
<form>

    <div class="formbody">

        <div class="formtitle"><span>基本信息</span></div>

        <ul class="forminfo">
            <li>
                <label>所属部门<b>*</b></label>
                <div class="vocation">
                    <select name="deptno" class="select1">
                        <c:forEach items="${depts}" var="dept">
                            <option value="${dept.deptno}">${dept.deptname}</option>
                        </c:forEach>
<%--                        <option value="4">教务部</option>--%>
<%--                        <option value="2">教学部</option>--%>
<%--                        <option value="3">咨询部</option>--%>
                    </select>
                </div>

            </li>
            <li>
                <label>收入金额</label>
                <input name="amount" type="text" class="dfinput"/><i></i></li>
            <li>
                <label>收入类型</label>
                <cite>
                    <input name="ictype" type="radio" value="人员外包" checked="checked"/>人员外包&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="ictype" type="radio" value="项目开发"/>项目开发&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="ictype" type="radio" value="报名费"/>报名费&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="ictype" type="radio" value="学费"/>学费&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="ictype" type="radio" value="认证考试"/>认证考试&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="ictype" type="radio" value="线上授课"/>线上授课
                    <input name="ictype" type="radio" value="其它"/>其它
                </cite>
            </li>
            <li>
                <label>收入日期</label>
                <input onfocus="WdatePicker({skin:'whyGreen',lang:'en'})" name="icdate" type="text" class="dfinput"/>
            </li>
            <li>
                <label>备注</label>
                <textarea name="indesc" cols="" rows="" class="textinput"></textarea>
            </li>
            <li>
                <label>&nbsp;</label>
                <input onclick="addIncome()" name="" type="button" class="btn" value="确认保存"/>
            </li>
        </ul>

    </div>
</form>

</body>

</html>