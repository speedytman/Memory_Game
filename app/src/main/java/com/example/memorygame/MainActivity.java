package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private MemoryGame mGame;
    private GridLayout mCardGrid;

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
        mGame.newGame();
    }

    private void setFaceValues() {
        for(int i = 0; i < 12; i++){
            ImageButton card = (ImageButton) mCardGrid.getChildAt(i);
            card.setImageResource(R.drawable.ic_face_down);
        }
    }


    public void onNewGameClick(View view){
        startGame();
    }

    public void onCardClick(View view) {
        int buttonIndex = mCardGrid.indexOfChild(view);
        int row = buttonIndex / MemoryGame.GRID_COL;
        int col = buttonIndex % MemoryGame.GRID_COL;

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

        if(mGame.isGameOver()){
            //Toast.makeText(this, R.string.congrats, Toast.LENGTH_SHORT).show()
        }
    }

}