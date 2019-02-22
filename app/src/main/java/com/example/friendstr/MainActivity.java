package com.example.friendstr;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // this will be the main list where all different 'friends' can be stored
    private ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiate all 'friends' and add them to list
        Friend arya = new Friend("Arya Stark", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. ", R.drawable.arya);
        Friend cersei = new Friend("Cersei", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. ", R.drawable.cersei);
        Friend daenerys = new Friend("Daenerys", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. ", R.drawable.daenerys);
        Friend jaime = new Friend("Jaime Lenister", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. ", R.drawable.jaime);
        Friend jon = new Friend("Jon Stark", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. ", R.drawable.jon);
        Friend jorah = new Friend("Jorah", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. ", R.drawable.jorah);
        Friend melisandre = new Friend("Melisandre", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.", R.drawable.melisandre);
        Friend sansa = new Friend("Sansa Stark", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.", R.drawable.sansa);
        Friend tyrion = new Friend("Tyrion", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.", R.drawable.tyrion);
        friends.add(arya);
        friends.add(cersei);
        friends.add(daenerys);
        friends.add(jaime);
        friends.add(jon);
        friends.add(jorah);
        friends.add(melisandre);
        friends.add(sansa);
        friends.add(tyrion);

        // connect gridview to the adapter to print out friends list on view
        GridView grid = (GridView) findViewById(R.id.griddy);
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        grid.setAdapter(adapter);

        // connect grid to click listener
        grid.setOnItemClickListener(new GridItemClickListener());

    }


    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        // handles clicks on each individual item
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // get object of clicked item
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);

            Log.d("Clicked:", clickedFriend.getName());

            // pass clicked item onto next activity via intent
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}
