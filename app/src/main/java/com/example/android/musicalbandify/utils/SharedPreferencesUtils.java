package com.example.android.musicalbandify.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by avishai on 3/15/2018.
 */

public class SharedPreferencesUtils {

    private static final String SHARED_PREFERENCES = "SharedPreferences";
    private static final String SOME_KEY = "somekey";
    private static final String MUSICAL_BANDIFY_PREFERENCES = "musical_bandify_preferences";

    //example for inserting SP value
    public static void setSomeValue(Context context, Integer val){
        SharedPreferences sp = getSP(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(SOME_KEY, val);
        editor.commit();

        Log.d(
                SHARED_PREFERENCES,
                "set - some value, value: " +val.toString());
    }

    //example for getting SP value
    public static int getSomeValue(Context context){
        SharedPreferences sp = getSP(context);

        return sp.getInt(SOME_KEY, 1);
    }

    /**
     * Main function, used by all functions to get SP Object
     * @param context
     * @return
     */
    private static SharedPreferences getSP(Context context){
        return context.getSharedPreferences(
                MUSICAL_BANDIFY_PREFERENCES,
                Context.MODE_PRIVATE);
    }
}
