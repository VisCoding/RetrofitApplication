package com.example.vishnu.retrofitapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vishnu.retrofitapplication.Model.Users;
import com.example.vishnu.retrofitapplication.R;

import java.util.ArrayList;

/**
 * Created by Admin on 11-11-2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    ArrayList<Users> usersArrayList;

    public UserAdapter(ArrayList<Users> usersArrayList){
        this.usersArrayList = usersArrayList;
    }
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
       View rootView = inflater.inflate(R.layout.row_user_details,parent,false);
        return new UserViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
      holder.txt_name.setText(usersArrayList.get(position).getName());
      holder.txt_email.setText(usersArrayList.get(position).getEmail());
      holder.txt_phone.setText(usersArrayList.get(position).getPhone());
      holder.txt_street.setText(usersArrayList.get(position).getAddressDetails().getStreet());
      holder.txt_pincode.setText(usersArrayList.get(position).getAddressDetails().getZipcode());
      holder.txt_lat.setText(usersArrayList.get(position).getAddressDetails().getGeo().getLat());

    }

    @Override
    public int getItemCount() {
        return usersArrayList == null ? 0 : usersArrayList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView txt_name , txt_email ,txt_lat  , txt_street , txt_pincode ,txt_phone;
        public UserViewHolder(View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_email = itemView.findViewById(R.id.txt_email);
            txt_phone = itemView.findViewById(R.id.txt_phone);
            txt_street = itemView.findViewById(R.id.txt_street);
            txt_pincode = itemView.findViewById(R.id.txt_pincode);
            txt_lat = itemView.findViewById(R.id.txt_lat);
        }
    }
}
