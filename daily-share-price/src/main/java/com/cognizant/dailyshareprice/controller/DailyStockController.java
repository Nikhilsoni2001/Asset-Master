package com.cognizant.dailyshareprice.controller;

import com.cognizant.dailyshareprice.model.StockDetails;
import com.cognizant.dailyshareprice.service.DailyStockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class DailyStockController {
    @Autowired
    private DailyStockServiceImpl service;

    @GetMapping("/dailySharePrice/name/{stockName}")
    public ResponseEntity<StockDetails> dailySharePrice(@PathVariable("stockName") String stockName) {
        return new ResponseEntity<>(service.dailySharePrice(stockName), HttpStatus.OK);
    }
}
