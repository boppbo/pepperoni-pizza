package de.hs_karlsruhe.Sheets;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the fifth exercise sheet.
 * Created by boris on 07.12.2015.
 */
public class FifthExerciseSheetTest {

    @Test
    public void testKonstruktor() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(1, 1, 2000);

        //noinspection ConstantConditions
        assertTrue(datum != null);
    }

    @Test
    public void testIsSchaltjahr1() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(1, 1, 2000);

        assertTrue(datum.isSchaltjahr());
    }

    @Test
    public void testIsSchaltjahr2() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(1, 1, 2001);

        assertTrue(!datum.isSchaltjahr());
    }

    @Test
    public void testIsSchaltjahr3() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(1, 1, 500);

        assertTrue(!datum.isSchaltjahr());
    }

    @Test
    public void testIsKorrekt1() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(15, 12, 2001);

        assertTrue(datum.isKorrekt());
    }

    @Test
    public void testIsKorrekt2() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(-1, 12, 2001);

        assertTrue(!datum.isKorrekt());
    }

    @Test
    public void testIsKorrekt3() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(15, 12, -999);

        assertTrue(!datum.isKorrekt());
    }

    @Test
    public void testIsKorrekt4() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(15, 99, 2001);

        assertTrue(!datum.isKorrekt());
    }

    @Test
    public void testIsKorrekt5() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(29, 2, 2000);

        assertTrue(datum.isKorrekt());
    }

    @Test
    public void testIsKorrekt6() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(15, 12, 1996);

        assertTrue(datum.isKorrekt());
    }

    @Test
    public void testGetTag1() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(15, 12, 1996);

        assertEquals(15, datum.getTag());
    }

    @Test
    public void testGetTag2() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(15, 12, -1996);

        assertEquals(-1, datum.getTag());
    }

    @Test
    public void testGetMonat1() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(15, 12, 1996);

        assertEquals(12, datum.getMonat());
    }

    @Test
    public void testGetMonat2() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(31, 4, 2001);

        assertEquals(-1, datum.getMonat());
    }

    @Test
    public void testGetJahr1() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(15, 12, 1996);

        assertEquals(1996, datum.getJahr());
    }

    @Test
    public void testGetJahr2() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(15, 13, 1996);

        assertEquals(-1, datum.getJahr());
    }

    @Test
    public void testToString() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(1, 1, 2000);

        assertEquals(datum.toString(), "1. Januar 2000 / Schaltjahr");
    }

    @Test
    public void testToString2() {
        FifthExerciseSheet.Datum datum = new FifthExerciseSheet.Datum(5, 8, 1999);

        assertEquals(datum.toString(), "5. August 1999 / kein Schaltjahr");
    }
}