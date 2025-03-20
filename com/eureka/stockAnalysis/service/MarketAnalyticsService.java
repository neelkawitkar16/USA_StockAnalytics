package com.eureka.stockAnalysis.service;

import com.eureka.stockAnalysis.dao.CompanyLocationsDAO;
import com.eureka.stockAnalysis.dao.LookupDAO;
import com.eureka.stockAnalysis.dao.StockFundamentalsDAO;
import com.eureka.stockAnalysis.dao.StockPriceHistoryDAO;
import com.eureka.stockAnalysis.vo.*;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<StockPriceHistoryVO> getLastThirtyDayStocks() throws SQLException {
        try {
            return stockPriceHistoryDAO.getStockPriceHistory();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<CompanyLocationsVO> getCompanyLocations() {
        return companyLocationsDAO.getCompanyLocationState("AL");
    }
}
