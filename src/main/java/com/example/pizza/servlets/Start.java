package com.example.pizza.servlets;

import com.example.pizza.db.DbDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/start")
public class Start extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            completeRequest(request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher =
                request.getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
    private void completeRequest(HttpServletRequest request) throws SQLException {
//        DbDao dao = new DbDao();
//        List<String> types = dao.pizzaTypes();
//        request.setAttribute("pizzaTypes", types);
//        System.out.println(request.getAttribute("pizzaTypes"));
//
//
//        dao.closeConnection();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
