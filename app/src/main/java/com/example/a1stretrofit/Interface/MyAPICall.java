package com.example.a1stretrofit.Interface;

import com.example.a1stretrofit.Model.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPICall {


   // https://run.mocky.io/v3/90fea295-8b4d-4e7c-be1e-f0788188102f


    @GET("90fea295-8b4d-4e7c-be1e-f0788188102f")
    Call<DataModel> getData();
}
