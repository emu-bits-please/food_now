package com.example.foodnow.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Option implements MenuChild {
    @SerializedName("id")
    private String id;

    @SerializedName("price")
    private float price;

    @SerializedName("max_price")
    private float maxPrice;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("increment")
    private float increment;

    @SerializedName("children")
    private ArrayList<MegaMenuType> children;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public ArrayList<MegaMenuType> getChildren() {
        return children;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public float getIncrement() {
        return increment;
    }

    public float getPrice() {
        return price;
    }
}
