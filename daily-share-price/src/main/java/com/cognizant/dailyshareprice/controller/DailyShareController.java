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
    public ResponseEntity<ShareDetails> dailySharePrice(@RequestHeader("Authorization") String token, @PathVariable("shareName") String shareName) {
        if (service.isSessionValid(token)) {
            System.out.println(token);
            return new ResponseEntity<>(service.dailySharePrice(shareName), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/dailyAllSharePrice")
    public ResponseEntity<List<ShareDetails>> getAllShareDetails(@RequestHeader("Authorization") String token) {
        if (service.isSessionValid(token))
            return new ResponseEntity<>(service.getAllShares(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/dailySharePrice/{shareId}")
    public ResponseEntity<List<Double>> getDailySharePriceByIDList(@RequestHeader("Authorization") String token, @PathVariable(value = "shareId") List<String> shareId) {
        if (service.isSessionValid(token)) {
            return new ResponseEntity<>(service.getShareByIdList(shareId), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }
}
