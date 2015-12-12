package de.hs_karlsruhe.ObligatoryExercise.Model;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the tic-tac-toe playfield
 * Created by boris on 10.12.2015.
 */
public class PlayFieldTest {
    @Test
    public void testNewPlayField() throws Exception {
        IPlayField instance = new PlayField();

        IntStream.range(0, 3)
                .flatMap(i -> IntStream.range(0, 3).map(j -> instance.getPosition(i, j)))
                .forEach(player -> assertEquals(player, IPlayField.POSITION_UNSET));
    }

    @Test
    public void testResetPosition() throws Exception {
        PlayField instance = new PlayField();

        instance.setPosition(0, 0, 0);
        instance.reset();

        IntStream.range(0, 3)
                .flatMap(i -> IntStream.range(0, 3).map(j -> instance.getPosition(i, j)))
                .forEach(player -> assertEquals(player, IPlayField.POSITION_UNSET));
    }

    @Test
    public void testGetPosition() throws Exception {
        PlayField instance = new PlayField();

        instance.setPosition(0, 0, 0);
        assertEquals(instance.getPosition(0, 0), 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetPositionOutOfBounds1() throws Exception {
        IPlayField instance = new PlayField();

        instance.getPosition(-1, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetPositionOutOfBounds2() throws Exception {
        IPlayField instance = new PlayField();

        instance.getPosition(0, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetPositionOutOfBounds1() throws Exception {
        PlayField instance = new PlayField();

        instance.setPosition(-1, 0, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetPositionOutOfBounds2() throws Exception {
        PlayField instance = new PlayField();

        instance.setPosition(0, -1, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetPositionOutOfBounds3() throws Exception {
        PlayField instance = new PlayField();

        instance.setPosition(0, 0, -1);
    }
}