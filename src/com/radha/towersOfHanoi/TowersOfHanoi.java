package com.radha.towersOfHanoi;

public class TowersOfHanoi {
    private Tower t1;
    private Tower t2;
    private Tower t3;

    public TowersOfHanoi(Tower t1, Tower t2, Tower t3) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    public Tower getT1() {
        return t1;
    }

    public Tower getT2() {
        return t2;
    }

    public Tower getT3() {
        return t3;
    }

    public void move(Move move) throws MoveException {
        Disk disk = move.getSourceTower().getTopDisk();
        try {
            move.getDestinationTower().putDisk(disk);
            move.getSourceTower().removeDisk();
        } catch (PutDiskException e) {
            throw new MoveException(move, e);
        }

    }
}
