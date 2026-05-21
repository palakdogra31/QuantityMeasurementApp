package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // =========================
    // WEIGHT METHODS (UC9)
    // =========================

    // Compare two Weight objects
    public static boolean demonstrateWeightEquality(
            Weight weight1,
            Weight weight2) {

        return weight1.equals(weight2);
    }

    // Compare two weights using values and units
    public static boolean demonstrateWeightComparison(
            double value1,
            WeightUnit unit1,
            double value2,
            WeightUnit unit2) {

        Weight weight1 = new Weight(value1, unit1);
        Weight weight2 = new Weight(value2, unit2);

        return weight1.equals(weight2);
    }

    // Convert using value and units
    public static Weight demonstrateWeightConversion(
            double value,
            WeightUnit fromUnit,
            WeightUnit toUnit) {

        Weight weight = new Weight(value, fromUnit);

        return weight.convertTo(toUnit);
    }

    // Overloaded conversion method
    public static Weight demonstrateWeightConversion(
            Weight weight,
            WeightUnit toUnit) {

        return weight.convertTo(toUnit);
    }

    // Add two weights (result in first operand unit)
    public static Weight demonstrateWeightAddition(
            Weight weight1,
            Weight weight2) {

        return weight1.add(weight2);
    }

    // Add two weights with explicit target unit
    public static Weight demonstrateWeightAddition(
            Weight weight1,
            Weight weight2,
            WeightUnit targetUnit) {

        return weight1.add(weight2, targetUnit);
    }


    // =========================
    // EXISTING LENGTH METHODS
    // =========================

    // Compare two Length objects
    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2) {

        return length1.equals(length2);
    }

    // Compare lengths using values and units
    public static boolean demonstrateLengthComparison(
            double value1,
            LengthUnit unit1,
            double value2,
            LengthUnit unit2) {

        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);

        return length1.equals(length2);
    }

    // Convert using value and units
    public static Length demonstrateLengthConversion(
            double value,
            LengthUnit fromUnit,
            LengthUnit toUnit) {

        Length length = new Length(value, fromUnit);

        return length.convertTo(toUnit);
    }

    // Overloaded conversion method
    public static Length demonstrateLengthConversion(
            Length length,
            LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    // Add two lengths
    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2) {

        return length1.add(length2);
    }

    // Add two lengths with explicit target unit
    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2,
            LengthUnit targetUnit) {

        return length1.add(length2, targetUnit);
    }


    // =========================
    // MAIN METHOD
    // =========================

    public static void main(String[] args) {

        // =========================
        // WEIGHT DEMONSTRATION
        // =========================

        Weight kilogramWeight =
                new Weight(1.0, WeightUnit.KILOGRAM);

        Weight gramWeight =
                new Weight(1000.0, WeightUnit.GRAM);

        Weight poundWeight =
                new Weight(2.20462, WeightUnit.POUND);

        // Equality
        System.out.println(
                "1 Kilogram equals 1000 Gram: "
                        + kilogramWeight.equals(gramWeight));

        // Conversion
        Weight convertedWeight =
                kilogramWeight.convertTo(WeightUnit.GRAM);

        System.out.println(
                "1 Kilogram in Gram: "
                        + convertedWeight);

        // Addition
        Weight addedWeight =
                kilogramWeight.add(gramWeight);

        System.out.println(
                "Addition Result: "
                        + addedWeight);

        // Explicit Target Unit Addition
        Weight addedInPound =
                kilogramWeight.add(
                        gramWeight,
                        WeightUnit.POUND);

        System.out.println(
                "Addition in Pound: "
                        + addedInPound);


        // =========================
        // LENGTH DEMONSTRATION
        // =========================

        Length feet =
                new Length(1.0, LengthUnit.FEET);

        Length inches =
                new Length(12.0, LengthUnit.INCHES);

        // Equality
        System.out.println(
                "1 Foot equals 12 Inches: "
                        + feet.equals(inches));

        // Conversion
        Length convertedLength =
                feet.convertTo(LengthUnit.INCHES);

        System.out.println(
                "1 Foot in Inches: "
                        + convertedLength);

        // Addition
        Length addedLength =
                feet.add(inches);

        System.out.println(
                "Addition Result: "
                        + addedLength);
    }
}