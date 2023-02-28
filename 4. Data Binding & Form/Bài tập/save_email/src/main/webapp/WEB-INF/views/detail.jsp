<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: K7
  Date: 2/28/2023
  Time: 4:39 PM
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
<table>
    <tr>
        <div class="form-group">
            <th>Languages:</th>
            <td>${emailBox.language}</td>
        </div>
    </tr>

    <tr>
        <div class="form-group">
            <th>Page Size:</th>
            <td>
                <span>Show</span>
                <span>${emailBox.pageSize}</span>
                <span>emails per size</span>
            </td>
        </div>
    </tr>

    <tr>
        <div class="form-group">
            <th>Spam filter:</th>
            <td>
          <span>
              <c:if test="${emailBox.spamsFilter}">
                  Enable spams filter
              </c:if>

              <c:if test="${!emailBox.spamsFilter}">
                  Disabled spams filter
              </c:if>

          </span>
            </td>
        </div>
    </tr>

    <tr>
        <div class="form-group">
            <th>Signature:</th>
            <td><span>${emailBox.signature}</span></td>
        </div>
    </tr>

    <tr>
        <th></th>
        <td><a href="/email-box" class="btn btn-secondary">Update</a></td>
    </tr>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
