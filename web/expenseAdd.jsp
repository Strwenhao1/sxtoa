<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" scope="page"/>
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
    <script type="text/javascript">
        $(document).ready(function (e) {
            $(".select1").uedSelect({
                width: 345
            });

        });
    </script>
    <script type="text/javascript">
        function addPhoto() {
            //获取上传图片li
            var li = $("#uploadphoto");
            //console.info(li);
            //准备添加的dom对象
            var content = $("<span>" +
                "<label>&nbsp;</label>" +
                "<input name='photo' type='file' class='dfinput' />" +
                "<i></i>" +
                "<input type='button'   class='btn'  value='删除' onclick='removeCurrSpan(this)'/>" +
                "</span>");
            //加入到指定位置
            li.append(content);
        }

        function removeCurrSpan(obj) {
            $(obj).parent().remove();

        }

        function addExpenseItem(id) {
            //获取上级标签
            var table = $(id);

            //创建当前标签
            var content = $('<tr>' +
                '<td>' +
                '<div class="vocation">' +
                '<select name="type" class="select1">' +
                '<option value="1">通信费用</option>' +
                '<option value="2">办公室耗材</option>' +
                '<option value="3">住宿费用</option>' +
                '<option value="4">房租水电</option>' +
                '<option value="5">其它</option>' +
                '</select>' +
                '</div>' +
                '</td>' +
                '<td><input name="amount" type="text" class="dfinput" /><i></i></td>' +
                '<td><input name="itemdesc" type="text" class="dfinput" /><i></i></td>' +
                '<td><input type="button"  class="btn"  value="删除" onclick="removeCurrItem(this)"/></td></tr>');

            //加入上级标签
            table.append(content);
            $(".select1").uedSelect({
                width: 345
            });
        }

        function removeCurrItem(obj) {
            $(obj).parent().parent().remove();

        }
    </script>

    <script>
        $(function () {
            $.ajax({
                type: "post",
                dataType: "json",
                url: "expenseController?method=findMgr",
                success: function (msg) {
                    $("#mgrs").empty()
                    for (var emp in msg) {
                        $("#mgrs").append("\t<option value='" + msg[emp].empId + "'>" + msg[emp].realName + "</option>")
                    }
                    console.log(msg)
                }
            })
        })
    </script>

    <script>
        function upto() {
            $.ajax({
                type: "post",
                data:$("form").serialize(),
                url: "expenseController?method=addExpense",
                success: function (msg) {
                        alert("添加成功")
                    window.location.href="myExpense.jsp"
                }
            })
        }
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">报销管理</a></li>
        <li><a href="#">添加报销</a></li>
    </ul>
</div>

<div class="formbody">
    <form>

        <div class="formtitle"><span>基本信息</span></div>

        <ul class="forminfo">
            <li>
                <label>报销人</label>
                <input name="" type="text" class="dfinput" value="${sessionScope.employee.realName}"/><i></i></li>
            <li>
            <li>
                <label>报销总额</label>
                <input name="totalAmount" type="text" class="dfinput"/><i></i></li>
            <li>
                <label>报销时间</label>

                <input name="" type="text" class="dfinput"
                       value="<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />"/><i></i></li>
            <li>
            <li>
                <label>具体报销项</label>
                <input type="button" class="btn" value="添加报销项" onclick="addExpenseItem('#table1')"/>

                <table border="" cellspacing="" cellpadding="" width="70%" id="table1">
                    <tr>
                        <td>报销类型</td>
                        <td>报销费用</td>
                        <td>费用说明</td>
                    </tr>
                    <tr>
                        <td>
                            <div class="vocation">
                                <select name="type" class="select1">
                                    <option value="1">通信费用</option>
                                    <option value="2">办公室耗材</option>
                                    <option value="3">住宿费用</option>
                                    <option value="4">房租水电</option>
                                    <option value="5">其他</option>
                                </select>
                            </div>
                        </td>
                        <td><input name="amount" type="text" class="dfinput"/><i></i></td>
                        <td><input name="itemdesc" type="text" class="dfinput"/><i></i></td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </li>
            <li>

            </li>
            <li id="uploadphoto">
                <label>上传报销图片</label>
                <span>
								<input name="photo" type="file" class="dfinput"/><i></i>
								<input type="button" class="btn" value="添加图片" onclick="addPhoto()"/>
							</span>
            </li>
            <li>
                <label>审批人<b>*</b></label>
                <div class="vocation">
                    <select name="nextauditor" id="mgrs" class="select1">

                    </select>
                </div>
                &nbsp;&nbsp;
                <input name="" type="text" class="dfinput" placeholder="也可以在此输入首字母帮助显示"/>
            </li>
            </li>
            <li>
                <label>总备注信息</label>
                <textarea name="expdesc" cols="" rows="" class="textinput"></textarea>
            </li>
            <li>
                <label>&nbsp;</label>
                <input name="" onclick="upto()" type="button" class="btn" value="确认保存"/>
            </li>
        </ul>
    </form>

</div>

</body>

</html>