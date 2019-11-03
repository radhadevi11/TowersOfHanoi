package com.radha.towersOfHanoi;

import org.assertj.core.api.Assertions;
import org.junit.Test;


import static org.junit.Assert.*;

public class DiskTest {

    @Test
    public void testCompareTo() {
        Disk bigDisk = new Disk(5);
        Disk equallyBigDisk = new Disk(5);
        Disk smallDisk = new Disk(2);


        Assertions.assertThat(bigDisk.compareTo(smallDisk)).isEqualTo(1);
        Assertions.assertThat(smallDisk.compareTo(bigDisk)).isEqualTo(-1);
        Assertions.assertThat(equallyBigDisk.compareTo(bigDisk)).isEqualTo(0);

    }
}