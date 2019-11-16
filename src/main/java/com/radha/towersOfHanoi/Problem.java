package com.radha.towersOfHanoi;

public class Problem {
    private TowersOfHanoi initialState;
    private TowersOfHanoi currentState;
    private TowersOfHanoi destinationState;
    private int noOfDisks;


    public Problem(int noOfDisks) {
        this.noOfDisks = noOfDisks;
        initialState = new TowersOfHanoi(noOfDisks, 0);
        currentState = new TowersOfHanoi(noOfDisks, 0);
        destinationState = new TowersOfHanoi(0, noOfDisks);
    }

   public TowersOfHanoi makeMove(Move move)throws MoveException{
            currentState.move(move);
            return currentState;


   }

}