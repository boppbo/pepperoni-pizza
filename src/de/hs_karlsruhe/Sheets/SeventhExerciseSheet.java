package de.hs_karlsruhe.Sheets;

import java.util.Arrays;

/**
 * Sudoku
 * Created by boris on 07.12.2015.
 */
public class SeventhExerciseSheet {

    public static boolean isCorrectSudoku(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            Boolean[] rowCheck = new Boolean[9];
            Boolean[] colCheck = new Boolean[9];

            for (int j = 0; j < 9; j++) {
                int x = sudoku[i][j] - 1;
                int y = sudoku[j][i] - 1;

                if (x > 9 || y > 9)
                    return false;

                rowCheck[x] = true;
                colCheck[y] = true;
            }

            if (!Arrays.stream(rowCheck).allMatch(Boolean.TRUE::equals)
                    || !Arrays.stream(colCheck).allMatch(Boolean.TRUE::equals))
                return false;
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isCorrectBlock(sudoku, i, j))
                    return false;
            }
        }

        return true;
    }

    private static boolean isCorrectBlock(int[][] sudoku, int firstRow, int firstCol) {
        Boolean[] blockCheck = new Boolean[9];

        for (int i = firstRow; i < firstRow + 3; i++) {
            for (int j = firstCol; j < firstCol + 3; j++) {
                blockCheck[sudoku[i][j] - 1] = true;
            }
        }

        return Arrays.stream(blockCheck).allMatch(Boolean.TRUE::equals);
    }
}
