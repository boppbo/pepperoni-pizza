package de.hs_karlsruhe.Sheets;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the fourth exercise sheet.
 * Created by boris on 07.12.2015.
 */
public class FourthExerciseSheetTest {
    private FourthExerciseSheet.Quersumme instance = new FourthExerciseSheet.Quersumme();

    @Test
    public void testZero() {
        assertEquals(this.instance.calc(0), 0);
    }

    @Test
    public void testOnehundret() {
        assertEquals(this.instance.calc(100), 1);

    }

    @Test
    public void test333() {
        assertEquals(this.instance.calc(333), 9);

    }

    @Test
    public void testSeven() {
        assertEquals(this.instance.calc(7), 7);

    }

    @Test
    public void testFoo() {
        assertEquals(this.instance.calc(96837651), 45);
    }
}