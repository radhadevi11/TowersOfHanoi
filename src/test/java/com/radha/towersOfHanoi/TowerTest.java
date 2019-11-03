package com.radha.towersOfHanoi;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class TowerTest {
    @Test
    public void testConstructor() throws NoMoreDiskException {
        Tower tower = new Tower(1, 3);

        Assertions.assertThat(tower.getTopDisk().getRadius()).isEqualTo(1);
        Assertions.assertThat(tower.removeDisk().getRadius()).isEqualTo(1);
        Assertions.assertThat(tower.removeDisk().getRadius()).isEqualTo(2);
        Assertions.assertThat(tower.removeDisk().getRadius()).isEqualTo(3);
        Assertions.assertThatThrownBy(() -> tower.removeDisk())
                .isInstanceOf(NoMoreDiskException.class)
                .hasCauseInstanceOf(EmptyStackException.class)
                .hasMessage("The tower 1 has no disks");


    }
}