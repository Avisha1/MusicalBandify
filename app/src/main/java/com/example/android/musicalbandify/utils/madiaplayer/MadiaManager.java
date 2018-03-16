package com.example.android.musicalbandify.utils.madiaplayer;

/**
 * Created by Ehud on 3/15/2018.
 */

public interface MadiaManager {
    void play();
    void pause();
    void updateSpeed(float speed);
    float getCurrentSpeed();
    String getSongStartTime();
    String getSongEndTime();
    int getSongCurrentPosition();
    boolean isPlaying();
}
