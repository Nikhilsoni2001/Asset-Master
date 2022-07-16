package com.cognizant.dailyshareprice.service;

import com.cognizant.dailyshareprice.model.StockDetails;

public interface DailyStockService {
    public StockDetails dailySharePrice(String stockName);
}
