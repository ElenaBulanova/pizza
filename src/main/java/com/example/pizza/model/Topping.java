package com.example.pizza.model;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Topping {
    private Integer id;
    private String name;

    public Topping(Integer id, String name) {
        this.id = null;
        this.name = name;
    }
    public Topping(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.name = resultSet.getString("topping_name");
    }
    public Topping(HttpServletRequest request){
        this.name = request.getParameter("topping_name");
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
        return "Topping{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

