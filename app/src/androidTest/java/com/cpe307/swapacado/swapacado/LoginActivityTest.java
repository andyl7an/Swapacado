package com.cpe307.swapacado.swapacado;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Post test, which will execute on an Android device.
 * Brandon
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest
{
    @Test
    public void testCreation() throws Exception
    {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.cpe307.swapacado.swapacado", appContext.getPackageName());

    }
    @Test
    public void testImg() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        LoginActivity login = new LoginActivity();
        View theView = login.findViewById(R.id.login_layout);
        ImageView view = new ImageView(appContext);
        view.setImageResource(R.drawable.andy);

        assertEquals(view.getDrawable(), theView.getBackground());


    }

    @Test
    public void testEmail() throws Exception
    {
        Context appContext = InstrumentationRegistry.getTargetContext();
        LoginActivity login = new LoginActivity();
        EditText lgn = (EditText) login.findViewById(R.id.email);
        lgn.setText("test");
        assertEquals("test", lgn.getText().toString());
        lgn.setEnabled(false);
        lgn.setText("test2");
        assertEquals("test", lgn.getText().toString());
    }

    @Test
    public void testPassword() throws  Exception
    {
        Context appContext = InstrumentationRegistry.getTargetContext();
        LoginActivity login = new LoginActivity();
        EditText pass = (EditText) login.findViewById(R.id.password);
        pass.setText("thePassword");

        pass.setText("test");
        assertEquals("test", pass.getText().toString());

        pass.setEnabled(false);
        pass.setText("test2");
        assertEquals("test", pass.getText().toString());
    }
}
