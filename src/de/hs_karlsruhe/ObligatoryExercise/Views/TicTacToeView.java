package de.hs_karlsruhe.ObligatoryExercise.Views;

import de.hs_karlsruhe.ObligatoryExercise.Model.IPlayField;

import java.awt.*;
import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * A view for tic-tac-toe
 * Created by boris on 09.12.2015.
 */
public class TicTacToeView implements ITicTacToeView {

    private final IPlayField model;
    private final PrintStream out;
    private final Scanner scanner;

    /**
     * Creates a new instance of the TicTacToeView class.
     *
     * @param model The model
     */
    public TicTacToeView(IPlayField model) {
        this(model, System.out);
    }

    /**
     * Creates a new instance of the TicTacToeView class.
     *
     * @param model  The model
     * @param stream The output stream
     */
    public TicTacToeView(IPlayField model, PrintStream stream) {
        this.model = Objects.requireNonNull(model);
        this.out = Objects.requireNonNull(stream);
        this.scanner = new Scanner(System.in, "UTF-8");
    }

    /**
     * Queries the position from the player.
     *
     * @param playerId The player that
     * @return The user input position.
     */
    @Override
    public Point queryPoint(int playerId) {
        this.out.printf("Spieler %s ist am Zug.%n", this.getPlayerSymbol(playerId));
        int column = this.queryInteger("Spaltennummer");
        int row = this.queryInteger("Zeilennummer");
        return new Point(column, row);
    }

    /**
     * Prints the playfield.
     */
    public void printField() {
        this.out.println(this.formatField());
    }

    /**
     * Prints a message saying the input was invalid.
     */
    @Override
    public void printInvalidInput() {
        this.out.println("Ungültige Eingabe!");
    }

    /**
     * Prints a message that no party won.
     */
    @Override
    public void printNoWinner() {
        this.out.println("Das Spiel endet unentschieden.");
    }

    /**
     * Prints a message displaying the winner.
     *
     * @param playerId The winning player id
     */
    @Override
    public void printWinner(int playerId) {
        this.out.printf("Spieler %s hat gewonnen%n", this.getPlayerSymbol(playerId));
    }

    /**
     * Get a formatted string representing the playfield
     *
     * @return The string representing the playfield.
     */
    protected String formatField() {
        return String.join("------" + System.lineSeparator(),
                IntStream.rangeClosed(0, this.model.getMaxRowIndex())
                        .mapToObj(i -> String.join("|",
                                IntStream.rangeClosed(0, this.model.getMaxColumnIndex())
                                        .mapToObj(j -> this.getPositionSymbol(i, j))
                                        .toArray(String[]::new)))
                        .map(line -> line + System.lineSeparator())
                        .toArray(String[]::new));
    }

    /**
     * Gets the symbol for the given player.
     *
     * @param playerId The player identifier
     * @return The symbol representing the player
     */
    protected String getPlayerSymbol(int playerId) {
        switch (playerId) {
            case IPlayField.POSITION_UNSET:
                return " ";
            case 0:
                return "X";
            case 1:
                return "O";
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * Gets the symbol for the specified position
     *
     * @param row    The zero based row index
     * @param column The zero based column index
     * @return The player symbol or whitespace for unset positions.
     */
    protected String getPositionSymbol(int row, int column) {
        return this.getPlayerSymbol(
                this.model.getPosition(row, column));
    }

    /**
     * Queries a integer with the range 0..2 from the user.
     *
     * @param description The metadata of the integer.
     * @return The user input
     */
    protected int queryInteger(String description) {
        if (description == null || description.isEmpty() || description.trim().length() < 1)
            throw new IllegalArgumentException();

        int result = -1;
        do {
            System.out.printf("Bitte die %s eingeben (0,1,2): ", description);
            try {
                result = this.scanner.nextInt();
            } catch (Exception e) {
                this.printInvalidInput();
                this.scanner.next();
            }
        } while (0 > result || result > 2);

        return result;
    }
}
