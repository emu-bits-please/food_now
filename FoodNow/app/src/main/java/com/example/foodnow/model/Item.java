package com.example.foodnow.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Item implements MenuChild {
    @SerializedName("id") private String id;
    @SerializedName("price") private float price;
    @SerializedName("max_price") private float maxPrice;
    @SerializedName("name") private String name;
    @SerializedName("description") private String description;
    @SerializedName("min_qty") private int minQuantity;
    @SerializedName("max_qty") private int maxQuantity;
    @SerializedName("children") private ArrayList<MegaMenuType> children;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public Item(String id, float price, float maxPrice, String name, String description, int minQuantity, int maxQuantity, ArrayList<MegaMenuType> children) {
        this.id = id;
        this.price = price;
        this.maxPrice = maxPrice;
        this.name = name;
        this.description = description;
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
        this.children = children;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public ArrayList<MegaMenuType> getChildren() {
        return children;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public int getMinQuantity() {
        return minQuantity;
    }
}
