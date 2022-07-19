package com.cognizant.dailymutualfundnav.service;

import com.cognizant.dailymutualfundnav.model.MutualFund;
import com.cognizant.dailymutualfundnav.repository.MutualFundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutualFundServiceImpl implements MutualFundService {
    @Autowired
    private MutualFundRepository repository;


    @Override
    public MutualFund getMutualFundNav(String mutualFundName) {
        return repository.findByMutualFundName(mutualFundName);
    }
}
