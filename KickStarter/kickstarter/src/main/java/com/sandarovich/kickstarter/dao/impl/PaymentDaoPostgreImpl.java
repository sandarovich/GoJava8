package com.sandarovich.kickstarter.dao.impl;

import com.sandarovich.kickstarter.dao.PaymentDao;
import com.sandarovich.kickstarter.dao.exception.DaoException;
import com.sandarovich.kickstarter.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class PaymentDaoPostgreImpl implements PaymentDao {
    private static final String SQL_INVEST_INTO_PROJECT =
            "INSERT INTO payment (cardnumber, cardholder, amount, projectid) " +
                    "VALUES (?, ? , ?, ?);";
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void pay(Payment payment, int projectId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INVEST_INTO_PROJECT)) {
            statement.setString(1, payment.getCardNumber());
            statement.setString(2, payment.getCardHolder());
            statement.setDouble(3, payment.getAmount());
            statement.setInt(4, projectId);
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
