package com.example.android.musicalbandify.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.musicalbandify.R;
import com.example.android.musicalbandify.adapters.SongAdapter;
import com.example.android.musicalbandify.data_objects.Song;

import java.util.ArrayList;

public class ByGenreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Shape Of You", "Ed Sheeran", R.mipmap.ic_launcher));
        songs.add(new Song("Perfect", "Ed Sheeran", R.mipmap.ic_launcher));
        songs.add(new Song("Thinking Out Loud", "Ed Sheeran", R.mipmap.ic_launcher));


        SongAdapter adapter = new SongAdapter(ByGenreActivity.this, songs);
        ListView listView = (ListView)findViewById(R.id.song_list);
        listView.setAdapter(adapter);
    }
}
