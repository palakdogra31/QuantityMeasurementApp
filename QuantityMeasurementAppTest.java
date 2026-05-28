package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // =========================================================
    // UC1 - FEET EQUALITY TESTS
    // =========================================================

    @Test
    public void testFeetEquality_SameValue() {

        Quantity<LengthUnit> feet1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> feet2 =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertEquals(feet1, feet2);
    }

    @Test
    public void testFeetEquality_SameReference() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertEquals(feet, feet);
    }

    @Test
    public void testFeetEquality_NullComparison() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertNotEquals(feet, null);
    }

    @Test
    public void testFeetEquality_DifferentClass() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        String text = "Feet";

        assertNotEquals(feet, text);
    }

    @Test
    public void testFeetInequality_DifferentValue() {

        Quantity<LengthUnit> feet1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> feet2 =
                new Quantity<>(2.0, LengthUnit.FEET);

        assertNotEquals(feet1, feet2);
    }

    // =========================================================
    // UC2 - INCH EQUALITY TESTS
    // =========================================================

    @Test
    public void testInchesEquality_SameValue() {

        Quantity<LengthUnit> inch1 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> inch2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(inch1, inch2);
    }

    @Test
    public void testInchesInequality_DifferentValue() {

        Quantity<LengthUnit> inch1 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> inch2 =
                new Quantity<>(24.0, LengthUnit.INCHES);

        assertNotEquals(inch1, inch2);
    }

    // =========================================================
    // UC3 - FEET AND INCHES EQUALITY
    // =========================================================

    @Test
    public void testFeetEqualsTwelveInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(feet, inches);
    }

    @Test
    public void testTwelveInchesEqualsOneFoot() {

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertEquals(inches, feet);
    }

    // =========================================================
    // UC4 - YARDS AND CENTIMETERS
    // =========================================================

    @Test
    public void testThreeFeetEqualsOneYard() {

        Quantity<LengthUnit> feet =
                new Quantity<>(3.0, LengthUnit.FEET);

        Quantity<LengthUnit> yard =
                new Quantity<>(1.0, LengthUnit.YARDS);

        assertEquals(feet, yard);
    }

    @Test
    public void testOneYardEqualsThreeFeet() {

        Quantity<LengthUnit> yard =
                new Quantity<>(1.0, LengthUnit.YARDS);

        Quantity<LengthUnit> feet =
                new Quantity<>(3.0, LengthUnit.FEET);

        assertEquals(yard, feet);
    }

    @Test
    public void testThirtySixInchesEqualsOneYard() {

        Quantity<LengthUnit> inches =
                new Quantity<>(36.0, LengthUnit.INCHES);

        Quantity<LengthUnit> yard =
                new Quantity<>(1.0, LengthUnit.YARDS);

        assertEquals(inches, yard);
    }

    @Test
    public void testOneYardEqualsThirtySixInches() {

        Quantity<LengthUnit> yard =
                new Quantity<>(1.0, LengthUnit.YARDS);

        Quantity<LengthUnit> inches =
                new Quantity<>(36.0, LengthUnit.INCHES);

        assertEquals(yard, inches);
    }

    @Test
    public void testThirtyPointFortyEightCentimetersEqualsOneFoot() {

        Quantity<LengthUnit> centimeters =
                new Quantity<>(30.48, LengthUnit.CENTIMETERS);

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertEquals(centimeters, feet);
    }

    @Test
    public void testOneCentimeterEqualsPoint393701Inches() {

        Quantity<LengthUnit> centimeter =
                new Quantity<>(1.0, LengthUnit.CENTIMETERS);

        double result =
                centimeter.convertTo(LengthUnit.INCHES);

        assertEquals(0.393701, result, 0.01);
    }

    // =========================================================
    // UC5 - CONVERSION TESTS
    // =========================================================

    @Test
    public void testConvertFeetToInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(2.0, LengthUnit.FEET);

        double result =
                feet.convertTo(LengthUnit.INCHES);

        assertEquals(24.0, result);
    }

    @Test
    public void testConvertInchesToFeet() {

        Quantity<LengthUnit> inches =
                new Quantity<>(24.0, LengthUnit.INCHES);

        double result =
                inches.convertTo(LengthUnit.FEET);

        assertEquals(2.0, result);
    }

    @Test
    public void testConvertYardsToFeet() {

        Quantity<LengthUnit> yards =
                new Quantity<>(2.0, LengthUnit.YARDS);

        double result =
                yards.convertTo(LengthUnit.FEET);

        assertEquals(6.0, result);
    }

    @Test
    public void testConvertCentimetersToInches() {

        Quantity<LengthUnit> centimeters =
                new Quantity<>(2.54, LengthUnit.CENTIMETERS);

        double result =
                centimeters.convertTo(LengthUnit.INCHES);

        assertEquals(1.0, result, 0.01);
    }

    @Test
    public void testSameUnitConversion() {

        Quantity<LengthUnit> feet =
                new Quantity<>(5.0, LengthUnit.FEET);

        double result =
                feet.convertTo(LengthUnit.FEET);

        assertEquals(5.0, result);
    }

    @Test
    public void testZeroValueConversion() {

        Quantity<LengthUnit> inches =
                new Quantity<>(0.0, LengthUnit.INCHES);

        double result =
                inches.convertTo(LengthUnit.FEET);

        assertEquals(0.0, result);
    }

    @Test
    public void testNegativeValueConversion() {

        Quantity<LengthUnit> feet =
                new Quantity<>(-5.0, LengthUnit.FEET);

        double result =
                feet.convertTo(LengthUnit.INCHES);

        assertEquals(-60.0, result);
    }

    // =========================================================
    // UC6 - ADDITION TESTS
    // =========================================================

    @Test
    public void testAddFeetAndInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.add(inches);

        Quantity<LengthUnit> expected =
                new Quantity<>(2.0, LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testAddInchesAndFeet() {

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                inches.add(feet);

        Quantity<LengthUnit> expected =
                new Quantity<>(24.0, LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    @Test
    public void testAddYardsAndFeet() {

        Quantity<LengthUnit> yards =
                new Quantity<>(2.0, LengthUnit.YARDS);

        Quantity<LengthUnit> feet =
                new Quantity<>(3.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                yards.add(feet);

        Quantity<LengthUnit> expected =
                new Quantity<>(3.0, LengthUnit.YARDS);

        assertEquals(expected, result);
    }

    @Test
    public void testAdditionWithZero() {

        Quantity<LengthUnit> feet =
                new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> zero =
                new Quantity<>(0.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.add(zero);

        assertEquals(feet, result);
    }

    @Test
    public void testAdditionWithNegativeValues() {

        Quantity<LengthUnit> feet1 =
                new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> feet2 =
                new Quantity<>(-2.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                feet1.add(feet2);

        Quantity<LengthUnit> expected =
                new Quantity<>(3.0, LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testAdditionCommutativity() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(
                feet.add(inches),
                inches.add(feet)
        );
    }

    // =========================================================
    // UC7 - TARGET UNIT ADDITION
    // =========================================================

    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {

        Quantity<LengthUnit> result =
                new Quantity<>(1.0, LengthUnit.FEET)
                        .add(
                                new Quantity<>(12.0,
                                        LengthUnit.INCHES),
                                LengthUnit.FEET
                        );

        assertEquals(
                new Quantity<>(2.0,
                        LengthUnit.FEET),
                result
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {

        Quantity<LengthUnit> result =
                new Quantity<>(1.0, LengthUnit.FEET)
                        .add(
                                new Quantity<>(12.0,
                                        LengthUnit.INCHES),
                                LengthUnit.INCHES
                        );

        assertEquals(
                new Quantity<>(24.0,
                        LengthUnit.INCHES),
                result
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {

        Quantity<LengthUnit> result =
                new Quantity<>(1.0, LengthUnit.FEET)
                        .add(
                                new Quantity<>(12.0,
                                        LengthUnit.INCHES),
                                LengthUnit.YARDS
                        );

        assertEquals(
                0.666,
                result.getValue(),
                0.01
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {

        Quantity<LengthUnit> result =
                new Quantity<>(1.0, LengthUnit.INCHES)
                        .add(
                                new Quantity<>(1.0,
                                        LengthUnit.INCHES),
                                LengthUnit.CENTIMETERS
                        );

        assertEquals(
                5.08,
                result.getValue(),
                0.01
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {

        Quantity<LengthUnit> result =
                new Quantity<>(2.0, LengthUnit.YARDS)
                        .add(
                                new Quantity<>(3.0,
                                        LengthUnit.FEET),
                                LengthUnit.YARDS
                        );

        assertEquals(3.0,
                result.getValue(),
                0.01);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {

        Quantity<LengthUnit> result =
                new Quantity<>(2.0, LengthUnit.YARDS)
                        .add(
                                new Quantity<>(3.0,
                                        LengthUnit.FEET),
                                LengthUnit.FEET
                        );

        assertEquals(9.0,
                result.getValue(),
                0.01);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity() {

        Quantity<LengthUnit> result1 =
                new Quantity<>(1.0, LengthUnit.FEET)
                        .add(
                                new Quantity<>(12.0,
                                        LengthUnit.INCHES),
                                LengthUnit.YARDS
                        );

        Quantity<LengthUnit> result2 =
                new Quantity<>(12.0, LengthUnit.INCHES)
                        .add(
                                new Quantity<>(1.0,
                                        LengthUnit.FEET),
                                LengthUnit.YARDS
                        );

        assertEquals(
                result1.getValue(),
                result2.getValue(),
                0.01
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_WithZero() {

        Quantity<LengthUnit> result =
                new Quantity<>(5.0, LengthUnit.FEET)
                        .add(
                                new Quantity<>(0.0,
                                        LengthUnit.INCHES),
                                LengthUnit.YARDS
                        );

        assertEquals(1.666,
                result.getValue(),
                0.01);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues() {

        Quantity<LengthUnit> result =
                new Quantity<>(5.0, LengthUnit.FEET)
                        .add(
                                new Quantity<>(-2.0,
                                        LengthUnit.FEET),
                                LengthUnit.INCHES
                        );

        assertEquals(36.0,
                result.getValue(),
                0.01);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_LargeToSmallScale() {

        Quantity<LengthUnit> result =
                new Quantity<>(1000.0, LengthUnit.FEET)
                        .add(
                                new Quantity<>(500.0,
                                        LengthUnit.FEET),
                                LengthUnit.INCHES
                        );

        assertEquals(18000.0,
                result.getValue(),
                0.01);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SmallToLargeScale() {

        Quantity<LengthUnit> result =
                new Quantity<>(12.0, LengthUnit.INCHES)
                        .add(
                                new Quantity<>(12.0,
                                        LengthUnit.INCHES),
                                LengthUnit.YARDS
                        );

        assertEquals(0.666,
                result.getValue(),
                0.01);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_PrecisionTolerance() {

        Quantity<LengthUnit> result =
                new Quantity<>(2.54,
                        LengthUnit.CENTIMETERS)
                        .add(
                                new Quantity<>(1.0,
                                        LengthUnit.INCHES),
                                LengthUnit.INCHES
                        );

        assertEquals(2.0,
                result.getValue(),
                0.01);
    }

    // =========================================================
    // UC8 - REFACTOR TESTS
    // =========================================================

    @Test
    public void testSameReferenceComparison() {

        Quantity<LengthUnit> length =
                new Quantity<>(5.0, LengthUnit.FEET);

        assertEquals(length, length);
    }

    @Test
    public void testNullComparison() {

        Quantity<LengthUnit> length =
                new Quantity<>(5.0, LengthUnit.FEET);

        assertNotEquals(length, null);
    }

    @Test
    public void testDifferentClassComparison() {

        Quantity<LengthUnit> length =
                new Quantity<>(5.0, LengthUnit.FEET);

        String str = "Length";

        assertNotEquals(length, str);
    }

    @Test
    public void testMultiUnitEquality() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> centimeters =
                new Quantity<>(30.48,
                        LengthUnit.CENTIMETERS);

        assertEquals(feet, inches);
        assertEquals(inches, centimeters);
        assertEquals(feet, centimeters);
    }

    // =========================================================
    // UC9 - WEIGHT TESTS
    // =========================================================

    @Test
    public void testWeightEquality() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        assertEquals(kilogram, gram);
    }

    @Test
    public void testWeightAddition() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                kilogram.add(
                        gram,
                        WeightUnit.KILOGRAM
                );

        assertEquals(
                2.0,
                result.getValue(),
                0.01
        );
    }

    @Test
    public void testWeightConversion() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        double pounds =
                kilogram.convertTo(
                        WeightUnit.POUND
                );

        assertEquals(
                2.20462,
                pounds,
                0.01
        );
    }

    @Test
    public void testHashCodeConsistency() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        assertEquals(
                kilogram.hashCode(),
                gram.hashCode()
        );
    }

    @Test
    public void testHashSetBehavior() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        HashSet<Quantity<WeightUnit>> set =
                new HashSet<>();

        set.add(kilogram);

        set.add(gram);

        assertEquals(1, set.size());
    }

    // =========================================================
    // UC10 - GENERICS TESTS
    // =========================================================

    @Test
    public void testGenericLengthQuantity() {

        Quantity<LengthUnit> quantity =
                new Quantity<>(5.0,
                        LengthUnit.FEET);

        assertEquals(
                LengthUnit.FEET,
                quantity.getUnit()
        );
    }

    @Test
    public void testGenericWeightQuantity() {

        Quantity<WeightUnit> quantity =
                new Quantity<>(5.0,
                        WeightUnit.KILOGRAM);

        assertEquals(
                WeightUnit.KILOGRAM,
                quantity.getUnit()
        );
    }

    @Test
    public void testGenericAddition() {

        Quantity<WeightUnit> q1 =
                new Quantity<>(2.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 =
                new Quantity<>(500.0,
                        WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                q1.add(
                        q2,
                        WeightUnit.KILOGRAM
                );

        assertEquals(
                2.5,
                result.getValue(),
                0.01
        );
    }
    @Test
public void volumeLitreEqualsMilliliters() {

    Quantity<VolumeUnit> litre =
            new Quantity<>(1.0, VolumeUnit.LITRE);

    Quantity<VolumeUnit> ml =
            new Quantity<>(1000.0,
                    VolumeUnit.MILLILITRE);

    assertTrue(
            QuantityMeasurementApp
                    .demonstrateEquality(litre, ml)
    );
}
@Test
public void convertVolumeLitersToMilliliters() {

    Quantity<VolumeUnit> litre =
            new Quantity<>(1.0, VolumeUnit.LITRE);

    Quantity<VolumeUnit> converted =
            QuantityMeasurementApp
                    .demonstrateConversion(
                            litre,
                            VolumeUnit.MILLILITRE
                    );

    assertEquals(
            1000.0,
            converted.getValue()
    );
}
@Test
public void addVolumeLitersAndMilliliters() {

    Quantity<VolumeUnit> litre =
            new Quantity<>(1.0, VolumeUnit.LITRE);

    Quantity<VolumeUnit> ml =
            new Quantity<>(1000.0,
                    VolumeUnit.MILLILITRE);

    Quantity<VolumeUnit> result =
            QuantityMeasurementApp
                    .demonstrateAddition(
                            litre,
                            ml
                    );

    assertEquals(
            2.0,
            result.getValue()
    );
}
@Test
public void convertVolumeGallonsToLitres() {

    Quantity<VolumeUnit> gallon =
            new Quantity<>(1.0,
                    VolumeUnit.GALLON);

    Quantity<VolumeUnit> converted =
            QuantityMeasurementApp
                    .demonstrateConversion(
                            gallon,
                            VolumeUnit.LITRE
                    );

    assertEquals(
            3.78541,
            converted.getValue(),
            0.01
    );
}
}