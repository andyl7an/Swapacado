package com.cpe307.swapacado.swapacado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

    public void hitSwapButton(View view) {
        String nameString = ((TextView) findViewById(R.id.expanded_name)).getText().toString();
        String iWantString = ((TextView) findViewById(R.id.expanded_want)).getText().toString();
        iWantString = iWantString.substring(iWantString.indexOf(':') + 2);
        String iHaveString = ((TextView) findViewById(R.id.expanded_have)).getText().toString();
        iHaveString = iHaveString.substring(iHaveString.indexOf(':') + 2);
        String description = (String) ((TextView) findViewById(R.id.expanded_description)).getText();

        Intent proposeSwap = new Intent(getApplicationContext(), ProposeSwapActivity.class);
        proposeSwap.putExtra("posterName", nameString);
        proposeSwap.putExtra("yourName", "Davide");
        proposeSwap.putExtra("wantString", iWantString);
        proposeSwap.putExtra("haveString", iHaveString);
        proposeSwap.putExtra("posterDescription", description);

        startActivity(proposeSwap);
        finish();
    }
}
