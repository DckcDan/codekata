package com.example.codekata.kata09.pricing;

import java.util.List;

public class PricingEngine {

    private PricingRules pricingRules;

    public PricingEngine(PricingRules pricingRules) {
        this.pricingRules = pricingRules;
    }

    public int getPrice(String itemId, int amount) {
        if (!pricingRules.containsRule(itemId)) {
            throw new RuntimeException("Item with id not found " + itemId);
        }
        int totalPrice = 0;
        List<PriceRule> priceRules = pricingRules.get(itemId);
        while (amount > 0) {
            PriceRule price = getBestPrice(priceRules, amount);
            totalPrice += price.getPrice();
            amount -= price.getAmount();
        }

        return totalPrice;
    }

    private PriceRule getBestPrice(List<PriceRule> priceRules, int amount) {
        PriceRule priceFound = null;

        for (PriceRule price : priceRules) {
            if (price.getAmount() > amount) {
                return priceFound;
            } else {
                priceFound = price;
            }
        }
        return priceFound;
    }
}
