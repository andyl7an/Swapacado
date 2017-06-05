package com.cpe307.swapacado.swapacado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ProposeSwapActivity extends AppCompatActivity {
    private boolean postButtonHit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propose_swap);

        Intent theIntent = this.getIntent();
        String posterName = theIntent.getStringExtra("posterName");
        String yourName = theIntent.getStringExtra("yourName");
        String posterDescription = theIntent.getStringExtra("posterDescription");

        String haveString = theIntent.getStringExtra("haveString");
        String wantString = theIntent.getStringExtra("wantString");

        TextView haveDescription = (TextView) findViewById(R.id.propose_youHave);
        haveDescription.setText(yourName + " has: " + wantString);

        TextView wantDescription = (TextView) findViewById(R.id.propose_heHave);
        wantDescription.setText(posterName + " has: " + haveString);

        TextView hisDescription = (TextView) findViewById(R.id.propose_hisDescription);
        hisDescription.setText(posterDescription);

        final Button submitButton = (Button) findViewById(R.id.propose_submit);
        submitButton.setEnabled(false);

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                toggleEnabled();
            }
        };

        EditText text1 = (EditText) findViewById(R.id.propose_location);
        text1.addTextChangedListener(watcher);
        EditText text2 = (EditText) findViewById(R.id.propose_location);
        text2.addTextChangedListener(watcher);
        EditText text3 = (EditText) findViewById(R.id.propose_location);
        text3.addTextChangedListener(watcher);
    }

    public void toggleEnabled()
    {
        final Button submitButton = (Button) findViewById(R.id.propose_submit);
        EditText text1 = (EditText) findViewById(R.id.propose_location);
        EditText text2 = (EditText) findViewById(R.id.propose_location);
        EditText text3 = (EditText) findViewById(R.id.propose_location);

        boolean notSubmit = "".equals(text1.getText().toString()) ||
                "".equals(text2.getText().toString()) ||
                "".equals(text3.getText().toString());
        submitButton.setEnabled(!notSubmit);

    }
    public void submitSwap(View view) {
        Toast.makeText(this.getApplicationContext(), "Proposal Submitted!!!", Toast.LENGTH_LONG).show();
        postButtonHit = true;
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(!postButtonHit)
        {
            Toast.makeText(this.getApplicationContext(), "Proposal NOT Submitted", Toast.LENGTH_LONG).show();
        }
    }
}