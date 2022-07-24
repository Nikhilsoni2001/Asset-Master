package com.cognizant.dailyshareprice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Data
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
