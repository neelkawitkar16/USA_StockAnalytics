package com.eureka.stockAnalysis.dao;

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
            System.out.println("There is a SQL Exception in base DAO: " +e.getMessage());
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
