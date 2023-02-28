<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: K7
  Date: 2/28/2023
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<div class="col-8">
<table>
    <form:form action="/email-box" modelAttribute="emailBox" method="post">

        <tr>
            <div class="form-group">
                <th><label for="language">Languages:</label></th>
                <td><form:select path="language" id="language" items="${languageList}"/></td>
            </div>
        </tr>

        <tr>
            <div class="form-group">
                <th><label for="pageSize">pageSize:</label></th>
                <td>
                    <span>show</span>
                    <form:select path="pageSize" id="pageSize" items="${pageSizeList}"/>
                    <span>emails per page</span>
                </td>
            </div>
        </tr>

        <tr>
            <div class="form-group">
                <th>
                    <label for="spamsFilter">Spams Filter:</label>
                </th>
                <td>
                    <form:checkbox path="spamsFilter" id="spamsFilter" items="spamsFilter"/>
                    <span>Enable spams filter</span>
                </td>
            </div>
        </tr>

        <tr>
            <div class="form-group">
                <th><label for="signature">Signature:</label></th>
                <td>
                    <form:textarea path="signature" id="signature" items="signature"/>
                </td>
            </div>
        </tr>
        <tr>
            <div class="form-group">
                <th></th>
                <td>
                    <button type="button" class="btn btn-primary">Cancel</button>
                    <button type="submit" class="btn  btn-secondary" onclick="window.location.href='/email-box'">
                        Update
                    </button>
                </td>
            </div>
        </tr>
    </form:form>
</table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
