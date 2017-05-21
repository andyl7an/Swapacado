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

    //Need empty constructor for db
    public Post()
    {

    }

    public static Post createPost(String posterId, boolean isWant, String wantString, String hasString)
    {
        Post p = new Post();
        p.posterId = posterId;
        p.isWant = isWant;
        p.wantString = wantString;
        p.hasString = hasString;
        p.epochTime = System.currentTimeMillis() / 1000;
        return p;
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
