package com.radha.towersOfHanoi;

public class NoMoreDiskException extends Exception {
    public NoMoreDiskException(String msg) {
        super(msg);
    }

    public NoMoreDiskException(String message, Throwable cause) {
        super(message, cause);
    }
}
