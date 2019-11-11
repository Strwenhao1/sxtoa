<%--
  Created by IntelliJ IDEA.
  User: 74000
  Date: 2019/11/9
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function test(msg) {
            console.log(msg.src)
            msg.src="random.jpg?a="+Math.random()
        }
    </script>
</head>
<body>
<img src="random.jpg" onclick="test(this)">
</body>

</html>
