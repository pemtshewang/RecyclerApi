package com.example.recyclerapi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView newsFeed;
    ProgressBar Loading;
    LinearLayoutManager layoutManager;
    PostAdapter adapter;
    List<Posts> postsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsFeed = findViewById(R.id.newsFeed);
        Loading = findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(this);
        newsFeed.setLayoutManager(layoutManager);
        adapter = new PostAdapter(postsList);
        newsFeed.setAdapter(adapter);
        fetchPosts();
    }

    private void fetchPosts() {

        /* Checking Network Connectivity and if there is no internet connection
            The progress bar keeps loading until the internet is set on manually.
         */
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            Loading.setVisibility(View.VISIBLE);
            //Starting retrofitclient for singleton responses
            RetrofitClient.getRetrofitClient().getPosts().enqueue(new Callback<List<Posts>>() {
                @Override
                public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        postsList.addAll(response.body());
                        adapter.notifyDataSetChanged();
                        Loading.setVisibility(View.GONE);
                    }
                }
                // if the server response fails
                @Override
                public void onFailure(Call<List<Posts>> call, Throwable t) {
                    Loading.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "No internet connection! Please Connect to Internet", Toast.LENGTH_SHORT).show();
        }
    }
}