package de.hs_karlsruhe.Sheets;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the eighth exercise sheet.
 * Created by boris on 08.12.2015.
 */
public class EighthExerciseSheetTest {
    private EighthExerciseSheet instance = new EighthExerciseSheet(() -> 0);

    @Test
    public void testLinearRecursion() throws Exception {
        assertEquals(this.instance.linearRecursion(new int[]{5, 9, 2, 13, 6, 4, 13, 5}), 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLinearRecursionNull() throws Exception {
        this.instance.linearRecursion(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLinearRecursionEmpty() throws Exception {
        this.instance.linearRecursion(new int[0]);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testLinearRecursionBig() throws Exception {
        this.instance.linearRecursion(new int[1000000]);
    }

    @Test
    public void testZeroBinomial() throws Exception {
        assertEquals(this.instance.getBinomialKoeffizient(1, 0), 1);
    }

    @Test
    public void testOneBinomial() throws Exception {
        assertEquals(this.instance.getBinomialKoeffizient(1, 1), 1);
    }

    @Test
    public void testBinomial2() throws Exception {
        assertEquals(this.instance.getBinomialKoeffizient(4, 2), 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBinomialNegN() throws Exception {
        this.instance.getBinomialKoeffizient(-1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBinomialNegK() throws Exception {
        this.instance.getBinomialKoeffizient(0, -1);
    }

    @Test
    public void testBinomialNSmallerK() throws Exception {
        assertEquals(this.instance.getBinomialKoeffizient(1, 5), 0);
    }
}