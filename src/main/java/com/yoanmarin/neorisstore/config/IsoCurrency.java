package com.yoanmarin.neorisstore.config;

public enum IsoCurrency {
    EUR("EUR"),
    COP("COP"),
    USD("USD");
    private String isoCurrencyType;

    private IsoCurrency(String isoCurrencyType){
        this.isoCurrencyType = isoCurrencyType;
    }

    public String getIsoCurrencyType(){
        return this.isoCurrencyType;
    }
}
