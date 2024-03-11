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
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 16px;
            box-sizing: border-box;
            border: none;
            border-bottom: 2px solid #007bff;
            outline: none;
        }

        button {
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button[type="submit"] {
            margin-top: 16px;
        }

    </style>
</head>
<body>

<c:if test="${param.result == 'error'}">
    <script>
        alert("아이디 비밀번호가 옳지 않습니다.");
    </script>
</c:if>

<form action="/login" method="post">
    <input type="text" name="id" placeholder="ID"/>
    <input type="text" name="password" placeholder="PASSWORD"/>
    <button type="submit">LOGIN</button>
</form>
</body>
</html>

