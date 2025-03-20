package com.eureka.stockAnalysis.dao;

import com.eureka.stockAnalysis.exception.StockException;
import com.eureka.stockAnalysis.vo.CompanyLocationsVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyLocationsDAO extends BaseDAO {
    public ArrayList<CompanyLocationsVO> getCompanyLocationState(String state) {
        String sqlQuery = """
                select
                     cl.ticker_symbol, sl.ticker_name, cl.city, cl.state, cl.zip
                from
                     endeavour.company_locations cl
                join
                     endeavour.stocks_lookup sl
                on
                    cl.ticker_symbol = sl.ticker_symbol
                where
                    cl.state = ?;
                """;

        ArrayList<CompanyLocationsVO> companyLocationList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,state);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                CompanyLocationsVO CompanyLocationsVO = new CompanyLocationsVO();
                CompanyLocationsVO.setTicker_symbol(resultSet.getString("ticker_symbol"));
                CompanyLocationsVO.setCity(resultSet.getString("city"));
                CompanyLocationsVO.setState(resultSet.getString("state"));
                CompanyLocationsVO.setZip(resultSet.getString("zip"));
                companyLocationList.add(CompanyLocationsVO);
            }
        } catch (SQLException e) {
            throw new StockException("There is stock exception in the CompanyLocation DAO:" + e.getMessage(), e.getCause());
        }
        return companyLocationList;
    }
}
