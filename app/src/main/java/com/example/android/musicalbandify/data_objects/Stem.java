package com.example.android.musicalbandify.data_objects;

/**
 * Created by avishai on 3/15/2018.
 */

public class Stem {

    private String mTitle;
    private int mAudioResourceId;
    private int mImageResourceId;

    public Stem(String title, int audioResourceId, int imageResourceId){
        mTitle = title;
        mAudioResourceId = audioResourceId;
        mImageResourceId = imageResourceId;
    }

    public String getTitle() { return mTitle; }
    public int getAudioResourceId() { return mAudioResourceId; }
    public int getImageResourceId() { return mImageResourceId; }
}
