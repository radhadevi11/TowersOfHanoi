package com.radha.towersOfHanoi;

public class Problem {
    private TowersOfHanoi initialState;
    private TowersOfHanoi currentState;
    private TowersOfHanoi destinationState;
    private int noOfDisks;
    private int moveCount;


    public Problem(int noOfDisks) {
        this.noOfDisks = noOfDisks;
        initialState = new TowersOfHanoi(noOfDisks, 0);
        currentState = new TowersOfHanoi(noOfDisks, 0);
        destinationState = new TowersOfHanoi(0, noOfDisks);
    }

   public TowersOfHanoi makeMove(Move move)throws MoveException{
            getCurrentState().move(move);
            moveCount++;
            return getCurrentState();
   }

  /* public Problem createProblem(int noOfDisks, int sourceTowerId, int destinationTowerId){
       TowersOfHanoi initialState = new TowersOfHanoi(noOfDisks,0);
       TowersOfHanoi currentState = new TowersOfHanoi(noOfDisks,0);

   }*/
   TowersOfHanoi getCurrentState() {
        return currentState;
    }

    public int getNoOfDisks() {
        return noOfDisks;
    }


    public boolean hasBeenSolved() {
        return this.currentState.equals(destinationState) &&
                moveCount == Math.pow(2, noOfDisks)-1;
    }


}