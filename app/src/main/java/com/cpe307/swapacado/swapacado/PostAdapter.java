package com.cpe307.swapacado.swapacado;

/**
 * Created by aalok_000 on 5/22/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

class CustomAdapter extends ArrayAdapter<Post>{


    public CustomAdapter(Context context, Post [] posts) {
        super(context, R.layout.custom_row ,posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(this.getContext());
        View customView = myInflater.inflate(R.layout.custom_row,parent, false);


        Post singlePost = getItem(position);
        //Name

        //Set profile picture of user
        //set name of user
        //set distance
        //Set Post Date and time of user
        //Set I want
        //Set I have
        //Show rating
        //Wire contact button
        //Wire Offer button
        return customView;
    }
}
