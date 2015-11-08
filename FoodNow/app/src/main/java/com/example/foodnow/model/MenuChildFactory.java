package com.example.foodnow.model;

import java.util.ArrayList;

/**
 * Created by rwitting on 11/8/15.
 */
public class MenuChildFactory {

    public static MenuChild getMenuChild(MegaMenuType megaMenuType) {

        MenuChild menuChild = null;

        if (megaMenuType.getType().equals("item")) {
            String id = megaMenuType.getId();
            float price = megaMenuType.getPrice();
            float maxPrice = megaMenuType.getMaxPrice();
            String name = megaMenuType.getName();
            String description = megaMenuType.getDescription();
            int minQuantity = megaMenuType.getMinQuantity();
            int maxQuantity = megaMenuType.getMaxQuantity();
            ArrayList<MegaMenuType> megaMenuTypes =  megaMenuType.getChildren();
            menuChild = new Item(id, price, maxPrice, name, description, minQuantity, maxQuantity, megaMenuTypes);
        }

        return menuChild;
    }
}
