package de.hs_karlsruhe.ObligatoryExercise.Controllers;

import de.hs_karlsruhe.ObligatoryExercise.Model.IPlayField;
import de.hs_karlsruhe.ObligatoryExercise.Model.PlayField;
import de.hs_karlsruhe.ObligatoryExercise.Services.PlayFieldStateProvider;
import de.hs_karlsruhe.ObligatoryExercise.Views.ITicTacToeView;
import de.hs_karlsruhe.ObligatoryExercise.Views.TicTacToeView;
import de.hs_karlsruhe.Sheets.Core.IExerciseSheet;

import java.awt.*;
import java.util.Objects;

/**
 * Controller for the tic-tac-toe game
 * Created by boris on 09.12.2015.
 */
public class TicTacToeController implements IExerciseSheet {
    private final PlayField model;
    private final PlayFieldStateProvider stateProvider;
    private final ITicTacToeView view;

    /**
     * Creates a new instance of the TicTacToeController class.
     *
     * @param model         The model
     * @param stateProvider The user interaction view
     * @param view          The view
     */
    public TicTacToeController(PlayField model, PlayFieldStateProvider stateProvider, ITicTacToeView view) {
        this.model = Objects.requireNonNull(model);
        this.stateProvider = Objects.requireNonNull(stateProvider);
        this.view = Objects.requireNonNull(view);
    }

    /**
     * Runs the game.
     */
    @Override
    public void runExercises() {
        int nextPlayerId;
        while ((nextPlayerId = this.stateProvider.getNextPlayer()) != PlayFieldStateProvider.PLAYERID_NO_MOVES_LEFT) {
            ((TicTacToeView) this.view).printField();

            Point newPoint = null;
            do {
                if (newPoint != null)
                    this.view.printInvalidInput();

                newPoint = this.view.queryPoint(nextPlayerId);
            } while (this.model.getPosition(newPoint.y, newPoint.x) != IPlayField.POSITION_UNSET);

            this.model.setPosition(newPoint.y, newPoint.x, nextPlayerId);
        }

        // Should be observer instead
        ((TicTacToeView) this.view).printField();

        int winnerId = this.stateProvider.getWinningPlayer();
        if (winnerId == PlayFieldStateProvider.PLAYERID_NO_WINNER) {
            this.view.printNoWinner();
        } else {
            this.view.printWinner(winnerId);
        }
    }
}
