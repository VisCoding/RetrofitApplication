package com.example.vishnu.retrofitapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vishnu.retrofitapplication.Model.Photos;
import com.example.vishnu.retrofitapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by uaeexchange on 10/11/17.
 */

/*Picasso.with(context).load(tnu).error(R.drawable.no_img).placeholder(R.drawable.img_def).into(holder.immoPic);
*
* String imageUrl = "https://www.baby-connect.com/images/baby2.gif";

        CircleImageView imageView = (CircleImageView) findViewById(R.id.image);

        Picasso.with(getApplicationContext()).load(imageUrl)
                .placeholder(R.drawable.images).error(R.drawable.ic_launcher)
                .into(imageView);
* */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>{

    private ArrayList<Photos> photolist ;
    Context mContext ;

    public  PhotoAdapter( ArrayList<Photos> photolist , Context context){
        this.photolist = photolist;
        mContext = context;

    }
    @Override
    public  PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        View rootView = layoutInflater.inflate(R.layout.row_photos,parent,false);
        return new PhotoViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(PhotoAdapter.PhotoViewHolder holder, int position) {

        holder.titleText.setText(photolist.get(position).getTitle());
        String thumbnailUrl = photolist.get(position).getThumbnailUrl();

        Picasso.with(mContext).load(thumbnailUrl).fit()
                .placeholder(R.drawable.progress_animation).error(R.mipmap.errrorimage_img)
                .into(holder.circleImageView);

    }


    @Override
    public int getItemCount() {
        return photolist.size();
    }


    class PhotoViewHolder extends  RecyclerView.ViewHolder {
        TextView titleText ;
        CircleImageView circleImageView ;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            circleImageView =  (CircleImageView) itemView.findViewById(R.id.image_view);
            titleText = itemView.findViewById(R.id.title_text);

        }
    }
}
