package com.radha.towersOfHanoi;

import java.util.ArrayList;
import java.util.List;

public class Solver {

    public List<Move> solve(Problem problem, int numDisks, int sourceTowerId, int destTowerId, int intermediateTowerId) throws MoveException {
        List<Move> moves = new ArrayList<>();
        if(numDisks == 1){
            Move move = new Move(sourceTowerId, destTowerId);
            problem.makeMove(move);
            System.out.println(move);
            System.out.println(problem.getCurrentState());
            moves.add(move);
            return moves;
        }
         moves.addAll(solve(problem, numDisks-1, sourceTowerId, intermediateTowerId,  destTowerId));
         moves.addAll(solve(problem, 1, sourceTowerId, destTowerId, intermediateTowerId));
         moves.addAll(solve(problem, numDisks-1, intermediateTowerId, destTowerId, sourceTowerId));
         return moves;

    }

    public List<Move> solve(Problem problem) throws MoveException {
        return solve(problem, problem.getNoOfDisks(), 1, 3, 2);
    }

    public static void main(String[] args) {
        Solver solver = new Solver();
        try {
            Problem problem = new Problem(3);
            List<Move> solve = solver.solve(problem);
            System.out.println("hasBeenSolved:"+problem.hasBeenSolved());

        } catch (MoveException e) {
            e.printStackTrace();
        }
    }
}
