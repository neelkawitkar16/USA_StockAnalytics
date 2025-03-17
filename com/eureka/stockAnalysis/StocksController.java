package com.eureka.stockAnalysis;

import com.eureka.stockAnalysis.dao.LookupDAO;
import com.eureka.stockAnalysis.service.MarketAnalyticsService;
import com.eureka.stockAnalysis.vo.SectorVO;
import com.eureka.stockAnalysis.vo.SubsectorVO;
import java.util.ArrayList;

public class StocksController {
    public static  void main(String[] args) {
        LookupDAO lookupDAO = new LookupDAO();
        MarketAnalyticsService marketAnalyticsService = new MarketAnalyticsService(lookupDAO);

        ArrayList<SectorVO> allSectors = marketAnalyticsService.getAllSectors();
        System.out.println("Sectors List: " + allSectors);
        System.out.println("\n");
        ArrayList<SubsectorVO> subsectorList = marketAnalyticsService.getAllSubsectors();
        System.out.println("All Subsectors: " + subsectorList);
    }
}
