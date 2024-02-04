package com.example.pizza.model;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Client {
    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Client(Integer id, String name, String phone, String email, String address) {
        this.id = null;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
    public Client(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.name = resultSet.getString("client_name");
        this.phone = resultSet.getString("phone");
        this.email = resultSet.getString("email");
        this.address = resultSet.getString("address");
    }
    public Client(HttpServletRequest request) {
        this.name = request.getParameter("client_name");
        this.phone = request.getParameter("phone");
        this.email = request.getParameter("email");
        this.address = request.getParameter("address");
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

