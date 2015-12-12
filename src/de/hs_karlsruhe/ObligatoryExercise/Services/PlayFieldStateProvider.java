package de.hs_karlsruhe.ObligatoryExercise.Services;

import de.hs_karlsruhe.ObligatoryExercise.Model.IPlayField;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * A state provider for tic-tac-toe playfield.
 * Created by boris on 11.12.2015.
 */
public class PlayFieldStateProvider {
    public static final int PLAYERID_NO_MOVES_LEFT = -1;
    public static final int PLAYERID_NO_WINNER = -1;

    private final int maxColIndex;
    private final int maxRowIndex;
    private final IPlayField model;

    /**
     * Creates a new instance of the playfield state provider class.
     *
     * @param model The playfield model.
     */
    public PlayFieldStateProvider(IPlayField model) {
        this.model = Objects.requireNonNull(model);

        this.maxColIndex = this.model.getMaxColumnIndex();
        this.maxRowIndex = this.model.getMaxRowIndex();
    }

    /**
     * Gets a value whether the player won.
     *
     * @param playerId The player identifier
     * @return True if the player won
     */
    protected boolean getPlayerWon(int playerId) {
        //Full row
        for (int row = 0; row <= maxRowIndex; row++) {
            final int finalRow = row;
            if (IntStream.rangeClosed(0, maxColIndex)
                    .map(col -> this.model.getPosition(finalRow, col))
                    .allMatch(i -> i == playerId))
                return true;
        }
        //Full column
        for (int col = 0; col <= maxColIndex; col++) {
            final int finalCol = col;
            if (IntStream.rangeClosed(0, maxRowIndex)
                    .map(row -> this.model.getPosition(row, finalCol))
                    .allMatch(i -> i == playerId))
                return true;
        }

        // Vertical - only works for squares.
        assert (maxColIndex == maxRowIndex);

        return IntStream.rangeClosed(0, maxColIndex)
                .map(i -> this.model.getPosition(i, i))
                .allMatch(i -> i == playerId)
                || IntStream.rangeClosed(0, maxColIndex)
                .map(i -> this.model.getPosition(i, maxColIndex - i))
                .allMatch(i -> i == playerId);
    }

    /**
     * Gets the player that is allowed to take the next move.
     *
     * @return The player id
     */
    public int getNextPlayer() {
        int maxPlayer = this.model.getMaxPlayerIndex();

        if (IntStream.rangeClosed(0, maxPlayer).anyMatch(this::getPlayerWon))
            return PLAYERID_NO_MOVES_LEFT;

        int[] playerCounter = new int[maxPlayer + 1];
        for (int row = 0; row <= this.maxRowIndex; row++) {
            for (int col = 0; col <= this.maxColIndex; col++) {
                int player = this.model.getPosition(row, col);
                if (player >= 0)
                    playerCounter[player]++;
            }
        }

        if (Arrays.stream(playerCounter).sum() >= (this.maxRowIndex + 1) * (this.maxColIndex + 1))
            return PLAYERID_NO_MOVES_LEFT;

        int minMoves = Integer.MAX_VALUE;
        int playerWithMinMoves = -1;
        for (int i = 0; i < playerCounter.length; i++) {
            int moves = playerCounter[i];
            if (moves < minMoves) {
                minMoves = moves;
                playerWithMinMoves = i;
            }
        }
        return playerWithMinMoves;
    }

    /**
     * Gets the player that won the game or PLAYERID_No_WINNER
     *
     * @return The player that won the game or PLAYERID_No_WINNER
     */
    public int getWinningPlayer() {
        return IntStream.rangeClosed(0, this.model.getMaxPlayerIndex())
                .filter(this::getPlayerWon)
                .findAny()
                .orElse(PLAYERID_NO_MOVES_LEFT);
    }
}
