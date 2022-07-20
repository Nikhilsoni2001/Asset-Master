package com.cognizant.calculatenetworth.controller;

import com.cognizant.calculatenetworth.model.StockDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "DAILY-SHARE-SERVICE")
public interface ShareDetailsFeignProxy {

    @GetMapping("/dailyAllSharePrice")
    public List<StockDetails> getAllShareDetails(@RequestHeader("Authorization") String token);

    @GetMapping("/dailySharePrice/{shareId}")
    public List<Double> getDailySharePriceByIDList(@RequestHeader("Authorization") String token, @PathVariable(value = "shareId") List<String> shareId);

    @GetMapping("/dailySharePrice/name/{shareName}")
    public StockDetails dailySharePrice(@RequestHeader("Authorization") String token, @PathVariable("shareName") String shareName);
}
