package com.cognizant.authorizationservice.controller;

import com.cognizant.authorizationservice.model.AuthResponse;
import com.cognizant.authorizationservice.model.UserData;
import com.cognizant.authorizationservice.service.AdminDetailService;
import com.cognizant.authorizationservice.service.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private JwtUtil jwtutil;

    @Autowired
    private AdminDetailService adminDetailService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserData userLoginCredentials) {
        logger.info("START");
        final UserDetails userdetails = adminDetailService.loadUserByUsername(userLoginCredentials.getUserid());
        String uid = "";
        String generateToken = "";
        if (userdetails.getPassword().equals(userLoginCredentials.getUpassword())) {
            uid = userLoginCredentials.getUserid();
            generateToken = jwtutil.generateToken(userdetails);
            logger.info(generateToken);
            logger.info("END");
            return new ResponseEntity<>(new UserData(uid, null, null, generateToken), HttpStatus.OK);
        } else {
            logger.info("END - Wrong credentials");
            return new ResponseEntity<>("Not Accessible", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token) {
        logger.info("START");

        AuthResponse res = new AuthResponse();
        if (token == null) {
            res.setValid(false);
            logger.info("END - Null Token");

            return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
        } else {
            String token1 = token.substring(7);
            if (jwtutil.validateToken(token1)) {
                res.setUid(jwtutil.extractUsername(token1));
                res.setValid(true);
                res.setName("admin");
            } else {
                res.setValid(false);
                logger.info("END - Token expired");

                return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
            }
        }
        logger.info("END - Token accepted");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
