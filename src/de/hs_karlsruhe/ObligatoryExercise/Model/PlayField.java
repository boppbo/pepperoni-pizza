package de.hs_karlsruhe.ObligatoryExercise.Model;

import java.util.stream.IntStream;

/**
 * The the tic-tac-toe playfield.
 * Created by boris on 09.12.2015.
 */
public class PlayField implements IPlayField {
    private static final int MAX_COLUMN_INDEX = 2;
    private static final int MAX_ROW_INDEX = 2;
    private static final int MAX_PLAYER_INDEX = 1;

    private static final int COLUMN_OFFSET = (MAX_COLUMN_INDEX + 1);
    private static final int ROW_OFFSET = (MAX_ROW_INDEX + 1);

    private static final int PLAYER_OFFSET = ROW_OFFSET * COLUMN_OFFSET;

    private int playField;

    /**
     * Gets the zero based max column index.
     *
     * @return The max column index
     */
    @Override
    public int getMaxColumnIndex() {
        return MAX_COLUMN_INDEX;
    }

    /**
     * Gets the zero based max row index.
     *
     * @return The max row index
     */
    @Override
    public int getMaxRowIndex() {
        return MAX_ROW_INDEX;
    }

    /**
     * Gets the zero based max player index.
     *
     * @return The max player index
     */
    @Override
    public int getMaxPlayerIndex() {
        return MAX_PLAYER_INDEX;
    }

    /**
     * Gets the occupancy of the field at the specified position.
     *
     * @param row    The row index
     * @param column The column index
     * @return Either the zero based player identifier or -1 for unset positions
     */
    @Override
    public int getPosition(int row, int column) {
        return IntStream.rangeClosed(0, MAX_PLAYER_INDEX)
                .filter(i -> this.getBit(this.getBitIndex(row, column, i)))
                .findAny()
                .orElse(POSITION_UNSET);
    }

    /**
     * Sets the field to the player at the specified position.
     *
     * @param row      The zero based row index
     * @param column   The zero based index
     * @param playerId The zero based player identifier
     */
    public void setPosition(int row, int column, int playerId) {
        this.setBit(this.getBitIndex(row, column, playerId));
    }

    /**
     * Gets the value for the specified position
     *
     * @param bitIndex The zero based bit index
     * @return The value at the specified position
     */
    protected boolean getBit(int bitIndex) {
        return (this.playField & this.getBitMask(bitIndex)) != 0;
    }

    /**
     * Gets the index required for accessing the specified location for the specified player.
     *
     * @param row      The zero based row index
     * @param column   The zero based column index
     * @param playerId The zero based player identifier
     * @return The zero based bit position in the data storage.
     */
    protected int getBitIndex(int row, int column, int playerId) {
        if (0 > row || row > MAX_ROW_INDEX
                || 0 > column || column > MAX_COLUMN_INDEX
                || 0 > playerId || playerId > MAX_PLAYER_INDEX)
            throw new IndexOutOfBoundsException();

        return playerId * PLAYER_OFFSET
                + row * COLUMN_OFFSET
                + column;
    }

    /**
     * Resets the playfield.
     */
    protected void reset() {
        this.playField = 0;
    }

    /**
     * Sets the bit at the specified position to true.
     *
     * @param bitIndex The zero based bit index
     */
    protected void setBit(int bitIndex) {
        this.playField = playField | this.getBitMask(bitIndex);
    }

    private int getBitMask(int bitIndex) {
        if (0 > bitIndex || bitIndex >= Integer.SIZE)
            throw new IllegalArgumentException();

        return 1 << bitIndex;
    }
}
