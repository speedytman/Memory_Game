package com.example.memorygame;


import static android.os.CountDownTimer.*;

import static com.example.memorygame.MemoryGame.GRID_COL;
import static com.example.memorygame.MemoryGame.GRID_ROW;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private MemoryGame mGame;
    private GridLayout mCardGrid;
    private int flipCount = 0;
    private int totalFlips = 0;
    private int tempRow;
    private int tempCol;
    private int tempButtonIndex;

    private int secs = 0;
    private boolean isRunning;
    private boolean wasRunning;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);

        mCardGrid = findViewById(R.id.card_grid);
        mGame = new MemoryGame();

        startGame();

        if (savedInstanceState != null) {
            secs = savedInstanceState.getInt("seconds");

            isRunning = savedInstanceState.getBoolean("running");

            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();

    }

    @Override
    protected void onSaveInstanceState(
            Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState
                .putInt("seconds", secs);
        savedInstanceState
                .putBoolean("running", isRunning);
        savedInstanceState
                .putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        wasRunning = isRunning;
        isRunning = false;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if (wasRunning) {
            isRunning = true;
        }
    }

    public void onClickStart(View view) {
            isRunning = true;

    }

    public void onClickStop(View view)
    {
        isRunning = false;
    }


    private void runTimer()
    {

        final TextView timer
                = (TextView)findViewById(
                R.id.timer);


        final Handler handler
                = new Handler();


        handler.post(new Runnable() {
            @Override

            public void run()
            {
                int hours = secs / 3600;
                int minutes = (secs % 3600) / 60;
                int seconds = secs % 60;

                String time
                        = String
                        .format(Locale.getDefault(),
                                "%d:%02d:%02d", hours,
                                minutes, seconds);

                timer.setText(time);

                if (isRunning) {
                    secs++;
                }

                handler.postDelayed(this, 1000);
            }
        });
    }

    public void startGame() {
        setFaceValues();
        flipCount = 0;
        totalFlips = 0;
        mGame.newGame();
    }



    private void setFaceValues() {
        for (int i = 0; i < 12; i++) {
            ImageButton card = (ImageButton) mCardGrid.getChildAt(i);
            card.setImageResource(R.drawable.ic_face_down);
        }
    }





    public void onNewGameClick(View view){
        isRunning = false;
        secs = 0;

        startGame();
    }

    public void onCardClick(View view) {
        if(totalFlips == 0){
            isRunning = true;
        }
        totalFlips++;
        flipCount++;
        //Log.d("stuff", "Flip Count: " + flipCount);
        if(flipCount < 2){
            int buttonIndex = mCardGrid.indexOfChild(view);
            int row = buttonIndex / GRID_COL;
            int col = buttonIndex % GRID_COL;
            tempRow = row;
            tempCol = col;
            tempButtonIndex = buttonIndex;
            //Log.d("stuff", "First Index: " + tempButtonIndex);

            //Log.d("stuff", "Index" + buttonIndex + " Row" + row + " Col" + col);

            int selectedCardFace = mGame.getSelectCardValue(row, col);
            mGame.markCardFlipped(row, col);

            ImageButton card = (ImageButton) mCardGrid.getChildAt(buttonIndex);

            //if(card.getDrawable().getConstantState() != getResources().getDrawable(R.drawable.ic_face_down).getConstantState()){
            //Log.d("Stuff", "I AM HERE!");
            //}
            if(selectedCardFace == 1){
                card.setImageResource(R.drawable.ic_face_one);
            }
            if(selectedCardFace == 2){
                card.setImageResource(R.drawable.ic_face_two);
            }
            if(selectedCardFace == 3){
                card.setImageResource(R.drawable.ic_face_three);
            }
            if(selectedCardFace == 4){
                card.setImageResource(R.drawable.ic_face_four);
            }
            if(selectedCardFace == 5){
                card.setImageResource(R.drawable.ic_face_five);
            }
            if(selectedCardFace == 6){
                card.setImageResource(R.drawable.ic_face_six);
            }
        }
        if(flipCount == 2){
            int buttonIndex = mCardGrid.indexOfChild(view);
            int row = buttonIndex / GRID_COL;
            int col = buttonIndex % GRID_COL;
            if(buttonIndex != tempButtonIndex) {
                //Log.d("stuff", "First Index seen in 2nd if: " + tempButtonIndex);

                //Log.d("stuff", "Index" + buttonIndex + " Row" + row + " Col" + col);

                int selectedCardFace = mGame.getSelectCardValue(row, col);
                mGame.markCardFlipped(row, col);
                int previousSelectedCardFace = mGame.getSelectCardValue(tempRow, tempCol);

                ImageButton card = (ImageButton) mCardGrid.getChildAt(buttonIndex);
                ImageButton previousCard = (ImageButton) mCardGrid.getChildAt(tempButtonIndex);

                //if(card.getDrawable().getConstantState() != getResources().getDrawable(R.drawable.ic_face_down).getConstantState()){
                //Log.d("Stuff", "I AM HERE!");
                //}
                if (selectedCardFace == 1) {
                    card.setImageResource(R.drawable.ic_face_one);
                }
                if (selectedCardFace == 2) {
                    card.setImageResource(R.drawable.ic_face_two);
                }
                if (selectedCardFace == 3) {
                    card.setImageResource(R.drawable.ic_face_three);
                }
                if (selectedCardFace == 4) {
                    card.setImageResource(R.drawable.ic_face_four);
                }
                if (selectedCardFace == 5) {
                    card.setImageResource(R.drawable.ic_face_five);
                }
                if (selectedCardFace == 6) {
                    card.setImageResource(R.drawable.ic_face_six);
                }

                if (selectedCardFace != previousSelectedCardFace) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            card.setImageResource(R.drawable.ic_face_down);
                            previousCard.setImageResource(R.drawable.ic_face_down);
                            mGame.markCardUnFlipped(row,col);
                            mGame.markCardUnFlipped(tempRow,tempCol);
                        }
                    }, 1000);
                    flipCount = 0;
                }
                else{
                    if (mGame.isGameOver()) {
                        isRunning = false;
                        Toast.makeText(this, R.string.congrats, Toast.LENGTH_SHORT).show();
                        flipCount = 0;
                    }
                    else{
                        flipCount = 0;
                    }
                }
            }
            else{
                flipCount = 1;
            }
        }

    }

}