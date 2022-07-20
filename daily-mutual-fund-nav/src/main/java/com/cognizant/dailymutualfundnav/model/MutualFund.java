package com.cognizant.dailymutualfundnav.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
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
