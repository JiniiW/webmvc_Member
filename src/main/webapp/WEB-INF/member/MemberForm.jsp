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

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 16px;
            box-sizing: border-box;
            border: none;
            border-bottom: 2px solid #007bff;
            outline: none;
            margin-top: 10px;
        }

        button {
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 20px;
        }

        button[type="reset"] {
            background-color: #ccc;
            margin-right: 8px;
        }
    </style>
</head>
<body>
<h1>회원가입</h1>
<form action="/member/add" method="post">
<%--    <label for="id">아이디</label>--%>
    <input type="text" id="id" name="id" placeholder="아이디" required><br>

<%--    <label for="password">비밀번호</label>--%>
    <input type="password" id="password" name="password" placeholder="비밀번호" required><br>

<%--    <label for="name">이름</label>--%>
    <input type="text" id="name" name="name" placeholder="이름" required><br>

<%--    <label for="email">이메일</label>--%>
    <input type="email" id="email" name="email" placeholder="이메일" required><br>

    <button type="reset">초기화</button>
    <button type="submit">회원 가입</button>
</form>
</body>
</html>
