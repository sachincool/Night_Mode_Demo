package com.example.crappy.night_mode_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
private Switch myswitch;
    private SharedPref sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPref = new SharedPref(this);
        if (sharedPref.loadMyNightMode()) {
            setTheme(R.style.darktheme);
        }
        else setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myswitch=findViewById(R.id.myswitch);
        if (sharedPref.loadMyNightMode()) {
            myswitch.setChecked(true);

        }
        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    sharedPref.setNightModeState(true);
                    restartApp();
                }
                else {
                    sharedPref.setNightModeState(false);
                    restartApp();
                }
            }


        });
    }

    public void restartApp() {
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }
}
