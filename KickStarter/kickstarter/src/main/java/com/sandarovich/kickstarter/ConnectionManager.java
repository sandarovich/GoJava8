package com.sandarovich.kickstarter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection manager
 */

public class ConnectionManager {

    private Connection connection;

    private void openConnection() throws SQLException {
        String user = "vlqhnrbjejpbkg";
        String pass = "ROfMEA0Iiwh8pbuwdB58GOwM7t";
        String dbName = "dfg7r5r65g9u67";
        String host = "ec2-54-83-22-48.compute-1.amazonaws.com";
        String port = "5432";
        String url = "jdbc:postgresql://" + host + ":" + port + "/" + dbName;

        connection = DriverManager.getConnection(url, user, pass);
    }

    public synchronized Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            openConnection();
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
