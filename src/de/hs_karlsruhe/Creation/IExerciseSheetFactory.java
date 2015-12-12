package de.hs_karlsruhe.Creation;

import de.hs_karlsruhe.Sheets.Core.IExerciseSheet;

/**
 * The exercise sheet factory
 * Created by boris on 12.10.2015.
 */
public interface IExerciseSheetFactory {
    /**
     * Creates the exercise sheet
     *
     * @param sheetIndex The exercise sheet index
     * @return The exercise sheet
     */
    IExerciseSheet createSheet(int sheetIndex);
}
