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

import java.util.ArrayList;

public class PlayActivity extends Activity {

    private ArrayList<Image> images;
    private ImagesAdapter imagesAdapter;
    private GridView tapsGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );

        setContentView(R.layout.activity_play);

        HideStatusBar();

        loadData();
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
        imagesAdapter = new ImagesAdapter(this, images, true);
        tapsGridView.setAdapter(imagesAdapter);
    }
}
