package com.radha.towersOfHanoi;

public class MoveException extends Throwable {
    public MoveException(Move move, PutDiskException e) {
        super("Illegal move:" + move, e);
    }
}
