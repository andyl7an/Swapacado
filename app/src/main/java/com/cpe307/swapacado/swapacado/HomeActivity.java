package com.cpe307.swapacado.swapacado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    protected String uniqueID;

    //Make the buttons at the bottom of the screen active
    private void attachMenuButtonHandlers() {
        View homeMenuBox = this.findViewById(R.id.homeMenuBar);
        homeMenuBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //To remove
                Toast.makeText(getApplicationContext(), "Home was clicked!!!", Toast.LENGTH_SHORT).show();
            }
        });
        View mapMenuBox = this.findViewById(R.id.mapMenuBar);
        mapMenuBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Remove toast
                Toast.makeText(getApplicationContext(), "Map was clicked!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this, MapActivity.class);
                intent.putExtra("uniqueID", uniqueID);
                startActivity(intent);
            }
        });

        View searchMenuBox = this.findViewById(R.id.searchMenuBar);
        searchMenuBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Search was clicked!!!", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                //intent.putExtra("uniqueID", uniqueID);
                //startActivity(intent);
            }
        });

        View profileMenuBox = this.findViewById(R.id.profileMenuBar);
        profileMenuBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Post was clicked!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                uniqueID = "123";
                intent.putExtra("uniqueID", uniqueID);
                startActivity(intent);
            }
        });
    }

    private void adjustTitleBar() {
        View title = this.findViewById(R.id.homeTitle);
        View plus = this.findViewById(R.id.plusButton);
        View messageIcon = this.findViewById(R.id.messageIcon);

        int titleHeight = title.getLayoutParams().height;

        //Set the plus' height and width to the dimensions of the height of the title
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(titleHeight,titleHeight);
        plus.setLayoutParams(layoutParams);
        messageIcon.setLayoutParams(layoutParams);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        uniqueID = this.getIntent().getStringExtra("uniqueID");

        attachMenuButtonHandlers();
        adjustTitleBar();



        //PURELY FOR DEVELOPMENT PURPOSES
        Intent mapIntent = new Intent(HomeActivity.this, MapActivity.class);

    }
}