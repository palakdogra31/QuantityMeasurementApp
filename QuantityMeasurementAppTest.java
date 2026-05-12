// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;

// public class QuantityMeasurementAppTest {

//     // ---------------- UC1 ----------------

//     @Test
//     public void testFeetEquality() {

//         Length l1 =
//                 new Length(1.0, Length.LengthUnit.FEET);

//         Length l2 = new Length(1.0, Length.LengthUnit.FEET);

//         assertTrue(l1.equals(l2));
//     }

//     @Test
//     public void testFeetInequality() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.FEET);

//         Length l2 =
//                 new Length(2.0,
//                         Length.LengthUnit.FEET);

//         assertFalse(l1.equals(l2));
//     }

//     // ---------------- UC2 ----------------

//     @Test
//     public void testInchesEquality() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.INCHES);

//         Length l2 =
//                 new Length(1.0,
//                         Length.LengthUnit.INCHES);

//         assertTrue(l1.equals(l2));
//     }

//     @Test
//     public void testFeetInchesComparison() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.FEET);

//         Length l2 =
//                 new Length(12.0,
//                         Length.LengthUnit.INCHES);

//         assertTrue(l1.equals(l2));
//     }

//     @Test
//     public void testInchesInequality() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.INCHES);

//         Length l2 =
//                 new Length(2.0,
//                         Length.LengthUnit.INCHES);

//         assertFalse(l1.equals(l2));
//     }

//     // ---------------- UC3 ----------------

//     @Test
//     public void testNullComparison() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.FEET);

//         assertFalse(l1.equals(null));
//     }

//     @Test
//     public void testSameReference() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.FEET);

//         assertTrue(l1.equals(l1));
//     }

//     @Test
//     public void testDifferentClassComparison() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.FEET);

//         assertFalse(l1.equals("test"));
//     }

//     // ---------------- UC4 ----------------

//     @Test
//     public void testEquality_YardToYard_SameValue() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.YARDS);

//         Length l2 =
//                 new Length(1.0,
//                         Length.LengthUnit.YARDS);

//         assertTrue(l1.equals(l2));
//     }

//     @Test
//     public void testEquality_YardToYard_DifferentValue() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.YARDS);

//         Length l2 =
//                 new Length(2.0,
//                         Length.LengthUnit.YARDS);

//         assertFalse(l1.equals(l2));
//     }

//     @Test
//     public void testEquality_YardToFeet_EquivalentValue() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.YARDS);

//         Length l2 =
//                 new Length(3.0,
//                         Length.LengthUnit.FEET);

//         assertTrue(l1.equals(l2));
//     }

//     @Test
//     public void testEquality_FeetToYard_EquivalentValue() {

//         Length l1 =
//                 new Length(3.0,
//                         Length.LengthUnit.FEET);

//         Length l2 =
//                 new Length(1.0,
//                         Length.LengthUnit.YARDS);

//         assertTrue(l1.equals(l2));
//     }

//     @Test
//     public void testEquality_YardToInches_EquivalentValue() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.YARDS);

//         Length l2 =
//                 new Length(36.0,
//                         Length.LengthUnit.INCHES);

//         assertTrue(l1.equals(l2));
//     }

//     @Test
//     public void testEquality_InchesToYard_EquivalentValue() {

//         Length l1 =
//                 new Length(36.0,
//                         Length.LengthUnit.INCHES);

//         Length l2 =
//                 new Length(1.0,
//                         Length.LengthUnit.YARDS);

//         assertTrue(l1.equals(l2));
//     }

//     @Test
//     public void testEquality_YardToFeet_NonEquivalentValue() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.YARDS);

//         Length l2 =
//                 new Length(2.0,
//                         Length.LengthUnit.FEET);

//         assertFalse(l1.equals(l2));
//     }

//     @Test
//     public void testEquality_centimetersToInches_EquivalentValue() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.CENTIMETERS);

//         Length l2 =
//                 new Length(0.393701,
//                         Length.LengthUnit.INCHES);

//         assertTrue(l1.equals(l2));
//     }

//     @Test
//     public void testEquality_centimetersToFeet_NonEquivalentValue() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.CENTIMETERS);

//         Length l2 =
//                 new Length(1.0,
//                         Length.LengthUnit.FEET);

//         assertFalse(l1.equals(l2));
//     }

//     @Test
//     public void testEquality_MultiUnit_TransitiveProperty() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.YARDS);

//         Length l2 =
//                 new Length(3.0,
//                         Length.LengthUnit.FEET);

//         Length l3 =
//                 new Length(36.0,
//                         Length.LengthUnit.INCHES);

//         assertTrue(l1.equals(l2));

//         assertTrue(l2.equals(l3));

//         assertTrue(l1.equals(l3));
//     }

//     @Test
//     public void testEquality_YardSameReference() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.YARDS);

//         assertTrue(l1.equals(l1));
//     }

//     @Test
//     public void testEquality_YardNullComparison() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.YARDS);

//         assertFalse(l1.equals(null));
//     }

//     @Test
//     public void testEquality_CentimetersSameReference() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.CENTIMETERS);

//         assertTrue(l1.equals(l1));
//     }

//     @Test
//     public void testEquality_CentimetersNullComparison() {

