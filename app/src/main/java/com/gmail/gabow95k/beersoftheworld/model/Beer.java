package com.gmail.gabow95k.beersoftheworld.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Beer {
    @Expose
    @SerializedName("contributed_by")
    private String contributed_by;
    @Expose
    @SerializedName("brewers_tips")
    private String brewers_tips;
    @Expose
    @SerializedName("food_pairing")
    private List<String> food_pairing;
    @Expose
    @SerializedName("ingredients")
    private Ingredients ingredients;
    @Expose
    @SerializedName("boil_volume")
    private Volume boil_volume;
    @Expose
    @SerializedName("volume")
    private Volume volume;
    @Expose
    @SerializedName("image_url")
    private String image_url;
    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("first_brewed")
    private String first_brewed;
    @Expose
    @SerializedName("tagline")
    private String tagline;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("id")
    private int id;

    public String getContributed_by() {
        return contributed_by;
    }

    public void setContributed_by(String contributed_by) {
        this.contributed_by = contributed_by;
    }

    public String getBrewers_tips() {
        return brewers_tips;
    }

    public void setBrewers_tips(String brewers_tips) {
        this.brewers_tips = brewers_tips;
    }

    public List<String> getFood_pairing() {
        return food_pairing;
    }

    public void setFood_pairing(List<String> food_pairing) {
        this.food_pairing = food_pairing;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public Volume getBoil_volume() {
        return boil_volume;
    }

    public void setBoil_volume(Volume boil_volume) {
        this.boil_volume = boil_volume;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirst_brewed() {
        return first_brewed;
    }

    public void setFirst_brewed(String first_brewed) {
        this.first_brewed = first_brewed;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
