package com.radha.towersOfHanoi;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class TowerTest {
    @Test
    public void testConstructor() throws NoMoreDiskException {
        Tower tower = new Tower(1, 3);

        Assertions.assertThat(tower.getTopDisk()).isPresent().contains(new Disk(1));
        Assertions.assertThat(tower.removeDisk().getRadius()).isEqualTo(1);
        Assertions.assertThat(tower.removeDisk().getRadius()).isEqualTo(2);
        Assertions.assertThat(tower.removeDisk().getRadius()).isEqualTo(3);
        Assertions.assertThatThrownBy(() -> tower.removeDisk())
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
        Assertions.assertThat(tower.getTopDisk()).contains(firstDisk);

        tower.putDisk(secondDisk);
        Assertions.assertThat(tower.getTopDisk()).contains(secondDisk);

        Assertions.assertThatThrownBy(() -> tower.putDisk(thirdDisk))
                .isInstanceOf(PutDiskException.class)
                .hasMessage("You can not put a large disk above the small disk");
    }

    @Test
    public void testRemoveDisk() throws NoMoreDiskException {
        Tower tower = new Tower(1, 3);

        Assertions.assertThat(tower.removeDisk()).isEqualTo(new Disk(1));
        Assertions.assertThat(tower.removeDisk()).isEqualTo(new Disk(2));
        Assertions.assertThat(tower.removeDisk()).isEqualTo(new Disk(3));
        Assertions.assertThatThrownBy(() -> tower.removeDisk())
                .isInstanceOf(NoMoreDiskException.class)
                .hasCauseInstanceOf(EmptyStackException.class)
                .hasMessage("The tower 1 has no disks");
    }

    @Test
    public void testGetTopDisk(){
        Tower tower = new Tower(1, 3);

        Assertions.assertThat(tower.getTopDisk()).isPresent().isEqualTo(new Disk(1));

    }

    @Test
    public void testGetTopDiskForEmptyTower(){
        Tower tower = new Tower(1, 0);

        Assertions.assertThat(tower.getTopDisk()).isEmpty();

    }



}