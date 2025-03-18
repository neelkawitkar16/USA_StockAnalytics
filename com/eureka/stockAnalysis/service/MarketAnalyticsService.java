package com.eureka.stockAnalysis.service;

import com.eureka.stockAnalysis.dao.LookupDAO;
import com.eureka.stockAnalysis.dao.StockFundamentalsDAO;
import com.eureka.stockAnalysis.vo.SectorVO;
import com.eureka.stockAnalysis.vo.StockFundamentalsVO;
import com.eureka.stockAnalysis.vo.SubsectorVO;

import java.util.ArrayList;

public class MarketAnalyticsService {
    private LookupDAO lookupDAO;
    private StockFundamentalsDAO stockFundamentalsDAO;

    public MarketAnalyticsService(LookupDAO lookupDAO, StockFundamentalsDAO stockFundamentalsDAO) {
        this.lookupDAO = lookupDAO;
        this.stockFundamentalsDAO = stockFundamentalsDAO;
    }

    public ArrayList<SectorVO> getAllSectors() {
        ArrayList<SectorVO> allSectors = lookupDAO.getAllSectors();
        return allSectors;
    }

    public ArrayList<SubsectorVO> getAllSubsectors() {
        return lookupDAO.getAllSubSectors();
    }

    public ArrayList<StockFundamentalsVO> getTopStocks() {
        return stockFundamentalsDAO.getStockFundamentals();
    }

    public ArrayList<StockFundamentalsVO> getAllStockFundamentals() {
        return stockFundamentalsDAO.getAllStockFundamentals();
    }
}
