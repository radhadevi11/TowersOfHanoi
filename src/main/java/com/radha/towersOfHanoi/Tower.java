package com.radha.towersOfHanoi;

import java.util.EmptyStackException;
import java.util.Optional;
import java.util.Stack;

public class Tower {
    private int id;
    private Stack<Disk> disks = new Stack<>();
    private int noOfDisks;

    public Tower(int id, int noOfDisks) {
        this.id = id;
        this.noOfDisks = noOfDisks;
        for(int i = noOfDisks; i > 0; i--){
            disks.push(new Disk(i));
        }
    }

    public int getId() {
        return id;
    }

    /**
     * Puts disk at the topmost location.
     * @param disk Disk to put
     * @throws PutDiskException If the given disk is larger than the current topmost disk
     */
    public void putDisk(Disk disk) throws PutDiskException{
        Optional<Disk> topDisk = getTopDisk();
        if(! topDisk.isPresent()){
            disks.push(disk);
        }
        else if(disk.compareTo(topDisk.get()) < 0) {
            disks.push(disk);
        }
        else{
            throw new PutDiskException("You can not put a large disk above the small disk");
        }

    }
    public Disk removeDisk() throws NoMoreDiskException {

            try {
                return disks.pop();
            }catch (EmptyStackException e){
                throw  new NoMoreDiskException("The tower "+this.getId()+" has no disks", e);
            }
    }

    @Override
    public String toString() {
        return "Tower{" +
                "id=" + id +
                '}';
    }
    public Optional<Disk> getTopDisk(){
        if(disks.empty()){
            return Optional.empty();
        }
        return Optional.of(disks.peek());
    }

    public void move(Tower destinationTower) throws  NoMoreDiskException, PutDiskException {
        Disk disk = this.getTopDisk()
                .orElseThrow(() -> new NoMoreDiskException("The top most disk is empty"));

           destinationTower.putDisk(disk);
            this.removeDisk();


    }

}
