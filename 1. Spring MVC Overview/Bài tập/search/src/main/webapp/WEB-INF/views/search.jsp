<%--
  Created by IntelliJ IDEA.
  User: K7
  Date: 2/24/2023
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thư viện tra cứu</title>
</head>
<body>
<form action="/search">
    <lable>Search</lable>
    <input type="text" name ="word">
    <input type="submit" value="Submit">
</form>
<h1>
    Kết quả: ${search}
</h1>
</body>
</html>
