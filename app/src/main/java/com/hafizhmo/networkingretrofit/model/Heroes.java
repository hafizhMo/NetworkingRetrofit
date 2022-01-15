package com.hafizhmo.networkingretrofit.model;

import com.google.gson.annotations.SerializedName;

public class Heroes {

    @SerializedName("localized_name")
    public String name;

    @SerializedName("img")
    public String image;

}
