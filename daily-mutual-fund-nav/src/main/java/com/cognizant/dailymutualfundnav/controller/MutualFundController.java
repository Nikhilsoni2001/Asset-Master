package com.cognizant.dailymutualfundnav.controller;

import com.cognizant.dailymutualfundnav.model.MutualFund;
import com.cognizant.dailymutualfundnav.service.MutualFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dailyMutualFundNav")
public class MutualFundController {

    @Autowired
    private MutualFundService service;

    @GetMapping("/name/{mutualFundName}")
    public MutualFund getDailyMutualDetails(@PathVariable("mutualFundName") String mutualFundName) {
        System.out.println("dailyMutualFundNav working");
        return service.getMutualFundNav(mutualFundName);
    }
}
