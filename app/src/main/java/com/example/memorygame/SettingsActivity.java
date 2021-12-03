package com.example.memorygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void onBackHomeClick (View view) {
        Intent intent = new Intent(SettingsActivity.this, HomeActivity.class);
        startActivity(intent);
    }


}
