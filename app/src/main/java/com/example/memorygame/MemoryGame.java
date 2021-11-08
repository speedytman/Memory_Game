package com.example.memorygame;

import android.util.Log;

import java.util.Random;

public class MemoryGame {
    public static final int GRID_COL = 3;
    public static final int GRID_ROW = 4;

    int faceOneCount;
    int faceTwoCount;
    int faceThreeCount;
    int faceFourCount;
    int faceFiveCount;
    int faceSixCount;

    private final int[][] mCardGrid;
    public MemoryGame() {
        mCardGrid = new int[GRID_ROW][GRID_COL];
    }

    public void newGame() {
        int faceOneCount = 0;
        int faceTwoCount = 0;
        int faceThreeCount = 0;
        int faceFourCount = 0;
        int faceFiveCount = 0;
        int faceSixCount = 0;
        for(int row = 0; row < GRID_ROW; row++){
            for(int col = 0; col < GRID_COL; col++){
                assignFace(row, col, faceOneCount, faceTwoCount, faceThreeCount, faceFourCount, faceFiveCount, faceSixCount);
            }
        }
    }

    public void assignFace(int row, int col, int faceOneCount, int faceTwoCount, int faceThreeCount, int faceFourCount, int faceFiveCount, int faceSixCount) {
        Random randomNumGenerator = new Random();

        int suggestedFace = randomNumGenerator.nextInt(5);
        if(suggestedFace == 0 && faceOneCount < 2){
            mCardGrid[row][col] = suggestedFace;
            Log.d("stuff", "" + suggestedFace);
            faceOneCount++;
        }
        if(suggestedFace == 0 && faceTwoCount < 2){
            mCardGrid[row][col] = suggestedFace;
            Log.d("stuff", "" + suggestedFace);
            faceTwoCount++;
        }
        if(suggestedFace == 0 && faceThreeCount < 2){
            mCardGrid[row][col] = suggestedFace;
            Log.d("stuff", "" + suggestedFace);
            faceThreeCount++;
        }
        if(suggestedFace == 0 && faceFourCount < 2){
            mCardGrid[row][col] = suggestedFace;
            Log.d("stuff", "" + suggestedFace);
            faceFourCount++;
        }
        if(suggestedFace == 0 && faceFiveCount < 2){
            mCardGrid[row][col] = suggestedFace;
            Log.d("stuff", "" + suggestedFace);
            faceFiveCount++;
        }
        if(suggestedFace == 0 && faceSixCount < 2){
            mCardGrid[row][col] = suggestedFace;
            Log.d("stuff", "" + suggestedFace);
            faceSixCount++;
        }
        else {
            assignFace(row, col, faceOneCount, faceTwoCount, faceThreeCount, faceFourCount, faceFiveCount, faceSixCount);
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
