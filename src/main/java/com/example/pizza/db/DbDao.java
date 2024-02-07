package com.example.pizza.db;

import com.example.pizza.model.Client;
import com.example.pizza.model.Order;
import com.example.pizza.model.Pizza;

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
    public List<String> toppingTypes() throws SQLException {
        String query = "SELECT topping_name FROM topping;";
        ResultSet result = connection.createStatement().executeQuery(query);
        return getStringListFromResultSet(result, "topping_name");
    }

    private List<String> getStringListFromResultSet(ResultSet result, String column) throws SQLException {
        List<String> resultAsString = new ArrayList<>();
        while (result.next()) {
            resultAsString.add(result.getString(column));
        }
        return resultAsString;
    }
    public int addClient(Client client) throws SQLException {
        int res = 0;
        String query = String.format("INSERT INTO client (client_name,phone,email,address)  VALUES ( '%s', '%s', '%s', '%s')",
                client.getName(),client.getPhone(),client.getEmail(),client.getAddress());
          connection.createStatement().executeUpdate(query);

        ResultSet resultSet = connection.createStatement().executeQuery("SELECT max(id) from client;");
        while (resultSet.next()) {
            res = resultSet.getInt(1);
        }
        return res;
    }

    public void addOrder(Order order) {
        try {
            connection.createStatement().executeUpdate(getQueryFromOrder(order));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private String getQueryFromOrder(Order order) throws SQLException {
        return String.format("INSERT INTO `order` (client_id, pizza_id,toppings, amount)  VALUES ( %d, %d, '%s', %d);",
                order.getClientId(), order.getPizzaId(),order.getToppings(), order.getAmount());

    }
    public int findPizzaByName(String pizza) throws SQLException {
        int res = 0;
        String query = String.format("SELECT * from pizza where pizza_name = '%s';", pizza);
        ResultSet result = connection.createStatement().executeQuery(query);
        result.next();
        res = new Pizza(result).getId();
        return res;
    }

    public List<Client> getAllClients(){
        try {
            return getClientListFromResultSet(
                    connection.createStatement().executeQuery("SELECT * FROM client;"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private List<Client> getClientListFromResultSet(ResultSet result) throws SQLException {
        List<Client> all = new ArrayList<>();
        while (result.next()) {
            all.add(new Client(result));
        }
        return all;
    }

    public Client findById(int id){
        try {
            ResultSet result =  connection.createStatement().executeQuery(String.format("SELECT * from client where id = %d;", id));
            result.next();
            return new Client(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void closeConnection() throws SQLException {
        connection.close();
    }
}
