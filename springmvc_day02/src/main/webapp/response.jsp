<%--
  Created by IntelliJ IDEA.
  User: Oushuai
  Date: 2020/3/2
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载，绑定单机事件
        $(function () {
            $("#btn").click(function () {
                 alert("hello btn");
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"欧阳杰","password":"234","age":23}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                    alert(data);
                    alert(data.username);
                    alert(data.password);
                    }
                });
            });
        });
    </script>
</head>
<body>
<button id="btn">发送ajax请求</button>
</body>
</html>