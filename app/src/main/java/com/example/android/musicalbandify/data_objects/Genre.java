package com.example.android.musicalbandify.data_objects;

/**
 * Created by avishai on 3/15/2018.
 */

public class Genre {

    private String mTitle;
    private Integer mTracksAmount;

    public Genre(String title, int tracksAmount){
        mTitle = title;
        mTracksAmount = tracksAmount;
    }

    public String getGenre(){
        return mTitle;
    }

    public String getTracksAmount() {
        return mTracksAmount.toString();
    }
}
