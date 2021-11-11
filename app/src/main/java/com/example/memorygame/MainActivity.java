package com.example.memorygame;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Clock;

public class MainActivity extends AppCompatActivity {

    private MemoryGame mGame;
    private GridLayout mCardGrid;
    private int flipCount = 0;
    private int tempRow;
    private int tempCol;
    private int tempButtonIndex;
    private TextView clockTimer;
    private int timer = 6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mCardGrid = findViewById(R.id.card_grid);
        mGame = new MemoryGame();

        startGame();
    }

    public void startGame() {
        setFaceValues();

        setTime(clockTimer);
        startClock(timer);
        mGame.newGame();
    }



    private void setFaceValues() {
        for (int i = 0; i < 12; i++) {
            ImageButton card = (ImageButton) mCardGrid.getChildAt(i);
            card.setImageResource(R.drawable.ic_face_down);
        }
    }

    private void setTime(TextView clockTimer) {
        int sec =  timer / 100;

        clockTimer.setText(" " + String.format("%02d, min"));
    }


    private void startClock(int sec) {
        CountDownTimer countDownTimer = new CountDownTimer(60000, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                clockTimer.setText("second remaining: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                clockTimer.setText("Your time is up!");
            }
        } .start();

    }





    public void onNewGameClick(View view){
        startGame();
    }

    public void onCardClick(View view) {
        flipCount++;
        //Log.d("stuff", "Flip Count: " + flipCount);
        if(flipCount < 2){
            int buttonIndex = mCardGrid.indexOfChild(view);
            int row = buttonIndex / MemoryGame.GRID_COL;
            int col = buttonIndex % MemoryGame.GRID_COL;
            tempRow = row;
            tempCol = col;
            tempButtonIndex = buttonIndex;
            //Log.d("stuff", "First Index: " + tempButtonIndex);

            //Log.d("stuff", "Index" + buttonIndex + " Row" + row + " Col" + col);

            int selectedCardFace = mGame.getSelectCardValue(row, col);

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
            int row = buttonIndex / MemoryGame.GRID_COL;
            int col = buttonIndex % MemoryGame.GRID_COL;
            if(buttonIndex != tempButtonIndex) {
                //Log.d("stuff", "First Index seen in 2nd if: " + tempButtonIndex);

                //Log.d("stuff", "Index" + buttonIndex + " Row" + row + " Col" + col);

                int selectedCardFace = mGame.getSelectCardValue(row, col);
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
                        }
                    }, 1000);

                }
                flipCount = 0;
            }
            else{
                Log.d("stuff", "Try Again");
                flipCount = 1;
            }
        }

    }

    public void isGameOver() {
        if (mGame.isGameOver()) {
            Toast.makeText(this, R.string.congrats, Toast.LENGTH_SHORT).show();
        }
    }

}