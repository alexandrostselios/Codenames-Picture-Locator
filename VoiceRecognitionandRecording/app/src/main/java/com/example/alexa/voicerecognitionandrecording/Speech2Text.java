package com.example.alexa.voicerecognitionandrecording;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Speech2Text extends AppCompatActivity {
    private String test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech2_text);
        Bundle bundle = getIntent().getExtras();
        test = bundle.getString("test").toString();
        System.out.println("Event: "+test);
    }
}