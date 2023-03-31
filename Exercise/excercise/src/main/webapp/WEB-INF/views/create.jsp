<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail Soccer Player</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<style>
    img {
        width: 69px;
        height: 69px;
    }
    **table{
        border-collapse: collapse;
        border-color: #0a58ca;
    }
</style>
<form:form action="/soccer-player/create" method="post" modelAttribute="soccerPlayer">
    <label>Mã cầu thủ</label>
    <form:input path="code" type="text"/><br>
    <label>Tên cầu thủ</label>
    <form:input path="name" type="text"/><br>
    <label>Ngày sinh</label>
    <form:input path="dateOfBirthday" type="text"/><br>
    <label>Kinh nghiệm</label>
    <form:input path="exp" type="text"/><br>
    <label>Vị trí</label>
    <form:input path="location" type="text"/><br>
    <label>Ảnh đại diện</label>
    <form:input path="img" type="text"/><br>
    <button type="submit">Thêm mới</button>
</form:form>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
        crossorigin="anonymous"></script>

</html>
