package com.cognizant.calculatenetworth.repository;

import com.cognizant.calculatenetworth.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {
    Asset findByPortfolioidAndAssetidAndType(int portfolioId, String id, String share);

    List<Asset> findByPortfolioidOrderByAssetid(int id);
}
