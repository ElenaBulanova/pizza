package com.example.pizza.model;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Pizza {
    private Integer id;
    private String name;

    public Pizza(Integer id, String name) {
        this.id = null;
        this.name = name;
    }

    public Pizza(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.name = resultSet.getString("pizza_name");
    }
    public Pizza(HttpServletRequest request){
        this.name = request.getParameter("pizza_name");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
