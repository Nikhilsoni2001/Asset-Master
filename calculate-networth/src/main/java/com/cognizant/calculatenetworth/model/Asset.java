package com.cognizant.calculatenetworth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
    @Id
    @Column
    private int tid;


    @Column
    private String assetid;
    @Column
    private int portfolioid;
    @Column
    private String type;
    @Column
    private int units;
}
