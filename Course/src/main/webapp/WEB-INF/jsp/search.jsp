<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Search Results</title>
</head>
<body>
    <h1>Search Results</h1>
    <c:forEach var="product" items="${products}">
        <p>${product.name} - ${product.price} $</p>
    </c:forEach>
    <a href="catalog">Back to Catalog</a>
</body>
</html>
