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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div>
    <h1>
        Sandwich Condiment
    </h1>
</div>
<form action="/add" method="post">
    <table class="table">
        <div>
            <th>
                <input type="checkbox" value="Lettuce" name="condiment"> Lettuce
            </th>
            <th>
                <input type="checkbox" value="Tomato" name="condiment"> Tomato
            </th>

            <th>
                <input type="checkbox" value="Mustard" name="condiment"> Mustard
            </th>
            <th>
                <input type="checkbox" value="Sprouts" name="condiment"> Sprouts
            </th>
            <th>
                <input type="checkbox" value="Cucumber" name="condiment"> Cucumber
            </th>
        </div>
    </table>
    <div>
        <input type="submit" value="Add condiment">
    </div>
</form>

<div>
    ${listCondiment}
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>

</html>
