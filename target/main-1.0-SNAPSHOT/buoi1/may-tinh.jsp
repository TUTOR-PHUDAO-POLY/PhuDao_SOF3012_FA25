<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <thead>
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Bộ nhớ</th>
            <th>Giá</th>
            <th>Màu sắc</th>
            <th>Miêu tả</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${lists}" var="mt" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${mt.id}</td>
                <td>${mt.ten}</td>
                <td>${mt.boNho}</td>
                <td>${mt.gia}</td>
                <td>${mt.mauSac}</td>
                <td>${mt.mieuTa}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
