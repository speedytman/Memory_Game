package com.example.memorygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    Switch music_off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        music_off = (Switch) findViewById(R.id.music_off);
    }

    public void onBackHomeClick (View view) {
        Intent intent = new Intent(SettingsActivity.this, HomeActivity.class);
        startActivity(intent);
    }
     public void onMusicSwitch (View view){
         // if (music_off.isChecked())
           //  music_off.stop();


    }


}
