package com.digi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDatasource {
    private static final String url = "jdbc:mysql://localhost:3306/users";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "159357";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
