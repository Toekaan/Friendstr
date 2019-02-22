package com.example.friendstr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // get intent from clicked item
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // define all changeable views of the activity
        ImageView profilePic = findViewById(R.id.profilePicture);
        TextView name = findViewById(R.id.name);
        TextView bio = findViewById(R.id.bio);
        RatingBar rating = findViewById(R.id.ratingBar);

        // insert object specific information in corresponding views
        profilePic.setImageResource(retrievedFriend.getDrawableId());
        name.setText(retrievedFriend.getName());
        bio.setText(retrievedFriend.getBio());
        //rating.setRating(retrievedFriend.getRating());

        // connect ratingbar to listener
        rating.setOnRatingBarChangeListener(new ratingBarClick());

        // get stored rating bar state (if any)
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float storedFloat = prefs.getFloat(retrievedFriend.getName(), 0);

        if (storedFloat != 0) {
            rating.setRating(storedFloat);
            Log.d("Restored", "Not ZERO");
        }
        else {
            rating.setRating(0);
            Log.d("Restored", "Yes ZERO");
        }
    }

    public class ratingBarClick implements RatingBar.OnRatingBarChangeListener {

        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            Log.d("RatingBar", "Boiiii");

            // get the intent again
            Intent intent = getIntent();
            Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");
/*
            // set rating of Friend object
            retrievedFriend.setRating(rating);
*/
            // keep rating bar state stored
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(retrievedFriend.getName(), rating);
            editor.apply();
        }
    }
}
