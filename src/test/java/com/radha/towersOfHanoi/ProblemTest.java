package com.radha.towersOfHanoi;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ProblemTest {

    @Test
    public void testMakeMove() throws MoveException {
        Problem problem = spy(new Problem(5));
        TowersOfHanoi currentState = mock(TowersOfHanoi.class);
        Move move = mock(Move.class);
        doReturn(currentState).when(problem).getCurrentState();

        TowersOfHanoi actual = problem.makeMove(move);

        verify(currentState).move(move);
        assertThat(actual).isEqualTo(currentState);
    }
}