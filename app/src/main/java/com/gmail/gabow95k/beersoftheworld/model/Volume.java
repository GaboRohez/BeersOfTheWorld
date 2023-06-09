package com.gmail.gabow95k.beersoftheworld.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Volume {
    @Expose
    @SerializedName("unit")
    private String unit;
    @Expose
    @SerializedName("value")
    private double value;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
