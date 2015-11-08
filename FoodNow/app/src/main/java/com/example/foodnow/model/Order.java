package com.example.foodnow.model;

public class Order {
    private String id;
    private Customer customer;
    private Merchant merchant;
    private float total;
    private int estimatedTime;

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public float getTotal() {
        return total;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }
}
