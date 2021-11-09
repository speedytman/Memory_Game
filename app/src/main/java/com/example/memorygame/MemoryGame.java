package com.example.memorygame;

import android.util.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MemoryGame {
    public static final int GRID_COL = 3;
    public static final int GRID_ROW = 4;

    private final int[][] mCardGrid;
    private final boolean[][] mCardFlippedGrid;
    private Integer[] faceValues = {1,1,2,2,3,3,4,4,5,5,6,6};
    public MemoryGame() {
        mCardGrid = new int[GRID_ROW][GRID_COL];
        mCardFlippedGrid = new boolean[GRID_ROW][GRID_COL];
    }

    public void newGame() {
        //Log.d("Stuff", "New Game");
        List<Integer> tempList = Arrays.asList(faceValues);
        Collections.shuffle(tempList);
        tempList.toArray(faceValues);
        int position = 0;
        for(int row = 0; row < GRID_ROW; row++){
            for(int col = 0; col < GRID_COL; col++){
                mCardGrid[row][col] = faceValues[position];
                mCardFlippedGrid[row][col] = false;
                position++;
                //Log.d("Stuff", Integer.toString(mCardGrid[row][col]));
            }
        }
    }


    public boolean doCardsMatch() {
        for(int row = 0; row < GRID_ROW; row++){
            for(int col = 0; col < GRID_COL; col++){
                if(mCardFlippedGrid[row][col]){

                }
            }
        }
        return false;
    }

    public int getSelectCardValue(int row, int col) {
        //Log.d("stuff", row + " " + col + " " + Integer.toString(mCardGrid[row][col]));
        if(mCardGrid[row][col] == 1){
            mCardFlippedGrid[row][col] = true;
            return 1;
        }
        if(mCardGrid[row][col] == 2){
            mCardFlippedGrid[row][col] = true;
            return 2;
        }
        if(mCardGrid[row][col] == 3){
            mCardFlippedGrid[row][col] = true;
            return 3;
        }
        if(mCardGrid[row][col] == 4){
            mCardFlippedGrid[row][col] = true;
            return 4;
        }
        if(mCardGrid[row][col] == 5){
            mCardFlippedGrid[row][col] = true;
            return 5;
        }
        if(mCardGrid[row][col] == 6){
            mCardFlippedGrid[row][col] = true;
            return 6;
        }
        return 0;
    }

    public boolean isGameOver() {
        for(int row = 0; row < GRID_ROW; row++){
            for(int col = 0; col < GRID_COL; col++){
                if(mCardFlippedGrid[row][col]){
                    return false;
                }
            }
        }
        return true;
    }
}
