package com.cognizant.authorizationservice.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminDetailsServiceTest {
    @Autowired(required = true)
    AdminDetailService adminDetailsService;

    @Test
    public void contextLoads() {
        assertNotNull(adminDetailsService);
    }

    @Test
    public void loadUserByUsernameTestSuccess() {
        assertEquals("101", adminDetailsService.loadUserByUsername("101").getUsername());
    }

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsernameTestFail() {
        assertEquals("randomUser", adminDetailsService.loadUserByUsername("randomUser").getUsername());
    }

}
