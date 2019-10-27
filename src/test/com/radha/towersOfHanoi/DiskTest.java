package test.com.radha.towersOfHanoi;

import com.radha.towersOfHanoi.Disk;
import org.junit.Assert;
import org.junit.Test;


class DiskTest {
    @Test
    public void testCompareTo(){
        Disk disk = new Disk(7);
        Disk other = new Disk(8);
        int actual = disk.compareTo(other);
        Assert.assertEquals(-1, actual);

    }

}