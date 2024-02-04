package com.example.pizza.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbDao {
    private final String url = "jdbc:mysql://localhost:3306/pizzas";
    private final String user = "root";
    private final String pass = "Vologda1";
    private final Connection connection;

    public DbDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("подключение невозможно");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер не распакован");
            throw new RuntimeException(e);
        }
    }
    public List<String> pizzaTypes() throws SQLException {
        String query = "SELECT  pizza_name FROM pizza;";
        ResultSet result = connection.createStatement().executeQuery(query);
        return getStringListFromResultSet(result, "pizza_name");
    }

    private List<String> getStringListFromResultSet(ResultSet result, String column) throws SQLException {
        List<String> resultAsString = new ArrayList<>();
        while (result.next()) {
            resultAsString.add(result.getString(column));
        }
        return resultAsString;
    }


    public void closeConnection() throws SQLException {
        connection.close();
    }
}
