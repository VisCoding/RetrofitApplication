package com.example.vishnu.retrofitapplication.Model;

import android.app.Activity;

/**
 * Created by Admin on 12-11-2017.
 */

public class MainModel {

    private String  ActivityName;
    private Class Activity;
    private String otherDetails;

    public MainModel(String ActivityName , Class Activity , String otherDetails){
        this.ActivityName = ActivityName;
        this.Activity = Activity;
        this.otherDetails = otherDetails;
    }


    public Class getActivity() {
        return this.Activity;
    }

    public void setActivity(Class activity) {
        this.Activity = activity;
    }



    public String getActivityName() {
        return ActivityName;
    }

    public void setActivityName(String activityName) {
        ActivityName = activityName;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }



}
