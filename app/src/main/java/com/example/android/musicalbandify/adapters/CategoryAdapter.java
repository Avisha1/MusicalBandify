package com.example.android.musicalbandify.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.musicalbandify.fragments.GenreFragment;

/**
 * Created by avishai on 3/15/2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new GenreFragment();
            case 1:
                return new GenreFragment();
            default:
                return new GenreFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Genre";
            case 1:
                return "Recently Played";
            case 2:
                return "Popular";
            default:
                return "Genre";
        }
    }
}
