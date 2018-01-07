package com.example.vishnu.retrofitapplication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.vishnu.retrofitapplication.Adapter.UserAdapter;
import com.example.vishnu.retrofitapplication.Model.Users;
import com.example.vishnu.retrofitapplication.Network.GetEmployeeDataService;
import com.example.vishnu.retrofitapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserListingActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Users> usersArrayList;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_listing);
        setRecyclerView();
        settingAdapter();
        getDataUsingRetrofit();
    }

    public void setRecyclerView(){

       recyclerView = (RecyclerView) findViewById(R.id.recycler_view_user_listing);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


    }

    public  void settingAdapter(){
        usersArrayList = new ArrayList<>();
        userAdapter = new UserAdapter(usersArrayList);
        recyclerView.setAdapter(userAdapter);
    }


    private void getDataUsingRetrofit() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetEmployeeDataService retrofit_service = retrofit.create(GetEmployeeDataService.class);

        Call<ArrayList<Users>> call = retrofit_service.getstackoverflowResponse();

        call.enqueue(new Callback<ArrayList<Users>>() {
            @Override
            public void onResponse(Call<ArrayList<Users>> call, Response<ArrayList<Users>> response) {
                usersArrayList = response.body();
                Log.d("124534t5  onResponse", "size  = " + usersArrayList.size());
                usersArrayList.addAll(response.body());

                userAdapter = new UserAdapter(usersArrayList);
                recyclerView.setAdapter(userAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<Users>> call, Throwable t) {
                Log.d("124534t5", "failure" + t.toString());
            }
        });


    }


}