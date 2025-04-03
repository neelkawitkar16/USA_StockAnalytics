package com.eureka.stockAnalysis.vo;

import java.math.BigDecimal;
import java.util.Objects;

public class StockFundamentalsVO implements Comparable<StockFundamentalsVO>{
    private String tickerSymbol;
    private int sectorId;
    private int subSectorId;
    private BigDecimal marketCap;
    private float currentRatio;


    public StockFundamentalsVO(String tickerSymbol, int sectorId, int subSectorId, BigDecimal marketCap, float currentRatio) {
        this.tickerSymbol = tickerSymbol;
        this.sectorId = sectorId;
        this.subSectorId = subSectorId;
        this.marketCap = marketCap;
        this.currentRatio = currentRatio;
    }

    public String toString(String accesstoken) {
        if (accesstoken == "abc"){
            System.out.println("StockFundamentals{" +
                    "tickerSymbol='" + tickerSymbol + '\'' +
                    ", sectorId=" + sectorId +
                    ", subSectorId=" + subSectorId +
                    ", marketCap=" + marketCap +
                    ", currentRatio=" + currentRatio +
                    "}\n");
        }
        return "Not Authorized";
    }

    @Override
    public String toString() {
        return "StockFundamentals{" +
                "tickerSymbol='" + tickerSymbol + '\'' +
                ", sectorID=" + sectorId +
                ", subSectorId=" + subSectorId +
                ", marketCap=" + marketCap +
                ", currentRatio=" + currentRatio +
                "}\n";
    }
    public StockFundamentalsVO(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

/*    public String getTickerSymbol(String accessToken) {
        if(accessToken == "abc") {
            return tickerSymbol;
        }
        return "You are not Authorized";
    }*/

    public String getTickerSymbol() {
            return tickerSymbol;
    }


    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public int getSubSectorId() {
        return subSectorId;
    }

    public void setSubSectorId(int subSectorId) {
        this.subSectorId = subSectorId;
    }

    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(BigDecimal marketCap) {
        this.marketCap = marketCap;
    }

    public float getCurrentRatio() {
        return currentRatio;
    }

    public void setCurrentRatio(float currentRatio) {
        this.currentRatio = currentRatio;
    }


    @Override
    public int compareTo(StockFundamentalsVO o) {
        return this.getMarketCap().compareTo(o.getMarketCap());
    }


/*    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StockFundamentalsVO that)) return false;
        return getSectorID() == that.getSectorID() && Double.compare(getMarketCap(), that.getMarketCap()) == 0 && Double.compare(getCurrentRatio(), that.getCurrentRatio()) == 0 && Objects.equals(getTickerSymbol(), that.getTickerSymbol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTickerSymbol(), getSectorID(), getMarketCap(), getCurrentRatio());
    }*/
}
