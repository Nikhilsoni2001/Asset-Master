package com.cognizant.dailymutualfundnav.repository;

import com.cognizant.dailymutualfundnav.model.MutualFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MutualFundRepository extends JpaRepository<MutualFund, Long> {
    MutualFund findByMutualFundName(String mutualFundName);
}
