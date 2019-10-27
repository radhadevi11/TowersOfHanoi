package com.radha.towersOfHanoi;

/**
 * The Move represents moving one disk from the sourceTower to destinationTower
 */
public class Move {
    private Tower sourceTower;
    private Tower destinationTower;

    public Move(Tower sourceTower, Tower destinationTower) {
        this.sourceTower = sourceTower;
        this.destinationTower = destinationTower;
    }

    public Tower getSourceTower() {
        return sourceTower;
    }

    public Tower getDestinationTower() {
        return destinationTower;
    }

    @Override
    public String toString() {
        return "Move{" +
                "sourceTower=" + sourceTower +
                ", destinationTower=" + destinationTower +
                '}';
    }
}
