<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 4/6/2026
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Them</h2>
<form action="/phong-kham/search" method="get">
    Ten: <input type="text" name="ten"> <br>
    <button type="submit">Search</button>
</form>
<br>
Them phong kham:
<button>
    <a href="/phong-kham/view-add">Them phong kham</a>
</button>
<br>
Danh sach phong kham:
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Ten</th>
        <th>So nha</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhSach}" var="phongKham">
        <tr>
            <td>${phongKham.id}</td>
            <td>${phongKham.ten}</td>
            <td>${phongKham.soNha}</td>
            <td>
                <a href="/phong-kham/detail?id=${phongKham.id}">Detail</a>
                <a href="/phong-kham/delete?id=${phongKham.id}">Delete</a>
                <a href="/phong-kham/view-update?id=${phongKham.id}">View update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/phong-kham/paging?page=${pageNo-1}">Prev</a> <br>
<a href="/phong-kham/paging?page=${pageNo+1}">Next</a>
</body>
</html>
