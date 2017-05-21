package com.cpe307.swapacado.swapacado;


import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aalok_000 on 5/21/2017.
 */

public class PostDatabase {

    final static String dbName = "AllPostsV1";
    //THIS LIST WILL KEEP TRACK OF ALL THE POSTS
    static List<Post> allPosts = new ArrayList<Post> ();
    //Later on implement a final List that keeps tracks of diffs and pushes updates

    public static void init()
    {
        FirebaseDatabase dbInstance = FirebaseDatabase.getInstance();
        DatabaseReference myRef = dbInstance.getReference(dbName);

        allPosts = new ArrayList<>();
        Post samplePost = Post.createPost("123", true, "i want", "i have");
        allPosts.add(samplePost);
        myRef.setValue(allPosts);;
    }
    public static void refreshAllPosts()
    {
        FirebaseDatabase dbInstance = FirebaseDatabase.getInstance();
        DatabaseReference myRef = dbInstance.getReference(dbName);

        final String TAG = "Ahluwalia";

        myRef.addValueEventListener(new ValueEventListener() {
            //Called every time the data in the db changes
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<List<Post>> t = new GenericTypeIndicator<List<Post>>() {};
                List<Post> updatedList = dataSnapshot.getValue(t);
                Log.d(TAG, "Updated db to: " + updatedList);
                allPosts = updatedList;
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
    public static List<Post> getWantPosts()
    {
        final ArrayList<Post> wantsOnly = new ArrayList<>();
        for(Post p : allPosts)
        {
            if(p.isWant)
            {
                wantsOnly.add(p);
            }
        }
        return wantsOnly;
    }
    public static List<Post> getHasPosts()
    {
        final ArrayList<Post> hasOnly = new ArrayList<>();
        for(Post p : allPosts)
        {
            if(p.isWant)
            {
                hasOnly.add(p);
            }
        }
        return hasOnly;
    }
    public static boolean addPost(Post p)
    {
        allPosts.add(p);
        FirebaseDatabase dbInstance = FirebaseDatabase.getInstance();
        DatabaseReference myRef = dbInstance.getReference("AllPostsV1");
        myRef.setValue(allPosts);
        return true;
    }
}
