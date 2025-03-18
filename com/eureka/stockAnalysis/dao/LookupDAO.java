package com.eureka.stockAnalysis.dao;

import com.eureka.stockAnalysis.exception.StockException;
import com.eureka.stockAnalysis.vo.SectorVO;
import com.eureka.stockAnalysis.vo.SubsectorVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LookupDAO extends BaseDAO {

    public ArrayList<SectorVO> getAllSectors() {
        String sqlQuery = """
                select * from endeavour.sector_lookup;
                """;

        ArrayList<SectorVO> sectorVOArrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SectorVO sectorVO = new SectorVO();
                sectorVO.setSectorID(resultSet.getInt("sector_id"));
                sectorVO.setSectorName(resultSet.getString("sector_name"));
                sectorVOArrayList.add(sectorVO);
            }
        } catch (SQLException e) {
            throw new StockException("There is stock exception in the Lookup DAO:" + e.getMessage(), e.getCause());
        }
        return sectorVOArrayList;
    }

    public ArrayList<SubsectorVO> getAllSubSectors() {

        String sqlQuery = """
                Select 
                    *
                from 
                    endeavour.subsector_lookup sl
                """;
        ArrayList<SubsectorVO> subsectorVOArrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SubsectorVO subsectorVO = new SubsectorVO();
                subsectorVO.setSectorID(resultSet.getInt("sector_id"));
                subsectorVO.setSubsectorName(resultSet.getString("subsector_name"));
                subsectorVO.setSubsectorID(resultSet.getInt("subsector_id"));
                subsectorVOArrayList.add(subsectorVO);
            }
        }catch (SQLException e){
            System.out.println("There is a SQL Exeption in LookUP DAO: "+e.getMessage());
        }
        return subsectorVOArrayList;
    }
}
