package com.example.vishnu.retrofitapplication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.vishnu.retrofitapplication.Adapter.EmployeeAdapter;
import com.example.vishnu.retrofitapplication.Adapter.PhotoAdapter;
import com.example.vishnu.retrofitapplication.Model.Employee;
import com.example.vishnu.retrofitapplication.Model.EmployeeList;
import com.example.vishnu.retrofitapplication.Model.Photos;
import com.example.vishnu.retrofitapplication.Network.GetEmployeeDataService;
import com.example.vishnu.retrofitapplication.Network.RetrofitInstance;
import com.example.vishnu.retrofitapplication.R;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoRetrieveActivity extends AppCompatActivity {
    private RecyclerView recyclerView ;
    private PhotoAdapter photoAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Photos> latLngData = new ArrayList<Photos>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_retrieve);
        settingUpRecyclerView();
        settingAdapter();
        Log.d("0000000000    ",    "PhotoRetrieveActivity Entered "  );

        GetEmployeeDataService service = RetrofitInstance.getRetrofitInstance().create(GetEmployeeDataService.class);
         Call<ArrayList<Photos>> call = service.getPhotData("https://jsonplaceholder.typicode.com/photos");

        call.enqueue(new Callback<ArrayList<Photos>>() {
            @Override
            public void onResponse(Call<ArrayList<Photos>> call, Response<ArrayList<Photos>> response) {

                try {


                    ArrayList<Photos> results = response.body();

                    Log.d("2132423    ", results.size()   +  "    " +  String.valueOf(response.body())  );

                    latLngData.addAll(response.body()) ;

                    photoAdapter = new PhotoAdapter(latLngData , getApplicationContext());


                    recyclerView.setAdapter(photoAdapter);

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Photos>> call, Throwable t) {

            }
        });



    }



    public void settingUpRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_photo_list);
        layoutManager = new LinearLayoutManager(PhotoRetrieveActivity.this);
        recyclerView.setLayoutManager(layoutManager);

    }

    public void settingAdapter(){
        ArrayList<Photos> List = new ArrayList<>();
        photoAdapter = new PhotoAdapter(List , getApplicationContext());

        recyclerView.setAdapter(photoAdapter);
    }





}
