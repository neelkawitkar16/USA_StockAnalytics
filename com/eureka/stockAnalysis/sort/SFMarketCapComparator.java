package com.eureka.stockAnalysis.sort;

import com.eureka.stockAnalysis.vo.StockFundamentalsVO;

import java.util.Comparator;

public class SFMarketCapComparator implements Comparator<StockFundamentalsVO> {
    @Override
    public int compare(StockFundamentalsVO o1, StockFundamentalsVO o2) {
        return o2.getMarketCap().compareTo(o1.getMarketCap());
    }
}
