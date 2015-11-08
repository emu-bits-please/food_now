package com.example.foodnow.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Merchant {

    public class Summary {
        @SerializedName("name")
        private String name;
    }

    @SerializedName("id")
    private String id;

    @SerializedName("summary")
    private Summary summary;

    @SerializedName("location")
    private Location location;

    @SerializedName("summary.phone")
    private String phone;

    @SerializedName("summary.cuisines")
    private ArrayList<String> cuisines;

    @SerializedName("rating")
    private int rating;

    @SerializedName("address")
    private String address;

    private MerchantType type;

    public Merchant(String id, String name, Location location, String phone, ArrayList<String> cuisines, int rating, MerchantType type) {
        this.id = id;
        this.summary.name = name;
        this.location = location;
        this.phone = phone;
        this.cuisines = cuisines;
        this.rating = rating;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return summary.name;
    }

    public Location getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<String> getCuisines() {
        return cuisines;
    }

    public int getRating() {
        return rating;
    }

    public MerchantType getType() {
        return type;
    }

    public String getAddress() {
        return String.format("%s\n%s, %s %s", location.getStreet(), location.getCity(), location.getState(), location.getZip());
    }
}
