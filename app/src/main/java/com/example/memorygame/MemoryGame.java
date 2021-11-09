package com.example.memorygame;

import android.util.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MemoryGame {
    public static final int GRID_COL = 3;
    public static final int GRID_ROW = 4;

    private final int[][] mCardGrid;
    private Integer[] faceValues = {1,1,2,2,3,3,4,4,5,5,6,6};
    public MemoryGame() {
        mCardGrid = new int[GRID_ROW][GRID_COL];
    }

    public void newGame() {
        Log.d("Stuff", "New Game");
        List<Integer> tempList = Arrays.asList(faceValues);
        Collections.shuffle(tempList);
        tempList.toArray(faceValues);
        int position = 0;
        for(int row = 0; row < GRID_ROW; row++){
            for(int col = 0; col < GRID_COL; col++){
                mCardGrid[row][col] = faceValues[position];
                position++;
                Log.d("Stuff", Integer.toString(mCardGrid[row][col]));
            }
        }
    }


    public boolean doCardsMatch() {
        return false;
    }

    public void selectCard(int row, int col) {

    }

    public boolean isGameOver() {
        return false;
    }
}