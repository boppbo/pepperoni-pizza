package de.hs_karlsruhe.Sheets;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * The tests for the ninth exercise sheet
 * Created by boris on 09.12.2015.
 */
public class NinthExerciseSheetTest {
    private NinthExerciseSheet instance = new NinthExerciseSheet(() -> 0);

    @Test
    public void testBinarySearch1() throws Exception {
        assertEquals(this.instance.binarySearch(new int[]{1, 3, 5, 7, 9, 13, 21}, 5), 2);
    }

    @Test
    public void testBinarySearch2() throws Exception {
        assertEquals(this.instance.binarySearch(new int[]{1, 3, 5, 7, 9, 13}, 5), 2);
    }

    @Test
    public void testBinarySearch3() throws Exception {
        assertEquals(this.instance.binarySearch(new int[]{1, 3, 5, 7, 9, 13, 21}, 500), -1);
    }

    @Test
    public void testBinarySearch4() throws Exception {
        assertEquals(this.instance.binarySearch(new int[]{1, 3, 5, 7, 9, 13, 21}, -500), -1);
    }

    @Test
    public void testSqrt1() throws Exception {
        assertTrue(Math.abs(this.instance.squareRoot(9) - 3) < 0.01);
    }

    @Test
    public void testSqrt2() throws Exception {
        assertTrue(Math.abs(this.instance.squareRoot(15) - 3.8729) < 0.001);
    }

    @Test
    public void testSqrt3() throws Exception {
        assertTrue(Math.abs(this.instance.squareRoot(0)) < 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSqrt4() throws Exception {
        this.instance.squareRoot(-1);
    }
}