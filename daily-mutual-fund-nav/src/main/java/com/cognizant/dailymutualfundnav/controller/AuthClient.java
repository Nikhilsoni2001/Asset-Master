package com.cognizant.dailymutualfundnav.controller;


import com.cognizant.dailymutualfundnav.model.AuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authorization-service", url = "http://43.205.128.198:9095")
public interface AuthClient {
    @GetMapping("/validate")
    public AuthResponse getValidity(@RequestHeader("Authorization") String token);
}
