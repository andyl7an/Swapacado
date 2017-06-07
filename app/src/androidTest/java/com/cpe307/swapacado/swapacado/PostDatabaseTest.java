package com.cpe307.swapacado.swapacado;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Post test, which will execute on an Android device.
 * Andy and Andy
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class PostDatabaseTest
{
    @Test
    public void testCreation() throws Exception
    {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.cpe307.swapacado.swapacado", appContext.getPackageName());
        assertEquals(null, appContext.getApplicationContext());
    }
    @Test
    public void testGetList() throws Exception
    {
        Post [] lis = PostDatabase.getAllPostsDummy();
        assertEquals(true, lis != null);
        assertEquals(true, lis.length > 0);
    }

    @Test
    public void testRefresh()
    {
        Post [] lis = PostDatabase.getAllPostsDummy();
        PostDatabase.refreshAllPosts();

        Post[] lis2 = PostDatabase.getAllPostsDummy();

        assertEquals(lis.length, lis2.length);

    }

    @Test
    public void testPost()
    {
        Post [] lis = PostDatabase.getAllPostsDummy();
        PostDatabase.refreshAllPosts();
        PostDatabase.demoAdd(null);
        Post[] lis2 = PostDatabase.getAllPostsDummy();

        assertEquals(lis.length, lis2.length);

    }
}