//         Length l1 =
//                 new Length(1.0,
//                         Length.LengthUnit.CENTIMETERS);

//         assertFalse(l1.equals(null));
//     }

//     @Test
//     public void testEquality_AllUnits_ComplexScenario() {

//         Length l1 =
//                 new Length(2.0,
//                         Length.LengthUnit.YARDS);

//         Length l2 =
//                 new Length(6.0,
//                         Length.LengthUnit.FEET);

//         Length l3 =
//                 new Length(72.0,
//                         Length.LengthUnit.INCHES);

//         assertTrue(l1.equals(l2));

//         assertTrue(l2.equals(l3));

//         assertTrue(l1.equals(l3));
//     }

//     // ---------------- NULL UNIT TESTS ----------------

//     @Test
//     public void testEquality_YardWithNullUnit() {

//         assertThrows(
//                 IllegalArgumentException.class,
//                 () -> {

//                     new Length(1.0, null);
//                 });
//     }

//     @Test
//     public void testEquality_CentimetersWithNullUnit() {

//         assertThrows(
//                 IllegalArgumentException.class,
//                 () -> {

//                     new Length(1.0, null);
//                 });
//     }
// }






package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clean and optimized test suite for UC1 → UC5
 */
public class QuantityMeasurementAppTest {

    // =========================
    // UC1 TESTS
    // =========================

    @Test
    public void testFeetEquality() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        Length l2 =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        assertEquals(l1, l2);
    }

    @Test
    public void testFeetInequality() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        Length l2 =
                new Length(2.0,
                        Length.LengthUnit.FEET);

        assertNotEquals(l1, l2);
    }

    // =========================
    // UC2 TESTS
    // =========================

    @Test
    public void testFeetInchesComparison() {

        Length feet =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        Length inches =
                new Length(12.0,
                        Length.LengthUnit.INCHES);

        assertEquals(feet, inches);
    }

    // =========================
    // UC3 TESTS
    // =========================

    @Test
    public void testNullComparison() {

        Length length =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        assertNotEquals(null, length);
    }

    @Test
    public void testSameReference() {

        Length length =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        assertEquals(length, length);
    }

    @Test
    public void testDifferentObjectComparison() {

        Length length =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        assertNotEquals(length, "test");
    }

    // =========================
    // UC4 TESTS
    // =========================

    @Test
    public void testYardToInchesEquality() {

        Length yard =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        Length inches =
                new Length(36.0,
                        Length.LengthUnit.INCHES);

        assertEquals(yard, inches);
    }

    @Test
    public void testYardToFeetEquality() {

        Length yard =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        Length feet =
                new Length(3.0,
                        Length.LengthUnit.FEET);

        assertEquals(yard, feet);
    }

    @Test
    public void testCentimeterToFeetEquality() {

        Length centimeter =
                new Length(30.48,
                        Length.LengthUnit.CENTIMETERS);

        Length feet =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        assertEquals(centimeter, feet);
    }

    @Test
    public void testTransitiveProperty() {

        Length yard =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        Length feet =
                new Length(3.0,
                        Length.LengthUnit.FEET);

        Length inches =
                new Length(36.0,
                        Length.LengthUnit.INCHES);

        assertEquals(yard, feet);

        assertEquals(feet, inches);

        assertEquals(yard, inches);
    }

    // =========================
    // UC5 CONVERSION TESTS
    // =========================

    @Test
    public void testConvertFeetToInches() {

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                1.0,
                                Length.LengthUnit.FEET,
                                Length.LengthUnit.INCHES);

        Length expected =
                new Length(12.0,
                        Length.LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertInchesToFeet() {

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                24.0,
                                Length.LengthUnit.INCHES,
                                Length.LengthUnit.FEET);

        Length expected =
                new Length(2.0,
                        Length.LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertYardsToInches() {

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                2.0,
                                Length.LengthUnit.YARDS,
                                Length.LengthUnit.INCHES);

        Length expected =
                new Length(72.0,
                        Length.LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    @Test
    public void testSameUnitConversion() {

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                5.0,
                                Length.LengthUnit.FEET,
                                Length.LengthUnit.FEET);

        Length expected =
                new Length(5.0,
                        Length.LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testZeroValueConversion() {

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                0.0,
                                Length.LengthUnit.FEET,
                                Length.LengthUnit.INCHES);

        Length expected =
                new Length(0.0,
                        Length.LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    @Test
    public void testNegativeValueConversion() {

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                -1.0,
                                Length.LengthUnit.FEET,
                                Length.LengthUnit.INCHES);

        Length expected =
                new Length(-12.0,
                        Length.LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    @Test
    public void testOverloadedConversionMethod() {

        Length yard =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                yard,
                                Length.LengthUnit.FEET);

        Length expected =
                new Length(3.0,
                        Length.LengthUnit.FEET);

        assertEquals(expected, result);
    }

    // =========================
    // EXCEPTION TESTS
    // =========================

    @Test
    public void testNullUnitException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(
                        1.0,
                        null));
    }

    @Test
    public void testNaNException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(
                        Double.NaN,
                        Length.LengthUnit.FEET));
    }

    @Test
    public void testInfiniteValueException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(
                        Double.POSITIVE_INFINITY,
                        Length.LengthUnit.FEET));
    }
}