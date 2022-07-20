package com.cognizant.dailymutualfundnav.service;

import com.cognizant.dailymutualfundnav.model.MutualFund;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MutualFundService {
    List<MutualFund> getAllMutualFund();

    MutualFund getMutualFundNav(String mutualFundName);

    List<Double> getMutualFundByIdList(List<String> mutualFundIdList);
}
