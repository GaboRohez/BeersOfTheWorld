package com.gmail.gabow95k.beersoftheworld.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ingredients {
    @Expose
    @SerializedName("yeast")
    private String yeast;
    @Expose
    @SerializedName("malt")
    private List<Malt> malt;

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }

    public List<Malt> getMalt() {
        return malt;
    }

    public void setMalt(List<Malt> malt) {
        this.malt = malt;
    }
}
