package com.example.codekata.kata09;

import com.example.codekata.kata09.pricing.PricingEngine;
import com.example.codekata.kata09.pricing.PricingRules;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PricingEngineTest {
    private PricingRules pricingRules;
    private PricingEngine pricingEngine;

    @Before
    public void init() {
        /**
         * A 50 1 unit
         * A 130 3 units
         * B 30 1 unit
         * B 45 2 units
         */
        pricingRules = new PricingRules();
        pricingRules.addRule("A", 1, 50);
        pricingRules.addRule("A", 3, 130);
        pricingRules.addRule("B", 1, 30);
        pricingRules.addRule("B", 2, 50);
        pricingRules.addRule("C", 1, 20);
        pricingRules.addRule("D", 1, 15);
        pricingEngine = new PricingEngine(pricingRules);


    }

    @Test
    public void testGetPrice() {

        assertEquals(pricingEngine.getPrice("A", 0), 0);
        assertEquals(pricingEngine.getPrice("A", 2), 100);
        assertEquals(pricingEngine.getPrice("A", 1), 50);
        assertEquals(pricingEngine.getPrice("A", 3), 130);
        assertEquals(pricingEngine.getPrice("A", 6), 260);
        assertEquals(pricingEngine.getPrice("A", 4), 180);
    }
}