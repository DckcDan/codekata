package com.example.codekata.kata09;

import com.example.codekata.kata09.pricing.PricingEngine;
import com.example.codekata.kata09.pricing.PricingRules;

import java.util.HashMap;
import java.util.Map;

public class CheckOut {

    private ShoppingCart shoppingCart;

    public CheckOut(PricingRules pricingRules) {
        this.shoppingCart = new ShoppingCart(new PricingEngine(pricingRules));
    }


    public void scan(String itemId) {
        shoppingCart.add(new Item(itemId));
    }

    public int total() {
        return shoppingCart.getTotalCost();
    }


}
