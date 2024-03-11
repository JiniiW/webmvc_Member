<%--
  Created by IntelliJ IDEA.
  User: jinii
  Date: 3/11/24
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify Member Info</title>
</head>
<body>

<h1>${dto.id}님</h1>
<form action="/member/update" method="post">

    <label for="id">아이디:</label>
    <input type="text" id="id" name="id" value="${dto.id}" readonly><br>

    <label for="password">비밀번호:</label>
    <input type="password" id="password" name="password" value="${dto.password}" required><br>

    <label for="name">이름:</label>
    <input type="text" id="name" name="name" value="${dto.name}" required><br>

    <label for="email">이메일:</label>
    <input type="email" id="email" name="email" value="${dto.email}" required><br>

    <button type="reset">초기화</button>
    <button type="submit">수정하기</button>
</form>
</body>
</html>
