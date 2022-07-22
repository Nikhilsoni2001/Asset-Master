package com.cognizant.calculatenetworth.controller;

import com.cognizant.calculatenetworth.model.MutualFundDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "DAILY-MUTUAL-FUND-NAV")
public interface MutualFundDetailsFeignProxy {
    @GetMapping("/dailyMutualFundNav/dailyAllMutualFundNav")
    public ResponseEntity<List<MutualFundDetails>> getAllMutualFund(@RequestHeader("Authorization") String token);

    @GetMapping("/dailyMutualFundNav/name/{mutualFundName}")
    public MutualFundDetails getDailyMutualFundNav(@RequestHeader("Authorization") String token, @PathVariable String mutualFundName);

    @GetMapping("/dailyMutualFundNav/{mutualFundId}")
    public List<Double> getDailyMutualFundNavById(@RequestHeader("Authorization") String token, @PathVariable(value = "mutualFundId") List<String> mutualFundIdList);
}
