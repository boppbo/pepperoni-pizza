package de.hs_karlsruhe.Sheets;

import de.hs_karlsruhe.Sheets.Core.SelectableExerciseSheetBase;
import de.hs_karlsruhe.Selection.IExerciseSelector;

/**
 * The first exercise sheet.
 * Created by boris on 12.10.2015.
 */
public class FirstExerciseSheet extends SelectableExerciseSheetBase {
    /**
     * Initializes the exercise sheet with the exercise selector.
     *
     * @param selector The exercise selector
     */
    public FirstExerciseSheet(IExerciseSelector selector) {
        super(selector);
    }

    /**
     * Calculates the given polygon.
     */
    protected void calculatePolynom() {
        double x = this.queryDouble();
        double polynom = Math.pow(x, 3) - 4 * Math.pow(x, 2) + x + 6;
        System.out.printf("f(%s) ist %s.%n", x, polynom);

        double irreducablePolynom = (x - 3) * (x + 1) * (x - 2);
        System.out.printf("f(%s) ist immer noch %s.%n", x, irreducablePolynom);

    }

    /**
     * Converts a given celsius temperature to the fahrenheit value.
     */
    protected void convertCelsius() {
        double celsiusTemperature = this.queryDouble();
        double fahrenheitTemperature = 9 * celsiusTemperature / 5 + 32;

        System.out.printf("%s Grad Celsius sind %s Grad Fahrenheit.%n", celsiusTemperature, fahrenheitTemperature);
    }

    /**
     * Calculates the power by doing multiple multiplications
     */
    protected void multiplicate() {
        //Double type is explicitly given.
        double base = this.queryDouble();
        double result = base;
        for (int i = 0; i < 5; i++)
            result = result * result;

        System.out.printf("Das Ergebnis von %s^32 ist %s.%n", base, result);
    }

    /**
     * Runs the selected exercise
     *
     * @param exerciseIndex The index of the selected exercise
     */
    @Override
    protected void doRunExercise(int exerciseIndex) {
        switch (exerciseIndex) {
            case 2:
                this.convertCelsius();
                break;
            case 3:
                this.multiplicate();
                break;
            case 4:
                this.calculatePolynom();
                break;
            default:
                this.throwOutOfBounds();
        }
    }
}
