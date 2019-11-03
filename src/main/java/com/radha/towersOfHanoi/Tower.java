package com.radha.towersOfHanoi;

import java.util.EmptyStackException;
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
        if(disk.compareTo(disks.peek()) < 0) {
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
    public Disk getTopDisk(){
        return this.disks.peek();
    }
}
