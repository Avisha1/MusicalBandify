package com.example.android.musicalbandify.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.musicalbandify.R;
import com.example.android.musicalbandify.data_objects.Genre;

import java.util.ArrayList;

/**
 * Created by avishai on 3/15/2018.
 */

public class GenreAdapter extends ArrayAdapter<Genre> {

    public GenreAdapter(@NonNull Context context, ArrayList<Genre> genreList) {
        super(context, 0, genreList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.genre_list_item, parent, false);
        }

        Genre currentGenre = getItem(position);

        TextView genreTextView = (TextView)listItemView.findViewById(R.id.genre_text_view);
        genreTextView.setText(currentGenre.getGenre());

        TextView tracksAmount = (TextView)listItemView.findViewById(R.id.tracks_amount_text_view);
        tracksAmount.setText(currentGenre.getTracksAmount() + " Tracks");

        return listItemView;
    }
}
