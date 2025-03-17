package com.eureka.stockAnalysis.vo;

import java.util.Objects;

public class StockFundamentals2 {
    private String tickerSymbol;
    private int sectorID;
    private double marketCap;
    private double currentRatio;

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public int getSectorID() {
        return sectorID;
    }

    public void setSectorID(int sectorID) {
        this.sectorID = sectorID;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }

    public double getCurrentRatio() {
        return currentRatio;
    }

    public void setCurrentRatio(double currentRatio) {
        this.currentRatio = currentRatio;
    }

    @Override
    public String toString() {
        return "StockFundamentals2{" +
                "tickerSymbol='" + tickerSymbol + '\'' +
                ", sectorID=" + sectorID +
                ", marketCap=" + marketCap +
                ", currentRatio=" + currentRatio +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StockFundamentals2 that)) return false;
        return getSectorID() == that.getSectorID() && Double.compare(getMarketCap(), that.getMarketCap()) == 0 && Double.compare(getCurrentRatio(), that.getCurrentRatio()) == 0 && Objects.equals(getTickerSymbol(), that.getTickerSymbol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTickerSymbol(), getSectorID(), getMarketCap(), getCurrentRatio());
    }
}
