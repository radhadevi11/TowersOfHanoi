package com.radha.towersOfHanoi;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class TowerTest {
    @Test
    public void testConstructor() throws NoMoreDiskException {
        Tower tower = new Tower(1, 3);

        assertThat(tower.getTopDisk()).isPresent().contains(new Disk(1));
        assertThat(tower.removeDisk().getRadius()).isEqualTo(1);
        assertThat(tower.removeDisk().getRadius()).isEqualTo(2);
        assertThat(tower.removeDisk().getRadius()).isEqualTo(3);
        assertThatThrownBy(() -> tower.removeDisk())
                .isInstanceOf(NoMoreDiskException.class)
                .hasCauseInstanceOf(EmptyStackException.class)
                .hasMessage("The tower 1 has no disks");


    }

    @Test
    public void testPutDisk() throws PutDiskException {
        Tower tower = new Tower(1,0);
        Disk firstDisk = new Disk(3);
        Disk secondDisk = new Disk(1);
        Disk thirdDisk = new Disk(2);

        tower.putDisk(firstDisk);
        assertThat(tower.getTopDisk()).contains(firstDisk);

        tower.putDisk(secondDisk);
        assertThat(tower.getTopDisk()).contains(secondDisk);

        assertThatThrownBy(() -> tower.putDisk(thirdDisk))
                .isInstanceOf(PutDiskException.class)
                .hasMessage("You can not put a large disk above the small disk");
    }

    @Test
    public void testRemoveDisk() throws NoMoreDiskException {
        Tower tower = new Tower(1, 3);

        assertThat(tower.removeDisk()).isEqualTo(new Disk(1));
        assertThat(tower.removeDisk()).isEqualTo(new Disk(2));
        assertThat(tower.removeDisk()).isEqualTo(new Disk(3));
        assertThatThrownBy(() -> tower.removeDisk())
                .isInstanceOf(NoMoreDiskException.class)
                .hasCauseInstanceOf(EmptyStackException.class)
                .hasMessage("The tower 1 has no disks");
    }

    @Test
    public void testGetTopDisk(){
        Tower tower = new Tower(1, 3);

        assertThat(tower.getTopDisk()).isPresent().isEqualTo(new Disk(1));

    }

    @Test
    public void testGetTopDiskForEmptyTower(){
        Tower tower = new Tower(1, 0);

        assertThat(tower.getTopDisk()).isEmpty();

    }

    @Test
    public void testMove() throws NoMoreDiskException, PutDiskException {
        Tower thisTower = new Tower(1,3);
        Tower destinationTower = new Tower(2, 0);

        thisTower.move(destinationTower);

        assertThat(thisTower.getTopDisk()).isPresent().contains(new Disk(2));
        assertThat(destinationTower.getTopDisk()).isPresent().contains(new Disk(1));

    }
    @Test
    public void testMoveWhenSourceTowerIsEmpty() throws NoMoreDiskException, PutDiskException {
        Tower thisTower = new Tower(1,0);
        Tower destinationTower = new Tower(2, 0);

        assertThatThrownBy(() -> thisTower.move(destinationTower))
                .isInstanceOf(NoMoreDiskException.class)
                .hasMessage("The tower "+thisTower+" is empty");



    }

    @Test
    public void testMoveWhenPuttingLargeDiskAboveSmallDisk() throws NoMoreDiskException, PutDiskException {
        Tower thisTower = new Tower(1,3);
        Tower destinationTower = new Tower(2, 0);

        thisTower.move(destinationTower);
        assertThatThrownBy(() -> thisTower.move(destinationTower))
                .isEqualTo(new PutDiskException(new Disk(2), destinationTower));
    }



}