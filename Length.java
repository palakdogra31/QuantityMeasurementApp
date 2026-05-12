//uc4

// public class Length {

//     private final double value;

//     private final LengthUnit unit;

//     // Enum for units
//     public enum LengthUnit {

//         FEET(12.0),
//         INCHES(1.0),
//         YARDS(36.0),
//         CENTIMETERS(0.393701);

//         private final double conversionFactor;

//         LengthUnit(double conversionFactor) {

//             this.conversionFactor = conversionFactor;
//         }

//         public double getConversionFactor() {

//             return conversionFactor;
//         }
//     }

//     // Constructor
//     public Length(double value,
//                   LengthUnit unit) {

//         if (unit == null) {

//             throw new IllegalArgumentException(
//                     "Unit cannot be null");
//         }

//         this.value = value;

//         this.unit = unit;
//     }

//     // Convert to inches
//     private double convertToBaseUnit() {

//         return this.value
//                 * this.unit.getConversionFactor();
//     }

//     // Compare method
//     public boolean compare(Length other) {

//         double difference =
//                 Math.abs(
//                         this.convertToBaseUnit()
//                         - other.convertToBaseUnit());

//         return difference < 0.0001;
//     }

//     // equals override
//     @Override
//     public boolean equals(Object obj) {

//         if (this == obj) {

//             return true;
//         }

//         if (obj == null) {

//             return false;
//         }

//         if (this.getClass() != obj.getClass()) {

//             return false;
//         }

//         Length other = (Length) obj;

//         return this.compare(other);
//     }
// }




//uc5
package com.apps.quantitymeasurement;

/**
 * A generic class for representing and comparing lengths in different units.
 *
 * <p>
 * This class encapsulates a length value along with its unit of measurement.
 * All conversions and comparisons use inches as the base unit.
 * </p>
 *
 * <p>
 * Supported Units:
 * FEET, INCHES, YARDS, CENTIMETERS
 * </p>
 *
 * <p>
 * Equality semantics:
 * Two Length objects are equal if their converted base-unit values are equal.
 * </p>
 *
 * @author Developer
 * @version 1.0
 */
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
     *
     * @param value length value
     * @param unit  length unit
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
     *
     * @return converted value in inches
     */
    private double convertToBaseUnit() {

        double baseValue =
                this.value *
                        this.unit.getConversionFactor();

        return Math.round(baseValue * 100.0) / 100.0;
    }

    /**
     * Private helper method for comparison.
     *
     * @param thatLength another Length object
     * @return true if equal, false otherwise
     */
    private boolean compare(Length thatLength) {

        return Double.compare(
                this.convertToBaseUnit(),
                thatLength.convertToBaseUnit()) == 0;
    }

    /**
     * Overrides equals() method for custom equality logic.
     *
     * @param o object to compare
     * @return true if equal, false otherwise
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
     * Converts this length into target unit.
     *
     * @param targetUnit target length unit
     * @return new Length object in target unit
     */
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        // convert current value to inches
        double baseValue =
                convertToBaseUnit();

        // convert inches to target unit
        double convertedValue =
                baseValue /
                        targetUnit.getConversionFactor();

        // rounding
        convertedValue =
                Math.round(convertedValue * 100.0) / 100.0;

        return new Length(convertedValue,
                targetUnit);
    }

    /**
     * Returns string representation of Length object.
     *
     * @return formatted string
     */
    @Override
    public String toString() {

        return value + " " + unit;
    }

    /**
     * Main method for standalone testing.
     */
    public static void main(String[] args) {

        Length length1 =
                new Length(1.0,
                        LengthUnit.FEET);

        Length convertedLength =
                length1.convertTo(
                        LengthUnit.INCHES);

        System.out.println(
                "Converted Length: "
                        + convertedLength);

        Length yard =
                new Length(1.0,
                        LengthUnit.YARDS);

        Length feet =
                yard.convertTo(
                        LengthUnit.FEET);

        System.out.println(
                "1 Yard in Feet: "
                        + feet);

        Length centimeter =
                new Length(2.54,
                        LengthUnit.CENTIMETERS);

        Length inches =
                centimeter.convertTo(
                        LengthUnit.INCHES);

        System.out.println(
                "2.54 cm in Inches: "
                        + inches);
    }
}