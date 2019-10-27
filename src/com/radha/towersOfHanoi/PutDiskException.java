package com.radha.towersOfHanoi;

public class PutDiskException extends Exception{
    public PutDiskException(String message, Throwable cause){
        super(message, cause);
    }
    public PutDiskException(String message){
        super(message);
    }
}
