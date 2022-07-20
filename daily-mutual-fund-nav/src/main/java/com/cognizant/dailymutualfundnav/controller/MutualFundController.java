package com.cognizant.dailymutualfundnav.controller;

import com.cognizant.dailymutualfundnav.model.MutualFund;
import com.cognizant.dailymutualfundnav.service.MutualFundServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dailyMutualFundNav")
public class MutualFundController {

    @Autowired
    private MutualFundServiceImpl service;

    @GetMapping("/dailyAllMutualFundNav")
    public ResponseEntity<List<MutualFund>> getAllMutualFund(@RequestHeader("Authorization") String token) {
        try {
            if (service.isSessionValid(token)) {
                return ResponseEntity.ok(service.getAllMutualFund());
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Throwable e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/dailyMutualFundNav/name/{mutualFundName}")
    public MutualFund getDailyMutualFundNav(@RequestHeader("Authorization") String token, @PathVariable String mutualFundName) {
        if (service.isSessionValid(token)) {
            return service.getMutualFundNav(mutualFundName);
        }
        return null;
    }

    @GetMapping("/dailyMutualFundNav/{mutualFundId}")
    public List<Double> getDailyMutualFundNavById(@RequestHeader("Authorization") String token, @PathVariable(value = "mutualFundId") List<String> mutualFundIdList) {
        if (service.isSessionValid(token)) {
            return service.getMutualFundByIdList(mutualFundIdList);
        }
        return null;
    }
}
