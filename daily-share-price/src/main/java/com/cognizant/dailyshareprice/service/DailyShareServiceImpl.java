package com.cognizant.dailyshareprice.service;

import com.cognizant.dailyshareprice.controller.AuthClient;
import com.cognizant.dailyshareprice.model.AuthResponse;
import com.cognizant.dailyshareprice.model.ShareDetails;
import com.cognizant.dailyshareprice.repository.ShareDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DailyShareServiceImpl implements DailyShareService {

    @Autowired
    private ShareDetailRepository repository;

    @Autowired
    private AuthClient authClient;

    @Override
    public ShareDetails dailySharePrice(String shareName) {
        return repository.findByShareName(shareName);
    }

    @Override
    public List<ShareDetails> getAllShares() {
        return repository.findAll();
    }

    @Override
    public List<Double> getShareByIdList(List<String> shareId) {
        List<Double> shareValueList = new ArrayList<>();
        List<ShareDetails> shareList = repository.findByShareId(shareId);
        for (ShareDetails s : shareList) {
            shareValueList.add(s.getShareValue());
        }
        return shareValueList;
    }

    public boolean isSessionValid(String token) {
        try {
            AuthResponse authResponse = authClient.getValidity(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
