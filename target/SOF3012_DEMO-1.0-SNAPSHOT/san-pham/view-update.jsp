<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 4/14/2026
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/san-pham/update" method="post">
        <b>ID: </b><input type="text" name="id" value="${sanPham.id}"><br>
        <b>Mã: </b><input type="text" name="ma" value="${sanPham.ma}"><br>
        <b>Tên: </b><input type="text" name="ten" value="${sanPham.ten}"><br>
        <b>Mô tả: </b><input type="text" name="moTa" value="${sanPham.moTa}"><br>
        <b>Website: </b><input type="text" name="website" value="${sanPham.website}"><br>
        <b>Giá bán: </b><input type="text" name="giaBan" value="${sanPham.giaBan}"><br>
        <b>Số lượng: </b><input type="text" name="soLuong" value="${sanPham.soLuong}"><br>
        <b>Loại sản phẩm: </b>
<%--        <input type="text" name="loaiSanPham" value="${sanPham.loaiSanPham}">--%>
        <select name="loaiSanPham">
            <c:forEach items="${lstLoaiSP}" var="loai">
                <option value="${loai.id}" label="${loai.ten}" ${sanPham.loaiSanPham.id== loai.id ? "selected":""}></option>
            </c:forEach>
        </select>
        <br>
        <b>Trạng thái: </b><input type="text" name="trangThai" value="${sanPham.trangThai}">
        <button type="submit">SỬA</button>
    </form>
</body>
</html>
