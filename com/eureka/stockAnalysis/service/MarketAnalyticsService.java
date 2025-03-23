package com.eureka.stockAnalysis.service;

import com.eureka.stockAnalysis.dao.CompanyLocationsDAO;
import com.eureka.stockAnalysis.dao.LookupDAO;
import com.eureka.stockAnalysis.dao.StockFundamentalsDAO;
import com.eureka.stockAnalysis.dao.StockPriceHistoryDAO;
import com.eureka.stockAnalysis.sort.SFCurrentRatioComparator;
import com.eureka.stockAnalysis.sort.SFMarketCapComparator;
import com.eureka.stockAnalysis.vo.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MarketAnalyticsService {
    private LookupDAO lookupDAO;
    private StockFundamentalsDAO stockFundamentalsDAO;
    private StockPriceHistoryDAO stockPriceHistoryDAO;
    private CompanyLocationsDAO companyLocationsDAO;

    public MarketAnalyticsService(LookupDAO lookupDAO, StockFundamentalsDAO stockFundamentalsDAO, StockPriceHistoryDAO stockPriceHistoryDAO, CompanyLocationsDAO companyLocationsDAO) {
        this.lookupDAO = lookupDAO;
        this.stockFundamentalsDAO = stockFundamentalsDAO;
        this.stockPriceHistoryDAO = stockPriceHistoryDAO;
        this.companyLocationsDAO = companyLocationsDAO;
    }

    public ArrayList<SectorVO> getAllSectors() {
        ArrayList<SectorVO> allSectors = lookupDAO.getAllSectors();
        System.out.println("Sectors List: " + allSectors);
        return allSectors;
    }

    public ArrayList<SubsectorVO> getAllSubsectors() {
        ArrayList<SubsectorVO> subsectorList = lookupDAO.getAllSubSectors();
        //Using Method Referencing
        subsectorList.sort(Comparator.comparing(SubsectorVO::getSectorID).reversed()
                .thenComparing(Comparator.comparing(SubsectorVO::getSubsectorID).reversed())); //sort by sectorid and then subsectorid
        //Using Lambda Function
        //subsectorList.sort(Comparator.comparing(subsectorVO -> subsectorVO.getSectorID()));

        System.out.println("All Subsectors: " + subsectorList);
        return subsectorList;
    }

    public ArrayList<StockFundamentalsVO> getTopStocks() {
        ArrayList<StockFundamentalsVO> topStocks = stockFundamentalsDAO.getStockFundamentals();
        System.out.println("Top 10 Stocks by Market Cap: " + topStocks);
        return topStocks;
    }

    public ArrayList<StockPriceHistoryVO> getLastThirtyDayStocks() {

        ArrayList<StockPriceHistoryVO> lastThirtyDayStockList = stockPriceHistoryDAO.getStockPriceHistory();
        lastThirtyDayStockList.sort(new Comparator<StockPriceHistoryVO>() {
                @Override
                public int compare(StockPriceHistoryVO o1, StockPriceHistoryVO o2) {
                    return o2.getVolume().compareTo(o1.getVolume());
                }
            });
            System.out.println("The last 30 days stocks" + lastThirtyDayStockList);

            return lastThirtyDayStockList;
    }

    public ArrayList<CompanyLocationsVO> getCompanyLocations() {
        ArrayList<CompanyLocationsVO> companyLocationsList = companyLocationsDAO.getCompanyLocationState("AL");
        Collections.sort(companyLocationsList);
        Collections.sort(companyLocationsList, new Comparator<CompanyLocationsVO>() {
            @Override
            public int compare(CompanyLocationsVO o1, CompanyLocationsVO o2) {
                return o1.getCity().compareTo(o2.getCity()); //sort city ascending
            }
        });
        System.out.println("The companies location" + companyLocationsList);

        return companyLocationsList;
    }

    public ArrayList<StockFundamentalsVO> getAllStockFundamentals() {
        ArrayList<StockFundamentalsVO> allStockFundamentalsList = stockFundamentalsDAO.getAllStockFundamentals();
         /*
        blue chip stocks are stocks with market cap greater than 100 billion USD
        small cap stocks are stocks with market cap between 250 million and 10 billion USD
         */
/*

       List<StockFundamentalsVO> blueChipStocks = new ArrayList<>();
        List<StockFundamentalsVO> smallCapStocks = new ArrayList<>();

        for (StockFundamentalsVO stock : allStockFundamentalsList) {
            if (stock.getMarketCap().compareTo(new BigDecimal("100000000000")) > 0) {
                blueChipStocks.add(stock);
            } else if (stock.getMarketCap().compareTo(new BigDecimal("250000000")) >= 0 && stock.getMarketCap().compareTo(new BigDecimal("10000000000")) <= 0) {
                smallCapStocks.add(stock);
            }
        }

        System.out.println("Blue Chip Stocks:");
        BigDecimal blueChipTotal = BigDecimal.ZERO;
        for (StockFundamentalsVO stock : blueChipStocks) {
            System.out.println(stock);
            blueChipTotal = blueChipTotal.add(stock.getMarketCap());
        }
        System.out.println("Total Market Cap for Blue Chips: " + blueChipTotal);

        System.out.println("\nSmall Cap Stocks:");
        BigDecimal smallCapTotal = BigDecimal.ZERO;
        for (StockFundamentalsVO stock : smallCapStocks) {
            System.out.println(stock);
            smallCapTotal = smallCapTotal.add(stock.getMarketCap());
        }
        System.out.println("Total Market Cap for Small Caps: " + smallCapTotal);

*/

        //SFMarketCapComparator sfMarketCapComparator = new SFMarketCapComparator();
        //One way to SOrt using Custom Comparator
        //allStockFundamentalsList.sort(sfMarketCapComparator);
        //Another way to sort using Custom Comparator
        //Collections.sort(allStockFundamentalsList, new SFCurrentRatioComparator());
        //Sort using Comparable/default
        // Collections.sort(allStockFundamentalsList);
        //Collections.sort(allStockFundamentalsList, new Comparator<StockFundamentalsVO>() {
        /*    @Override
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
*/

/*
        SFCurrentRatioComparator sfCurrentRatioComparator = new SFCurrentRatioComparator();
        topStocks.sort(sfCurrentRatioComparator);
        System.out.println("\nThis is sorting the CR by using comparator concept" + sfCurrentRatioComparator);
*/
        StockFundamentalsVO dummyAppleStock = new StockFundamentalsVO("AAPL", 10, 250,
                new BigDecimal("500000000000"), 3.26F);
        allStockFundamentalsList.add(dummyAppleStock);
        // Comparator.comparing

        System.out.println("All Stock Fundamentals" + allStockFundamentalsList);
        return allStockFundamentalsList;
    }
}
