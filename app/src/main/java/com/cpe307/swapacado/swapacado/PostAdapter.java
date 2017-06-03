package com.cpe307.swapacado.swapacado;

/**
 * Created by aalok_000 on 5/22/2017.
 */

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<Post>{

    Context homeContext;


    public CustomAdapter(Context context, Post [] posts) {
        super(context, R.layout.custom_row ,posts);
        homeContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(this.getContext());
        View theActualView;
        theActualView = myInflater.inflate(R.layout.custom_row, parent, false);


        Post singlePost = getItem(position);

        final String name = singlePost.getName();
        TextView nameView = (TextView) theActualView.findViewById(R.id.postCard_name);
        nameView.setText(name);
        nameView.setTag(singlePost.getDescription());

        ImageView faceLocation = (ImageView) theActualView.findViewById(R.id.postCard_egg);
        faceLocation.setImageResource(singlePost.getFaceRID());
        faceLocation.setTag(singlePost.getFaceRID());


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

        Button contactButton = (Button)  theActualView.findViewById(R.id.postCard_contact);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog contact_popup = new Dialog(homeContext);
                contact_popup.setContentView(R.layout.contact_layout);
                contact_popup.show();
                TextView textName = (TextView) contact_popup.findViewById(R.id.contactPopup_name);
                TextView textPhone = (TextView) contact_popup.findViewById(R.id.contactPopup_phone);
                TextView textEmail = (TextView) contact_popup.findViewById(R.id.contactPopup_email);

                RatingBar ratingBar = (RatingBar) contact_popup.findViewById(R.id.contactPopup_rating);
                ratingBar.setIsIndicator(true);
                float randomFloat = (float) (0.5 * (1 + ((int)(Math.random() * 10))));
                ratingBar.setRating(randomFloat);

                textName.setText(name);
                textName.setTextSize(42);
                textPhone.setText("425.985.4894");
                textPhone.setTextSize(30);
                textEmail.setText(name+"@calpoly.edu");
                textEmail.setTextSize(30);
            }
        });
        theActualView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameString = ((TextView) view.findViewById(R.id.postCard_name)).getText().toString();
                int profileResouurce = (Integer) ((ImageView) view.findViewById(R.id.postCard_egg)).getTag();
                String iWantString = ((TextView) view.findViewById(R.id.postCard_want)).getText().toString();;
                String iHaveString = ((TextView) view.findViewById(R.id.postCard_have)).getText().toString();;
                String description = (String) ((TextView) view.findViewById(R.id.postCard_name)).getTag();

                Intent expandedPost = new Intent(homeContext, ExpandedPostActivity.class);
                expandedPost.putExtra("nameString", nameString);
                expandedPost.putExtra("profileResource", profileResouurce);
                expandedPost.putExtra("iWantString", iWantString);
                expandedPost.putExtra("iHaveString", iHaveString);
                expandedPost.putExtra("description", description);
                homeContext.startActivity(expandedPost);
            }
        });

        //Wire Swap button
        return theActualView;
    }
}
