package com.hafizhmo.networkingretrofit.network;

import com.hafizhmo.networkingretrofit.model.Character;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("characters")
    Call<List<Character>> getCharacter();

}
