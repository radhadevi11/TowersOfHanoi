package com.radha.towersOfHanoi;

public class TowersOfHanoi {
    private Tower t1;
    private Tower t2;
    private Tower t3;


    public TowersOfHanoi(int noOfDisksInT1, int noOfDisksInT3) {

        t1 = new Tower(1, noOfDisksInT1);
        t2 = new Tower(2, 0);
        t3 = new Tower(3, noOfDisksInT3);

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
        else if(id == t2.getId()){
            return t2;
        }
        else{
            return  t3;
        }
    }
}
