package com.example.foodnow.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("children")
    private ArrayList<MegaMenuType> children;

    @SerializedName("description")
    private String description;

    @SerializedName("unique_id")
    private int uniqueId;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Item getRandomItem() {
        MegaMenuType subMenu = children.get((int) (Math.random() * children.size()));

        List<MegaMenuType> megaMenuItems = subMenu.getChildren();

        MegaMenuType megaMenuItem = megaMenuItems.get((int) (Math.random() * megaMenuItems.size()));

        MenuChild menuChildItem = MenuChildFactory.getMenuChild(megaMenuItem);

        if(menuChildItem instanceof Item) {
            return (Item) menuChildItem;
        }

        return null;

    }

    public ArrayList<MegaMenuType> getChildren() {
        return children;
    }

    public String getDescription() {
        return description;
    }
}
