package com.cognizant.calculatenetworth.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockDetailsTest {
    StockDetails shareDetails=new StockDetails();

    @Test
    void testGetShareId() {
        shareDetails.setShareId("101");
        assertEquals("101", shareDetails.getShareId());
    }

    @Test
    void testGetShareName() {
        shareDetails.setShareName("abc");
        assertEquals("abc", shareDetails.getShareName());
    }

    @Test
    void testGetShareValue() {
        shareDetails.setShareValue(10.0);
        assertEquals(10.0, shareDetails.getShareValue());
    }

    @Test
    void testStockDetailsStringStringDouble() {
        StockDetails shareDetails=new StockDetails("101", "abc", 10.0);
        assertEquals("101", shareDetails.getShareId());
        assertEquals("abc", shareDetails.getShareName());
        assertEquals(10.0, shareDetails.getShareValue());
    }

    @Test
    void testStockDetails() {
        StockDetails shareDetails=new StockDetails();
    }

    @Test
    void testToString() {
        StockDetails shareDetails=new StockDetails("101", "abc", 10.0);
        assertEquals("StockDetails(shareId=101, shareName=abc, shareValue=10.0)", shareDetails.toString());

    }
}
