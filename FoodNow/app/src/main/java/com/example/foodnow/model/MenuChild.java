package com.example.foodnow.model;

import java.util.ArrayList;

public interface MenuChild {
    public String getId();

    public String getName();

    public ArrayList<MenuChild> getChildren();
}