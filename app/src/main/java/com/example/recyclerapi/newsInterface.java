package com.example.recyclerapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface newsInterface {
    // The endpoint of What they Says API
    // The response is in form of JSON and later stored as arraylist upon recieving
@GET("/comments")
    Call<List<Posts>> getPosts();
}
