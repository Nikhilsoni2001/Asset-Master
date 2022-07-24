package com.cognizant.authorizationservice.service;

import com.cognizant.authorizationservice.model.UserData;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JwtUtilTest {


    @Autowired(required = true)
    JwtUtil jwtUtil;
    @Autowired
    AdminDetailService adminDetailService;

    @Test
    public void contextLoads() {

        assertNotNull(jwtUtil);

    }

    private static String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxNTcyMTkxMywiaWF0IjoxNjE1NTQxOTEzfQ.sBh1dxvrhBUQWtmOIzJ0HYBIQCxZ__5Hhr1IvsOyYNI";

    @Test
    public void extractUsernameTestSuccess() throws JSONException {
        JSONObject json = new JSONObject();
        assertEquals("101", jwtUtil.extractUsername(json.getString(token)));
    }

    @Test
    public void generateTokenTestSuccess() {
        UserData userData = new UserData("101", "pwd", "101", "");
        UserDetails userDetails = adminDetailService.loadUserByUsername(userData.getUserid());
        String exampleToken = jwtUtil.generateToken(userDetails);
        assertNotNull(exampleToken);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void generateTokenTestFail() {
        UserData userData = new UserData("randomUser", "randomUser", "randomUser", "");
        UserDetails userDetails = adminDetailService.loadUserByUsername(userData.getUserid());
        String exampleToken = jwtUtil.generateToken(userDetails);
        assertNull(exampleToken);
    }

    @Test
    public void validateTokenTestSuccess() {
        assertTrue(jwtUtil.validateToken(token));
    }

    @Test
    public void validateTokenTestFail() {
        assertFalse(jwtUtil.validateToken("randomToken"));

    }

}
