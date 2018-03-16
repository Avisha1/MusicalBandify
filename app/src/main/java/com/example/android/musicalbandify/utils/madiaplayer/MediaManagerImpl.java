package com.example.android.musicalbandify.utils.madiaplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ehud on 3/15/2018.
 */

public class MediaManagerImpl implements MadiaManager {
    public static final String RAW_RECOURCES_TYPE = "raw";
    private Context context;
    private float songSpeed = 0.5f;
    private int mediaResorceId;
    private int bpm;

    private MediaPlayer mediaPlayer;

    public MediaManagerImpl(Context context, float songSpeed, int mediaResorceId, int bpm) {
        this.context = context;
        this.songSpeed = songSpeed;
        this.mediaResorceId = mediaResorceId;
        this.bpm = bpm;
        initMediaStream();

    }

    private void initMediaStream() {
//        int mediaResorceId = context.getResources().getIdentifier(songName, RAW_RECOURCES_TYPE,context.getPackageName());
        mediaPlayer = MediaPlayer.create(context, mediaResorceId);
//        mediaPlayer.getPlaybackParams().setSpeed(songSpeed);
    }

    @Override
    public void play() {
        mediaPlayer.start();
    }

    @Override
    public void pause() {
        mediaPlayer.pause();
    }

    @Override
    public void updateSpeed(float speed) {

        float realSpeed = speed / (bpm / (float) 60);
        if ((realSpeed < 0)||(realSpeed > 3)) { return; }
        Log.d("Media Manager: ", "Update Speed: " + realSpeed);
        songSpeed = realSpeed;
        PlaybackParams params = mediaPlayer.getPlaybackParams().setSpeed(songSpeed);
        mediaPlayer.setPlaybackParams(params);
    }

    @Override
    public float getCurrentSpeed() {
        return  mediaPlayer.getPlaybackParams().getSpeed();
    }

    // Get the song Start/End time

    @Override
    public String getSongStartTime() {

        float startTime = mediaPlayer.getDuration();
        return String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime)));
    }

    @Override
    public String getSongEndTime() {

        float endTime = mediaPlayer.getDuration();
        return String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) endTime),
                TimeUnit.MILLISECONDS.toSeconds((long) endTime -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) endTime))));
    }

    @Override
    public int getSongCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    @Override
    public boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }


}
