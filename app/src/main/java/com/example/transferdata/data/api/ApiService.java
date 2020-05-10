package com.example.transferdata.data.api;

import com.example.transferdata.data.models.UserResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiService
{
    String Base_URL="http://jsonplaceholder.typicode.com/";

    @GET("/posts")
    Call<ArrayList<UserResponse>> getUserList();


}
