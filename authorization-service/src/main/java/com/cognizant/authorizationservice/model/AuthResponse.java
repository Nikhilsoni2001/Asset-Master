package com.cognizant.authorizationservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private String uid;

    private String name;

    private boolean isValid;
}
