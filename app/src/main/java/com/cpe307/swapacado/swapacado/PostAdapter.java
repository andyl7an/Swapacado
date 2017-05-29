package com.cpe307.swapacado.swapacado;

/**
 * Created by aalok_000 on 5/22/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<Post>{


    public CustomAdapter(Context context, Post [] posts) {
        super(context, R.layout.custom_row ,posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(this.getContext());
        View customView = myInflater.inflate(R.layout.custom_row,parent, false);


        Post singlePost = getItem(position);

        String name = singlePost.getName();
        TextView nameView = (TextView) customView.findViewById(R.id.postCard_name);
        nameView.setText(name);

        String distanceString = singlePost.getDistanceString();
        TextView distanceView = (TextView) customView.findViewById(R.id.postCard_distance);
        distanceView.setText(distanceString);

        String dateString = singlePost.getPostTimeString();
        TextView dateView = (TextView) customView.findViewById(R.id.postCard_postDate);
        dateView.setText(dateString);

        String haveString = singlePost.getHaveString();
        TextView haveView = (TextView) customView.findViewById(R.id.postCard_have);
        haveView.setText(haveString);

        String wantString = singlePost.getWantString();
        TextView wantView = (TextView) customView.findViewById(R.id.postCard_want);
        wantView.setText(wantString);

        //Set profile picture of user
        //Show rating
        //Wire contact button
        //Wire Offer button
        return customView;
    }
}
