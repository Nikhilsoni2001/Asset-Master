package com.cognizant.dailyshareprice.service;

import com.cognizant.dailyshareprice.model.ShareDetails;

import java.util.List;

public interface DailyShareService {
    ShareDetails dailySharePrice(String shareName);
    List<ShareDetails> getAllShares();
    List<Double> getShareByIdList(List<String> shareId);
}
