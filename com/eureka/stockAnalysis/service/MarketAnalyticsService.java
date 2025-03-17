package com.eureka.stockAnalysis.service;

import com.eureka.stockAnalysis.dao.LookupDAO;
import com.eureka.stockAnalysis.dao.StockFundamentals2DAO;
import com.eureka.stockAnalysis.vo.SectorVO;
import com.eureka.stockAnalysis.vo.StockFundamentals2;
import com.eureka.stockAnalysis.vo.SubsectorVO;

import java.util.ArrayList;

public class MarketAnalyticsService {
    private LookupDAO lookupDAO;
    private StockFundamentals2DAO stockFundamentals2DAO;

    public MarketAnalyticsService(LookupDAO lookupDAO, StockFundamentals2DAO stockFundamentals2DAO) {
        this.lookupDAO = lookupDAO;
        this.stockFundamentals2DAO = stockFundamentals2DAO;
    }

    public ArrayList<SectorVO> getAllSectors() {
        ArrayList<SectorVO> allSectors = lookupDAO.getAllSectors();
        return allSectors;
    }

    public ArrayList<SubsectorVO> getAllSubsectors() {
        return lookupDAO.getAllSubSectors();
    }

    public ArrayList<StockFundamentals2> getTopStocks() {
        return stockFundamentals2DAO.getStockFundamentals();
    }
}
