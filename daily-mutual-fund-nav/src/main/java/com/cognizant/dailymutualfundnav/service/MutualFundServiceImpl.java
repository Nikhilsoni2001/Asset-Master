package com.cognizant.dailymutualfundnav.service;

import com.cognizant.dailymutualfundnav.controller.AuthClient;
import com.cognizant.dailymutualfundnav.model.AuthResponse;
import com.cognizant.dailymutualfundnav.model.MutualFund;
import com.cognizant.dailymutualfundnav.repository.MutualFundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MutualFundServiceImpl implements MutualFundService {
    @Autowired
    private MutualFundRepository repository;

    @Autowired
    private AuthClient authClient;

    @Override
    @Transactional
    public List<MutualFund> getAllMutualFund() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public MutualFund getMutualFundNav(String mutualFundName) {
        return repository.findByMutualFundName(mutualFundName);
    }

    @Override
    public List<Double> getMutualFundByIdList(List<String> mutualFundIdList) {
        List<Double> mfValueList = new ArrayList<>();
        List<MutualFund> mfList = repository.findByMutualFundId(mutualFundIdList);
        for (MutualFund m : mfList) {
            mfValueList.add(m.getMutualFundValue());
        }
        return mfValueList;
    }

    public Boolean isSessionValid(String token) {
        AuthResponse authResponse = authClient.getValidity(token);
        if (authResponse == null) throw new RuntimeException("Exception Thrown-Null Auth Response returned");

        return true;
    }
}
