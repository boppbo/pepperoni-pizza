package de.hs_karlsruhe.Sheets;

import com.sun.deploy.util.StringUtils;
import de.hs_karlsruhe.Sheets.Core.SelectableExerciseSheetBase;
import de.hs_karlsruhe.Selection.IExerciseSelector;

import java.util.Arrays;
import java.util.Objects;

/**
 * The ninth exercise sheet.
 * Created by boris on 09.12.2015.
 */
public class NinthExerciseSheet extends SelectableExerciseSheetBase {
    /**
     * Initializes the exercise sheet with the exercise selector.
     *
     * @param selector The exercise selector
     */
    public NinthExerciseSheet(IExerciseSelector selector) {
        super(selector);
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
                int key = this.queryInteger();
                String input = this.queryString("Bitte geben Sie eine durch Komma getrennte Menge von Ganzzahlen ein: ");
                int pos = this.binarySearch(
                        Arrays.stream(StringUtils.splitString(input, ","))
                                .map(StringUtils::trimWhitespace)
                                .mapToInt(Integer::parseInt)
                                .sorted()
                                .toArray(), key);
                if (pos < 0)
                    System.out.printf("Die Zahl %s ist nicht in der Liste enthalten%n", key);
                else
                    System.out.printf("Die Zahl %s ist die %s-größte Zahl%n", key, pos + 1);
                break;
            case 2:
                double z = this.queryDouble();
                System.out.println(this.squareRoot(z));
                break;
            default:
                this.throwOutOfBounds();
        }
    }

    /**
     * Searches the array for the given key.
     *
     * @param numbers   The array
     * @param searchKey The key
     * @return The index of the searched element or "-1" for not found.
     */
    public int binarySearch(int[] numbers, int searchKey) {
        Objects.requireNonNull(numbers);

        int low = 0, high = numbers.length - 1, currentPos;

        while (low <= high) {
            currentPos = (low + high) >>> 1; // middle
            int checkedItem = numbers[currentPos];

            if (searchKey < checkedItem) {
                high = currentPos - 1;
                continue;
            }
            if (searchKey > checkedItem) {
                low = currentPos + 1;
                continue;
            }
            //checkedItem == searchKey;
            return currentPos;
        }

        // not found
        return -1;
    }

    /**
     * Returns the square root of given number.
     *
     * @param z The number
     * @return The square root
     */
    public double squareRoot(double z) {
        if (z < 0)
            throw new IllegalArgumentException();

        return this.internalSquareRoot(0, z, z);
    }

    private double internalSquareRoot(double l, double r, double z) {
        final double epsilon = 0.001;
        double a = (l + r) / 2;

        if (z - a * a > epsilon) // a < w
            return this.internalSquareRoot(a, r, z);
        else if (a * a - z > epsilon) // a > w
            return this.internalSquareRoot(l, a, z);
        else
            return a;
    }
}
