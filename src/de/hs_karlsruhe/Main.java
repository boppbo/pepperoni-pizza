package de.hs_karlsruhe;

import de.hs_karlsruhe.Creation.ExerciseSheetFactory;
import de.hs_karlsruhe.Selection.ExerciseSelector;

public class Main {

    /**
     * Entry point for the console application
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        new ExecutionPipeline(
                new ExerciseSelector("sheet"),
                new ExerciseSheetFactory(
                        new ExerciseSelector()
                )).run();
    }
}
