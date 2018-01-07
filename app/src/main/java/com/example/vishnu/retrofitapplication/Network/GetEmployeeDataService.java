package com.example.vishnu.retrofitapplication.Network;

import com.example.vishnu.retrofitapplication.Model.EmployeeList;
import com.example.vishnu.retrofitapplication.Model.Photos;
import com.example.vishnu.retrofitapplication.Model.Users;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Vishnu Nair on 31/10/17.
 */

public interface GetEmployeeDataService
{

    @GET
    Call<EmployeeList> getEmployeeData(@Url String url);

    @GET
    Call<ArrayList<Photos>> getPhotData(@Url String url);

    @GET("/users")
    Call<ArrayList<Users>> getstackoverflowResponse();

    @GET("retrofit-demo.php")
    Call<EmployeeList> getEmployeeData(@Query("company_no") int companyNo);

}
