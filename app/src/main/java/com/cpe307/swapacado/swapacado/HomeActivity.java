package com.cpe307.swapacado.swapacado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    //Make the buttons at the bottom of the screen active
    private void attachMenuButtonHandlers() {
        View homeMenuBox = this.findViewById(R.id.homeMenuBar);
        homeMenuBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Home was clicked!!!", Toast.LENGTH_SHORT).show();
            }
        });
        View mapMenuBox = this.findViewById(R.id.mapMenuBar);
        mapMenuBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Map was clicked!!!", Toast.LENGTH_SHORT).show();
            }
        });

        View searchMenuBox = this.findViewById(R.id.searchMenuBar);
        searchMenuBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Search was clicked!!!", Toast.LENGTH_SHORT).show();
            }
        });

        View postMenuBox = this.findViewById(R.id.postMenuBar);
        postMenuBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Post was clicked!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void adjustTitleBar() {
        View title = this.findViewById(R.id.homeTitle);
        View plus = this.findViewById(R.id.plusButton);

        int titleHeight = title.getLayoutParams().height;

        //Set the plus' height and width to the dimensions of the height of the title
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(titleHeight,titleHeight);
        plus.setLayoutParams(layoutParams);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        attachMenuButtonHandlers();
        adjustTitleBar();



        //PURELY FOR DEVELOPMENT PURPOSES
        Intent mapIntent = new Intent(HomeActivity.this, MapActivity.class);

    }
}
