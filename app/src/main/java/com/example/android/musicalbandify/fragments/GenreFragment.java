package com.example.android.musicalbandify.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.musicalbandify.R;
import com.example.android.musicalbandify.activities.ByGenreActivity;
import com.example.android.musicalbandify.adapters.GenreAdapter;
import com.example.android.musicalbandify.data_objects.Genre;

import java.util.ArrayList;

/**
 * Created by avishai on 3/15/2018.
 */

public class GenreFragment extends Fragment {

    public GenreFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.genre_list, container, false);

        // Create an array of words
        final ArrayList<Genre> genres = new ArrayList<>();
        genres.add(new Genre("Pop", 324));
        genres.add(new Genre("Rock", 45));
        genres.add(new Genre("Jazz", 24));
        genres.add(new Genre("Mizrahit!", 0));

        GenreAdapter adapter = new GenreAdapter(getActivity(), genres);
        ListView listView = (ListView)rootView.findViewById(R.id.genre_list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent GenreActivity = new Intent(getActivity(), ByGenreActivity.class);
                startActivity(GenreActivity);
            }
        });

        return rootView;
    }
}
