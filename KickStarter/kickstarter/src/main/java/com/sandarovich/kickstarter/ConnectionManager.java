package com.sandarovich.kickstarter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Connection manager
 */

public class ConnectionManager {

    private DataSource dataSource;

    public ConnectionManager() {
        try {
            InitialContext initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/kickstarter");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
