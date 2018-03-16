package com.example.android.musicalbandify.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        songs.add(new Song("Shape Of You", "Ed Sheeran", R.mipmap.shape_of_you_cover));
        songs.add(new Song("Gravity", "John Mayer", R.mipmap.jhon_mayer_cover));
        songs.add(new Song("Shake It Off", "Taylor Swift", R.mipmap.taylor_swift_cover));
        songs.add(new Song("Thinking Out Loud", "Ed Sheeran", R.mipmap.shape_of_you_cover));



        SongAdapter adapter = new SongAdapter(ByGenreActivity.this, songs);
        ListView listView = (ListView)findViewById(R.id.song_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent InstrumentActivity = new Intent(ByGenreActivity.this, InstrumentsActivity.class);
                startActivity(InstrumentActivity);
            }
        });


    }
}
