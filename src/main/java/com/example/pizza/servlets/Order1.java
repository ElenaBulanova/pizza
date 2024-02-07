package com.example.pizza.servlets;

import com.example.pizza.db.DbDao;
import com.example.pizza.model.Client;
import com.example.pizza.model.Order;
import com.example.pizza.model.Pizza;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/pizza")
public class Order1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            completeRequest(request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher =
                request.getServletContext().getRequestDispatcher("/pizza.jsp");
        dispatcher.forward(request, response);
    }

    private void completeRequest(HttpServletRequest request) throws SQLException {
        DbDao dao = new DbDao();
        request.setAttribute("amount", 1);
        List<String> types = dao.pizzaTypes();
        request.setAttribute("pizzaTypes", types);

        List<String> toppings = dao.toppingTypes();
        request.setAttribute("toppingTypes", toppings);

        List<Client> clients = dao.getAllClients();
        List<String> forSelect = clients.stream().map(n -> String.format("%d: '%s': тел. '%s' ", n.getId(), n.getName(), n.getPhone())).toList();
        request.setAttribute("all", forSelect);

        dao.closeConnection();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        DbDao dao = new DbDao();

        String oldOrExistClient = "";
        String[] radio = request.getParameterValues("rb");
        for (String t : radio)
            oldOrExistClient = oldOrExistClient + t;


        int pizzaId = 0;
        try {
            pizzaId = dao.findPizzaByName(request.getParameter("pizza_name"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String toppings = "";
        String[] tops = request.getParameterValues("topping");
        if (tops != null)
        for (String t : tops)
            toppings = toppings + t + " ";


        if (oldOrExistClient.equals("1")) {
            String idString = request.getParameter("id");
            String id = idString.substring(0, idString.indexOf(':'));
            Client oldClient = dao.findById(Integer.parseInt(id));
            Order orderToAdd = new Order(null, oldClient.getId(), pizzaId, toppings, Integer.parseInt(request.getParameter("amount")));
            dao.addOrder(orderToAdd);
        } else {
            Client clientToAdd = new Client(request);
            int clientId = 0;
            try {
                clientId = dao.addClient(clientToAdd);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Order orderToAdd = new Order(null, clientId, pizzaId, toppings, Integer.parseInt(request.getParameter("amount")));
            dao.addOrder(orderToAdd);
        }

        try {
            dao.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
