package de.hs_karlsruhe.ObligatoryExercise.Model;

/**
 * Interface for read operations on the tic-tac-toe playfield.
 * Created by boris on 12.12.2015.
 */
public interface IPlayField {
    /**
     * The playerId getPositions returns for unset positions.
     */
    int POSITION_UNSET = -1;

    /**
     * Gets the zero based max column index.
     *
     * @return The max column index
     */
    int getMaxColumnIndex();

    /**
     * Gets the zero based max row index.
     *
     * @return The max row index
     */
    int getMaxRowIndex();

    /**
     * Gets the zero based max player index.
     *
     * @return The max player index
     */
    int getMaxPlayerIndex();

    /**
     * Gets the occupancy of the field at the specified position.
     *
     * @param row    The row index
     * @param column The column index
     * @return Either the zero based player identifier or -1 for unset positions
     */
    int getPosition(int row, int column);
}
