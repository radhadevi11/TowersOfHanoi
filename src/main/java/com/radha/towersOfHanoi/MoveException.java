package com.radha.towersOfHanoi;

public class MoveException extends Throwable {
    public MoveException(Move move, Exception e) {
        super("Illegal move:" + move, e);
    }
}
