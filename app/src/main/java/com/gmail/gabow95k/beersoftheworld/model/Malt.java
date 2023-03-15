package com.gmail.gabow95k.beersoftheworld.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Malt {
    @Expose
    @SerializedName("amount")
    private Volume amount;
    @Expose
    @SerializedName("name")
    private String name;

    public Volume getAmount() {
        return amount;
    }

    public void setAmount(Volume amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
