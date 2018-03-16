package com.example.android.musicalbandify.data_objects;

import com.example.android.musicalbandify.R;

import java.util.ArrayList;

/**
 * Created by Ehud on 3/16/2018.
 */

public class Image {

    private boolean isVisible;
    private Integer resourceId;

    public Image(Boolean isVisible, Integer resourceId) {
        this.isVisible = isVisible;
        this.resourceId = resourceId;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public void setImageResource(Integer mImageUrl) {
        this.resourceId = resourceId;
    }

    public Integer getImageResource(){
        return resourceId;
    }

    public static ArrayList<Image> generateDummyFriendList() {
        ArrayList<Image> images = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            images.add(new Image(false, R.drawable.finger_pointer));
        }
        return images;
    }
}
