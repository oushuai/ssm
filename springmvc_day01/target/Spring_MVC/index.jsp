<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Hello World!</h2>
<a href="user/hello">入门</a>
<a href="user/testMethod">method</a>
<a href="user/testParam?username=xiaoou">param</a>
<a href="user/testParam1?username=xiaoou&password=123456">动态参数绑定</a>
<form action="acount/save" method="post">
   用户名： <input type="text" name="username" /><br>
    密码:<input type="text" name="password" /><br>
    余额：<input type="text" name="money" /><br>
    姓名： <input type="text" name="user.name" /><br>
    年龄： <input type="text" name="user.age" /><br>
    性别： <input type="text" name="user.sex" /><br>
    <button type="submit">提交账号</button>
</form>
<form action="acount/save" method="post">
    用户名： <input type="text" name="username" /><br>
    密码:<input type="text" name="password" /><br>
    余额：<input type="text" name="money" /><br>

    姓名： <input type="text" name="user.name" /><br>
    年龄： <input type="text" name="user.age" /><br>
    性别： <input type="text" name="user.sex" /><br>
<%--如果是list<User>就是list[0].username,list[0].password--%>
    电话1： <input type="text" name="phoneNo[0]" /><br>
    电话2： <input type="text" name="phoneNo[1]" /><br>

    上级姓名： <input type="text" name="map['上级'].name" /><br>
    上级年龄： <input type="text" name="map['上级'].age" /><br>

    <button type="submit">提交map和list</button>
</form>
<form action="user/save" method="post">
    生日：<input type="text" name="date" /><br>
    姓名： <input type="text" name="name" /><br>
    年龄： <input type="text" name="age" /><br>
    性别： <input type="text" name="sex" /><br>
    <button type="submit">提交使用者</button>
</form>
<a href="user/testServlet">测试servlet</a>


</body>
</html>
