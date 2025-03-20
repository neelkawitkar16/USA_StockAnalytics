package com.eureka.stockAnalysis.vo;

public class CompanyLocationsVO implements Comparable<CompanyLocationsVO> {
    private String ticker_symbol;
    private String city;
    private String state;
    private String zip;

    public String getTicker_symbol() {
        return ticker_symbol;
    }

    public void setTicker_symbol(String ticker_symbol) {
        this.ticker_symbol = ticker_symbol;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "CompanyLocationsVO{" +
                "ticker_symbol='" + ticker_symbol + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                "\n";
    }

    @Override
    public int compareTo(CompanyLocationsVO o) {
        return this.getTicker_symbol().compareTo(o.getTicker_symbol());
    }
}
