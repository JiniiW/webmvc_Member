<%--
  Created by IntelliJ IDEA.
  User: jinii
  Date: 3/10/24
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Member</title>
</head>
<body>
<h1>Member List</h1>
<table border="1">
    <thead>
    <tr>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>가입일</th>
<%--        수정, 삭제 추가 구현 필요--%>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dto" items="${dtoList}">
        <tr>
            <td>${dto.id}</td>
            <td>${dto.password}</td>
            <td>${dto.name}</td>
            <td>${dto.email}</td>
            <td>${dto.join_date}</td>
<%--            수정, 삭제 추가구현 필요--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
