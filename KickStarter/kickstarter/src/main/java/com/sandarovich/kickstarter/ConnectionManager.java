package com.sandarovich.kickstarter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Connection manager
 */

public class ConnectionManager {

    private DataSource dataSource;

    public ConnectionManager() {

    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
