package com.eureka.stockAnalysis.vo;

public class Stocks {
    private String tickerSymbol;
    private String tickerName;

    @Override
    public String toString() {
        return "Stocks{" +
                "tickerSymbol='" + tickerSymbol + '\'' +
                ", tickerName='" + tickerName + '\'' +
                '}';
    }

    public Stocks(String tickerSymbol, String tickerName){
        this.tickerSymbol = tickerSymbol;
        this.tickerName = tickerName;
    }

    //Getter is a standard method user to access a private variable/object within an obj of a class
    public String getTickerSymbol() {
        return tickerSymbol;
    }

    //Setter is a standard method used to set a specific value to a specific private varible.object
    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getTickerName() {
        return tickerName;
    }

    public void setTickerName(String tickerName) {
        this.tickerName = tickerName;
    }
}
