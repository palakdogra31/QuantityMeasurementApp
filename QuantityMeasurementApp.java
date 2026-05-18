package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    /**
     * Demonstrates equality between two lengths.
     */
    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2) {

        boolean result =
                length1.equals(length2);

        if (result) {

            System.out.println(
                    "The two length measurements are equal.");
        }

        else {

            System.out.println(
                    "The two length measurements are not equal.");
        }

        return result;
    }

    /**
     * Demonstrates comparison.
     */
    public static boolean demonstrateLengthComparison(
            double value1,
            Length.LengthUnit unit1,
            double value2,
            Length.LengthUnit unit2) {

        Length length1 =
                new Length(value1, unit1);

        Length length2 =
                new Length(value2, unit2);

        return demonstrateLengthEquality(
                length1,
                length2);
    }

    /**
     * Demonstrates conversion.
     */
    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit fromUnit,
            Length.LengthUnit toUnit) {

        Length length =
                new Length(value,
                        fromUnit);

        Length convertedLength =
                length.convertTo(toUnit);

        System.out.println(
                value + " "
                        + fromUnit
                        + " = "
                        + convertedLength);

        return convertedLength;
    }

    /**
     * Overloaded conversion method.
     */
    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit toUnit) {

        Length convertedLength =
                length.convertTo(toUnit);

        System.out.println(
                length
                        + " = "
                        + convertedLength);

        return convertedLength;
    }

    /**
     * UC6 Addition method.
     */
    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2) {

        Length result =
                length1.add(length2);

        System.out.println(
                length1
                        + " + "
                        + length2
                        + " = "
                        + result);

        return result;
    }

    /**
     * UC7 Addition method with target unit.
     */
    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2,
            Length.LengthUnit targetUnit) {

        Length result =
                length1.add(
                        length2,
                        targetUnit);

        System.out.println(
                length1
                        + " + "
                        + length2
                        + " = "
                        + result);

        return result;
    }

    /**
     * Main method.
     */
    public static void main(String[] args) {

        System.out.println(
                "===== UC7 Quantity Measurement App =====");

        Length length1 =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET);

        Length length2 =
                new Length(
                        12.0,
                        Length.LengthUnit.INCHES);

        demonstrateLengthAddition(
                length1,
                length2,
                Length.LengthUnit.FEET);

        demonstrateLengthAddition(
                length1,
                length2,
                Length.LengthUnit.INCHES);

        demonstrateLengthAddition(
                length1,
                length2,
                Length.LengthUnit.YARDS);

        demonstrateLengthAddition(
                new Length(
                        1.0,
                        Length.LengthUnit.YARDS),

                new Length(
                        3.0,
                        Length.LengthUnit.FEET),

                Length.LengthUnit.YARDS);
    }
}