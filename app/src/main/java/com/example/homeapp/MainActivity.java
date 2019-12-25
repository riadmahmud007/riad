package com.example.homeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Switch light1, lidht2,fan ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        light1 = findViewById(R.id.lamp1);
        lidht2 = findViewById(R.id.lamp2);
        fan = findViewById(R.id.fan);
    }
}
