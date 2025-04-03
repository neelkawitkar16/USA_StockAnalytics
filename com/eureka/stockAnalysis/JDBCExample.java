package com.eureka.stockAnalysis;

import java.sql.*;

public class JDBCExample {
    //DataBase Connection variables
    private static final String jdbcURL = "jdbc:postgresql://endeavourtech.ddns.net:27443/StocksDB";
    private static final String username = "evr_java_app";
    private static final String password = "mqF59Px7FNqwK4JfYTNRqoRX9D";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
        getAllSectors(connection);
        System.out.println("\n\n+++++++++++++++++++++++++");
        getSubSectors(connection);
        System.out.println("\n\n+++++++++++++++++++++++++");
        getSectorsById(connection, 36);
    }

    private static void getAllSectors(Connection connection) throws SQLException {
        String sqlQuery = """
                select * from endeavour.sector_lookup sl
                """;

        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            int sectorId = resultSet.getInt("sector_id");
            String sectorName = resultSet.getString("sector_name");

            System.out.println("Sector_Id: " + sectorId + " Sector_Name: " + sectorName);
        }
    }

    private static void getSubSectors(Connection connection) throws SQLException {
        String sqlQuery = """
                select * from endeavour.subsector_lookup;
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            int subsectorId = resultSet.getInt("subsector_id");
            String subsectorName = resultSet.getString("subsector_name");
            int sectorId = resultSet.getInt("sector_id");

            System.out.println("Subsector_Id: " + subsectorId + " Sub_Sector_Name: " + subsectorName + " Sector_Id: " + sectorId);
        }
    }

    private static void getSectorsById(Connection connection, int sector_id) throws SQLException {
        String sqlQuery = """
                select * from endeavour.sector_lookup sl where sector_id = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, sector_id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int sectorId = resultSet.getInt(("sector_id"));
            String sectorName = resultSet.getString("sector_name");

            System.out.println("Sector_Id: " + sectorId + " Sector_Name: " + sectorName);
        }
    }

}
