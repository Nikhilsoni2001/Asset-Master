package com.cognizant.dailyshareprice.repository;

import com.cognizant.dailyshareprice.model.StockDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDetailRepository extends JpaRepository<StockDetails, Long> {
    StockDetails findByStockName(String stockName);

}
