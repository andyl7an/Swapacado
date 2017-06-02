package com.cpe307.swapacado.swapacado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        ViewGroup injectionLocation = (LinearLayout) this.findViewById(R.id.newPost_customRowInjectionLocation);
        View child = getLayoutInflater().inflate(R.layout.custom_row, null);
        injectionLocation.addView(child);

        Button swapButton = (Button) injectionLocation.findViewById(R.id.postCard_swap);
        Button contactButton = (Button) injectionLocation.findViewById(R.id.postCard_contact);

        TextView iHaveView = (TextView) injectionLocation.findViewById(R.id.postCard_have);
        TextView iWantView = (TextView) injectionLocation.findViewById(R.id.postCard_want);
        iHaveView.setText("I Have: ");
        iWantView.setText("I Want: ");

        swapButton.setEnabled(false);
        contactButton.setEnabled(false);
//        swapButton.

        addLiveUpdatesForBox();
    }

    private void addLiveUpdatesForBox() {
        final EditText haveEdit = (EditText) findViewById(R.id.newPost_haveEditText);
        final EditText wantEdit = (EditText) findViewById(R.id.newPost_wantEditText);

        final ViewGroup injectionLocation = (LinearLayout) this.findViewById(R.id.newPost_customRowInjectionLocation);
        final TextView iHaveView = (TextView) injectionLocation.findViewById(R.id.postCard_have);
        final TextView iWantView = (TextView) injectionLocation.findViewById(R.id.postCard_want);

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
                iWantView.setText("I Wave: " + wantEdit.getText().toString());
            }
        });
    }
    //On click for the post button
}
