package com.eureka.stockAnalysis.service;

import com.eureka.stockAnalysis.dao.CompanyLocationsDAO;
import com.eureka.stockAnalysis.dao.LookupDAO;
import com.eureka.stockAnalysis.dao.StockFundamentalsDAO;
import com.eureka.stockAnalysis.dao.StockPriceHistoryDAO;
import com.eureka.stockAnalysis.sort.SFCurrentRatioComparator;
import com.eureka.stockAnalysis.sort.SFMarketCapComparator;
import com.eureka.stockAnalysis.vo.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MarketAnalyticsService {
    private LookupDAO lookupDAO;
    private StockFundamentalsDAO stockFundamentalsDAO;
    private StockPriceHistoryDAO stockPriceHistoryDAO;
    private CompanyLocationsDAO companyLocationsDAO;

    public MarketAnalyticsService(LookupDAO lookupDAO, StockFundamentalsDAO stockFundamentalsDAO,
                                  StockPriceHistoryDAO stockPriceHistoryDAO, CompanyLocationsDAO companyLocationsDAO) {
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

        //MAP using foreach
        //SubsectorID : SectorName
        Map<Integer, String> subSectorMap = new HashMap<>();
        subsectorList.forEach( subsectorVO -> {
                subSectorMap.put(subsectorVO.getSubsectorID(), subsectorVO.getSubsectorName());
                }
        );

        //MAP using Streams
        //SubsectorID : SubSectorName
        Map<Integer, String> collect = subsectorList.stream()
                .collect(Collectors.toMap(SubsectorVO::getSubsectorID,
                        SubsectorVO::getSubsectorName));
        System.out.println(collect);

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

    public void getSpecificStockPriceHistory(String ticker_symbol, LocalDate fromDate, LocalDate toDate) {
        ArrayList<StockPriceHistoryVO> specificStockPriceHistoryList =
                stockPriceHistoryDAO.getSpecificStockPriceHistory(ticker_symbol, fromDate, toDate);
        specificStockPriceHistoryList.sort(Comparator.comparing(StockPriceHistoryVO::getClosePrice).reversed()
                .thenComparing(Comparator.comparing(StockPriceHistoryVO::getTradingDate)));

        System.out.println("This list is for a specific stock price history: " + specificStockPriceHistoryList);
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
                new BigDecimal("5000000000000"), 3.26F);
        allStockFundamentalsList.add(dummyAppleStock);
        // Comparator.comparing
        allStockFundamentalsList.sort(Comparator.comparing(StockFundamentalsVO::getMarketCap)
                .thenComparing(Comparator.comparing(StockFundamentalsVO::getTickerSymbol).reversed()
                        .thenComparing(Comparator.comparing(StockFundamentalsVO::getSectorId))));
        System.out.println("All Stock Fundamentals" + allStockFundamentalsList);

        return allStockFundamentalsList;
    }

    public void processHealthCareStocks() {
        ArrayList<StockFundamentalsVO> allStockFundamentalsList = stockFundamentalsDAO.getAllStockFundamentals();

        //Filter All stock Fundamentals for HealthCare Sector 10: Lambda Function in Streams
        List<StockFundamentalsVO> collect = allStockFundamentalsList.stream()
                .filter(stockFundamentalsVO -> {
                    return stockFundamentalsVO.getSectorId() == 34;
                }).collect(Collectors.toList());

        System.out.println("Number of Healthcare Stocks: " + collect.size());

        //Count of Stocks in Healthcare sector
        long count = allStockFundamentalsList.stream()
                .filter(s -> s.getSectorId() == 34)
                .count();//terminal function

        System.out.println("Healthcare count from stream: " + count);

        //Total Market Cap of Health Care Sector
        Optional<BigDecimal> reduce = allStockFundamentalsList.stream()
                .filter(stockFundamentalsVO -> stockFundamentalsVO.getSectorId() == 34) // filter for healthcare
                .map(StockFundamentalsVO::getMarketCap)
                .reduce((marketcap1, marketcap2) -> marketcap1.add(marketcap2));

        reduce.ifPresent(s -> System.out.println("The total market cap of healthcare is: " + s));

        //Order HealthCare Stocks by Market Cap. filter all Current Ratios to be non-zero and post all nulls in
        //market cap at last
        List<StockFundamentalsVO> collect1 = allStockFundamentalsList.stream()
                .filter(s -> s.getSectorId() == 34)
                .filter(s->s.getCurrentRatio() != 0.0)
                .sorted(Comparator.comparing(StockFundamentalsVO::getMarketCap,
                                Comparator.nullsFirst(BigDecimal::compareTo)
                ).reversed())
                .collect(Collectors.toList());

        //System.out.println(collect1);


        //Filter for Health Care and create a map as below
        // subsectorID and list of Stck Fundamentals
        Map<Integer, List<StockFundamentalsVO>> collect2 = allStockFundamentalsList.stream()
                .filter(s -> s.getSectorId() == 34)
                .collect(Collectors.groupingBy(StockFundamentalsVO::getSubSectorId));

        //same as above in functionality but tedious
        //Using a Foreach to generate Subsector Map of Healthcare
        Map<Integer, List<StockFundamentalsVO>> outputMap = new HashMap<>();
        allStockFundamentalsList.forEach(stockFundamentalsVO -> {
            if(stockFundamentalsVO.getSectorId() == 34) {
                List<StockFundamentalsVO> stockFundamentalsVOS = outputMap.computeIfAbsent(stockFundamentalsVO.getSectorId(),
                        subsectorId -> {
                            List<StockFundamentalsVO> temp = new ArrayList<>();
                            temp.add(stockFundamentalsVO);
                            return temp;
                        });
                stockFundamentalsVOS.add(stockFundamentalsVO);
                outputMap.put(stockFundamentalsVO.getSubSectorId(),stockFundamentalsVOS);
            }
        });
        System.out.println(collect2);
    }

    //Get the list of stock fundamentals of all the BlueChip stocks (MC > 10B)
    public void blueChipStocks() {
        ArrayList<StockFundamentalsVO> allStockFundamentalsList = stockFundamentalsDAO.getAllStockFundamentals();

        List<StockFundamentalsVO> blueChipStockList = allStockFundamentalsList.stream()
                .filter(stockFundamentalsVO ->
                        stockFundamentalsVO.getMarketCap().compareTo(new BigDecimal(1000000000)) >= 0) // intermediate function
                .sorted(Comparator.comparing(StockFundamentalsVO::getMarketCap).reversed()) // intermediate function
                .collect(Collectors.toList()); //terminal function

        System.out.println(blueChipStockList);

        // Calculate the sum of all blue-chip stock market caps
        BigDecimal totalMarketCap = blueChipStockList.stream()
                .map(StockFundamentalsVO::getMarketCap) // Extract market caps
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Sum them

        System.out.println("Total Market Cap of Blue-Chip Stocks: " + totalMarketCap);
    }


    // Method to identify small cap stocks. Small cap stocks have a market cap between 250 million and 2 billion USD
    public void smallCapStocks() {
        ArrayList<StockFundamentalsVO> allStockFundamentalsList = stockFundamentalsDAO.getAllStockFundamentals();

        Map<String, StockFundamentalsVO> smallCapStocksMap = allStockFundamentalsList.stream()
                .filter(stockFundamentalsVO ->
                        stockFundamentalsVO.getMarketCap().compareTo(new BigDecimal(2000000000)) < 0)
                .filter(stockFundamentalsVO ->
                        stockFundamentalsVO.getMarketCap().compareTo(new BigDecimal(250000000)) >= 0)
                .collect(Collectors.toMap(StockFundamentalsVO::getTickerSymbol,
                        stockFundamentalsVO -> {
                            return stockFundamentalsVO; // returning the object
                        }));

        System.out.println(smallCapStocksMap);

        // total MC of small cap stocks
        ArrayList<StockFundamentalsVO> allStockFundamentalsList1 = stockFundamentalsDAO.getAllStockFundamentals();

            // Filter small-cap stocks and collect them in a List
            List<StockFundamentalsVO> smallCapStockList = allStockFundamentalsList1.stream()
                    .filter(stockFundamentalsVO ->
                            stockFundamentalsVO.getMarketCap().compareTo(new BigDecimal(2000000000)) < 0) // Less than 2B
                    .filter(stockFundamentalsVO ->
                            stockFundamentalsVO.getMarketCap().compareTo(new BigDecimal(250000000)) >= 0) // Greater than or equal to 250M
                    .collect(Collectors.toList());

            // Calculate the total market capitalization of small-cap stocks
            Optional<BigDecimal> totalMarketCap = smallCapStockList.stream()
                    .map(StockFundamentalsVO::getMarketCap) // Extract the market cap
                    .reduce(BigDecimal::add);

            totalMarketCap.ifPresent(s -> System.out.println("Total Market Cap of Small-Cap Stocks: " + s));
    }

    //{Communication Services=93, Utilities=62, Financial Services=319, Basic Materials=81}
    public void getSectorMap() {
        //get stock fundamentals and sector lookup data
        ArrayList<StockFundamentalsVO> allStockFundamentalsList = stockFundamentalsDAO.getAllStockFundamentals();
        ArrayList<SectorVO> sectorLookUpList = lookupDAO.getAllSectors();

        //Create a Map of SectorID -> SectorName
        Map<Integer, String> sectorMap = sectorLookUpList.stream()
                .collect(Collectors.toMap(SectorVO::getSectorID, SectorVO::getSectorName)); //{34=Healthcare, 35=Basic Materials, 36=Industrials}

        //Converting StockFundamentalsList  to a SectorID and List<StockfundamentalVO>
        Map<Integer, List<StockFundamentalsVO>> stockFundamentalsSectorMap  = allStockFundamentalsList.stream()
                .collect(Collectors.groupingBy(stockFundamentalsVO -> stockFundamentalsVO.getSectorId()));

        //Create a Map of SectorName -> Count of Stocks
        Map<String, Integer> finalOutputMap = new HashMap<>();
        sectorMap.forEach((sectorID, sectorName) -> {
            if (stockFundamentalsSectorMap.get(sectorID) !=null) {
                finalOutputMap.put(sectorName, stockFundamentalsSectorMap.get(sectorID).size());
            }
        });
        System.out.println(finalOutputMap);
    }

    //another way for the above solution
    /**
     * Print sector names and number of stocks in each sector: using Compute if Absent
     * Healthcare: 510
     * Basic Materials: 108
     * Financial Services: 486
     * Industrials: 391
     * Technology: 368
     * ...
     * Sector lookup data is available from the lookupsDao
     * Stock fundamentals data is available from the stockFundamentsDao
     */
    public void anotherGetSectorMap() {
        ArrayList<SectorVO> allSectorsList = lookupDAO.getAllSectors();
        ArrayList<StockFundamentalsVO> allStockFundamentalsList = stockFundamentalsDAO.getAllStockFundamentals();

        Map<Integer, String> sectosMap = allSectorsList.stream()
                .collect(Collectors.toMap(SectorVO::getSectorID,
                        SectorVO::getSectorName));

        Map<String, Integer> finalOutputMap = new HashMap<>();

        allStockFundamentalsList.forEach(stockFundamentalsVO -> {
            int sectorId = stockFundamentalsVO.getSectorId();
            String sectorName = sectosMap.get(sectorId);
            finalOutputMap.put(sectorName, finalOutputMap.computeIfAbsent(sectorName, k -> 0) + 1);
        });
        System.out.println(finalOutputMap);
    }

    /*
     Calculates the total market cap for each SubSector of the economy
     Example Output:
     Airport Services : 1500000000
     Healthcare Plans : 834443045
    */
    public void calculateMarketCapBySubsectors() {
        ArrayList<StockFundamentalsVO> allStockFundamentalsList = stockFundamentalsDAO.getAllStockFundamentals();
        ArrayList<SubsectorVO> allSubSectorsList = lookupDAO.getAllSubSectors();
        Map<String, BigDecimal> finalOutputMap = new HashMap<>();

        Map<Integer, String> sectorMap = allSubSectorsList.stream()
                .collect(Collectors.toMap(SubsectorVO::getSubsectorID,
                        SubsectorVO::getSubsectorName));

        Map<Integer, List<StockFundamentalsVO>> stockFundamentalsMap = allStockFundamentalsList.stream()
                .collect(Collectors.groupingBy(StockFundamentalsVO::getSubSectorId));

        sectorMap.forEach((subsectorID, subsectorName) ->{
            if (stockFundamentalsMap.get(subsectorID)!= null) {
                Optional<BigDecimal> marketCap = stockFundamentalsMap.get(subsectorID).stream()
                        .map(StockFundamentalsVO::getMarketCap)
                        .reduce(BigDecimal::add);
                if (!marketCap.isEmpty()) {
                    finalOutputMap.put(subsectorName, marketCap.get());
                }
            }
        });
        System.out.println(finalOutputMap);
    }
}
