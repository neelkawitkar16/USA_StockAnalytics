package com.eureka.stockAnalysis.dao;

import com.eureka.stockAnalysis.vo.StockFundamentals2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockFundamentals2DAO extends BaseDAO {
    public ArrayList<StockFundamentals2> getStockFundamentals() {
        String sqlQuery = """
                SELECT TICKER_SYMBOL, SECTOR_ID, MARKET_CAP, CURRENT_RATIO
                FROM endeavour.STOCK_FUNDAMENTALS
                ORDER BY MARKET_CAP DESC
                LIMIT 10;
                """;

        ArrayList<StockFundamentals2> stockFundamentalsList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                StockFundamentals2 stock = new StockFundamentals2();
                stock.setTickerSymbol(resultSet.getString("TICKER_SYMBOL"));
                stock.setSectorID(resultSet.getInt("SECTOR_ID"));
                stock.setMarketCap(resultSet.getDouble("MARKET_CAP"));
                stock.setCurrentRatio(resultSet.getDouble("CURRENT_RATIO"));
                stockFundamentalsList.add(stock);
            }

        } catch (SQLException e) {
            System.out.println("There is a SQL Exception in StockFundamentalsDao: " + e.getMessage());
        }

        return stockFundamentalsList;
    }
}
