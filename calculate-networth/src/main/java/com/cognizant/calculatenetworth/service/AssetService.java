package com.cognizant.calculatenetworth.service;

import com.cognizant.calculatenetworth.model.Asset;
import com.cognizant.calculatenetworth.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssetService {
    @Autowired
    private AssetRepository repository;

    @Transactional
    public List<Asset> getAllAssetForPortfolio(int id){
        return repository.findByPortfolioidOrderByAssetid(id);
    }
}
