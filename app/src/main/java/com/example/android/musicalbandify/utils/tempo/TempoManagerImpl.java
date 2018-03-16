package com.example.android.musicalbandify.utils.tempo;

/**
 * Created by Ehud on 3/15/2018.
 */

public class TempoManagerImpl implements TempoManager {

    private Long lastTick;
    private Long currentTick;
    private OnChangeTempoListener onChangeTempoListener;
    private int tickPerChange;
    private int tickPerLastUpdate;

    public TempoManagerImpl(OnChangeTempoListener onChangeTempoListener, int tickPerChange) {
        this.onChangeTempoListener = onChangeTempoListener;
        this.tickPerChange = tickPerChange;
        initTick();
    }

    @Override
    public void initTick() {

        lastTick = 0L;
        tickPerLastUpdate = 0;
    }

    @Override
    public void tick() {

        // Init last tick
        if (lastTick == 0){
            lastTick = System.currentTimeMillis();
            return;
        }
        // measure the tempo between ticks
        if(tickPerLastUpdate++ == tickPerChange) {
            currentTick = System.currentTimeMillis();
            float result = (float) tickPerChange / ((float) (currentTick - lastTick) / (float)1000) ;
            tickPerLastUpdate = 0;
            lastTick = currentTick;
            onChangeTempoListener.onChange(result);
        }
    }

    @Override
    public void setOnChangeListener(int ticksPerChange, OnChangeTempoListener onChangeTempoListener) {

        this.tickPerChange = ticksPerChange;
        this.onChangeTempoListener = onChangeTempoListener;
    }
}
