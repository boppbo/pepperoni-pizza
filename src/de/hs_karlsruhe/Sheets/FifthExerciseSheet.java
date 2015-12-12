package de.hs_karlsruhe.Sheets;

import de.hs_karlsruhe.Sheets.Core.ExerciseSheetBase;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * The fifth exercise sheet.
 * Created by boris on 09.11.2015.
 */
public class FifthExerciseSheet extends ExerciseSheetBase {
    @Override
    public void runExercises() {
        System.out.print("Tag: ");
        int tag = this.queryInteger();

        System.out.print("Monat: ");
        int monat = this.queryInteger();

        System.out.print("Jahr: ");
        int jahr = this.queryInteger();

        System.out.println(new Datum(tag, monat, jahr));
    }

    /**
     * Date representation. Should be replaced by upstream java Calendar / Date
     * TODO: Rename UML to english terms.
     */
    public static class Datum {
        private int tag, monat, jahr;
        private int[] dayOfMonth;

        /**
         * Creates a new Date instance.
         *
         * @param tag   The day
         * @param monat The month.
         * @param jahr  The year.
         */
        public Datum(int tag, int monat, int jahr) {
            // Real world applications would throw illegal argument here.
            this.tag = tag;
            this.monat = monat;
            this.jahr = jahr;

            this.dayOfMonth = new int[]{31, this.isSchaltjahr() ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        }

        public boolean isSchaltjahr() {
            return ThirdExerciseSheet.isLeapYear(this.jahr);
        }

        public boolean isKorrekt() {
            return 0 <= this.jahr
                    && (1 <= this.monat && this.monat < 13)
                    && (1 <= this.tag && this.tag <= this.dayOfMonth[this.monat - 1]);
        }

        public int getTag() {
            return this.isKorrekt() ? this.tag : -1;
        }

        public int getMonat() {
            return this.isKorrekt() ? this.monat : -1;
        }

        public int getJahr() {
            return this.isKorrekt() ? this.jahr : -1;
        }

        @Override
        public String toString() {
            return this.isKorrekt()
                    ? String.format(
                    "%s. %s %s / %sSchaltjahr"
                    , this.tag
                    , new SimpleDateFormat("MMMM").format(
                            new GregorianCalendar(this.jahr, this.monat - 1, 1).getTime())
                    , this.jahr
                    , this.isSchaltjahr() ? "" : "kein ")
                    : "ungültiges Datum";

        }
    }
}
