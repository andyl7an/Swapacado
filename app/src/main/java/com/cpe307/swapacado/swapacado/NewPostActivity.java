package com.cpe307.swapacado.swapacado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class NewPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        ViewGroup injectionLocation = (LinearLayout) this.findViewById(R.id.newPost_customRowInjectionLocation);
        LayoutInflater myInflater = null;
        View child = getLayoutInflater().inflate(R.layout.custom_row, null);
        injectionLocation.addView(child);
//        myInflater.inflate;
//        View.inflate(this.getApplicationContext(),R.id.xml_customRow, injectionLocation);

    }
    //On click for the post button
}
