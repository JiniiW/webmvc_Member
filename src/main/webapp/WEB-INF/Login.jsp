<%--
  Created by IntelliJ IDEA.
  User: jinii
  Date: 3/11/24
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<c:if test="${param.result == 'error'}">
    <span style="color:red"><h1>옳지 않습니다.</h1></span>
</c:if>
<form action="/login" method="post">
    <input type="text" name="id"/>
    <input type="text" name="password"/>
    <button type="submit">LOGIN</button>
</form>
</body>
</html>

