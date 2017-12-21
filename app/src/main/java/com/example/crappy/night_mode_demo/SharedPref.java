package com.example.crappy.night_mode_demo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by root on 22/12/17.
 */

public class SharedPref {
    private SharedPreferences sharedPreferences;

    public SharedPref(Context context) {
        this.sharedPreferences = context.getSharedPreferences("", Context.MODE_PRIVATE);

    }

    //State True= Nightmode False= Normalmode
    public void setNightModeState(Boolean state) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Nightmode", state);
        editor.commit();

    }

    // Getting the value of nightmode
    public Boolean loadMyNightMode() {
        Boolean state = sharedPreferences.getBoolean("Nightmode", false);
        return state;
    }
}
