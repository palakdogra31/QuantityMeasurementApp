package com.apps.quantitymeasurement;

public class Length {

    // Instance variables
    private final double value;
    private final LengthUnit unit;

    // Constructor
    public Length(double value,
                  LengthUnit unit) {

        if (unit == null) {

            throw new IllegalArgumentException(
                    "Unit cannot be null");
        }

        if (!Double.isFinite(value)) {

            throw new IllegalArgumentException(
                    "Invalid numeric value");
        }

        this.value = value;
        this.unit = unit;
    }

    // Equality comparison
    @Override
    public boolean equals(Object o) {

        if (this == o) {

            return true;
        }

        if (o == null) {

            return false;
        }

        if (this.getClass() != o.getClass()) {

            return false;
        }

        Length thatLength =
                (Length) o;

        return compare(thatLength);
    }

    // Convert to target unit
    public Length convertTo(
            LengthUnit targetUnit) {

        if (targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double baseValue =
                convertToBaseUnit();

        double convertedValue =
                targetUnit.convertFromBaseUnit(
                        baseValue);

        return new Length(
                convertedValue,
                targetUnit);
    }

    // Add and return result in same unit
    public Length add(Length thatLength) {

        return addAndConvert(
                thatLength,
                this.unit);
    }

    // Add and return result in target unit
    public Length add(Length length,
                      LengthUnit targetUnit) {

        if (targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        return addAndConvert(
                length,
                targetUnit);
    }

    // Compare two lengths
    private boolean compare(
        Length thatLength) {

    double thisBaseValue =
            this.unit.convertToBaseUnit(
                    this.value);

    double thatBaseValue =
            thatLength.unit.convertToBaseUnit(
                    thatLength.value);

    return Math.abs(
            thisBaseValue - thatBaseValue)
            < 0.0001;
}

    // Internal add helper
    private Length addAndConvert(
            Length length,
            LengthUnit targetUnit) {

        double totalInBaseUnit =
                this.convertToBaseUnit()
                        + length.convertToBaseUnit();

        double convertedValue =
                convertFromBaseToTargetUnit(
                        totalInBaseUnit,
                        targetUnit);

        return new Length(
                convertedValue,
                targetUnit);
    }

    // Convert current value to base unit
    private double convertToBaseUnit() {

        return unit.convertToBaseUnit(value);
    }

    // Convert base unit to target unit
    private double convertFromBaseToTargetUnit(
            double lengthInFeet,
            LengthUnit targetUnit) {

        return targetUnit.convertFromBaseUnit(
                lengthInFeet);
    }

    @Override
    public String toString() {

        return value + " " + unit;
    }

    // Main method
    public static void main(String[] args) {

        Length length1 =
                new Length(1.0,
                        LengthUnit.FEET);

        Length length2 =
                new Length(12.0,
                        LengthUnit.INCHES);

        System.out.println(
                "Equal? "
                        + length1.equals(length2));



        Length converted =
                length1.convertTo(
                        LengthUnit.INCHES);

        System.out.println(
                "Converted: "
                        + converted);



        Length added =
                length1.add(
                        length2,
                        LengthUnit.FEET);

        System.out.println(
                "Addition Result: "
                        + added);
    }
}