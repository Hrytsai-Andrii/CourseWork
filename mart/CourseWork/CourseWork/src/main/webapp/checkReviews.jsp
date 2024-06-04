<%@ page import="java.util.UUID" %>
<%@ page import="com.coursework.coursework.DAOs.TendersDAO" %>
<%@ page import="com.coursework.coursework.ServiceLayer.Tender" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Відгуки на тендер</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #222;
            color: #ddd;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #333;
            border-radius: 8px;
        }
        .header a {
            color: #fff;
            text-decoration: none;
            padding: 10px 20px;
            background-color: #444;
            border-radius: 5px;
            transition: background-color 0.3s;
            display: inline-block;
            margin-bottom: 10px;
        }
        .header a:hover {
            background-color: #555;
        }
        .tender {
            padding: 10px;
            border: 1px solid #555;
            border-radius: 5px;
            margin-bottom: 20px;
            background-color: #444;
        }
        .review {
            margin-left: 20px;
            padding: 5px;
            border-left: 2px solid #555;
            background-color: #555;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            margin-top: 10px;
            background-color: #008CBA;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .button:hover {
            background-color: #005f7f;
        }
    </style>
</head>
<body>
<%
    String id = request.getParameter("id");

    if (id != null && !id.isEmpty()) {
        UUID tenderId = UUID.fromString(request.getParameter("id"));
        TendersDAO tendersDAO = (TendersDAO) request.getServletContext().getAttribute("tendersDataBase");
        Tender tender = tendersDAO.getTenderById(tenderId);

        if (tender == null) {
            response.sendError(500, "Тендер за таким id не знайдено");
        } else {
            request.setAttribute("tender", tender);
        }
    } else {
        response.sendError(500, "Id тендеру відсутнє");
        return;
    }
%>

<div class="container">
    <h1>Відгуки на тендер "${tender.name}"</h1>

    <c:if test="${empty tender.tenderReviews}">
        <h2>У вас поки немає відгуків</h2>
    </c:if>
    <div class="tender">
        <c:if test="${not empty tender.tenderReviews}">
            <c:forEach var="review" items="${tender.tenderReviews}">
                <div class="review">
                    <p>Назва компанії: ${review.companyName}</p>
                    <p>${review.review}</p>
                    <p>Номер телефону: ${review.phoneNumber}</p>
                </div>
            </c:forEach>
        </c:if>
    </div>
    <a href="userAccount.jsp" class="button">Повернутися назад</a>
</div>
</body>
</html>


