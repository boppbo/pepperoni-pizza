package de.hs_karlsruhe.Sheets;

import de.hs_karlsruhe.Sheets.Core.ExerciseSheetBase;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

/**
 * The tenth exercise sheet.
 * Created by boris on 09.12.2015.
 */
public class TenthExerciseSheet extends ExerciseSheetBase {
    public void mergeSort(int[] a, int links, int rechts) {
        if (links >= rechts)
            return;

        int mitte = (links + rechts) / 2;
        mergeSort(a, links, mitte);
        mergeSort(a, mitte + 1, rechts);
        reisverschluss(a, links, mitte, rechts);
    }

    private void reisverschluss(int[] a, int links, int mitte, int rechts) {
        throw new NotImplementedException();
    }

    /**
     * Runs the mergesort process.
     */
    @Override
    public void runExercises() {
        int[] a = new int[]{5, 2, 3, 50, 12, 6, 6, 2};
        this.mergeSort(a, 0, a.length - 1);

        System.out.println(
                String.join(", ", Arrays.stream(a)
                        .mapToObj(Integer::toString)
                        .toArray(String[]::new)));
    }
}
