package com.radha.towersOfHanoi;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class TowersOfHanoiTest {
    @Test
    public void testGetTowerByTowerId() {
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi(5, 0);

        assertThat(towersOfHanoi.getTowerByTowerId(1)).isEqualTo(new Tower(1, 5));
    }
    @Test
    public void testGetTowerByTowerIdForInvalidId() {
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi(5, 0);

        assertThatThrownBy(() -> towersOfHanoi.getTowerByTowerId(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid Tower Id. Tower Id can be 1,2 or 3");
    }

    @Test
    public void testMove() throws MoveException, NoMoreDiskException, PutDiskException {
        TowersOfHanoi towersOfHanoi = spy(new TowersOfHanoi(5, 0));
        Move move = new Move(1, 2);
        Tower sourceTower = mock(Tower.class);
        doReturn(sourceTower).when(towersOfHanoi).getTowerByTowerId(1);
        Tower destTower = mock(Tower.class);
        doReturn(destTower).when(towersOfHanoi).getTowerByTowerId(2);

        towersOfHanoi.move(move);

        verify(sourceTower).move(destTower);
    }

    @Test
    public void testMoveOnFailure() throws MoveException, NoMoreDiskException, PutDiskException {
        TowersOfHanoi towersOfHanoi = spy(new TowersOfHanoi(5, 0));
        Move move = new Move(1, 2);
        Tower sourceTower = mock(Tower.class);
        doReturn(sourceTower).when(towersOfHanoi).getTowerByTowerId(1);
        Tower destTower = mock(Tower.class);
        doReturn(destTower).when(towersOfHanoi).getTowerByTowerId(2);
        PutDiskException putDiskException = new PutDiskException(null, null);
        doThrow(putDiskException).when(sourceTower).move(destTower);

        assertThatThrownBy(() -> towersOfHanoi.move(move))
                .isInstanceOf(MoveException.class)
                .hasCause(putDiskException);
    }
}