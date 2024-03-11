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
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        h1 {
            color: #007bff;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        tbody tr:hover {
            background-color: white;
        }

        button {
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 30px;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }
    </style>
</head>
<body>
<h1>Member List</h1>
<table>
    <thead>
    <tr>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>가입일</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dto" items="${dtoList}">
        <tr>
            <td>${dto.id}</td>
            <td>${dto.password}</td>
            <td>${dto.name}</td>
            <td>${dto.email}</td>
            <td>${dto.joinDate}</td>
            <td><a href="/member/update?id=${dto.id}">수정</a></td>
            <td><a href="/member/delete?id=${dto.id}">삭제</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<button onclick="location.href='/member/add'">회원가입</button>
</body>
</html>
