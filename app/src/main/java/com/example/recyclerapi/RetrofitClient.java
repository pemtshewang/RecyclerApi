package com.example.recyclerapi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;;

public class RetrofitClient {
    //constructing to base URL to fetch data from
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    //Creating a retrofit client object
    private static Retrofit retrofit = null;

    //implementing the newsInterface interface for constructing the retrofit client
    public static newsInterface getRetrofitClient(){
        //checking if the retrofit has client initialized or not
        //if not
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    //converting the JSON format by using GsonConverterFactory
                    .addConverterFactory(GsonConverterFactory.create())
                    //Building the final data format
                    .build();
        }
        //creating a retrofit client by returning the interface class
        return retrofit.create(newsInterface.class);
    }
}
