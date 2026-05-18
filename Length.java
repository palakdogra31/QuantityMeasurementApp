//uc7 

package com.apps.quantitymeasurement;

public class Length {

    // Instance variables
    private final double value;
    private final LengthUnit unit;

    /**
     * Enum representing different length units and their
     * conversion factors relative to inches.
     */
    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {

            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {

            return conversionFactor;
        }
    }

    /**
     * Constructor to initialize length value and unit.
     */
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

    /**
     * Converts this length into base unit (inches).
     */
    private double convertToBaseUnit() {

        double baseValue =
                this.value *
                        this.unit.getConversionFactor();

        return Math.round(baseValue * 100.0) / 100.0;
    }

    /**
     * Helper comparison method.
     */
    private boolean compare(Length thatLength) {

        return Double.compare(
                this.convertToBaseUnit(),
                thatLength.convertToBaseUnit()) == 0;
    }

    /**
     * Overrides equals method.
     */
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

        Length thatLength = (Length) o;

        return compare(thatLength);
    }

    /**
     * Converts current length into target unit.
     */
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double baseValue =
                convertToBaseUnit();

        double convertedValue =
                baseValue /
                        targetUnit.getConversionFactor();

        convertedValue =
                Math.round(convertedValue * 100.0) / 100.0;

        return new Length(
                convertedValue,
                targetUnit);
    }

    /**
     * UC6 Addition Method
     * Result returned in first operand unit.
     */
    public Length add(Length thatLength) {

        return addAndConvert(
                thatLength,
                this.unit);
    }

    /**
     * UC7 Addition Method
     * Result returned in specified target unit.
     */
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

    /**
     * Private utility method for addition.
     */
    private Length addAndConvert(
            Length length,
            LengthUnit targetUnit) {

        if (length == null) {

            throw new IllegalArgumentException(
                    "Length cannot be null");
        }

        double thisBaseValue =
                this.convertToBaseUnit();

        double thatBaseValue =
                length.convertToBaseUnit();

        double sumInBaseUnit =
                thisBaseValue + thatBaseValue;

        double convertedValue =
                convertFromBaseToTargetUnit(
                        sumInBaseUnit,
                        targetUnit);

        return new Length(
                convertedValue,
                targetUnit);
    }

    /**
     * Converts inches into target unit.
     */
    private double convertFromBaseToTargetUnit(
            double lengthInInches,
            LengthUnit targetUnit) {

        double convertedValue =
                lengthInInches /
                        targetUnit.getConversionFactor();

        return Math.round(
                convertedValue * 100.0) / 100.0;
    }

    /**
     * String representation.
     */
    @Override
    public String toString() {

        return value + " " + unit;
    }

    /**
     * Main method.
     */
    public static void main(String[] args) {

        Length length1 =
                new Length(
                        1.0,
                        LengthUnit.FEET);

        Length length2 =
                new Length(
                        12.0,
                        LengthUnit.INCHES);

        System.out.println(
                "Addition in FEET: "
                        + length1.add(
                                length2,
                                LengthUnit.FEET));

        System.out.println(
                "Addition in INCHES: "
                        + length1.add(
                                length2,
                                LengthUnit.INCHES));

        System.out.println(
                "Addition in YARDS: "
                        + length1.add(
                                length2,
                                LengthUnit.YARDS));
    }
}