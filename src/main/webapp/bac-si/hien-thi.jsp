<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 4/6/2026
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Them bac si</h2>
<form action="/bac-si/add" method="post">
    Ten: <input type="text" name="ten"> <br>
    Dia chi: <input type="text" name="diaChi"> <br>
    Luong: <input type="text" name="luong"> <br>
    Phong kham:
    <select name="phongKham">
        <c:forEach items="${listPhongKham}" var="pk">
            <option value="${pk.id}" label="${pk.ten}"></option>
        </c:forEach>
    </select> <br>
    <button type="submit">Save</button>
</form>
<br>
<h2>Bang bac si</h2>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Ten</th>
        <th>Dia chi</th>
        <th>Luong</th>
        <th>Phong kham</th>
        <th>So nha phong kham</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listBacSi}" var="bs">
        <tr>
            <td>${bs.id}</td>
            <td>${bs.ten}</td>
            <td>${bs.diaChi}</td>
            <td>${bs.luong}</td>
            <td>${bs.phongKham.ten}</td>
            <td>${bs.phongKham.soNha}</td>
            <td>
                <a href="/bac-si/view-update?id=${bs.id}">Update</a>
                <a href="/bac-si/delete?id=${bs.id}">Xoa</a>
                <a href="/bac-si/detail?id=${bs.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
