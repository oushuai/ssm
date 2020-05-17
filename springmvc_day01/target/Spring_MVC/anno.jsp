<%--
  Created by IntelliJ IDEA.
  User: Oushuai
  Date: 2020/2/27
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="anno/testParam?username=xiaoou">带参数</a>
<br>
<form action="anno/testResponseBody" method="post">
    姓名： <input type="text" name="name" /><br>
    性别： <input type="text" name="sex" /><br>
    <button type="submit">提交responseBody</button>
</form>
<a href="anno/testPathVariable/1">restful风格</a>
<hr>
<a href="anno/testRequestHeader">testRequestHeader</a>
<hr>
<a href="anno/testCookieValue">testCookieValue</a>
<hr>
<a href="anno/testModelAttribute1">testModelAttribute</a>
<form action="anno/testModelAttribute1" method="post">
    姓名： <input type="text" name="name" /><br>
    性别： <input type="text" name="sex" /><br>
    <button type="submit">testModelAttribute1</button>
</form>
<form action="anno/testModelAttribute2" method="post">
    姓名： <input type="text" name="name" /><br>
    性别： <input type="text" name="sex" /><br>
    <button type="submit">testModelAttribute2</button>
</form>
<a href="anno/testSessionAttribute">testSessionAttribute</a>

<a href="anno/getSessionAttribute">getSessionAttribute</a>

<a href="anno/deleteSessionAttribute">deleteSessionAttribute</a>

</body>
</html>
