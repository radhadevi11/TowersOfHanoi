package com.radha.towersOfHanoi;

/**
 * The Move represents moving one disk from the sourceTowerId to destinationTowerId
 */
public class Move {
    private int sourceTowerId;
    private int destinationTowerId;

    public Move(int sourceTowerId, int destinationTowerId) {
        this.sourceTowerId = sourceTowerId;
        this.destinationTowerId = destinationTowerId;
    }

    public int getSourceTowerId() {
        return sourceTowerId;
    }

    public int getDestinationTowerId() {
        return destinationTowerId;
    }

    @Override
    public String toString() {
        return "Move{" +
                "sourceTowerId=" + sourceTowerId +
                ", destinationTowerId=" + destinationTowerId +
                '}';
    }
}
