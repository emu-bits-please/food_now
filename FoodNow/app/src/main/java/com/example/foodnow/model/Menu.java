package com.example.foodnow.model;

import android.util.Log;

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

    public MegaMenuType getRandomItem() {
        MegaMenuType subMenu = children.get((int) (Math.random() * children.size()));

        Log.d("type", subMenu.toString());

        return subMenu;
        /*
        List<MegaMenuType> megaMenuItems = subMenu.getChildren();

        MegaMenuType megaMenuItem = megaMenuItems.get((int) (Math.random() * megaMenuItems.size()));
        Log.d("type", megaMenuItem.getType());
        return megaMenuItem;
        */
    }

    public ArrayList<MegaMenuType> getChildren() {
        return children;
    }

    public String getDescription() {
        return description;
    }
}
