package de.hs_karlsruhe.Sheets.Core;

import de.hs_karlsruhe.Selection.IExerciseSelector;

/**
 * Common workflow to run one exercise of the sheet.
 * Created by boris on 23.10.2015.
 */
public abstract class SelectableExerciseSheetBase extends ExerciseSheetBase {
    private final IExerciseSelector _selector;

    /**
     * Initializes the exercise sheet with the exercise selector.
     *
     * @param selector The exercise selector
     */
    public SelectableExerciseSheetBase(IExerciseSelector selector) {
        if (selector == null)
            throw new IllegalArgumentException("selector");

        this._selector = selector;
    }

    /**
     * Runs the selected exercise.
     *
     * @param exerciseIndex The index of the selected exercise
     */
    protected abstract void doRunExercise(int exerciseIndex) throws IndexOutOfBoundsException;

    /**
     * Throws an index out of bounds exception with a matching human readable message.
     */
    protected void throwOutOfBounds() {
        throw new IndexOutOfBoundsException("The selected exercise wasn't found!");
    }

    /**
     * Selects the desired exercise and runs it.
     */
    @Override
    public final void runExercises() {
        int exerciseIndex = this._selector.getIndex();

        try {
            this.doRunExercise(exerciseIndex);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
