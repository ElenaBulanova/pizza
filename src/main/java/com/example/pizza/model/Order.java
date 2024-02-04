package com.example.pizza.model;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Order {
    private Integer id;
    private Integer clientId;
    private Integer pizzaId;
    private Integer toppingId;
    private Integer amount;

    public Order(Integer id, Integer clientId, Integer pizzaId, Integer toppingId, Integer amount) {
        this.id = null;
        this.clientId = clientId;
        this.pizzaId = pizzaId;
        this.toppingId = toppingId;
        this.amount = amount;
    }
    public Order(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.clientId = resultSet.getInt("client_id");
        this.pizzaId = resultSet.getInt("pizza_id");
        this.toppingId = resultSet.getInt("topping_id");
        this.amount = resultSet.getInt("amount");
    }
    public Order(HttpServletRequest request) {
        this.clientId = Integer.parseInt(request.getParameter("client_id"));
        this.pizzaId = Integer.parseInt(request.getParameter("pizza_id"));
        this.toppingId = Integer.parseInt(request.getParameter("topping_id"));
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

    public Integer getToppingId() {
        return toppingId;
    }

    public void setToppingId(Integer toppingId) {
        this.toppingId = toppingId;
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
                ", toppingId=" + toppingId +
                ", amount=" + amount +
                '}';
    }
}
