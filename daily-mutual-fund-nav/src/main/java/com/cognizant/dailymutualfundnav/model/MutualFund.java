package com.cognizant.dailymutualfundnav.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MutualFund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long mutualFundId;
    @Column
    private String mutualFundName;
    @Column
    private Double mutualFundValue;
}
