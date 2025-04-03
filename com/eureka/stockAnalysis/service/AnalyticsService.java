package com.eureka.stockAnalysis.service;

import com.eureka.stockAnalysis.vo.StockFundamentals;
import com.eureka.stockAnalysis.vo.Stocks;

public class AnalyticsService {
   public static void main(String[] args){
       Stocks appleStock = new Stocks( "AAPL", "Apple Inc.");
       System.out.println("Apple Stock: " + appleStock);

       StockFundamentals nvdaStock = createStockFundamentalsObject("NVDA", 11, 255, 34555555, 1.56F);
       StockFundamentals msftStock = createStockFundamentalsObject("MSFT", 11, 255, 34555555, 1.56F);

       StockFundamentals amdStock = new StockFundamentals("AMD");
       System.out.println("AMD Stock Fundamentals: " + amdStock);
       amdStock.setSectorId(15);
       amdStock.setSubsectorId(335);
       System.out.println("AMD Stock Fundamentals: " + amdStock);
       amdStock.setSubsectorId(111);
       System.out.println("AMD Stock Fundamentals: " + amdStock);
       System.out.println("Is MSFT a bluechip stock: " + msftStock.isBlueChip());
       int a = 5;
       int b = passByValue(a);
       System.out.println("The values of a and b are: " +a +b);
       passByReference(msftStock);
       System.out.println("MSFT Stock Fundamentals: " +msftStock);
   }

   public static StockFundamentals createStockFundamentalsObject(String tickerSymbol,
                                                                 int sectorId,
                                                                 int subsectorId,
                                                                 long marketCap,
                                                                 float currentRatio){
       StockFundamentals stockFundamentalsObject = new StockFundamentals(tickerSymbol,
               sectorId,
               subsectorId,
               marketCap,
               currentRatio);
       System.out.println("Your Stocks Fundamentals are" + stockFundamentalsObject);
       return stockFundamentalsObject;
   }
    public static int passByValue(int a) {
        a = 250;
        return a;
    }

    public static void passByReference(StockFundamentals stockFundamentalsObject) {
        stockFundamentalsObject.setSectorId(250);
    }


//    public static void passByReferenceOtherWay(StockFundamentals stockFundamentalsObject) {
//        StockFundamentals tempStockFundamentals = new StockFundamentals(stockFundamentalsObject.getTickerSymbol(), stockFundamentalsObject.getSectorId())
//    }

}







