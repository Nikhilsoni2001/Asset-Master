package com.cognizant.dailymutualfundnav.repository;

import com.cognizant.dailymutualfundnav.model.MutualFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MutualFundRepository extends JpaRepository<MutualFund, String> {
    MutualFund findByMutualFundName(String mutualFundName);

    @Query("SELECT m FROM MutualFund m WHERE m.mutualFundId IN (:mutualFundIdList) order by m.mutualFundId")
    public List<MutualFund> findByMutualFundId(@Param("mutualFundIdList") List<String> mutualFundIdList);
}
