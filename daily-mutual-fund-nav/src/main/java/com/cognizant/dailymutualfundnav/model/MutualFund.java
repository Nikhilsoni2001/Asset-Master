package com.cognizant.dailymutualfundnav.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MutualFund {
    @Id
    @Column
    private String mutualFundId;
    @Column
    private String mutualFundName;
    @Column
    private Double mutualFundValue;
}
