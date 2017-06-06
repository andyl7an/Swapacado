package com.cpe307.swapacado.swapacado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    protected String uniqueID = "123";
    private boolean shouldRefreshList;

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

        View searchMenuBox = this.findViewById(R.id.searchMenuBar);
        searchMenuBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(searchIntent);
            }
        });

        View profileMenuBox = this.findViewById(R.id.profileMenuBar);
        profileMenuBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                intent.putExtra("uniqueID", uniqueID);
                startActivity(intent);
                finish();
            }
        });
    }

    private void attachTopButtonHandlers()
    {
        View newPostButton = this.findViewById(R.id.plusButton);
        newPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, NewPostActivity.class);
                shouldRefreshList = true;
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
        attachTopButtonHandlers();
        PostDatabase.refreshAllPosts();

        ListView myListView = (ListView) findViewById(R.id.home_listview);

        Post [] data = getPosts();
        myListView.setAdapter(new CustomAdapter(HomeActivity.this, data));
    }

    //Should change the list adapter according to what is in the
    private void filterByWhatIWant()
    {
        String [] wants = getWants();
        Post [] currentPosts = getPosts();
        ArrayList<Post> filtered = new ArrayList<>();
        for(Post aPost : currentPosts)
        {
            boolean canAdd = false;
            for(String query : wants)
            {
                if(!canAdd)
                {
                    canAdd = aPost.matchesHaves(query);
                }
            }
            if(canAdd)
            {
                filtered.add(aPost);
            }
        }

        Post [] filteredArray = filtered.toArray(new Post[filtered.size()]);
        ListView myListView = (ListView) findViewById(R.id.home_listview);
        myListView.setAdapter(new CustomAdapter(HomeActivity.this, filteredArray));
    }

    private Post[] getPosts() {
        return  PostDatabase.getAllPostsDummy();
    }

    //Display in list view only people asking for things i have
    public void filterByWhatIHave()
    {
        String [] haves = getHaves();
        Post [] currentPosts = getPosts();
        ArrayList<Post> filtered = new ArrayList<>();
        for(Post aPost : currentPosts)
        {
            boolean canAdd = false;
            for(String query : haves)
            {
                if(!canAdd)
                {
                    canAdd = aPost.matchesWants(query);
                }
            }
            if(canAdd)
            {
                filtered.add(aPost);
            }
        }
        Post [] filteredArray = filtered.toArray(new Post[filtered.size()]);
        ListView myListView = (ListView) findViewById(R.id.home_listview);
        myListView.setAdapter(new CustomAdapter(HomeActivity.this, filteredArray));

    }

    //getHaves and getWants need to be linked to the posts that the user currently has up
    //will dynamically look at them to create these two lists

    //List of strings that the user HAS and wants to trade away
    private String[] getHaves() {
        return new String []{"Chips", "Wine", "Coke"};
    }

    //List of strings that the other person has BUT USER WANTS
    private String[] getWants() {
        return new String [] {"Eggs", "Milk", "Cereal"};
    }

    public void toggleHaves(View view) {
        checkboxWork();
    }

    public void toggleWants(View view) {
        checkboxWork();
    }
    public void filterPerfectTrades()
    {
        Post [] currentPosts = getPosts();
        ArrayList<Post> filtered = new ArrayList<>();

        String [] haves = getHaves();
        String [] wants = getWants();
        for(Post aPost : currentPosts)
        {
            boolean canAddHave = false;
            boolean canAddWant = false;
            for(String query : haves)
            {
                if(!canAddHave)
                {
                    canAddHave = aPost.matchesWants(query);
                }
            }
            for(String query : wants)
            {
                if(!canAddWant)
                {
                    canAddWant  = aPost.matchesHaves(query);
                }
            }
            if(canAddHave && canAddWant)
            {
                filtered.add(aPost);
            }
        }

        Post [] filteredArray = filtered.toArray(new Post[filtered.size()]);
        ListView myListView = (ListView) findViewById(R.id.home_listview);
        myListView.setAdapter(new CustomAdapter(HomeActivity.this, filteredArray));
    }

    private void checkboxWork() {
        CheckBox ifIHave = (CheckBox) findViewById(R.id.home_toggleHave);
        CheckBox ifIWant = (CheckBox) findViewById(R.id.home_toggleWant);

        boolean onlyThingsIWant = ifIHave.isChecked();
        boolean onlyThingsIHave = ifIWant.isChecked();

        if(onlyThingsIHave && onlyThingsIWant)
        {
            filterPerfectTrades();
        }
        else if(onlyThingsIHave)
        {
            filterByWhatIHave();
        }
        else if(onlyThingsIWant)
        {
            filterByWhatIWant();
        }
        else
        {
            ListView myListView = (ListView) findViewById(R.id.home_listview);
            Post [] data = getPosts();
            myListView.setAdapter(new CustomAdapter(HomeActivity.this, data));
        }

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if(shouldRefreshList)
        {
            shouldRefreshList = false;
            checkboxWork();
        }


    }
}