package com.example.codekata.kata09.pricing;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class PricingRules {

    private Map<String, List<PriceRule>> priceRules;

    public PricingRules() {
        priceRules = new HashMap<>();
    }

    public void addRule(String itemId, int amount, int price) {
        PriceRule priceRule = new PriceRule(itemId, amount, price);
        List<PriceRule> list = priceRules.getOrDefault(itemId, new ArrayList<>());
        list.add(new PriceRule(itemId, amount, price));
        priceRules.put(itemId, list);
    }


    public List<PriceRule> get(String itemId) {
        return priceRules.get(itemId);
    }

    public boolean containsRule(String itemId) {
        return priceRules.containsKey(itemId);
    }
}
