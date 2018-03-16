package com.example.android.musicalbandify.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;

import com.example.android.musicalbandify.R;
import com.example.android.musicalbandify.adapters.ImagesAdapter;
import com.example.android.musicalbandify.data_objects.Image;
import com.example.android.musicalbandify.utils.madiaplayer.MadiaManager;
import com.example.android.musicalbandify.utils.madiaplayer.MediaManagerImpl;
import com.example.android.musicalbandify.utils.tempo.OnChangeTempoListener;
import com.example.android.musicalbandify.utils.tempo.TempoManager;
import com.example.android.musicalbandify.utils.tempo.TempoManagerImpl;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PlayActivity extends Activity {

    private ArrayList<Image> images;
    private ImagesAdapter imagesAdapter;
    private GridView tapsGridView;
    private MadiaManager mediaManager;
    TempoManager tempoManager;
    Random random;
    int currentOn1,currentOn2;
    private static int period = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );

        setContentView(R.layout.activity_play);

        HideStatusBar();
        int recourceID = getIntent().getIntExtra(InstrumentsActivity.SONG_RESOURCE_ID, 0);

        tempoManager = new TempoManagerImpl(new OnChangeTempoListener() {
            @Override
            public void onChange(float tempo) {
                mediaManager.updateSpeed(tempo);
            }
        }, 5);
        mediaManager = new MediaManagerImpl(this,1,recourceID,96);

        loadData();
        mediaManager.play();
    }

    public void HideStatusBar(){
        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    private void loadData() {

        // Init taps grid view
        tapsGridView = (GridView) findViewById(R.id.tapsGridView);
        images = Image.generateDummyFriendList();
        imagesAdapter = new ImagesAdapter(this, images, true, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempoManager.tick();
            }
        });
        tapsGridView.setAdapter(imagesAdapter);
    }



    @Override
    protected void onResume() {
        super.onResume();
        startTimer();
    }

    private void startTimer() {
        this.random = new Random();
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                // do something...
                lightsOn();
                System.out.println("delay = " + period);
                period = 625;
                ;  // change the period time
                timer.cancel(); // cancel time
                startTimer();   // start the time again with a new delay time
            }
        }, period, period);
    }

    private void lightsOn() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Image friend1 = images.get(currentOn1);
                Image friend2 = images.get(currentOn2);

                friend1.setIsVisible(false);
                friend2.setIsVisible(false);

                Random r1 = new Random();
                Random r2 = new Random();
                currentOn1 = r1.nextInt(21);
                currentOn2 = r2.nextInt(21);

                friend1 = images.get(currentOn1);
                friend2 = images.get(currentOn2);

                friend1.setIsVisible(true);
                friend2.setIsVisible(true);

                imagesAdapter.notifyDataSetChanged();
                tapsGridView.invalidateViews();
            }
        });

    }
}
