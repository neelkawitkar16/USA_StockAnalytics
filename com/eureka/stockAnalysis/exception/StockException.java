package com.eureka.stockAnalysis.exception;

public class StockException extends RuntimeException {
    // write a custom exception
    public StockException(String message) {
        super(message);
    }

    public StockException(String message, Throwable cause) {
        super(message, cause);
    }
}
