<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>List Soccer Player</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<style>
    img {
        width: 100px;
        height: 100px;
    }

</style>
<body>
<h1 class="text-center" style="color: red">
    Danh Sách Cầu Thủ Bóng Đá
</h1>
<a class="btn btn-success" style="margin-bottom: 10px" href="/soccer-player/create">
    Thêm mới cầu thủ</a>
<table class="table table-striped able-bordered table-hover">
    <tr>
        <th>Mã cầu thủ</th>
        <th>Họ Và Tên</th>
        <th>Ngày Sinh</th>
        <th>Kinh Nghiệm</th>
        <th>Vị Trí</th>
        <th>Ảnh Đại Diện</th>
        <th>Thông Tin Chi Tiết</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="soccerPlayer" items="${list}">
        <tr>
            <td>${soccerPlayer.code}</td>
            <td>${soccerPlayer.name}</td>
            <td>${soccerPlayer.dateOfBirthday}</td>
            <td>${soccerPlayer.exp}</td>
            <td>${soccerPlayer.location}</td>
            <td><img src="${soccerPlayer.img}"></td>
            <td><a href="/soccer-player/detail/${soccerPlayer.id}">Xem chi tiết</a></td>
            <td>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"
                        onclick="infoDelete(${soccerPlayer.id},'${soccerPlayer.name}')">
                    xóa
                </button>
            </td>
            <td><a href="/soccer-player/update/${soccerPlayer.id}" class="btn btn-primary">Sửa</a></td>
        </tr>
    </c:forEach>
</table>


<%--modal--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/soccer-player/delete">
                <div class="modal-body">
                    <input hidden type="text" id="idDelete" name="idDelete">
                    <span>You may want to delete </span><span style="color: red" class="fw-bolder"
                                                              id="nameDelete"></span> ?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-danger">Xóa</button>
                </div>
            </form>

        </div>
    </div>
</div>
<script>
    function infoDelete(id, name) {
        debugger
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerText = name;
    }
</script>
</body>
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
