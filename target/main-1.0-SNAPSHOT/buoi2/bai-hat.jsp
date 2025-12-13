<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 10/12/25
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/song-management/add" method="POST">
    Ten bai hat: <input type="text" name="tenBaiHat" value="${baiHat.tenBaiHat}"/> <br/>
    Gia: <input type="text" name="gia" value="${baiHat.gia}"/> <br/>
    Thoi luong: <input type="text" name="thoiLuong" value="${baiHat.thoiLuong}"/> <br/>
        Ngay ra mat: <input type="text" name="ngayRaMat1" value="${baiHat.ngayRaMat}"/> <br/>
    <button type="submit">Add</button>
</form>
<select>
    <c:forEach items="${listCaSi}" var="caSi">
        <option value="${caSi.id}">${caSi.tenCaSi}</option>
    </c:forEach>
</select>
<table cellspacing="0" cellpadding="10" border="1">
    <thead>
    <tr>
        <th>STT</th>
        <th>Tên bài hát</th>
        <th>Giá</th>
        <th>Thời lượng</th>
        <th>Ngày ra mắt</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listBaiHat}" var="bh" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${bh.tenBaiHat}</td>
            <td>${bh.gia}</td>
            <td>${bh.thoiLuong}</td>
            <td>${bh.ngayRaMat}</td>
            <td>
                <button>
                    <a href="/song-management/detail?id1=${bh.id}">Detail</a>
                </button>
                <button>
                    <a href="/song-management/remove?id2=${bh.id}">Remove</a>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
