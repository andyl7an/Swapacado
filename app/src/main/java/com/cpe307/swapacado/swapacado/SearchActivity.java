package com.cpe307.swapacado.swapacado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    protected String uniqueID = "123";
    String searchItem;
    Spinner selector;
    ImageButton searchButton;
    boolean searchHaves;
    boolean searchWants;
    String[] categories;

    //Make the buttons at the bottom of the screen active
    private void attachMenuButtonHandlers() {
        View homeMenuBox = this.findViewById(R.id.homeMenuBar);
        homeMenuBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(SearchActivity.this, HomeActivity.class);
                startActivity(homeIntent);
            }
        });

        View searchMenuBox = this.findViewById(R.id.searchMenuBar);
        searchMenuBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Search was clicked!!!", Toast.LENGTH_SHORT).show();
            }
        });

        View profileMenuBox = this.findViewById(R.id.profileMenuBar);
        profileMenuBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, ProfileActivity.class);
                intent.putExtra("uniqueID", uniqueID);
                startActivity(intent);
                finish();
            }
        });
    }

    private void adjustTitleBar() {
        //Set the plus' height and width to the dimensions of the height of the title
    }

    private void setSearchFilter()
    {
        selector = (Spinner)findViewById(R.id.searchSpinner);
        selector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                searchItem = categories[position];
/**DBGY**/                Toast.makeText(getApplicationContext(), "Selected: " + searchItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //nothing selected
            }
        });
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        selector.setAdapter(categoryAdapter);

        searchButton = (ImageButton)findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                preformSearch();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        populateCategories();
        attachMenuButtonHandlers();
        adjustTitleBar();
        setSearchFilter();

        searchHaves = false;
        searchWants = false;

        ListView myListView = (ListView) findViewById(R.id.search_listview);
        Post [] data = getPosts();
        myListView.setAdapter(new CustomAdapter(SearchActivity.this, data));
    }

    private Post[] getPosts() {
        return  PostDatabase.getAllPostsDummy();
    }

    // Populates the category drop-down with the same strings as the posts
    private void populateCategories()
    {
        categories = new String[]{"Eggs", "Cereal", "Fruit", "Bagels", "Avocadoes", "Milk",
                "Plus Dollars", "Ice Cream", "Chocolate", "Tea", "Apple Juice", "Coke",
                "Bread","Granola bars","Ramen","Chips","Cookies","Wine",};
    }

    // The on-ccheck listener for the "Haves" checkbox
    public void checkHaves(View view)
    {
        searchHaves = !searchHaves;
    }

    // The on-check listener for the "Wants" checkbox
    public void checkWants(View view)
    {
        searchWants = !searchWants;
    }

    // This will filter based on the search criteria
    private void preformSearch()
    {
        Post [] currentPosts = getPosts();
        ArrayList<Post> filtered = new ArrayList<>();

        boolean canAddHave = false;
        boolean canAddWant = false;

        for(Post aPost : currentPosts)
        {

            if(searchHaves)
            {
                canAddHave = aPost.matchesHaves(searchItem);
            }

            if(searchWants)
            {
                canAddWant  = aPost.matchesWants(searchItem);
            }

            if(canAddHave || canAddWant)
            {
                filtered.add(aPost);
            }
        }

        Post [] filteredArray = filtered.toArray(new Post[filtered.size()]);
        ListView myListView = (ListView) findViewById(R.id.search_listview);
        myListView.setAdapter(new CustomAdapter(SearchActivity.this, filteredArray));

    }

}