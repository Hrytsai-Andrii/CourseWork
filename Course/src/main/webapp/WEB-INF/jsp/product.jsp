<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Digital Catalog - ${product.name}</title>
</head>
<body>
    <h1>${product.name}</h1>
    <form action="search" method="get">
        <input type="text" name="name" placeholder="Search...">
        <button type="submit">Search</button>
    </form>
    <c:if test="${sessionScope.user != null}">
        <p>Hello, ${sessionScope.user.name}!</p>
        <form action="auth" method="post">
            <button type="submit">Logout</button>
        </form>
        <a href="admin?action=editProduct&productId=${product.id}">Edit Product</a>
        <a href="admin?action=deleteProduct&productId=${product.id}">Delete Product</a>
    </c:if>
    <c:if test="${sessionScope.user == null}">
        <form action="auth" method="post">
            <input type="text" name="name" placeholder="Username">
            <input type="password" name="password" placeholder="Password">
            <button type="submit">Login</button>
        </form>
        <a href="register">Register</a>
    </c:if>
    <img src="images/${product.image}" alt="${product.name}">
    <p>${product.description}</p>
    <p>${product.price} $</p>
    <form action="cart" method="post">
        <input type="hidden" name="productId" value="${product.id}">
        <button type="submit">Add to Cart</button>
    </form>
    <a href="catalog?id=${product.category.id}">Back to Category</a>
</body>
</html>
