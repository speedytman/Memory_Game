package com.example.memorygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    Switch music_off;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final RatingBar gameRatingBar;
        gameRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        EditText editText = (EditText) findViewById(R.id.ratingText);
        Button submitButton;
        submitButton = (Button) findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String totalStars = "Total Stars: " + gameRatingBar.getNumStars();
                String rating = "Rating: " + gameRatingBar.getRating();
                Toast.makeText(getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();
                editText.getText().clear();
            }
        });
    }

    public void onBackClick (View view) {
        Intent intent = new Intent(SettingsActivity.this, HomeActivity.class);
        startActivity(intent);
    }


}
