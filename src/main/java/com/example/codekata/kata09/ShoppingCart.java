package com.example.codekata.kata09;

import com.example.codekata.kata09.pricing.PricingEngine;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private PricingEngine pricingEngine;
    private Map<String, Item> items = new HashMap<>();

    public ShoppingCart(PricingEngine pricingEngine) {
        this.pricingEngine = pricingEngine;
    }

    public void add(Item item) {
        if (items.containsKey(item.getId())) {
            Item itemAdded = items.get(item.getId());
            itemAdded.increaseAmount();
            items.put(item.getId(), itemAdded);
        } else {
            items.put(item.getId(), new Item(item.getId()));
        }
    }


    public int getTotalCost() {
        return items.values().stream()
                .mapToInt(item -> pricingEngine.getPrice(item.getId(), item.getAmount()))
                .sum();
    }

}
