package com.radha.towersOfHanoi;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disk disk = (Disk) o;
        return Double.compare(disk.radius, radius) == 0;
    }

    @Override
    public String toString() {
        return "Disk{" +
                "radius=" + radius +
                '}';
    }
}
