package com.cpe307.swapacado.swapacado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //removed temporarily taken out code to accomodate sonarqube
        Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
        homeIntent.putExtra("uniqueID", ""); // This token will be generated using the value of the login
        //We should use the UID stored in firebase
        startActivity(homeIntent);
        finish();
    }
}
