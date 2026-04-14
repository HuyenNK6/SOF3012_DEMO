<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 4/14/2026
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Thông tin chi tiết</h2>
    <form action="/san-pham/add" method="post">
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
        <button type="submit">THÊM MỚI</button>
    </form>
    <%--------------------------------------------------%>
    <h2>Bảng Sản Phẩm</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Mô tả</th>
                <th>Website</th>
                <th>Giá bán</th>
                <th>Số lượng</th>
                <th>Loại sản phẩm</th>
                <th>Trạng thái</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lstSanPham}" var="sp">
                <tr>
                    <td>${sp.id}</td>
                    <td>${sp.ma}</td>
                    <td>${sp.ten}</td>
                    <td>${sp.moTa}</td>
                    <td>${sp.website}</td>
                    <td>${sp.giaBan}</td>
                    <td>${sp.soLuong}</td>
                    <td>${sp.loaiSanPham.ten}</td>
                    <td>${sp.trangThai}</td>
                    <td>
                        <a href="/san-pham/detail?id=${sp.id}">Detail</a>
                        <a href="/san-pham/view-update?id=${sp.id}">Update</a>
                        <a href="/san-pham/delete?id=${sp.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
