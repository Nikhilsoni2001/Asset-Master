package com.cognizant.dailyshareprice.model;

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
public class ShareDetails {
    @Id
    @Column
    private String shareId;
    @Column(name = "share_name")
    private String shareName;
    @Column
    private Double shareValue;
}
