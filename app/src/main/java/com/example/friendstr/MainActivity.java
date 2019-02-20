package com.example.friendstr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
/*Tip: when implementing the onItemLongClick method for long clicks, you need to return true if
        you performed an action in response to the long click. Otherwise, Android will run the normal click listener, too.*/