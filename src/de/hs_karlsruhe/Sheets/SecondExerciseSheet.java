package de.hs_karlsruhe.Sheets;

import de.hs_karlsruhe.Selection.IExerciseSelector;
import de.hs_karlsruhe.Sheets.Core.SelectableExerciseSheetBase;

/**
 * The second exercise sheet.
 * Created by boris on 03.11.2015.
 */
public class SecondExerciseSheet extends SelectableExerciseSheetBase {
    /**
     * Creates a new instance of the second sheet class
     *
     * @param selector The exercise selector.
     */
    public SecondExerciseSheet(IExerciseSelector selector) {
        super(selector);
    }

    private String buildZarmonierName(int number) {
        StringBuilder builder = new StringBuilder();
        int doubleWordCount = Math.round((float) (Math.log10(number) / Math.log10(2))) - 2;
        for (int i = 0; i < doubleWordCount; i++)
            builder.append("doppel");
        builder.append("vier");
        builder.setCharAt(0, Character.toUpperCase(builder.charAt(0)));
        return builder.toString();
    }

    /**
     * Doubles a queried number by manipulating the exponent.
     */
    protected void manipulateFloat() {
        float result = (float) this.queryDouble();

        //Math.getExponent() for poor people
        final int significandBitCount = 23;
        final int exponentBitMask = 0xFF << significandBitCount;
        final int floatCharacteristic = 127;
        int resultBits = Float.floatToIntBits(result);
        int exponent = ((resultBits & exponentBitMask) >> significandBitCount) - floatCharacteristic;

        // increment
        exponent += 1;

        // clear exponent and set new one
        resultBits &= ~exponentBitMask;
        resultBits |= (exponent + floatCharacteristic) << significandBitCount;

        // compare our float to the calculated value
        System.out.println(result * 2);
        System.out.println(Float.intBitsToFloat(resultBits));
    }

    /**
     * Multiplies a number with bit operations.
     */
    protected void multiply() {
        int a = this.queryInteger(true);

        //33 = 2^5 + 1
        System.out.printf("%s * 33 = %s %n", a, (a << 5) + a);
        //41 = 2^5 + 2^3 + 1
        System.out.printf("%s * 41 = %s %n", a, (a << 5) + (a << 3) + a);
    }

    /**
     * Determines if a number is valid in the 'zarmonier' system.
     */
    protected void zarmonier() {
        int number = this.queryInteger();
        boolean isCommonNumber = number < 5, isFourCoefficient = number % 4 < 1, isValidNumber = isCommonNumber ||
                isFourCoefficient;

        String numberText = (!isFourCoefficient || number > 128)
                ? Integer.toString(number)
                : this.buildZarmonierName(number);

        System.out.printf("Die Zahl %s ist %seine Unzahl.%n", numberText, isValidNumber ? "k" : "");
    }

    /**
     * Runs the selected exercise.
     *
     * @param exerciseIndex The index of the selected exercise
     */
    @Override
    protected void doRunExercise(int exerciseIndex) {
        switch (exerciseIndex) {
            case 1:
                this.multiply();
                break;
            case 2:
                this.manipulateFloat();
                break;
            case 3:
                this.zarmonier();
                break;
            default:
                this.throwOutOfBounds();
        }
    }
}
