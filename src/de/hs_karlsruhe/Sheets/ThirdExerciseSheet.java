package de.hs_karlsruhe.Sheets;

import de.hs_karlsruhe.Sheets.Core.ExerciseSheetBase;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * The third exercise sheet
 * Created by boris on 05.11.2015.
 */
public class ThirdExerciseSheet extends ExerciseSheetBase {
    /**
     * Determines whether the given year is a leap year
     *
     * @param year The year to check
     * @return True for a leap year otherwise false
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 < 1 && year % 100 > 0) || year % 400 < 1;
    }

    /**
     * Gets the day of the week index for the given date
     *
     * @param calendar The date to process
     * @return A value between 0 and 6
     */
    public static int getDayOfWeek(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR), month = calendar.get(Calendar.MONTH), day = calendar.get(Calendar.DAY_OF_MONTH);
        if (year < 1900)
            throw new IllegalArgumentException();

        //December wouldn't be necessary.
        int[] dayOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        long result = day;
        for (int i = 0; i < month; i++)
            result += dayOfMonth[i];

        //No leap day for jan and feb
        if ((month < Calendar.MARCH) && isLeapYear(year))
            result -= 1;

        year -= 1900;
        result += year * 365 + year / 4;

        return (int) result % 7;
    }

    /**
     * Determines whether the given dates are leap years and their week day.
     */
    @Override
    public void runExercises() {
        for (int i : new int[]{1899, 1900, 1904, 2000})
            System.out.printf("Das Jahr %s ist %s Schaltjahr.%n", i, isLeapYear(i) ? "ein" : "kein");

        System.out.println(getDayOfWeek(new GregorianCalendar(1916, Calendar.APRIL, 23)));
        System.out.println(getDayOfWeek(new GregorianCalendar(2007, Calendar.APRIL, 8)));
        System.out.println(getDayOfWeek(new GregorianCalendar(2010, Calendar.APRIL, 4)));
        System.out.println();

        System.out.println(getDayOfWeek(new GregorianCalendar(2006, Calendar.MARCH, 1)));
        System.out.println(getDayOfWeek(new GregorianCalendar(2007, Calendar.MARCH, 21)));
        System.out.println(getDayOfWeek(new GregorianCalendar(2010, Calendar.FEBRUARY, 17)));
        System.out.println();

        System.out.println(getDayOfWeek(new GregorianCalendar(1949, Calendar.MAY, 23)));
        //Today
        System.out.println(getDayOfWeek(new GregorianCalendar()));
    }
}
