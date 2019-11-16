package com.radha.towersOfHanoi;

public class NoMoreDiskException extends Exception {
    public NoMoreDiskException(Tower tower) {
        super("The tower "+tower+" is empty");
    }

    public NoMoreDiskException(String message, Throwable cause) {
        super(message, cause);
    }
}
