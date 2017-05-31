package com.cpe307.swapacado.swapacado;

/**
 * A class to represent the Post class
 * Created by aalok_000 on 5/21/2017.
 */

public class Post {
    public String posterId;
    public boolean isWant;
    public boolean postVisible;
    public String wantString;
    public String hasString;
    public long epochTime;

    private String privateName;
    private String privateDistance;
    private String privateDate;
    private String privateWant;
    private int index = -1;
    private String privateHave;

    final static String [] goods = new String [] {"Eggs", "Cereal", "Fruit", "Bagels", "Avacadoes", "Milk",
        "Plus Dollars", "Ice Cream", "Chocolate", "Tea", "Apple Juice", "Coke",
        "Bread","Granola bars","Ramen","Chips","Cookies","Wine",};
    //Need empty constructor for db
    public Post()
    {
        privateName = null;
        privateDistance = null;
        privateDate = null;
        privateWant = null;
        privateHave = null;
    }

    public static Post createPost(String posterId, boolean isWant, String wantString, String hasString)
    {
        Post p = new Post();
        p.posterId = posterId;
        p.isWant = isWant;
        p.wantString = wantString;
        p.hasString = hasString;
        p.epochTime = System.currentTimeMillis() / 1000;

        p.populateHiddenVariables();
        return p;
    }

    //A method to set the private variables for the program
    private void populateHiddenVariables() {
        getName();
        getDistanceString();
        getHaveString();
        getWantString();
        getPostTimeString();
    }

    //Stub method returning dummy data
    public String getName()
    {
        if(privateName != null)
        {
            return privateName;
        }
        String [] names = new String [] {"Davide", "Zach", "Bill", "Andy", "Josh", "Aalok", "Brandon", "Michael", "Mark", "Harry",
            "Alex", "Mary", "Barbara", "Sam", "Linda", "Sophia", "Emma", "Olivia", "Ava", "Lily"};
        int rand = (int) (Math.random() * names.length);
        privateName =  names[rand];
        return getName();
    }
    public String getDistanceString()
    {
        if(privateDistance != null)
        {
            return privateDistance;
        }
        int rand = (int) (Math.random() * 50) + 1;
        double milesAway = rand / 10.0;
        privateDistance = String.format("%.1f miles", milesAway);
        return getDistanceString();
    }
    public String getPostTimeString()
    {
        if(privateDate != null)
        {
            return privateDate;
        }
        String output = "";
        int hr = 8 + ((int) ( Math.random() * 12));
        int min = ((int) (Math.random() * 60));
        if(hr < 12)
        {
            output = hr + ":";
            if(min < 10)
            {
                output = output + "0" + min;
            }
            else
            {
                output = output + min;
            }
            output += " am";
        }
        else if(hr == 12)
        {
            output = "12:";
            if(min < 10)
            {
                output = output + "0" + min;
            }
            else
            {
                output = output + min;
            }
            output += " pm";
        }
        else
        {
            hr -= 12;
            output = hr + ":";
            if(min < 10)
            {
                output = output + "0" + min;
            }
            else
            {
                output = output + min;
            }
            output += " pm";

        }
        privateDate = output;
        return getPostTimeString();
    }
    public String getWantString()
    {
        if(privateWant != null)
        {
            return privateWant;
        }
        int rand = ((int) (Math.random() * goods.length));
        while(index == rand)
        {
            rand = ((int) (Math.random() * goods.length));
        }
        index = rand;
        privateWant = "I want: " + goods[rand];
        return getWantString();
    }
    public String getHaveString()
    {
        if(privateHave != null)
        {
            return privateHave;
        }
        int rand = ((int) (Math.random() * goods.length));
        while(index == rand)
        {
            rand = ((int) (Math.random() * goods.length));
        }
        index = rand;
        privateHave = "I have: " + goods[rand];
        return getHaveString();
    }
    public boolean matchesSearchQuery(String query)
    {
        String searchString = "";
        if(privateName != null)
        {
            searchString += privateName;
        }
        if(privateWant != null)
        {
            searchString += privateWant;
        }
        if(privateHave != null)
        {
            searchString += privateHave;
        }
        searchString = searchString.toUpperCase();
        query = query.toUpperCase();
        return searchString.indexOf(query) != -1;
    }

    public boolean matchesHaves(String query) {
        if(privateHave != null)
        {
            return privateHave.toUpperCase().indexOf(query.toUpperCase()) != -1;
        }
        return false;
    }
    public boolean matchesWants(String query) {
        if(privateWant != null)
        {
            return privateWant.toUpperCase().indexOf(query.toUpperCase()) != -1;
        }
        return false;
    }
    /**
     *
     * @return true if poster wants the objects, false if poster has objects
     */
/*
    public String getWantString()
    {
        return this.wantString;
    }
    public String getHasString()
    {
        return this.hasString;
    }
    public long getPostTime()
    {
        return epochTime;
    }
    */
}
