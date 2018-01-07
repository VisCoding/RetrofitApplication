package com.example.vishnu.retrofitapplication.Activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.vishnu.retrofitapplication.Adapter.Photo2Adapter;
import com.example.vishnu.retrofitapplication.Model.Photo2Pojo;
import com.example.vishnu.retrofitapplication.R;

public class Photo2RetrieveActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Photo2Adapter photo2Adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo2_retrieve);
    }

    private void initViews(){


    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        // <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
