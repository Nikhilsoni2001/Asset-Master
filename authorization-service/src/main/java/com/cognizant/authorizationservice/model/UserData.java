package com.cognizant.authorizationservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userdata")
public class UserData {
    @Id
    @Column(name = "userId")
    private String userid;

    @Column(name = "userPassword")
    private String upassword;

    @Column(name = "userName")
    private String uname;

    private String authToken;
}
