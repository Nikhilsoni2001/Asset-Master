package com.cognizant.calculatenetworth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellObject {

    int pid;

    List<String> stockIdList;

    List<String> mfAssetList;
}
