package com.example.asm_android_movie.network;

import com.example.asm_android_movie.model.BigData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiManager {
    String SERVER = "https://springfilm.herokuapp.com";
    @GET("/apifree/home")
    Call<BigData> apiGetBigData();
}
