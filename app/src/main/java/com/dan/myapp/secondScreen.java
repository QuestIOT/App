package com.dan.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class secondScreen extends AppCompatActivity {

    TextView mtextUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mtextUser = (TextView) findViewById(R.id.textViewUser);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("name");


        mtextUser.setText(data);
    }
}
