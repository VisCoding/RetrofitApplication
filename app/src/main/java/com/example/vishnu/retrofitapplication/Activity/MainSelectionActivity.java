package com.example.vishnu.retrofitapplication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.vishnu.retrofitapplication.Adapter.MainSelectionAdapter;
import com.example.vishnu.retrofitapplication.Adapter.PhotoAdapter;
import com.example.vishnu.retrofitapplication.Model.MainModel;
import com.example.vishnu.retrofitapplication.Model.Photos;
import com.example.vishnu.retrofitapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainSelectionActivity extends AppCompatActivity {
    private RecyclerView recyclerView ;
    private MainSelectionAdapter  mainSelectionAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<MainModel> mainModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_selection);
        mainModelArrayList = getAll();
        settingUpRecyclerView();
        settingAdapter();

    }
    public void settingUpRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_main_selection_list);
        layoutManager = new LinearLayoutManager(MainSelectionActivity.this);
        recyclerView.setLayoutManager(layoutManager);





    }
    private ArrayList<MainModel> getAll() {


        ArrayList<MainModel> allItems = new ArrayList<MainModel>();
        allItems.add(new MainModel("Employee Details",MainActivity.class ,""));
        allItems.add(new MainModel("Photos",PhotoRetrieveActivity.class ,""));
        allItems.add(new MainModel("User Details",UserListingActivity.class ,""));

        return allItems;
    }

    public void settingAdapter(){


        mainSelectionAdapter = new MainSelectionAdapter(mainModelArrayList , getApplicationContext());

        recyclerView.setAdapter(mainSelectionAdapter);
    }
}
