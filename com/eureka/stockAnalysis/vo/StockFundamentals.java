package com.eureka.stockAnalysis.vo;

public class StockFundamentals {
    private  String tickerSymbol;
    private int sectorId;
    private int subsectorId;
    private long marketCap;
    private float currentRatio;

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public StockFundamentals(String tickerSymbol, int sectorId, int subsectorId, long marketCap, float currentRatio) {
        this.tickerSymbol = tickerSymbol;
        this.sectorId = sectorId;
        this.subsectorId = subsectorId;
        this.marketCap = marketCap;
        this.currentRatio = currentRatio;
    }

    public StockFundamentals(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    @Override
    public String toString() {
        return "StockFundamentals{" +
                "tickerSymbol='" + tickerSymbol + '\'' +
                ", sectorId=" + sectorId +
                ", subsectorId=" + subsectorId +
                ", marketCap=" + marketCap +
                ", currentRatio=" + currentRatio +
                '}';
    }

    public float getCurrentRatio() {
        return currentRatio;
    }

    public void setCurrentRatio(float currentRatio) {
        this.currentRatio = currentRatio;
    }

    public long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(long marketCap) {
        this.marketCap = marketCap;
    }

    public int getSubsectorId() {
        return subsectorId;
    }

    public void setSubsectorId(int subsectorId) {
        this.subsectorId = subsectorId;
    }

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public boolean isBlueChip() {
        if(this.marketCap > 1000000) {
            return true;
        } else {
            return false;
        }
    }
}
