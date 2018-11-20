package com.example.codekata.kata09.pricing;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriceRule {

    private String itemId;
    private int amount;
    private int price;
}
