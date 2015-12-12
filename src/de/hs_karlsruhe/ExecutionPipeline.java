package de.hs_karlsruhe;

import de.hs_karlsruhe.Creation.IExerciseSheetFactory;
import de.hs_karlsruhe.Selection.IExerciseSelector;
import de.hs_karlsruhe.Sheets.Core.IExerciseSheet;

/**
 * The main workflow of the application
 * Created by boris on 12.10.2015.
 */
public class ExecutionPipeline {

    private final IExerciseSheetFactory _factory;
    private final IExerciseSelector _selector;

    /**
     * Creates a new instance of the execution pipeline class
     *
     * @param selector The exercise selector
     * @param factory  The exercise sheet factory
     */
    public ExecutionPipeline(IExerciseSelector selector, IExerciseSheetFactory factory) {
        if (selector == null)
            throw new IllegalArgumentException("selector");
        if (factory == null)
            throw new IllegalArgumentException("factory");

        this._selector = selector;
        this._factory = factory;
    }

    /**
     * Runs the main application workflow.
     */
    public void run() {
        while (true) {
            IExerciseSheet sheet;
            int sheetIndex = this._selector.getIndex();

            if (sheetIndex < 0)
                return;

            try {
                sheet = this._factory.createSheet(sheetIndex);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getLocalizedMessage());
                continue;
            }

            sheet.runExercises();
            System.out.println();
        }
    }
}
