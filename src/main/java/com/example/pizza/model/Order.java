package com.example.pizza.model;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Order {
    private Integer id;
    private Integer clientId;
    private Integer pizzaId;
    private String toppings;
    private Integer amount;

    public Order(Integer id, Integer clientId, Integer pizzaId, String toppings, Integer amount) {
        this.id = null;
        this.clientId = clientId;
        this.pizzaId = pizzaId;
        this.toppings = toppings;
        this.amount = amount;
    }
    public Order(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.clientId = resultSet.getInt("client_id");
        this.pizzaId = resultSet.getInt("pizza_id");
        this.toppings = resultSet.getString("toppings");
        this.amount = resultSet.getInt("amount");
    }
    public Order(HttpServletRequest request) {
        this.clientId = Integer.parseInt(request.getParameter("client_id"));
        this.pizzaId = Integer.parseInt(request.getParameter("pizza_id"));
        this.toppings = request.getParameter("toppings");
        this.amount = Integer.parseInt(request.getParameter("amount"));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", pizzaId=" + pizzaId +
                ", toppings=" + toppings +
                ", amount=" + amount +
                '}';
    }
}
