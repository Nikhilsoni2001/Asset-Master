package com.cognizant.calculatenetworth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellObjectMap {
    int pid;

    Map<String, Integer> stockIdList;

    Map<String, Integer> mfAssetList;
}
