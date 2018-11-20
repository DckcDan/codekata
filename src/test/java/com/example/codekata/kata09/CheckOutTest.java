package com.example.codekata.kata09;

import com.example.codekata.kata09.pricing.PricingRules;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckOutTest {

    private CheckOut checkOut;

    @Before
    public void init() {
          PricingRules pricingRules = new PricingRules();
        pricingRules.addRule("A",1,50);
        pricingRules.addRule("A",3,130);
        pricingRules.addRule("B",1,30);
        pricingRules.addRule("B",2,45);
        pricingRules.addRule("C",1,20);
        pricingRules.addRule("D",1,15);

        checkOut = new CheckOut(pricingRules);
    }

    @Test
    public void testTotals() {

        assertEquals(0, price(""));
        assertEquals(50, price("A"));
        assertEquals(80, price("AB"));
        assertEquals(115, price("CDBA"));

        assertEquals(100, price("AA"));
        assertEquals(130, price("AAA"));
        assertEquals(180, price("AAAA"));
        assertEquals(230, price("AAAAA"));
        assertEquals(260, price("AAAAAA"));

        assertEquals(160, price("AAAB"));
        assertEquals(175, price("AAABB"));
        assertEquals(190, price("AAABBD"));
        assertEquals(190, price("DABABA"));
    }

    private int price(String items) {
        for (int index = 0; index < items.length(); index++) {
           checkOut.scan(String.valueOf(items.charAt(index)));
        }
        int total = checkOut.total();
        init();
        return total;
    }

    @Test
    public void testIncrement() {

        checkOut.scan("A");
        assertEquals( 50, checkOut.total());
        checkOut.scan("B");
        assertEquals( 80, checkOut.total());
        checkOut.scan("A");
        assertEquals(130, checkOut.total());
        checkOut.scan("A");
        assertEquals(160, checkOut.total());
        checkOut.scan("B");
        assertEquals(175, checkOut.total());
    }
}