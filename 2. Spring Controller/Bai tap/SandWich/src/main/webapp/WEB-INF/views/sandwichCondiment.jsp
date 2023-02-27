<%--
  Created by IntelliJ IDEA.
  User: K7
  Date: 2/27/2023
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiment</title>
</head>
<body>
<div>
    <h1>
        Sandwich Condiment
    </h1>
</div>
<div class="row">
    <form action="/add" method="post">

        <div>
            <input type="checkbox" value="Lettuce" name="condiment"> Lettuce
            <input type="checkbox" value="Tomato" name="condiment"> Tomato
            <input type="checkbox" value="Mustard" name="condiment"> Mustard
            <input type="checkbox" value="Sprouts" name="condiment"> Sprouts
            <input type="checkbox" value="Cucumber" name="condiment"> Cucumber
        </div>

        <div>
            <input type="submit" value="Add condiment">
        </div>
    </form>
</div>
<div>
    ${listCondiment}
</div>
</body>
</html>
