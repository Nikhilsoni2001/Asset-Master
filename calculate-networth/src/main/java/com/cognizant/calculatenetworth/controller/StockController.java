package com.cognizant.calculatenetworth.controller;

import com.cognizant.calculatenetworth.model.Asset;
import com.cognizant.calculatenetworth.model.MutualFundDetails;
import com.cognizant.calculatenetworth.model.SellObjectMap;
import com.cognizant.calculatenetworth.model.StockDetails;
import com.cognizant.calculatenetworth.service.AssetService;
import com.cognizant.calculatenetworth.service.SellAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/NetWorth")
@CrossOrigin("*")
public class StockController {
    @Autowired
    private ShareDetailsFeignProxy shareDetailsFeignProxy;

    @Autowired
    private MutualFundDetailsFeignProxy mutualFundDetailsFeignProxy;

    @Autowired
    private AssetService assetService;

    @Autowired
    private SellAssetService sellAssetService;

    @GetMapping("/calculateNetworth/{id}")
    public double getAsset(@RequestHeader("Authorization") String token,@PathVariable(value = "id") int id)
    {
        double netWorth = 0.0;
        if(sellAssetService.isSessionValid(token)) {
            List<String> stockAssetList = new ArrayList<>();
            List<String> mutualFundAssetList = new ArrayList<>();
            List<Double> stockValueList = new ArrayList<>();
            List<Double> mutualFundValueList = new ArrayList<>();
            List<Asset> assets = assetService.getAllAssetForPortfolio(id);
            for (Asset a : assets) {
                if (a.getType().equals("Share")) {
                    stockAssetList.add(a.getAssetid());
                } else {
                    mutualFundAssetList.add(a.getAssetid());
                }
            }
            if (!stockAssetList.isEmpty()) {
                stockValueList = shareDetailsFeignProxy.getDailySharePriceByIDList(token,stockAssetList);
            }
            if (!mutualFundAssetList.isEmpty()) {
                mutualFundValueList = mutualFundDetailsFeignProxy.getDailyMutualFundNavById(token,mutualFundAssetList);
            }
            int stockCounter = 0, mfCounter = 0;
            for (Asset a : assets) {
                if (a.getType().equals("Share")) {
                    netWorth += a.getUnits() * stockValueList.get(stockCounter);
                    stockCounter++;
                } else {
                    netWorth += a.getUnits() * mutualFundValueList.get(mfCounter);
                    mfCounter++;
                }
            }
        }
        return netWorth;

    }


    @PostMapping("/SellAssets")
    public double calculateBalancePostSellPerStock(@RequestHeader("Authorization") String token,@RequestBody SellObjectMap sell) {
        if(sellAssetService.isSessionValid(token)) {
            Map<String, Integer> stockIdList = sell.getStockIdList();
            Map<String, Integer> mfIdList = sell.getMfAssetList();
            if (!stockIdList.isEmpty()) {
                sellAssetService.deleteStockAssetWithUnits(sell.getPid(), stockIdList);
            }
            if (!mfIdList.isEmpty()) {
                sellAssetService.deleteMutualFundAssetWithUnits(sell.getPid(), mfIdList);
            }
        }
        return getAsset(token,sell.getPid());
    }

    @GetMapping("/GetAllAssets/{portfolioId}")
    public List<Asset> getAllAssets(@RequestHeader("Authorization") String token, @PathVariable(value = "portfolioId") int portfolioId) {
        if (sellAssetService.isSessionValid(token)) {
            return assetService.getAllAssetForPortfolio(portfolioId);
        }
        return null;
    }

    @GetMapping("/shares")
    public List<Asset> getAllStocks(@RequestHeader("Authorization") String token) {
        List<Asset> stockList = new ArrayList<>();
        List<StockDetails> shareslist = shareDetailsFeignProxy.getAllShareDetails(token);
        for (StockDetails s : shareslist) {
            stockList.add(new Asset(10, s.getShareId(), 1, "share", 10));
        }
        return stockList;
    }

    @GetMapping("/pershare/{shareName}")
    public ResponseEntity<StockDetails> getStockName(@RequestHeader("Authorization") String token, @PathVariable(value = "shareName") String shareName) {
        return new ResponseEntity<>(shareDetailsFeignProxy.dailySharePrice(token, shareName), HttpStatus.OK);
    }

    @GetMapping("/mutualfunds")
    public ResponseEntity<List<MutualFundDetails>> getAllMutualFunds(@RequestHeader("Authorization") String token) {
        return mutualFundDetailsFeignProxy.getAllMutualFund(token);
    }

}
