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
<form class="requestForm" method="post" action="${pageContext.request.contextPath}/pizza">
    <%List<String> types = (List<String>) request.getAttribute("pizzaTypes");%>
    <%List<String> toppings = (List<String>) request.getAttribute("toppingTypes");%>

    <h3> Выберите пиццу:</h3>
        <select class="requestInput" name="pizza_name">
             <%for (String type: types) {%>
            <option value="<%=type%>" selected><%=type%></option>
            <%}%>
        </select>
    <p>
        <input type="text"  name="amount" value="1" placeholder="Количество"><br>
    </p>

    <h3> Выберите топпинг:</h3>

    <%for (String type: toppings) {%>
    <div>
        <input type="checkbox" name="topping" value=<%=type%> <label> <%=type%> </label>
    </div>
     <%}%>

    <h3> Клиент:</h3>
    <div>
        <input type="radio" name="rb" id="rb1" value="1" checked> <label for="rb1">Выбрать клиента</label>
    </div>

<%--    <div>--%>
<%--        <input type="radio" name="rb" id="rb2" value="2"> <label for="rb2">Новый клиент</label>--%>
<%--    </div>--%>


    <%List<String> all = (List<String>) request.getAttribute("all");%>
<%--    <h3> Заказчик:</h3>--%>
<%--    <form method="post" action="${pageContext.request.contextPath}/pizza">--%>
        <select class="requestInput" name="id">
            <%for (String n : all) {%>
            <option><%=n%></option>
            <%}%>
        </select>
    <br>
    <br>
<%--    </form>--%>


<%--    <p>--%>
    <div>
        <input class="radio" type="radio" name="rb" id="rb2" value="2"> <label for="rb2">Новый клиент</label>
    </div>
<%--    <h3> Новый клиент:</h3>--%>
    <input type="text" class="userInput" name="client_name" placeholder="Имя"><br>
    <input type="text" class="userInput" name="phone"  placeholder="Номер телефона"><br>
    <input type="text" class="userInput" name="email"  placeholder="e-mail"><br>
    <input type="text" class="userInput" name="address"  placeholder="Адрес"><br>
<%--    </p>--%>


    <input type="submit" class="requestButton" value="Оформить">




</form>
    </div>
</div>

</body>
</html>
