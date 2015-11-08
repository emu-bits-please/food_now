package com.example.foodnow.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rwitting on 11/8/15.
 */
public class MerchantList {
    @SerializedName("merchants")
    List<Merchant> merchants;

    public List<Merchant> getMerchants() {
        return merchants;
    }
}
