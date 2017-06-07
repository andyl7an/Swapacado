package com.cpe307.swapacado.swapacado;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Post test, which will execute on an Android device.
 * Michael
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class HomeActivityTest
{
    @Test
    public void testCreation() throws Exception
    {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.cpe307.swapacado.swapacado", appContext.getPackageName());

    }

    @Test
    public void testHeaders() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        HomeActivity activity= new HomeActivity();
        View view = activity.findViewById(R.id.homeHeader);
        assertNotNull(view);
        assertEquals(activity.findViewById(R.id.plusButton), view.findViewById(R.id.plusButton));
        assertEquals(activity.findViewById(R.id.messageIcon), view.findViewById(R.id.messageIcon));

    }

    @Test
    public void testMyListView() throws Exception
    {
        Context appContext = InstrumentationRegistry.getTargetContext();
        HomeActivity activity = new HomeActivity();

        activity.filterByWhatIHave();
        assertNotNull(activity.findViewById(R.id.home_listview));

        View titleView = activity.findViewById(R.id.homeHeader);
        String titleString = titleView.toString();
        assertEquals("Swapacado", titleString);
    }
}
