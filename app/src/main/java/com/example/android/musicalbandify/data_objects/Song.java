package com.example.android.musicalbandify.data_objects;

/**
 * Created by avishai on 3/15/2018.
 */

public class Song {

    private String mName;
    private String mSinger;
    private Stem [] mStems;
    private int mImageResourceId;

    public Song(String name, String singer, int imageResourceId) {
        mName = name;
        mSinger = singer;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getSinger() {
        return mSinger;
    }

    public Stem[] getStems(){
        return mStems;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    //TODO
    //Need to be changed to images of musical tools somehow
    public String getStemsAsString(){
        return "G, D, V";
    }

}
