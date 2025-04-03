package com.eureka.stockAnalysis.sort;

import com.eureka.stockAnalysis.vo.StockFundamentalsVO;

import java.util.Comparator;

public class SFCurrentRatioComparator implements Comparator<StockFundamentalsVO> {
    @Override
    public int compare(StockFundamentalsVO o1, StockFundamentalsVO o2) {
        if (o1.getCurrentRatio() == o2.getCurrentRatio()){
            return 0;
        } else if (o1.getCurrentRatio() < o2.getCurrentRatio()) {
            return -1;
        }else{
            return 1;
        }
    }
}