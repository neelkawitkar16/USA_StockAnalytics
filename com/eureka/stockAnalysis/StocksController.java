package com.eureka.stockAnalysis;

import com.eureka.stockAnalysis.dao.LookupDAO;
import com.eureka.stockAnalysis.dao.StockFundamentals2DAO;
import com.eureka.stockAnalysis.service.MarketAnalyticsService;
import com.eureka.stockAnalysis.vo.SectorVO;
import com.eureka.stockAnalysis.vo.StockFundamentals2;
import com.eureka.stockAnalysis.vo.SubsectorVO;
import java.util.ArrayList;

public class StocksController {
    public static  void main(String[] args) {
        LookupDAO lookupDAO = new LookupDAO();
        StockFundamentals2DAO stockFundamentals2DAO = new StockFundamentals2DAO();
        MarketAnalyticsService marketAnalyticsService = new MarketAnalyticsService(lookupDAO, stockFundamentals2DAO);

        ArrayList<SectorVO> allSectors = marketAnalyticsService.getAllSectors();
        System.out.println("Sectors List: " + allSectors);
        System.out.println("\n");
        ArrayList<SubsectorVO> subsectorList = marketAnalyticsService.getAllSubsectors();
        System.out.println("All Subsectors: " + subsectorList);
        ArrayList<StockFundamentals2> topStocks = marketAnalyticsService.getTopStocks();
        System.out.println("Top 10 Stocks by Market Cap: " + topStocks);
    }
}
