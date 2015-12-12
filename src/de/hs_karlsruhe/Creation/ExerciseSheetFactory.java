package de.hs_karlsruhe.Creation;

import de.hs_karlsruhe.ObligatoryExercise.Controllers.TicTacToeController;
import de.hs_karlsruhe.ObligatoryExercise.Model.PlayField;
import de.hs_karlsruhe.ObligatoryExercise.Views.TicTacToeView;
import de.hs_karlsruhe.Sheets.*;
import de.hs_karlsruhe.ObligatoryExercise.Services.PlayFieldStateProvider;
import de.hs_karlsruhe.Selection.IExerciseSelector;
import de.hs_karlsruhe.Sheets.Core.IExerciseSheet;

import java.util.Objects;

/**
 * A facotry for exercise sheets
 * Created by boris on 12.10.2015.
 */
public class ExerciseSheetFactory implements IExerciseSheetFactory {
    private final IExerciseSelector _selector;

    /**
     * Creates a new instance of the exercise sheet factory.
     *
     * @param selector The exercise selector for the exercise sheets.
     */
    public ExerciseSheetFactory(IExerciseSelector selector) {
        this._selector = Objects.requireNonNull(selector);
    }

    /**
     * Creates the exercise sheet.
     *
     * @param sheetIndex The exercise sheet index
     * @return The zero based exercise sheet index
     * @throws IndexOutOfBoundsException
     */
    @Override
    public IExerciseSheet createSheet(int sheetIndex) throws IndexOutOfBoundsException {
        switch (sheetIndex) {
            case 0:
                PlayField model = new PlayField();
                return new TicTacToeController(model, new PlayFieldStateProvider(model), new TicTacToeView(model));
            case 1:
                return new FirstExerciseSheet(this._selector);
            case 2:
                return new SecondExerciseSheet(this._selector);
            case 3:
                return new ThirdExerciseSheet();
            case 4:
                return new FourthExerciseSheet(this._selector);
            case 5:
                return new FifthExerciseSheet();
            case 8:
                return new EighthExerciseSheet(this._selector);
            case 9:
                return new NinthExerciseSheet(this._selector);
            case 10:
                return new TenthExerciseSheet();
            default:
                throw new IndexOutOfBoundsException("The selected exercise sheet wasn't found!");
        }
    }
}
