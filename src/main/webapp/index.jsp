<%@ page import="com.example.pizza.db.DbDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Заказ пиццы</title>
    <link rel="stylesheet" href="pizzaStyle.css">
</head>

<body>
<h1><%= "Заказ пиццы" %></h1>
    <p>
        <a href="${pageContext.request.contextPath}/pizza.jsp">Заказать пиццу</a>
    </p>

<br/>
<%--<script src="test.js"> </script>--%>

</body>
</html>