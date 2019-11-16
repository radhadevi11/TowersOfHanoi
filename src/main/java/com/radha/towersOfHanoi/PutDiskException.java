package com.radha.towersOfHanoi;

public class PutDiskException extends Exception{

    public PutDiskException(Disk disk, Tower tower){
        super("You can not put a large disk:" + disk + " on Tower: " + tower + " above the small disk");
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PutDiskException &&
                getMessage().equals(((PutDiskException) obj).getMessage());
    }
}
