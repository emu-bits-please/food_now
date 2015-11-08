package com.example.foodnow.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rwitting on 11/8/15.
 */
public class MenuList {
    @SerializedName("menu")
    List<Menu> menulist;

    public List<Menu> getMenulist() {
        return menulist;
    }
}
