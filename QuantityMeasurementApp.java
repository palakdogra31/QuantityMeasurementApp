// public class QuantityMeasurementApp {

//     // Generic equality method
//     public static boolean demonstrateLengthEquality(
//             Length l1,
//             Length l2) {

//         return l1.equals(l2);
//     }

//     // Generic comparison display
//     public static void demonstrateLengthComparison(
//             double value1,
//             Length.LengthUnit unit1,
//             double value2,
//             Length.LengthUnit unit2) {

//         Length l1 =
//                 new Length(value1, unit1);

//         Length l2 =
//                 new Length(value2, unit2);

//         System.out.println(
//                 value1 + " " + unit1
//                         + " == "
//                         + value2 + " " + unit2
//                         + " ? "
//                         + demonstrateLengthEquality(l1, l2));
//     }

//     // Main Method
//     public static void main(String[] args) {

//         // Feet and Inches
//         demonstrateLengthComparison(
//                 1.0,
//                 Length.LengthUnit.FEET,
//                 12.0,
//                 Length.LengthUnit.INCHES);

//         // Yard and Inches
//         demonstrateLengthComparison(
//                 1.0,
//                 Length.LengthUnit.YARDS,
//                 36.0,
//                 Length.LengthUnit.INCHES);

//         // Yard and Feet
//         demonstrateLengthComparison(
//                 1.0,
//                 Length.LengthUnit.YARDS,
//                 3.0,
//                 Length.LengthUnit.FEET);

//         // Centimeters and Inches
//         demonstrateLengthComparison(
//                 1.0,
//                 Length.LengthUnit.CENTIMETERS,
//                 0.393701,
//                 Length.LengthUnit.INCHES);

//         // Feet and Yards
//         demonstrateLengthComparison(
//                 6.0,
//                 Length.LengthUnit.FEET,
//                 2.0,
//                 Length.LengthUnit.YARDS);

//         // Centimeters and Feet
//         demonstrateLengthComparison(
//                 30.48,
//                 Length.LengthUnit.CENTIMETERS,
//                 1.0,
//                 Length.LengthUnit.FEET);
//     }
// }




//uc5
// package com.apps.quantitymeasurement;

// /**
//  * UC5 - Quantity Measurement Application
//  *
//  * <p>
//  * This application demonstrates:
//  * </p>
//  *
//  * <ul>
//  *     <li>Length equality comparison</li>
//  *     <li>Cross-unit equality checks</li>
//  *     <li>Length conversion between units</li>
//  *     <li>Method overloading</li>
//  * </ul>
//  *
//  * <p>
//  * Supported Units:
//  * FEET, INCHES, YARDS, CENTIMETERS
//  * </p>
//  *
//  * @author Developer
//  * @version 1.0
//  */
// public class QuantityMeasurementApp {

//     /**
//      * Demonstrates equality between two Length objects.
//      *
//      * @param length1 first length
//      * @param length2 second length
//      * @return true if equal, false otherwise
//      */
//     public static boolean demonstrateLengthEquality(
//             Length length1,
//             Length length2) {

//         boolean result =
//                 length1.equals(length2);

//         if (result) {

//             System.out.println(
//                     "The two length measurements are equal.");
//         }

//         else {

//             System.out.println(
//                     "The two length measurements are not equal.");
//         }

//         return result;
//     }

//     /**
//      * Demonstrates comparison using primitive values and units.
//      *
//      * @param value1 first value
//      * @param unit1  first unit
//      * @param value2 second value
//      * @param unit2  second unit
//      * @return true if equal, false otherwise
//      */
//     public static boolean demonstrateLengthComparison(
//             double value1,
//             Length.LengthUnit unit1,
//             double value2,
//             Length.LengthUnit unit2) {

//         Length length1 =
//                 new Length(value1, unit1);

//         Length length2 =
//                 new Length(value2, unit2);

//         return demonstrateLengthEquality(
//                 length1,
//                 length2);
//     }

