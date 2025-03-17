package com.eureka.stockAnalysis.service;

import com.eureka.stockAnalysis.dao.LookupDAO;
import com.eureka.stockAnalysis.vo.SectorVO;
import com.eureka.stockAnalysis.vo.SubsectorVO;

import java.util.ArrayList;

public class MarketAnalyticsService {
    private LookupDAO lookupDAO;

    public MarketAnalyticsService(LookupDAO lookupDAO) {
        this.lookupDAO = lookupDAO;
    }

    public ArrayList<SectorVO> getAllSectors() {
        ArrayList<SectorVO> allSectors = lookupDAO.getAllSectors();
        return allSectors;
    }

    public ArrayList<SubsectorVO> getAllSubsectors() {
        return lookupDAO.getAllSubSectors();
    }
}
