package com.cpe307.swapacado.swapacado;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Post test, which will execute on an Android device.
 * Aalok Ahluwalia and Josh
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class PostTest
{
    @Test
    public void testCreation() throws Exception
    {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.cpe307.swapacado.swapacado", appContext.getPackageName());

        Post createdPost = Post.createPost("sampleId", true, "want string", "have string");
        assertEquals("sampleId", createdPost.posterId);
        assertEquals(true, createdPost.isWant);
        assertEquals("want string", createdPost.wantString);
        assertEquals("have string", createdPost.hasString);
    }
    @Test
    public void testMatchesSearchQuery() throws Exception
    {
        Post pos = Post.createPost("sampleId", true, "I want: Avocadoes", "I have: Eggs");
        boolean actualMatched = pos.matchesSearchQuery("I have: ");
        assertEquals(true, actualMatched);

        actualMatched = pos.matchesSearchQuery("I want: ");
        assertEquals(true, actualMatched);

        actualMatched = pos.matchesSearchQuery(pos.getWantString());
        assertEquals(true, actualMatched);

        actualMatched = pos.matchesSearchQuery(pos.getHaveString());
        assertEquals(true, actualMatched);
    }

    @Test
    public void testGetPostTimeString()
    {
        String theTime = Post.createPost("",false,"","").getPostTimeString();
        boolean hasAmXOrPm = theTime.indexOf("am") == -1 ^ theTime.indexOf("pm") == -1;
        assertEquals(true, hasAmXOrPm);

        boolean hasColon = theTime.indexOf(":") != -1;
        assertEquals(true, hasColon);

        String [] tokens = theTime.trim().split(" ");
        String [] tokens2 = tokens[0].trim().split(":");
        try{
            Integer.parseInt(tokens2[0]);
            Integer.parseInt(tokens2[1]);
            assertFalse(false);
        }
        catch (Exception ex)
        {
            assertFalse(true);
        }
    }

    @Test
    public void testGoods ()
    {
        Post thePost = Post.createPost("posterId", false, "have", "want");
        String distanceString = thePost.getDistanceString();
        String [] tokens = distanceString.split(" ");
        assertEquals("miles", tokens[1]);
        assertEquals(true, tokens[0].indexOf(".") != -1);
        try
        {
            double dub1 = Integer.parseInt(tokens[0]);
            assertEquals(true,true);
        }
        catch(Exception ex)
        {
            assertEquals(true,false);
        }
    }
}
