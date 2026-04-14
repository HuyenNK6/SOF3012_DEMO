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
<h2>Thong tin</h2>
Id: <input type="text" name="id" value="${bacSi.id}"> <br>
Ten: <input type="text" name="ten" value="${bacSi.ten}"> <br>
Dia chi: <input type="text" name="diaChi"  value="${bacSi.diaChi}"> <br>
Luong: <input type="text" name="luong"  value="${bacSi.luong}"> <br>
Phong kham:
<select name="phongKham">
    <c:forEach items="${listPhongKham}" var="pk">
        <option value="${pk.id}" label="${pk.ten}" ${bacSi.phongKham.id == pk.id ? "selected" : ""}></option>
    </c:forEach>
</select> <br>
</body>
</html>
