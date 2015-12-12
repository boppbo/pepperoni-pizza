package de.hs_karlsruhe.ObligatoryExercise.Services;

import de.hs_karlsruhe.ObligatoryExercise.Model.PlayField;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the tic-tac-toe playfield state provider.
 * Created by boris on 11.12.2015.
 */
public class PlayFieldStateProviderTest {

    @Test
    public void testGetNextPlayer() throws Exception {
        PlayField field = new PlayField();
        PlayFieldStateProvider out = new PlayFieldStateProvider(field);

        assertEquals(out.getNextPlayer(), 0);

        field.setPosition(0, 0, 0);

        assertEquals(out.getNextPlayer(), 1);

        field.setPosition(0, 1, 1);

        assertEquals(out.getNextPlayer(), 0);
    }

    @Test
    public void testGetWinningPlayer() throws Exception {
        PlayField field = new PlayField();
        field.setPosition(2, 0, 0);
        field.setPosition(2, 1, 0);
        PlayFieldStateProvider out = new PlayFieldStateProvider(field);

        assertEquals(out.getPlayerWon(0), false);
        assertEquals(out.getWinningPlayer(), -1);

        field.setPosition(2, 2, 0);

        assertEquals(out.getPlayerWon(0), true);
        assertEquals(out.getWinningPlayer(), 0);
    }
}