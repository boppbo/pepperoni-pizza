package de.hs_karlsruhe.Sheets;

import de.hs_karlsruhe.Sheets.Core.SelectableExerciseSheetBase;
import de.hs_karlsruhe.Selection.IExerciseSelector;

import java.util.Arrays;

/**
 * The eighth exercise sheet.
 * Created by boris on 07.12.2015.
 */
public class EighthExerciseSheet extends SelectableExerciseSheetBase {

    private int counter = 0;

    /**
     * Initializes the exercise sheet with the exercise selector.
     *
     * @param selector The exercise selector
     */
    public EighthExerciseSheet(IExerciseSelector selector) {
        super(selector);
    }

    /**
     * @param exerciseIndex The index of the selected exercise
     */
    @Override
    protected void doRunExercise(int exerciseIndex) throws IndexOutOfBoundsException {
        switch (exerciseIndex) {
            case 1:
                System.out.println(this.linearRecursion(new int[]{5, 9, 2, 13, 6, 4, 13, 5}));
                break;
            case 2:
                for (int i = 0; i < 31; i++) {
                    int k = i / 2;
                    long result = this.getBinomialKoeffizient(i, k);
                    System.out.printf("(%s/%s) = %s (%s iterations)%n", i, k, result, this.getCounter());
                    this.resetCounter();
                }
                break;
            default:
                this.throwOutOfBounds();
        }
    }

    /**
     * @param n The zero based row index
     * @param k The zero based collumn index
     * @return The seleected row and col in the pascal triangle. This equals the binomial factor
     */
    public long getBinomialKoeffizient(int n, int k) {
        if (n < 0 || k < 0)
            throw new IllegalArgumentException("n");

        this.counter++;

        if (n < k)
            return 0;

        if (k == 0 || n == k)
            return 1;

        return this.getBinomialKoeffizient(n - 1, k - 1) + this.getBinomialKoeffizient(n - 1, k);
    }

    /**
     * Gets the recursion counter
     *
     * @return The number of genBinomialKoeffizient calls.
     */
    public int getCounter() {
        return this.counter;
    }

    /**
     * Resets the recursion counter.
     */
    public void resetCounter() {
        this.counter = 0;
    }

    /**
     * Gets the smallest number in the array.
     * <p>
     * A general rule with recursion is don't use recursion if you can do it inside a simple linear loop.
     * Furthermore this implementation isn't suited for large arrays (presuming java doesn't get tail call optimization right)
     *
     * @param numbers The input array.
     * @return The smallest number in the array.
     */
    public int linearRecursion(int[] numbers) {
        if (numbers == null || numbers.length == 0 || numbers.length > 100)
            throw new IllegalArgumentException("numbers");

        if (numbers.length == 1)
            return numbers[0];

        return Math.min(
                this.linearRecursion(
                        Arrays.copyOf(numbers, numbers.length - 1))
                , numbers[numbers.length - 1]);
    }
}
