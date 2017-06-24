<%--
  Created by IntelliJ IDEA.
  User: zhangyu
  Date: 2017/6/23
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>

<html>
<head>
    <title>用户登录</title>
</head>
<body>

<form action="loginServlet" method="post">
    <input type="text" name="name">
    <input type="submit" value="提交">
</form>
<div>上次展示的内容为：${name }</div>



</body>
</html>
