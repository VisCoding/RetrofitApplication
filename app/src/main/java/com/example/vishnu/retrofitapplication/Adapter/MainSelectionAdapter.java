package com.example.vishnu.retrofitapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vishnu.retrofitapplication.Activity.PhotoRetrieveActivity;
import com.example.vishnu.retrofitapplication.Model.MainModel;
import com.example.vishnu.retrofitapplication.R;

import java.util.ArrayList;

/**
 * Created by Admin on 12-11-2017.
 */

public class MainSelectionAdapter extends RecyclerView.Adapter<MainSelectionAdapter.MainViewHolder> {
    ArrayList<MainModel>  mainModelArrayList;
    Context mcontext;

    public MainSelectionAdapter(ArrayList<MainModel>  mainModelArrayList , Context context){
        this.mainModelArrayList = mainModelArrayList;
        this.mcontext = context;
    }
    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       LayoutInflater inflater = LayoutInflater.from(parent.getContext());
       View rootView = inflater.inflate(R.layout.row_selection , parent ,false);
        return new MainViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, final int position) {
        holder.txt_activity_name.setText(mainModelArrayList.get(position).getActivityName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Class activity = mainModelArrayList.get(position).getActivity();
                Intent intent = new Intent(mcontext, activity);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mainModelArrayList == null ? 0 : mainModelArrayList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{
        TextView txt_activity_name , txt_other_detail;

        public MainViewHolder(View itemView) {
            super(itemView);
            txt_activity_name = itemView.findViewById(R.id.txt_activity_name);
            txt_other_detail = itemView.findViewById(R.id.txt_other_detail);
        }
    }
}
