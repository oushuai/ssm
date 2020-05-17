<%--
  Created by IntelliJ IDEA.
  User: Oushuai
  Date: 2020/3/6
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/findAll">testSpringMVC</a>
<form action="account/save" method="post">
   金额： <input type="text" name="money">
    姓名：<input type="text" name="name">
    <button onclick="function x() {
      alert('保存成功');
    }" value="提交"></button>
</form>

</body>
</html>
