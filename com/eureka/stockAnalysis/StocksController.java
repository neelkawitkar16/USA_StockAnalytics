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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StocksController {
    public static  void main(String[] args) throws SQLException {
        LookupDAO lookupDAO = new LookupDAO();
        StockFundamentalsDAO stockFundamentals2DAO = new StockFundamentalsDAO();
        StockPriceHistoryDAO stockPriceHistoryDAO =new StockPriceHistoryDAO();
        CompanyLocationsDAO companyLocationsDAO = new CompanyLocationsDAO();
        MarketAnalyticsService marketAnalyticsService = new MarketAnalyticsService(lookupDAO, stockFundamentals2DAO, stockPriceHistoryDAO, companyLocationsDAO);

        ArrayList<SectorVO> allSectors = marketAnalyticsService.getAllSectors();
        System.out.println("Sectors List: " + allSectors);
        System.out.println("\n");

        ArrayList<SubsectorVO> subsectorList = marketAnalyticsService.getAllSubsectors();
        System.out.println("All Subsectors: " + subsectorList);
        System.out.println("\n");

        ArrayList<StockFundamentalsVO> topStocks = marketAnalyticsService.getTopStocks();
        System.out.println("Top 10 Stocks by Market Cap: " + topStocks);
        System.out.println("\n");

        ArrayList<StockFundamentalsVO> allStockFundamentalsList = marketAnalyticsService.getAllStockFundamentals();
        System.out.println("All Stock Fundamentals" + allStockFundamentalsList);
        System.out.println("\n");

        ArrayList<CompanyLocationsVO> companyLocationsList = marketAnalyticsService.getCompanyLocations();
        //Collections.sort(companyLocationsList);
        Collections.sort(companyLocationsList, new Comparator<CompanyLocationsVO>() {
            @Override
            public int compare(CompanyLocationsVO o1, CompanyLocationsVO o2) {
                return o1.getCity().compareTo(o2.getCity()); //sort city ascending
            }
        });
/*        Collections.sort(companyLocationsList, new Comparator<CompanyLocationsVO>() {
            @Override
            public int compare(CompanyLocationsVO o1, CompanyLocationsVO o2) {
                return o2.getZip().compareTo(o1.getZip()); // sort zip desc
            }
        });*/
        System.out.println("The companies location" + companyLocationsList);

        try {
            ArrayList<StockPriceHistoryVO> lastThirtyDayStockList = marketAnalyticsService.getLastThirtyDayStocks();
            lastThirtyDayStockList.sort(new Comparator<StockPriceHistoryVO>() {
                @Override
                public int compare(StockPriceHistoryVO o1, StockPriceHistoryVO o2) {
                    return o2.getVolume().compareTo(o1.getVolume());
                }
            });
            System.out.println("The last 30 days stocks" + lastThirtyDayStockList);
            System.out.println("\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

/*        SFCurrentRatioComparator sfCurrentRatioComparator = new SFCurrentRatioComparator();
        topStocks.sort(sfCurrentRatioComparator);
        System.out.println("\nThis is sorting the CR by using comparator concept" + sfCurrentRatioComparator);*/
        SFMarketCapComparator sfMarketCapComparator = new SFMarketCapComparator();
        //One way to SOrt using Custom Comparator
        //allStockFundamentalsList.sort(sfMarketCapComparator);
        //Another way to sort using Custom Comparator
        //Collections.sort(allStockFundamentalsList, new SFCurrentRatioComparator());
        //Sort using Comparable/default
        //Collections.sort(allStockFundamentalsList);
        Collections.sort(allStockFundamentalsList, new Comparator<StockFundamentalsVO>() {
            @Override
            public int compare(StockFundamentalsVO o1, StockFundamentalsVO o2) {
                System.out.println(o1.getTickerSymbol("abc"));
                if (o1.getSectorId() == o2.getSectorId()){
                    return 0;
                } else if (o1.getSectorId() > o2.getSectorId()) {
                    return -1;
                }else {
                    return 1;
                }
            }
        });
    }
}
