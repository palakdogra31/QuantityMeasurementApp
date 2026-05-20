package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Equality demonstration
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

    // Comparison using primitive values
    public static boolean demonstrateLengthComparison(
            double value1,
            LengthUnit unit1,
            double value2,
            LengthUnit unit2) {

        Length length1 =
                new Length(value1,
                        unit1);

        Length length2 =
                new Length(value2,
                        unit2);

        return demonstrateLengthEquality(
                length1,
                length2);
    }

    // Conversion demonstration
    public static Length demonstrateLengthConversion(
            double value,
            LengthUnit fromUnit,
            LengthUnit toUnit) {

        Length length =
                new Length(value,
                        fromUnit);

        Length convertedLength =
                length.convertTo(toUnit);

        System.out.println(
                value + " " + fromUnit
                        + " = "
                        + convertedLength);

        return convertedLength;
    }

    // Overloaded conversion method
    public static Length demonstrateLengthConversion(
            Length length,
            LengthUnit toUnit) {

        Length convertedLength =
                length.convertTo(toUnit);

        System.out.println(
                length
                        + " = "
                        + convertedLength);

        return convertedLength;
    }

    // Addition demonstration
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

    // Addition with target unit
    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2,
            LengthUnit targetUnit) {

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

    // Main method
    public static void main(String[] args) {

        System.out.println(
                "===== UC8 =====");



        demonstrateLengthComparison(
                1.0,
                LengthUnit.FEET,
                12.0,
                LengthUnit.INCHES);



        demonstrateLengthConversion(
                1.0,
                LengthUnit.FEET,
                LengthUnit.INCHES);



        Length l1 =
                new Length(1.0,
                        LengthUnit.FEET);

        Length l2 =
                new Length(12.0,
                        LengthUnit.INCHES);



        demonstrateLengthAddition(
                l1,
                l2);



        demonstrateLengthAddition(
                l1,
                l2,
                LengthUnit.INCHES);
    }
}