package com.example.android.musicalbandify.utils.tempo;

/**
 * Created by Ehud on 3/15/2018.
 */

public interface TempoManager {

    void tick();
    void setOnChangeListener(int ticksPerChange, OnChangeTempoListener onChangeTempoListener);
    void initTick();

}
