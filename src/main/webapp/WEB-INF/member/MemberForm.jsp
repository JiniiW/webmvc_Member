<%--
  Created by IntelliJ IDEA.
  User: jinii
  Date: 3/10/24
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Register From</title>
</head>
<body>
<form action="/member/add" method="post">
    <label for="id">아이디:</label>
    <input type="text" id="id" name="id" required><br>

    <label for="password">비밀번호:</label>
    <input type="password" id="password" name="password" required><br>

    <label for="name">이름:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="email">이메일:</label>
    <input type="email" id="email" name="email" required><br>

    <button type="reset">초기화</button>
    <button type="submit">회원 가입</button>
</form>
</body>
</html>
