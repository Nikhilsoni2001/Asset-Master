package com.cognizant.dailymutualfundnav.controller;


import com.cognizant.dailymutualfundnav.model.AuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "AUTHORIZATION-SERVICE")
public interface AuthClient {
    @GetMapping("/validate")
    public AuthResponse getValidity(@RequestHeader("Authorization") String token);
}
