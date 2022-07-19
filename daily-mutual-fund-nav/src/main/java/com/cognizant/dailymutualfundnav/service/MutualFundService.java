package com.cognizant.dailymutualfundnav.service;

import com.cognizant.dailymutualfundnav.model.MutualFund;
import org.springframework.stereotype.Service;

public interface MutualFundService {
    MutualFund getMutualFundNav(String mutualFundName);
}
