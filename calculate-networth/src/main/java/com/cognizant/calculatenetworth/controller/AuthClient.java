package com.cognizant.calculatenetworth.controller;

import com.cognizant.calculatenetworth.model.AuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authorization-service", url = "http://63.205.126.151:9095")
public interface AuthClient {
    @GetMapping("/validate")
    public AuthResponse getValidity(@RequestHeader("Authorization") String token);
}
