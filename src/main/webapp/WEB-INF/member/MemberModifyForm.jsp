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

        label {
            display: block;
            margin-bottom: 8px;
            color: #333333;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        button {
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px;
        }

    </style>
</head>
<body>

<h1>${dto.id}님</h1>
<form action="/member/update" method="post">

    <input type="text" id="id" name="id" value="${dto.id}" readonly style="display: none;"><br>

    <label for="password">비밀번호</label>
    <input type="password" id="password" name="password" value="${dto.password}" required><br>

    <label for="name">이름</label>
    <input type="text" id="name" name="name" value="${dto.name}" required><br>

    <label for="email">이메일</label>
    <input type="email" id="email" name="email" value="${dto.email}" required><br>

    <button type="submit">수정하기</button>
</form>
</body>
</html>
