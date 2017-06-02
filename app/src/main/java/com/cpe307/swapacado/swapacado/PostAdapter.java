package com.cpe307.swapacado.swapacado;

/**
 * Created by aalok_000 on 5/22/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<Post>{


    private View theActualView;

    public CustomAdapter(Context context, Post [] posts) {
        super(context, R.layout.custom_row ,posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(this.getContext());
        theActualView = myInflater.inflate(R.layout.custom_row, parent, false);


        Post singlePost = getItem(position);

        String name = singlePost.getName();
        TextView nameView = (TextView) theActualView.findViewById(R.id.postCard_name);
        nameView.setText(name);

        String faceURL = singlePost.getFaceURL();
        ImageView faceLocation = (ImageView) theActualView.findViewById(R.id.postCard_egg);
        faceLocation.setImageResource(singlePost.getFaceRID());

        String distanceString = singlePost.getDistanceString();
        TextView distanceView = (TextView) theActualView.findViewById(R.id.postCard_distance);
        distanceView.setText(distanceString);

        String dateString = singlePost.getPostTimeString();
        TextView dateView = (TextView) theActualView.findViewById(R.id.postCard_postDate);
        dateView.setText(dateString);

        String haveString = singlePost.getHaveString();
        TextView haveView = (TextView) theActualView.findViewById(R.id.postCard_have);
        haveView.setText(haveString);

        String wantString = singlePost.getWantString();
        TextView wantView = (TextView) theActualView.findViewById(R.id.postCard_want);
        wantView.setText(wantString);

        //Set profile picture of user
        //Show rating
        //Wire contact button
        //Wire Offer button
        return theActualView;
    }
}
