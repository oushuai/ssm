<%--
  Created by IntelliJ IDEA.
  User: Oushuai
  Date: 2020/3/2
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h3>传统文件上传</h3>
<form action="user/fileUpload" enctype="multipart/form-data" method="post">
    选择文件：<input type="file" name="upload" /> <br>
    <input type="submit" value="上传" />
</form>
<h3>springmvc文件上传</h3>
<form action="user/fileUpload1" enctype="multipart/form-data" method="post">
    选择文件：<input type="file" name="upload" /> <br>
    <input type="submit" value="上传" />
</form>
<h3>跨服务器文件上传</h3>
<%--改jms和httpport9090 1090端口一般用explode，改jre和on update action-redeploy--%>
<form action="user/fileUpload2" enctype="multipart/form-data" method="post">
    选择文件：<input type="file" name="upload" /> <br>
    <input type="submit" value="上传" />
</form>
</body>
</html>
