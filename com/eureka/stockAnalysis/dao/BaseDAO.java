package com.eureka.stockAnalysis.dao;

import com.eureka.stockAnalysis.exception.StockException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO implements AutoCloseable{
    //DataBase Connection variables
    private static final String jdbcURL = "jdbc:postgresql://endeavourtech.ddns.net:27443/StocksDB";
    private static final String username = "evr_java_app";
    private static final String password = "mqF59Px7FNqwK4JfYTNRqoRX9D";
    public Connection connection;

    public BaseDAO() {
        try {
            this.connection = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace(); // this is prints the stack trace
            throw new StockException("There is stock exception in the base DAO:" + e.getMessage(), e.getCause()); // this is custom exception
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
