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
        String user = "0gqDWl5Ea1MoSQLH5gcBABiyuXsGINdp";
        String pass = "gphvdznv";
        String dbName = "gphvdznv";
        String host = "tantor.db.elephantsql.com";
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
