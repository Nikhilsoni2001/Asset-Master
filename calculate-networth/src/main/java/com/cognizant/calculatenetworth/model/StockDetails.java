package com.cognizant.calculatenetworth.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDetails {

    private String shareId;

    private String shareName;

    private double shareValue;

}
