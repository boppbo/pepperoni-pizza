package de.hs_karlsruhe.Sheets.Core;

import java.util.Scanner;

/**
 * Exercise sheet class with helpers for user input
 * Created by boris on 05.11.2015.
 */
public abstract class ExerciseSheetBase implements IExerciseSheet {
    private final Scanner _scanner = new Scanner(System.in, "UTF-8");

    /**
     * Queries the user to enter a double value.
     *
     * @return The entered double value
     */
    protected double queryDouble() {
        System.out.print("Bitte geben Sie eine beliebige Gleitkommazahl ein: ");
        double result = this._scanner.nextDouble();
        this._scanner.nextLine();
        return result;
    }

    /**
     * Queries the user to enter any integer value.
     *
     * @return The entered integer value
     */
    protected int queryInteger() {
        return this.queryInteger(false);
    }

    /**
     * Queries the user to enter a integer value.
     *
     * @param positiveOnly Flag to allow only positive values.
     * @return The entered positive integer value.
     */
    protected int queryInteger(boolean positiveOnly) {
        int result;

        do {
            System.out.printf("Bitte geben Sie eine %s Ganzzahl ein: ", positiveOnly ? "positive " : "beliebige");
            result = this._scanner.nextInt();
            this._scanner.nextLine();
        } while (positiveOnly && result < 0);

        return result;
    }

    /**
     * Queries the user with the given message to enter a value;
     *
     * @param message The prompt message.
     * @return The user input
     */
    protected String queryString(String message) {
        System.out.print(message);
        return this._scanner.nextLine();
    }

    /**
     * Runs the exercises of the sheet
     */
    public abstract void runExercises();

}
