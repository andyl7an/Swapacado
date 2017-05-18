package com.cpe307.swapacado.swapacado;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

public class ProfileActivity extends AppCompatActivity {

    String uniqueID;

    private UserAccount getProfileFromUniqueId(String uniqueId) {
        UserAccount user = new UserAccount();
        user.setFirstname("Davide");
        user.setLastname("Falessi");
        user.rating = 3.2;
        return user;
    }
    private void attachMenuButtonHandlers() {
        View homeMenuBox = this.findViewById(R.id.homeMenuBar);
        homeMenuBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //To remove
                Toast.makeText(getApplicationContext(), "Home was clicked!!!", Toast.LENGTH_SHORT).show();
                Intent homeIntent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(homeIntent);
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
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        attachMenuButtonHandlers();

        String uniqueID = this.getIntent().getStringExtra("uniqueID");
        this.uniqueID = uniqueID;

        UserAccount currentUser = getProfileFromUniqueId(uniqueID);

        TextView nameBox = (TextView) findViewById(R.id.profilePageName);
        nameBox.setText(currentUser.getFirstname() + " " + currentUser.getLastname());

        String falessiImageURL = "http://users.csc.calpoly.edu/~ahluwali/swapacado_assets/davide.jpg";

        AsyncPictureFetcher fetchImage = new AsyncPictureFetcher();
        fetchImage.execute(falessiImageURL);
        configureImage();

        setTradeCount();


    }

    private void setTradeCount() {
        TextView trades = (TextView) findViewById(R.id.profilePageTradeCount);
        int tradeCount = getTradesById(uniqueID);
        trades.setText("Trades : " + tradeCount);
        if(tradeCount == 0) {
            trades.setText("No Trades!!!");
        }
    }

    //A method to configure the impage relative to the dimensions of the device
    //The picture will take up half of the screen space
    private void configureImage() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        RelativeLayout.LayoutParams halfPage = new RelativeLayout.LayoutParams(width, height/2);
        ImageView profPic = (ImageView) findViewById(R.id.profilePageImage);
        profPic.setLayoutParams(halfPage);
    }

    private int getTradesById(String id) {
        return (int) (Math.random() * 100);
    }

    /**
     * Given a URL, returns a drawable object pointed to by url
     */
    class AsyncPictureFetcher extends AsyncTask <String, String, Drawable> {
        @Override
        protected Drawable doInBackground(String... strings) {
            try {
                InputStream is = (InputStream) new URL(strings[0]).getContent();
                Drawable d = Drawable.createFromStream(is, "content delivery source");
                return d;
            } catch(Exception ex) {
                Log.d("Ahluwalia", "Exception with network request!!!");
                Log.d("Ahluwalia", ex.toString());
                return null;
            }
        }
        @Override
        protected  void onPostExecute(Drawable result) {
            super.onPostExecute(result);
            ((ImageView) findViewById(R.id.profilePageImage)).setImageDrawable(result);
        }
    }

}

