package com.eureka.stockAnalysis;

import com.eureka.stockAnalysis.dao.CompanyLocationsDAO;
import com.eureka.stockAnalysis.dao.LookupDAO;
import com.eureka.stockAnalysis.dao.StockFundamentalsDAO;
import com.eureka.stockAnalysis.dao.StockPriceHistoryDAO;
import com.eureka.stockAnalysis.service.MarketAnalyticsService;
import com.eureka.stockAnalysis.sort.SFCurrentRatioComparator;
import com.eureka.stockAnalysis.sort.SFMarketCapComparator;
import com.eureka.stockAnalysis.vo.*;

import java.sql.SQLException;
import java.time.LocalDate;

public class StocksController {
    public static  void main(String[] args) throws SQLException {
        LookupDAO lookupDAO = new LookupDAO();
        StockFundamentalsDAO stockFundamentals2DAO = new StockFundamentalsDAO();
        StockPriceHistoryDAO stockPriceHistoryDAO =new StockPriceHistoryDAO();
        CompanyLocationsDAO companyLocationsDAO = new CompanyLocationsDAO();
        MarketAnalyticsService marketAnalyticsService = new MarketAnalyticsService(lookupDAO, stockFundamentals2DAO, stockPriceHistoryDAO, companyLocationsDAO);

//        marketAnalyticsService.getAllSectors();

//        marketAnalyticsService.getAllSubsectors();

//        marketAnalyticsService.getTopStocks();

//        marketAnalyticsService.getCompanyLocations();

//        marketAnalyticsService.getLastThirtyDayStocks();

//        marketAnalyticsService.getAllStockFundamentals();

/*
          marketAnalyticsService.getSpecificStockPriceHistory("AAPL",
                LocalDate.parse("2024-01-01"),
                LocalDate.parse("2024-02-28"));
*/

//        marketAnalyticsService.processHealthCareStocks();
//
//
//        marketAnalyticsService.blueChipStocks();

//        marketAnalyticsService.smallCapStocks();

//        marketAnalyticsService.getSectorMap();

//        marketAnalyticsService.anotherGetSectorMap();

//        marketAnalyticsService.calculateMarketCapBySubsectors();

//        marketAnalyticsService.displayLowestClosingPrice("AAPL");

//        marketAnalyticsService.printStockHistoryByMonth("MSFT");

        marketAnalyticsService.getStateTotalMarketCapMap();

//        marketAnalyticsService.streamsRecap();

//        marketAnalyticsService.calculateSectorAverageMarketCap();
    }
}
