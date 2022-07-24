package com.cognizant.calculatenetworth.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthResponseTest {
    AuthResponse authResponse = new AuthResponse();

    @Test
    void testSetUid() {
        authResponse.setUid("uid1");
        assertEquals("uid1", authResponse.getUid());
    }

    @Test
    void testSetName() {
        authResponse.setName("name");
        assertEquals("name", authResponse.getName());
    }

    @Test
    void testSetValid() {
        authResponse.setValid(true);
        assertTrue(authResponse.isValid());
    }

}
