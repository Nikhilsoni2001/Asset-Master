package com.cognizant.dailyshareprice.controller;

import com.cognizant.dailyshareprice.model.ShareDetails;
import com.cognizant.dailyshareprice.service.DailyShareServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class DailyShareController {
    @Autowired
    private DailyShareServiceImpl service;

    @GetMapping("/dailySharePrice/name/{shareName}")
    public ShareDetails dailySharePrice(@RequestHeader("Authorization") String token, @PathVariable("shareName") String shareName) {
        if (service.isSessionValid(token)) {
            System.out.println(token);
            return service.dailySharePrice(shareName);
        }
        return null;
    }

    @GetMapping("/dailyAllSharePrice")
    public List<ShareDetails> getAllShareDetails(@RequestHeader("Authorization") String token) {
        if (service.isSessionValid(token))
            return service.getAllShares();
        return null;
    }

    @GetMapping("/dailySharePrice/{shareId}")
    public List<Double> getDailySharePriceByIDList(@RequestHeader("Authorization") String token, @PathVariable(value = "shareId") List<String> shareId) {
        if (service.isSessionValid(token)) {
            return service.getShareByIdList(shareId);
        }
        return null;
    }
}
