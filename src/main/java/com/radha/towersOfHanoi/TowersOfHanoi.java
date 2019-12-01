package com.radha.towersOfHanoi;

import java.util.Optional;

public class TowersOfHanoi {
    private Tower t1;
    private Tower t2;
    private Tower t3;


    public TowersOfHanoi(int noOfDisksInT1, int noOfDisksInT3) {

        t1 = new Tower(1, noOfDisksInT1);
        t2 = new Tower(2, 0);
        t3 = new Tower(3, noOfDisksInT3);

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
        try {

               Tower sourceTower = getTowerByTowerId(move.getSourceTowerId());
               Tower destinationTower = getTowerByTowerId(move.getDestinationTowerId());
               sourceTower.move(destinationTower);

        } catch (PutDiskException | NoMoreDiskException e ) {
            //System.out.println("");
            throw new MoveException(move, e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TowersOfHanoi otherTowersOfHanoi = (TowersOfHanoi)o;
        return (this.t1.equals(otherTowersOfHanoi.t1)
                && this.t2.equals(otherTowersOfHanoi.t2)
                && this.t3.equals(otherTowersOfHanoi.t3));
    }

    public Tower getTowerByTowerId(int id){
        if(id == t1.getId()){
            return t1;
        }
        if(id == t2.getId()){
            return t2;
        }
        if(id == t3.getId()){
            return  t3;
        }
        throw new IllegalArgumentException("Invalid Tower Id. Tower Id can be 1,2 or 3");
    }

    @Override
    public String toString() {
        return "TowersOfHanoi{" +
                "t1=" + t1 +
                ", t2=" + t2 +
                ", t3=" + t3 +
                '}';
    }
}
