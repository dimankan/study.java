package org.example;

public class CurrencyData {
    private final String date;
    private final double usdRate;
    private final double eurRate;

    public CurrencyData(String date, double usdRate, double eurRate) {
        this.date = date;
        this.usdRate = usdRate;
        this.eurRate = eurRate;
    }

    public String getDate() {
        return date;
    }

    public double getUsdRate() {
        return usdRate;
    }

    public double getEurRate() {
        return eurRate;
    }
}
