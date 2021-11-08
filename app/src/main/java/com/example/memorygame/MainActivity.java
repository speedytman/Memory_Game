package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
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
        mGame.newGame();
        setFaceValues();
    }

    private void setFaceValues() {

    }


    public void onNewGameClick(View view){
        startGame();
    }

    public void onCardClick(View view) {
        int buttonIndex = mCardGrid.indexOfChild(view);
        int row = buttonIndex / MemoryGame.GRID_ROW;
        int col = buttonIndex % MemoryGame.GRID_COL;

        mGame.selectCard(row, col);
        setFaceValues();

        if(mGame.isGameOver()){
            //Toast.makeText(this, R.string.congrats, Toast.LENGTH_SHORT).show()
        }
    }

}