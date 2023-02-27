<%--
  Created by IntelliJ IDEA.
  User: K7
  Date: 2/27/2023
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
  <form action="/calculator">
    <div class="mb-4">
      <input type="number" name="firstNumber">
      <input type="number" name="secondNumber">
    </div>
    <br>
    <hr>
    <div>
      <input type="submit" value="Addition" name="calculation">
      <input type="submit" value="Subtraction" name="calculation">
      <input type="submit" value="Multiplication" name="calculation">
      <input type="submit" value="Division" name="calculation">
    </div>
    <br>
    <div>
      <p>
        Result:${calculationMessage}: ${result}
      <p style="color: red">
        ${message}
      </p>
      </p>
    </div>
  </form>
</div>
</body>
</html>
