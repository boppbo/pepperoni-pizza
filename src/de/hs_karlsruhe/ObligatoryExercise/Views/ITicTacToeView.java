package de.hs_karlsruhe.ObligatoryExercise.Views;

import java.awt.*;

/**
 * Interface for tic-tac-toe views.
 * Created by boris on 12.12.2015.
 */
public interface ITicTacToeView {
    /**
     * Prints a message saying the input was invalid.
     */
    void printInvalidInput();

    /**
     * Prints a message that no party won.
     */
    void printNoWinner();

    /**
     * Prints a message displaying the winner.
     *
     * @param playerId The winning player id
     */
    void printWinner(int playerId);

    /**
     * Queries the position from the player.
     *
     * @param playerId The player that
     * @return The user input position.
     */
    Point queryPoint(int playerId);
}
