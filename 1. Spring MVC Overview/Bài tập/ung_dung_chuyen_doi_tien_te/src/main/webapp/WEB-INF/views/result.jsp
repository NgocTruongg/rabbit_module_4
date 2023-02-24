<%--
  Created by IntelliJ IDEA.
  User: K7
  Date: 2/24/2023
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/convert" >
    <input type="text" name="USD" value="${USD}">
    <button type="submit" value="Result">Result</button>
</form>

<h1>
    Result: ${VND}
</h1>
</body>
</html>
