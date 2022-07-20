package com.cognizant.calculatenetworth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MutualFundDetails {
    private String mutualFundId;
    private String mutualFundName;
    private double mutualFundValue;
}
