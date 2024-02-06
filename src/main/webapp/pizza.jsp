<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Елена
  Date: 05.02.2024
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заказ</title>
    <link rel="stylesheet" href="pizzaStyle.css">
</head>
<body>
<div class="container">
    <div class="modal">
<form class="requestForm" method="get" action="${pageContext.request.contextPath}/pizza">
    <%List<String> types = (List<String>) request.getAttribute("pizzaTypes");%>
    <%System.out.println("из jsp: " + types);%>

    </select>
        <select class="requestInput" name="type">
<%--             <%for (String type: types) {%>--%>
<%--            <option><%=type%></option>--%>
<%--            <%}%>--%>
    <option>margo</option>
        </select>
    <input type="submit" class="requestButton" value="Оформить">
</form>
    </div>
</div>

</body>
</html>
