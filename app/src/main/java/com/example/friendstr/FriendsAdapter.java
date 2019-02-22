package com.example.friendstr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friends;


    public FriendsAdapter(Context context, int resource, ArrayList<Friend> friends) {
        super(context, resource, friends);
        this.friends = friends;
    }

    // gets all of the specific friend items and converts them into different views, returned to be printed on the main grid
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // initialize views to be changed
        ImageView convertImage = convertView.findViewById(R.id.itemImg);
        TextView convertText = convertView.findViewById(R.id.itemName);

        // get data from specific friend
        Friend convertFriend = friends.get(position);

        // put data from list into convert views
        convertImage.setImageResource(convertFriend.getDrawableId());
        convertText.setText(convertFriend.getName());


        // convertView.findViewById() gives access to the views of covert view (grid_item)
        // getting data from the ArrayList friends can be done using: friends.get()
        //To load a Drawable image for putting into the ImageView, use the following line of code:
        // anImageViewReference.setImageResource(aDrawableId); while remembering that we saved resource ids for each of our
        // friends in the friends list already!
        return convertView;
    }
}
