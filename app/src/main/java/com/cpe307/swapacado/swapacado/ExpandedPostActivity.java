package com.cpe307.swapacado.swapacado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ExpandedPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_post);

        TextView nameView = (TextView) findViewById(R.id.expanded_name);
        ImageView eggView = (ImageView) findViewById(R.id.expanded_egg);
        RatingBar ratingView = (RatingBar) findViewById(R.id.expanded_rating);

        TextView emailView = (TextView) findViewById(R.id.expanded_email);

        TextView iWantView = (TextView) findViewById(R.id.expanded_want);
        TextView iHaveView = (TextView) findViewById(R.id.expanded_have);

        TextView descriptionView = (TextView) findViewById(R.id.expanded_description);

        Intent theIntent = this.getIntent();
        String nameString = theIntent.getStringExtra("nameString");
        String iWantString = theIntent.getStringExtra("iWantString");
        String iHaveString = theIntent.getStringExtra("iHaveString");
        int profileResource = theIntent.getIntExtra("profileResource", -1);
        String description = theIntent.getStringExtra("description");

        nameView.setText(nameString);
        iHaveView.setText(iHaveString);
        iWantView.setText(iWantString);
        emailView.setText(nameString+"@calpoly.edu");
        if(profileResource != -1)
        {
            eggView.setImageResource(profileResource);
        }
        float randomRating = (float) (0.5 * (1 + ((int)(Math.random() * 10))));
        ratingView.setRating(randomRating);
        descriptionView.setText(description);

    }
}
