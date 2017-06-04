package com.cpe307.swapacado.swapacado;


import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by aalok_000 on 5/21/2017.
 */

public class PostDatabase {
    static final String DBNAME = "AllPostsV1";
    //THIS LIST WILL KEEP TRACK OF ALL THE POSTS
    static List<Post> allPosts = new ArrayList<> ();
    //Later on implement a final List that keeps tracks of diffs and pushes updates
    static Post [] theDummyPosts = null;

    private PostDatabase() {
        throw new IllegalAccessError("Utility class");
    }

    public static void init()
    {
        FirebaseDatabase dbInstance = FirebaseDatabase.getInstance();
        DatabaseReference myRef = dbInstance.getReference(DBNAME);

        allPosts = new ArrayList<>();
        Post samplePost = Post.createPost("123", true, "i want", "i have");
        allPosts.add(samplePost);
        myRef.setValue(allPosts);
    }
    public static List <Post> getAllPosts()
    {
        return new ArrayList<>(allPosts);
    }
    public static Post [] getAllPostsDummy()
    {
        if(theDummyPosts == null)
        {
            theDummyPosts = new Post[65];
            for(int ind = 0; ind < theDummyPosts.length; ind++)
            {
                theDummyPosts[ind] = Post.createPost("",false,"","");
            }
            timeSortDummyPosts();
        }
        return theDummyPosts;
    }

    private static void timeSortDummyPosts() {
        Arrays.sort(theDummyPosts, new Comparator(){
            public int compare(Object o1, Object o2)
            {
                Post p1 = (Post) o1;
                Post p2 = (Post) o2;
                return p1.demoTime - p2.demoTime;
            }
        });
    }

    public static void refreshAllPosts()
    {
        FirebaseDatabase dbInstance = FirebaseDatabase.getInstance();
        DatabaseReference myRef = dbInstance.getReference(DBNAME);

        final String tag = "Ahluwalia";

        myRef.addValueEventListener(new ValueEventListener() {
            //Called every time the data in the db changes
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<List<Post>> t = new GenericTypeIndicator<List<Post>>() {};
                List<Post> updatedList = dataSnapshot.getValue(t);
                Log.d(tag, "Updated db to: " + updatedList);
                allPosts = updatedList;
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(tag, "Failed to read value.", error.toException());
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

    public static void demoAdd(Post toAdd) {
        Post [] oldPosts = getAllPostsDummy();
        Post [] newPosts = new Post [oldPosts.length + 1];
        newPosts[0] = toAdd;
        for(int ind = 0; ind < oldPosts.length; ind++)
        {
            newPosts[ind+1] = oldPosts[ind];
        }
        theDummyPosts = newPosts;
    }
}
