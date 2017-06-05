package com.cpe307.swapacado.swapacado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewPostActivity extends AppCompatActivity {

    private Button postButton;
    ViewGroup injectionLocation;
    EditText iHaveEditText;
    EditText iWantEditText;
    EditText descriptionEditText;
    boolean toasted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);


        injectionLocation = (LinearLayout) this.findViewById(R.id.newPost_customRowInjectionLocation);
        View child = getLayoutInflater().inflate(R.layout.custom_row, null);
        injectionLocation.addView(child);

        ImageView cardPicture = (ImageView) injectionLocation.findViewById(R.id.postCard_egg);
        cardPicture.setImageResource(R.drawable.man1);

        Button swapButton = (Button) injectionLocation.findViewById(R.id.postCard_swap);
        Button contactButton = (Button) injectionLocation.findViewById(R.id.postCard_contact);

        iHaveEditText = (EditText) findViewById(R.id.newPost_haveEditText);
        iWantEditText = (EditText) findViewById(R.id.newPost_wantEditText);
        descriptionEditText = (EditText) findViewById(R.id.newPost_description);

        togglePostButtonEnabled();

        TextView iHaveView = (TextView) injectionLocation.findViewById(R.id.postCard_have);
        TextView iWantView = (TextView) injectionLocation.findViewById(R.id.postCard_want);
        iHaveView.setText("I Have: ");
        iWantView.setText("I Want: ");

        swapButton.setEnabled(false);
        contactButton.setEnabled(false);
//        swapButton.

        addLiveUpdatesForBox();
        attachPostClickListener();

        TextView distanceView = (TextView) injectionLocation.findViewById(R.id.postCard_distance);
        distanceView.setText("0.0 miles");
        TextView nameView = (TextView) injectionLocation.findViewById(R.id.postCard_name);
        nameView.setText("Davide");

        String time = new SimpleDateFormat("hh:mm a").format(new Date());
        if(time.charAt(0) == '0')
        {
            time = time.substring(1);
        }
        TextView dateView = (TextView) injectionLocation.findViewById(R.id.postCard_postDate);
        dateView.setText(time);
    }

    private void attachPostClickListener() {
        Button tempPostButton = (Button) findViewById(R.id.newPost_postButton);
        tempPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String privateDate = ((TextView) injectionLocation.findViewById(R.id.postCard_postDate)).getText().toString();
                    String longDescription = descriptionEditText.getText().toString();
                    String privateWant = "I want: " + iWantEditText.getText().toString();
                    String privateHave = "I have: " + iHaveEditText.getText().toString();
                    Post toAdd = Post.newPostDemo("Davide", "0.0 miles", privateDate,
                        privateWant, privateHave, true, longDescription, 0);
                    PostDatabase.demoAdd(toAdd);
                    toasted = true;
                    Toast.makeText(NewPostActivity.this, "Post Submitted!", Toast.LENGTH_LONG).show();
                }
                catch(Exception ex)
                {
                    Toast.makeText(NewPostActivity.this, "System error, post not submitted!", Toast.LENGTH_LONG).show();
                    Log.d("Ahluwalia", ex.toString());
                    toasted = true;
                }
                finish();
            }
        });
    }

    public void togglePostButtonEnabled()
    {
        final EditText haveEdit = (EditText) findViewById(R.id.newPost_haveEditText);
        final EditText wantEdit = (EditText) findViewById(R.id.newPost_wantEditText);
        final EditText description = (EditText) findViewById(R.id.newPost_description);

        boolean enabled = (!"".equals(haveEdit.getText().toString()) &&
                !"".equals(wantEdit.getText().toString()) &&
                !"".equals(description.getText().toString()));

        this.postButton = (Button) findViewById(R.id.newPost_postButton);
        this.postButton.setEnabled(enabled);


    }

    private void addLiveUpdatesForBox() {
        final EditText haveEdit = (EditText) findViewById(R.id.newPost_haveEditText);
        final EditText wantEdit = (EditText) findViewById(R.id.newPost_wantEditText);

        final ViewGroup tempInjectionLocation = (LinearLayout) this.findViewById(R.id.newPost_customRowInjectionLocation);
        final TextView iHaveView = (TextView) tempInjectionLocation.findViewById(R.id.postCard_have);
        final TextView iWantView = (TextView) tempInjectionLocation.findViewById(R.id.postCard_want);
        final EditText description = (EditText) findViewById(R.id.newPost_description);

        description.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //before text changed
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //on text change

            }

            @Override
            public void afterTextChanged(Editable editable) {
                togglePostButtonEnabled();
            }
        });

        haveEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //implement before text change
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //implement on text change
            }

            @Override
            public void afterTextChanged(Editable editable) {
                iHaveView.setText("I Have: " + haveEdit.getText().toString());
                togglePostButtonEnabled();
            }
        });
        wantEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //implement before text change
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //implement on text change
            }

            @Override
            public void afterTextChanged(Editable editable) {
                iWantView.setText("I Want: " + wantEdit.getText().toString());
            }
        });
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        if(!toasted)
        {
            Toast.makeText(getApplicationContext(),"Post discarded", Toast.LENGTH_LONG).show();
            toasted = true;
        }

    }
}
