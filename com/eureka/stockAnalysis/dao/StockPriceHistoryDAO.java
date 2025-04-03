package com.eureka.stockAnalysis.dao;

import com.eureka.stockAnalysis.exception.StockException;
import com.eureka.stockAnalysis.vo.StockPriceHistoryVO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class StockPriceHistoryDAO extends BaseDAO {

    public ArrayList<StockPriceHistoryVO> getStockPriceHistory() {
        String sqlQuery = """
                 SELECT *
                 FROM endeavour.stocks_price_history 
                 WHERE trading_date >= current_date - 30
                """;

        ArrayList<StockPriceHistoryVO> stockPriceHistoryList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                StockPriceHistoryVO stockPriceHistoryVO = new StockPriceHistoryVO();
                        stockPriceHistoryVO.setClosePrice(resultSet.getBigDecimal("close_price"));
                        stockPriceHistoryVO.setLowPrice(resultSet.getBigDecimal("low_price"));
                        stockPriceHistoryVO.setOpenPrice(resultSet.getBigDecimal("open_price"));
                        stockPriceHistoryVO.setVolume(resultSet.getBigDecimal("volume"));
                        stockPriceHistoryVO.setTickerSymbol(resultSet.getString("ticker_symbol"));
                        stockPriceHistoryVO.setTradingDate(resultSet.getDate("trading_date").toLocalDate());
                        stockPriceHistoryList.add(stockPriceHistoryVO);
            }
        } catch (SQLException e) {
            throw new StockException("There is stock exception in the StockPriceHistory DAO:" + e.getMessage(), e.getCause());
        }
        return stockPriceHistoryList;
    }

    public ArrayList<StockPriceHistoryVO> getSpecificStockPriceHistory(String tickerSymbol, LocalDate fromDate, LocalDate toDate) {
        String sqlQuery = """
                    SELECT 
                        * 
                    FROM 
                        endeavour.stocks_price_history
                    WHERE 
                        ticker_symbol = ? and 
                        trading_date between ? and ?;
                """;

        ArrayList<StockPriceHistoryVO> priceHistoryList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, tickerSymbol);
            preparedStatement.setDate(2, Date.valueOf(fromDate));
            preparedStatement.setDate(3, Date.valueOf(toDate));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                StockPriceHistoryVO stockPriceHistoryVOObj = new StockPriceHistoryVO();
                    stockPriceHistoryVOObj.setClosePrice(resultSet.getBigDecimal("close_price"));
                    stockPriceHistoryVOObj.setLowPrice(resultSet.getBigDecimal("low_price"));
                    stockPriceHistoryVOObj.setOpenPrice(resultSet.getBigDecimal("open_price"));
                    stockPriceHistoryVOObj.setVolume(resultSet.getBigDecimal("volume"));
                    stockPriceHistoryVOObj.setTickerSymbol(resultSet.getString("ticker_symbol"));
                    stockPriceHistoryVOObj.setTradingDate(resultSet.getDate("trading_date").toLocalDate());
                    priceHistoryList.add(stockPriceHistoryVOObj);
            }
        } catch (Exception e) {
            throw new StockException("There is stock exception in the StockPriceHistory DAO:" + e.getMessage(), e.getCause());
        }
        return priceHistoryList;
    }
}
