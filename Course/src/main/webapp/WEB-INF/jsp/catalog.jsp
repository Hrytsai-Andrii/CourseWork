<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Digital Catalog - ${category.name}</title>
</head>
<body>
    <h1>${category.name}</h1>
     <form action="search" method="get">
        <input type="text" name="name" placeholder="Search...">
        <button type="submit">Search</button>
    </form>
    <c:if test="${sessionScope.user != null}">
        <p>Hello, ${sessionScope.user.name}!</p>
        <form action="auth" method="post">
        	<input type="hidden" name="command" value="logout">
            <button type="submit">Logout</button>
        </form>
        
		<p>Create new category</p>
        <form action="createCategory" method="post"> 
            <input type="text" name="name" value="${category.name}">
            <button type="submit">Create</button>
        </form>
    </c:if>
    <c:if test="${sessionScope.user == null}">
        <form action="auth" method="post">
            <input type="hidden" name="command" value="login">
            <input type="text" name="name" placeholder="Username">
            <input type="password" name="password" placeholder="Password">
            <button type="submit">Login</button>
        </form>
        <a href="register">Register</a>
    </c:if>
   
    <c:choose>
        <c:when test="${not empty categories.subcategories}">
            <h2>Subcategories</h2>
            <ul>
                <c:forEach var="subcategory" items="${categories.subcategories}">
                    <li><a href="catalog?id=${subcategory.id}">${subcategory.name}</a></li>
                    <c:if test="${sessionScope.user != null}">
                    	<form action="change" method=get>
                    		<input type="hidden" name="id" value="${subcategory.id}"></input>
                    		<button type="submit">Change</button>
                    	</form>
                    	<form action="change" method="post">
                        <input type="hidden" name="command" value="add">
                        <input type="hidden" name="id" value="${subcategory.id}">
                        <input type="text" name="name" value="">
                        <button type="submit">Add</button>
                    	</form>
                    	<form action="change" method="post">
                        <input type="hidden" name="command" value="addProduct">
                        <input type="hidden" name="id" value="${subcategory.id}">
                        <p>Name</p>
                        <input type="text" name="name" value="">
                        <p>Price</p>
                        <input type="text" name="price" value="">
                        <button type="submit">Add product</button>
                    	</form>
                    	<form action="deleteSub" method="post">
                    		<input type="hidden" name="id" value="${subcategory.id}">
                    		<input type="hidden" name="parent" value="${categories.id}">
                    		<button type="submit">Delete</button>
                    	</form>
                    </c:if>
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            <h2>Products</h2>
            <ul>
                <c:forEach var="product" items="${category.products}">
                    <li>${product.name} - ${product.price} $</li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
</body>
</html>
