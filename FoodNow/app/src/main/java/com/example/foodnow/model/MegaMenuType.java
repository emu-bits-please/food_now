package com.example.foodnow.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by rwitting on 11/8/15.
 */
public class MegaMenuType {

    //item type vars - this is a superset of menu type vars
    @SerializedName("id") private String id;
    @SerializedName("price") private float price;
    @SerializedName("max_price") private float maxPrice;
    @SerializedName("name") private String name;
    @SerializedName("description") private String description;
    @SerializedName("min_qty") private int minQuantity;
    @SerializedName("max_qty") private int maxQuantity;
    @SerializedName("children") private ArrayList<MegaMenuType> children;
    @SerializedName("type") private String type;

    //option type vars
    //@SerializedName("id") private String id;
    //@SerializedName("price") private float price;
    //@SerializedName("max_price") private float maxPrice;
    //@SerializedName("name") private String name;
   // @SerializedName("description") private String description;
    @SerializedName("increment") private float increment;
    //@SerializedName("children") private ArrayList<MenuChild> children;

    //optionGroup type vars
    //@SerializedName("id") private String id;
    //@SerializedName("name") private String name;
    //@SerializedName("description") private String description;
    @SerializedName("min_selection") private int minSelection;
    @SerializedName("max_selection") private int maxSelection;
    @SerializedName("sel_dep") private int selDep;
    //@SerializedName("children") private ArrayList<MenuChild> children;

    public String getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<MegaMenuType> getChildren() {
        return children;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public float getIncrement() {
        return increment;
    }

    public int getMinSelection() {
        return minSelection;
    }

    public int getMaxSelection() {
        return maxSelection;
    }

    public int getSelDep() {
        return selDep;
    }



    public String getType() {
        return type;
    }
}
