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
<h3>Выберите пиццу:</h3>
<form class="requestForm" method="post" action="${pageContext.request.contextPath}/order">
    <%List<String> types = (List<String>) request.getAttribute("pizzaTypes");%>
    <%System.out.println(types);%>
    <select name="type">

    </select>
<%--    <select class="requestInput" name="type">--%>
<%--         <%for (String type: types) {%>--%>
<%--        <option><%=type%></option>--%>
<%--        <%}%>--%>
<%--    </select>--%>
    <input type="submit" class="requestButton" value="Оформить">
</form>
<br/>
<script src="test.js"> </script>

</body>
</html>