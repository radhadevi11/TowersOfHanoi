package com.radha.towersOfHanoi;

public class Disk implements Comparable<Disk> {
    private double radius;

    public Disk(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }


    @Override
    public int compareTo(Disk other) {
       return Double.compare(this.getRadius(), other.getRadius());
    }
}
