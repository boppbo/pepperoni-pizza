package de.hs_karlsruhe.Sheets;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the seventh exercise sheet.
 * Created by boris on 07.12.2015.
 */
public class SeventhExerciseSheetTest {

    @Test
    public void testIsCorrectSudoku() throws Exception {
        assertTrue(SeventhExerciseSheet.isCorrectSudoku(
                new int[][]{
                        {5, 3, 4, 6, 7, 8, 9, 1, 2},
                        {6, 7, 2, 1, 9, 5, 3, 4, 8},
                        {1, 9, 8, 3, 4, 2, 5, 6, 7},
                        {8, 5, 9, 7, 6, 1, 4, 2, 3},
                        {4, 2, 6, 8, 5, 3, 7, 9, 1},
                        {7, 1, 3, 9, 2, 4, 8, 5, 6},
                        {9, 6, 1, 5, 3, 7, 2, 8, 4},
                        {2, 8, 7, 4, 1, 9, 6, 3, 5},
                        {3, 4, 5, 2, 8, 6, 1, 7, 9}
                }));
    }

    @Test
    public void testFaultySudoku1() throws Exception {
        assertFalse(SeventhExerciseSheet.isCorrectSudoku(
                new int[][]{
                        {5, 3, 4, 6, 7, 8, 8, 1, 3},
                        {6, 7, 2, 1, 9, 5, 3, 4, 8},
                        {1, 9, 8, 3, 4, 2, 5, 6, 7},
                        {8, 5, 9, 7, 6, 1, 4, 2, 3},
                        {4, 2, 6, 8, 5, 3, 7, 9, 1},
                        {7, 1, 3, 9, 2, 4, 8, 5, 6},
                        {9, 6, 1, 5, 3, 7, 2, 8, 4},
                        {2, 8, 7, 4, 1, 9, 6, 3, 5},
                        {3, 4, 5, 2, 8, 6, 2, 7, 8}
                }));
    }

    @Test
    public void testFaultySudoku2() throws Exception {
        assertFalse(SeventhExerciseSheet.isCorrectSudoku(
                new int[][]{
                        {5, 3, 7, 6, 4, 8, 9, 1, 2},
                        {6, 7, 2, 1, 9, 5, 3, 4, 8},
                        {1, 9, 4, 3, 8, 2, 5, 6, 7},
                        {8, 5, 9, 7, 6, 1, 4, 2, 3},
                        {4, 2, 6, 8, 5, 3, 7, 9, 1},
                        {7, 1, 3, 9, 2, 4, 8, 5, 6},
                        {9, 6, 8, 5, 3, 7, 2, 1, 4},
                        {2, 8, 1, 4, 7, 9, 6, 3, 5},
                        {3, 4, 5, 2, 8, 6, 1, 7, 9}
                }));
    }

    @Test
    public void testFaultySudoku3() throws Exception {
        assertFalse(SeventhExerciseSheet.isCorrectSudoku(
                new int[][]{
                        {5, 5, 5, 5, 5, 5, 5, 5, 5},
                        {5, 5, 5, 5, 5, 5, 5, 5, 5},
                        {5, 5, 5, 5, 5, 5, 5, 5, 5},
                        {5, 5, 5, 5, 5, 5, 5, 5, 5},
                        {5, 5, 5, 5, 5, 5, 5, 5, 5},
                        {5, 5, 5, 5, 5, 5, 5, 5, 5},
                        {5, 5, 5, 5, 5, 5, 5, 5, 5},
                        {5, 5, 5, 5, 5, 5, 5, 5, 5},
                        {5, 5, 5, 5, 5, 5, 5, 5, 5}
                }));
    }

    @Test
    public void testFaultySudoku4() throws Exception {
        assertFalse(SeventhExerciseSheet.isCorrectSudoku(
                new int[][]{
                        {5, 3, 4, 6, 7, 8, 9, 1, 2},
                        {6, 7, 2, 1, 9, 5, 3, 4, 8},
                        {8, 5, 9, 7, 6, 1, 4, 2, 3},
                        {4, 2, 6, 8, 5, 3, 7, 9, 1},
                        {7, 1, 3, 9, 2, 4, 8, 5, 6},
                        {9, 6, 1, 5, 3, 7, 2, 8, 4},
                        {1, 9, 8, 3, 4, 2, 5, 6, 7},
                        {2, 8, 7, 4, 1, 9, 6, 3, 5},
                        {3, 4, 5, 2, 8, 6, 1, 7, 9}
                }));
    }

    @Test
    public void testFaultySudoku5() throws Exception {
        assertFalse(SeventhExerciseSheet.isCorrectSudoku(
                new int[][]{
                        {5, 3, 4, 6, 7, 8, 9, 12, 2},
                        {6, 7, 2, 12, 9, 5, 3, 4, 8},
                        {12, 9, 8, 3, 4, 2, 5, 6, 7},
                        {8, 5, 9, 7, 6, 12, 4, 2, 3},
                        {4, 2, 6, 8, 5, 3, 7, 9, 12},
                        {7, 12, 3, 9, 2, 4, 8, 5, 6},
                        {9, 6, 12, 5, 3, 7, 2, 8, 4},
                        {2, 8, 7, 4, 12, 9, 6, 3, 5},
                        {3, 4, 5, 2, 8, 6, 12, 7, 9}
                }));
    }
}