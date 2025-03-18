package com.eureka.stockAnalysis.dao;

import com.eureka.stockAnalysis.exception.StockException;
import com.eureka.stockAnalysis.vo.StockFundamentalsVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockFundamentalsDAO extends BaseDAO {
    public ArrayList<StockFundamentalsVO> getStockFundamentals() {
        String sqlQuery = """
                SELECT TICKER_SYMBOL, SECTOR_ID, SUBSECTOR_ID, MARKET_CAP, CURRENT_RATIO
                FROM endeavour.STOCK_FUNDAMENTALS
                ORDER BY MARKET_CAP DESC
                LIMIT 10;
                """;

        ArrayList<StockFundamentalsVO> stockFundamentalsList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                StockFundamentalsVO stockFundamentalsVO = new StockFundamentalsVO(
                        resultSet.getString("ticker_symbol"),
                        resultSet.getInt("sector_id"),
                        resultSet.getInt("subsector_id"),
                        resultSet.getBigDecimal("market_cap"),
                        resultSet.getFloat("current_ratio"));
                stockFundamentalsList.add(stockFundamentalsVO);

            }

        } catch (SQLException e) {
            throw new StockException("There is stock exception in the StockFundamentals2 DAO:" + e.getMessage(), e.getCause());
        }

        return stockFundamentalsList;
    }

    public ArrayList<StockFundamentalsVO> getAllStockFundamentals() {
        String sqlQuery = """
                SELECT *
                FROM endeavour.STOCK_FUNDAMENTALS
                """;

        ArrayList<StockFundamentalsVO> stockFundamentalsVOArrayList = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                StockFundamentalsVO stockFundamentalsVO = new StockFundamentalsVO(
                        resultSet.getString("ticker_symbol"),
                        resultSet.getInt("sector_id"),
                        resultSet.getInt("subsector_id"),
                        resultSet.getBigDecimal("market_cap"),
                        resultSet.getFloat("current_ratio"));
                stockFundamentalsVOArrayList.add(stockFundamentalsVO);
            }

        }catch (SQLException e){
            throw new StockException("There is Stock Exception in Stock Fundamentals DAO: "+ e.getMessage(), e.getCause());
        }
        return stockFundamentalsVOArrayList;
    }
}
