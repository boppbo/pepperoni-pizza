package de.hs_karlsruhe.Sheets;

import de.hs_karlsruhe.Selection.IExerciseSelector;
import de.hs_karlsruhe.Sheets.Core.SelectableExerciseSheetBase;

/**
 * The fourth exercise sheet.
 * Created by boris on 09.11.2015.
 */
public class FourthExerciseSheet extends SelectableExerciseSheetBase {
    /**
     * Initializes the exercise sheet with the exercise selector.
     *
     * @param selector The exercise selector
     */
    public FourthExerciseSheet(IExerciseSelector selector) {
        super(selector);
    }

    private void digitSum() {
        for (long i : new long[]{14632, 12345, 12})
            System.out.printf("Die Quersumme von %s ist %s%n", i, new Quersumme().calc(i));
    }

    private void euler() {
        for (double x : new double[]{1, 2, 3, 3.5, 4.711, 10})
            System.out.printf("e^x von x=%s ist %s%n", x, Euler.pow(x));
    }

    /**
     * Runs the selected exercise.
     *
     * @param exerciseIndex The index of the selected exercise
     * @throws IndexOutOfBoundsException
     */
    @Override
    protected void doRunExercise(int exerciseIndex) throws IndexOutOfBoundsException {
        switch (exerciseIndex) {
            case 1:
                this.digitSum();
                break;
            case 2:
                this.euler();
                break;
            default:
                this.throwOutOfBounds();
        }
    }

    private static class Euler {
        private static double pow(double x) {
            // 1 + x + (x*x)/(2*1) + (x*x*x)/(3*2*1)
            long divisor = 1;
            double result = 1, lastResult = 0;

            for (int i = 1; result - lastResult > 0.001; i++) {
                lastResult = result;

                divisor *= i;
                result += Math.pow(x, i) / divisor;
            }

            return result;
        }
    }

    public static class Quersumme {
        public int calc(long input) {
            int result = 0;

            do {
                result += input % 10;
                input /= 10;
            } while (input > 0);

            return result;
        }
    }
}
