package com.hafizhmo.networkingretrofit.network;

import com.hafizhmo.networkingretrofit.model.Heroes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("heroStats")
    Call<List<Heroes>> getHeroes();

}
