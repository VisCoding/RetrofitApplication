package com.example.vishnu.retrofitapplication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.vishnu.retrofitapplication.Adapter.EmployeeAdapter;
import com.example.vishnu.retrofitapplication.Model.Employee;
import com.example.vishnu.retrofitapplication.Model.EmployeeList;
import com.example.vishnu.retrofitapplication.Network.GetEmployeeDataService;
import com.example.vishnu.retrofitapplication.Network.RetrofitInstance;
import com.example.vishnu.retrofitapplication.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EmployeeAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_employee_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);


//E/RecyclerView: No adapter attached; skipping layout  ....... Initializing
        //Initializing the postlist list
        ArrayList<Employee> List = new ArrayList<>();
        adapter = new EmployeeAdapter(List);

        recyclerView.setAdapter(adapter);

       /*Create handle for the RetrofitInstance interface*/
        GetEmployeeDataService service = RetrofitInstance.getRetrofitInstance().create(GetEmployeeDataService.class);

         /*Call the method with parameter in the interface to get the employee data*/


       Call<EmployeeList> call = service.getEmployeeData(100);


       //Call<EmployeeList> call = service.getEmployeeData("http://navjacinth9.000webhostapp.com/json/retrofit-demo.php?company_no=123");




        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {

                Log.wtf("response", String.valueOf(response));

                Log.wtf("response.body()", String.valueOf(response.body()));
                generateEmployeeList(response.body().getEmployeeList());
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });



    }

    /*Method to generate List of employees using RecyclerView with custom adapter*/
    private void generateEmployeeList(ArrayList<Employee> empDataList) {

        adapter = new EmployeeAdapter(empDataList);


        recyclerView.setAdapter(adapter);



    }
}
