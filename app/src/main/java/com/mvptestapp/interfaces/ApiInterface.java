package com.mvptestapp.interfaces;

import com.mvptestapp.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("s/2iodh4vg0eortkl/facts.json")
    Call<ApiResponse> getData();
}