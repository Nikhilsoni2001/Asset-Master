package com.cognizant.calculatenetworth.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PortfolioTest {
    @Test
    void testPortfolio() {
        Portfolio portfolio=new Portfolio();
    }

    @Test
    void testPortfolioInt() {
        Portfolio portfolio=new Portfolio(1);
    }

    @Test
    void testToString() {
        Portfolio portfolio=new Portfolio(1);
        assertEquals("Portfolio(portfolioId=1)",portfolio.toString());
    }

    @Test
    void testSetPortfolioId() {
        Portfolio portfolio=new Portfolio();
        portfolio.setPortfolioId(1);
        assertEquals(1,portfolio.getPortfolioId());
    }
}
