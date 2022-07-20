package com.cognizant.calculatenetworth.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {
    @Id
    @Column
    private int portfolioId;
}
