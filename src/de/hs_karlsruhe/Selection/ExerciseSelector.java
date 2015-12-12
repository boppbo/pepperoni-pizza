package de.hs_karlsruhe.Selection;

import java.util.Scanner;

/**
 * The exercise selector
 * Created by boris on 12.10.2015.
 */
public class ExerciseSelector implements IExerciseSelector {
    private static final String itemTypePrefix = "exercise";
    private final String _itemType;
    private final Scanner _scanner;

    /**
     * Creates a new instance of the ExerciseSelector class.
     */
    public ExerciseSelector() {
        this(null);
    }

    /**
     * Creates a new instance of the ExerciseSelector class.
     *
     * @param itemType: A suffix after exercise used for the prompt.
     */
    public ExerciseSelector(String itemType) {
        this._itemType = (itemType == null || itemType.isEmpty() || itemType.trim().length() < 1)
                ? itemTypePrefix
                : itemTypePrefix + " " + itemType;

        this._scanner = new Scanner(System.in, "UTF-8");
    }

    /**
     * Gets the exercise sheet index
     *
     * @return The exercise sheet index
     */
    @Override
    public int getIndex() {
        System.out.printf("Please select the %s you want to perform: ", this._itemType);
        return this._scanner.nextInt();
    }
}
