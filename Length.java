package com.apps.quantitymeasurement;

public class Length {

    // Instance Variables
    private double value;
    private LengthUnit unit;

    // Enum for different length units
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

    // Constructor
    public Length(double value,
                  LengthUnit unit) {

        this.value = value;
        this.unit = unit;
    }

    // Convert all units into base unit (inches)
    private double convertToBaseUnit() {

        return value * unit.getConversionFactor();
    }

    // Compare method
    public boolean compare(Length thatLength) {

    double difference =
            Math.abs(
                    this.convertToBaseUnit()
                    - thatLength.convertToBaseUnit());

    return difference < 0.0001;
}

    // Overridden equals method
    @Override
    public boolean equals(Object o) {

        // Same reference
        if (this == o) {

            return true;
        }

        // Null check
        if (o == null) {

            return false;
        }

        // Class check
        if (getClass() != o.getClass()) {

            return false;
        }

        Length that = (Length) o;

        return compare(that);
    }

    // Main method for demonstration
    public static void main(String[] args) {

        Length length1 =
                new Length(1.0,
                        LengthUnit.FEET);

        Length length2 =
                new Length(12.0,
                        LengthUnit.INCHES);

        System.out.println(
                "Feet and Inches Equal? "
                        + length1.equals(length2));



        Length length3 =
                new Length(1.0,
                        LengthUnit.YARDS);

        Length length4 =
                new Length(36.0,
                        LengthUnit.INCHES);

        System.out.println(
                "Yards and Inches Equal? "
                        + length3.equals(length4));



        Length length5 =
                new Length(100.0,
                        LengthUnit.CENTIMETERS);

        Length length6 =
                new Length(39.3701,
                        LengthUnit.INCHES);

        System.out.println(
                "Centimeters and Inches Equal? "
                        + length5.equals(length6));
    }
}