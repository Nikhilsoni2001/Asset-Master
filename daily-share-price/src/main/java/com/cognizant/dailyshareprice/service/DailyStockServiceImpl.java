package com.cognizant.dailyshareprice.service;

import com.cognizant.dailyshareprice.model.StockDetails;
import com.cognizant.dailyshareprice.repository.StockDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyStockServiceImpl implements DailyStockService {

    @Autowired
    private StockDetailRepository repository;

    @Override
    public StockDetails dailySharePrice(String stockName) {
        return repository.findByStockName(stockName);
    }
}
