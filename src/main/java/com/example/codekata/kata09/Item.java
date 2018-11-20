package com.example.codekata.kata09;

import lombok.Getter;

@Getter
public class Item {

    private String id;
    private int amount;

    public Item(String id) {
        this.id = id;
        amount = 1;
    }

    public Item(String id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public void increaseAmount() {
        this.amount++;
    }
}
