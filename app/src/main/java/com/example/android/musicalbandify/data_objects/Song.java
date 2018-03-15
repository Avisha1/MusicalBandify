package com.example.android.musicalbandify.data_objects;

/**
 * Created by avishai on 3/15/2018.
 */

public class Song {

    private String mName;
    private String mSinger;
    private int mLength;
    private Stem [] mStems;

    public Song(String name, String singer, int length, Stem[] stemArr) {
        mName = name;
        mSinger = singer;
        mLength = length;
        mStems = stemArr;
    }

    public String getName() {
        return mName;
    }

    public String getSinger() {
        return mSinger;
    }

    public int getLength() {
        return mLength;
    }

    public Stem[] getStems(){
        return mStems;
    }

    //TODO
    //Need to be changed to images of musical tools somehow
    public String getStemsAsString(){
        return "G, D, V";
    }

}