//     /**
//      * Demonstrates length conversion from one unit to another.
//      *
//      * @param value    value to convert
//      * @param fromUnit source unit
//      * @param toUnit   target unit
//      * @return converted Length object
//      */
//     public static Length demonstrateLengthConversion(
//             double value,
//             Length.LengthUnit fromUnit,
//             Length.LengthUnit toUnit) {

//         Length length =
//                 new Length(value,
//                         fromUnit);

//         Length convertedLength =
//                 length.convertTo(toUnit);

//         System.out.println(
//                 value + " " + fromUnit
//                         + " = "
//                         + convertedLength);

//         return convertedLength;
//     }

//     /**
//      * Overloaded conversion method using Length object.
//      *
//      * @param length existing Length object
//      * @param toUnit target unit
//      * @return converted Length object
//      */
//     public static Length demonstrateLengthConversion(
//             Length length,
//             Length.LengthUnit toUnit) {

//         Length convertedLength =
//                 length.convertTo(toUnit);

//         System.out.println(
//                 length
//                         + " = "
//                         + convertedLength);

//         return convertedLength;
//     }

//     /**
//      * Main method.
//      *
//      * @param args command-line arguments
//      */
//     public static void main(String[] args) {

//         System.out.println(
//                 "===== UC5 Quantity Measurement App =====");

//         // Equality checks
//         demonstrateLengthComparison(
//                 1.0,
//                 Length.LengthUnit.FEET,
//                 12.0,
//                 Length.LengthUnit.INCHES);

//         demonstrateLengthComparison(
//                 1.0,
//                 Length.LengthUnit.YARDS,
//                 36.0,
//                 Length.LengthUnit.INCHES);

//         demonstrateLengthComparison(
//                 3.0,
//                 Length.LengthUnit.FEET,
//                 1.0,
//                 Length.LengthUnit.YARDS);

//         demonstrateLengthComparison(
//                 30.48,
//                 Length.LengthUnit.CENTIMETERS,
//                 1.0,
//                 Length.LengthUnit.FEET);

//         // Conversion examples
//         System.out.println(
//                 "\n===== Conversion Examples =====");

//         demonstrateLengthConversion(
//                 1.0,
//                 Length.LengthUnit.FEET,
//                 Length.LengthUnit.INCHES);

//         demonstrateLengthConversion(
//                 2.0,
//                 Length.LengthUnit.YARDS,
//                 Length.LengthUnit.INCHES);

//         demonstrateLengthConversion(
//                 24.0,
//                 Length.LengthUnit.INCHES,
//                 Length.LengthUnit.FEET);

//         demonstrateLengthConversion(
//                 30.48,
//                 Length.LengthUnit.CENTIMETERS,
//                 Length.LengthUnit.FEET);

//         // Overloaded method example
//         System.out.println(
//                 "\n===== Overloaded Method Example =====");

//         Length yard =
//                 new Length(1.0,
//                         Length.LengthUnit.YARDS);

//         demonstrateLengthConversion(
//                 yard,
//                 Length.LengthUnit.FEET);
//     }
// }




//uc6
package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Equality demonstration
    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2) {

        return length1.equals(length2);
    }

    // Comparison demonstration
    public static boolean demonstrateLengthComparison(
            Length length1,
            Length length2) {

        return length1.equals(length2);
    }

    // Conversion using raw values
    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit fromUnit,
            Length.LengthUnit toUnit) {

        Length length =
                new Length(value, fromUnit);

        return length.convertTo(toUnit);
    }

    // Conversion using object
    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    // Addition demonstration
    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2) {

        return length1.add(length2);
    }

    // Main method
    public static void main(String[] args) {

        Length feet =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        Length inches =
                new Length(12.0,
                        Length.LengthUnit.INCHES);

        boolean equalResult =
                demonstrateLengthEquality(
                        feet,
                        inches);

        System.out.println(
                "Equality Result : "
                        + equalResult);

        Length converted =
                demonstrateLengthConversion(
                        1.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES);

        System.out.println(
                "Converted Length : "
                        + converted);

        Length added =
                demonstrateLengthAddition(
                        feet,
                        inches);

        System.out.println(
                "Added Length : "
                        + added);
    }
}