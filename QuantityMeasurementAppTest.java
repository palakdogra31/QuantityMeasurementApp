package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // =====================================================
    // UC1 - FEET EQUALITY TESTS
    // =====================================================

    @Test
    public void testFeetEquality_SameValue() {

        Length l1 =
                new Length(
                        1.0,
                        LengthUnit.FEET);

        Length l2 =
                new Length(
                        1.0,
                        LengthUnit.FEET);

        assertEquals(l1, l2);
    }

    @Test
    public void testFeetInequality_DifferentValue() {

        Length l1 =
                new Length(
                        1.0,
                        LengthUnit.FEET);

        Length l2 =
                new Length(
                        2.0,
                        LengthUnit.FEET);

        assertNotEquals(l1, l2);
    }

    @Test
    public void testFeetEquality_SameReference() {

        Length l1 =
                new Length(
                        1.0,
                        LengthUnit.FEET);

        assertEquals(l1, l1);
    }

    @Test
    public void testFeetEquality_NullComparison() {

        Length l1 =
                new Length(
                        1.0,
                        LengthUnit.FEET);

        assertNotEquals(null, l1);
    }

    @Test
    public void testFeetEquality_DifferentClass() {

        Length l1 =
                new Length(
                        1.0,
                        LengthUnit.FEET);

        assertFalse(l1.equals("test"));
    }

    // =====================================================
    // UC2 - INCHES TESTS
    // =====================================================

    @Test
    public void testInchesEquality_SameValue() {

        Length l1 =
                new Length(
                        1.0,
                        LengthUnit.INCHES);

        Length l2 =
                new Length(
                        1.0,
                        LengthUnit.INCHES);

        assertEquals(l1, l2);
    }

    @Test
    public void testInchesInequality_DifferentValue() {

        Length l1 =
                new Length(
                        1.0,
                        LengthUnit.INCHES);

        Length l2 =
                new Length(
                        2.0,
                        LengthUnit.INCHES);

        assertNotEquals(l1, l2);
    }

    @Test
    public void testFeetEqualsTwelveInches() {

        Length l1 =
                new Length(
                        1.0,
                        LengthUnit.FEET);

        Length l2 =
                new Length(
                        12.0,
                        LengthUnit.INCHES);

        assertEquals(l1, l2);
    }

    @Test
    public void testTwelveInchesEqualsOneFoot() {

        Length l1 =
                new Length(
                        12.0,
                        LengthUnit.INCHES);

        Length l2 =
                new Length(
                        1.0,
                        LengthUnit.FEET);

        assertEquals(l1, l2);
    }

    // =====================================================
    // UC3 - GENERIC LENGTH TESTS
    // =====================================================

    @Test
    public void testNullComparison() {

        Length l1 =
                new Length(
                        1.0,
                        LengthUnit.FEET);

        assertFalse(l1.equals(null));
    }

    @Test
    public void testSameReferenceComparison() {

        Length l1 =
                new Length(
                        1.0,
                        LengthUnit.FEET);

        assertTrue(l1.equals(l1));
    }

    @Test
    public void testDifferentClassComparison() {

        Length l1 =
                new Length(
                        1.0,
                        LengthUnit.FEET);

        assertFalse(l1.equals("Length"));
    }

    // =====================================================
    // UC4 - YARDS & CENTIMETERS TESTS
    // =====================================================

    @Test
    public void testOneYardEqualsThreeFeet() {

        Length l1 =
                new Length(
                        1.0,
                        LengthUnit.YARDS);

        Length l2 =
                new Length(
                        3.0,
                        LengthUnit.FEET);

        assertEquals(l1, l2);
    }

    @Test
    public void testThreeFeetEqualsOneYard() {

        Length l1 =
                new Length(
                        3.0,
                        LengthUnit.FEET);

        Length l2 =
                new Length(
                        1.0,
                        LengthUnit.YARDS);

        assertEquals(l1, l2);
    }

    @Test
    public void testOneYardEqualsThirtySixInches() {

        Length l1 =
                new Length(
                        1.0,
                        LengthUnit.YARDS);

        Length l2 =
                new Length(
                        36.0,
                        LengthUnit.INCHES);

        assertEquals(l1, l2);
    }

    @Test
    public void testThirtySixInchesEqualsOneYard() {

        Length l1 =
                new Length(
                        36.0,
                        LengthUnit.INCHES);

        Length l2 =
                new Length(
                        1.0,
                        LengthUnit.YARDS);

        assertEquals(l1, l2);
    }

    @Test
    public void testOneCentimeterEqualsPoint393701Inches() {

        Length l1 =
                new Length(
                        1.0,
                        LengthUnit.CENTIMETERS);

        Length l2 =
                new Length(
                        0.393701,
                        LengthUnit.INCHES);

        assertEquals(l1, l2);
    }

    @Test
    public void testThirtyPointFortyEightCentimetersEqualsOneFoot() {

        Length l1 =
                new Length(
                        30.48,
                        LengthUnit.CENTIMETERS);

        Length l2 =
                new Length(
                        1.0,
                        LengthUnit.FEET);

        assertEquals(l1, l2);
    }

    @Test
    public void testMultiUnitEquality() {

        Length yard =
                new Length(
                        2.0,
                        LengthUnit.YARDS);

        Length feet =
                new Length(
                        6.0,
                        LengthUnit.FEET);

        Length inches =
                new Length(
                        72.0,
                        LengthUnit.INCHES);

        assertEquals(yard, feet);

        assertEquals(feet, inches);

        assertEquals(yard, inches);
    }

    // =====================================================
    // UC5 - CONVERSION TESTS
    // =====================================================

    @Test
    public void testConvertFeetToInches() {

        Length result =
                new Length(
                        1.0,
                        LengthUnit.FEET)

                        .convertTo(
                                LengthUnit.INCHES);

        Length expected =
                new Length(
                        12.0,
                        LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertInchesToFeet() {

        Length result =
                new Length(
                        24.0,
                        LengthUnit.INCHES)

                        .convertTo(
                                LengthUnit.FEET);

        Length expected =
                new Length(
                        2.0,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertYardsToFeet() {

        Length result =
                new Length(
                        1.0,
                        LengthUnit.YARDS)

                        .convertTo(
                                LengthUnit.FEET);

        Length expected =
                new Length(
                        3.0,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertCentimetersToInches() {

        Length result =
                new Length(
                        2.54,
                        LengthUnit.CENTIMETERS)

                        .convertTo(
                                LengthUnit.INCHES);

        Length expected =
                new Length(
                        1.0,
                        LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    @Test
    public void testSameUnitConversion() {

        Length result =
                new Length(
                        5.0,
                        LengthUnit.FEET)

                        .convertTo(
                                LengthUnit.FEET);

        Length expected =
                new Length(
                        5.0,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testZeroValueConversion() {

        Length result =
                new Length(
                        0.0,
                        LengthUnit.FEET)

                        .convertTo(
                                LengthUnit.INCHES);

        Length expected =
                new Length(
                        0.0,
                        LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    @Test
    public void testNegativeValueConversion() {

        Length result =
                new Length(
                        -1.0,
                        LengthUnit.FEET)

                        .convertTo(
                                LengthUnit.INCHES);

        Length expected =
                new Length(
                        -12.0,
                        LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    // =====================================================
    // UC5 - EXCEPTION TESTS
    // =====================================================

    @Test
    public void testNullUnitException() {

        assertThrows(
                IllegalArgumentException.class,

                () -> new Length(
                        1.0,
                        null));
    }

    @Test
    public void testNaNValueException() {

        assertThrows(
                IllegalArgumentException.class,

                () -> new Length(
                        Double.NaN,
                        LengthUnit.FEET));
    }

    @Test
    public void testInfiniteValueException() {

        assertThrows(
                IllegalArgumentException.class,

                () -> new Length(
                        Double.POSITIVE_INFINITY,
                        LengthUnit.FEET));
    }

    // =====================================================
    // UC6 - ADDITION TESTS
    // =====================================================

    @Test
    public void testAddFeetAndInches() {

        Length result =
                new Length(
                        1.0,
                        LengthUnit.FEET)

                        .add(

                                new Length(
                                        12.0,
                                        LengthUnit.INCHES));

        Length expected =
                new Length(
                        2.0,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testAddInchesAndFeet() {

        Length result =
                new Length(
                        12.0,
                        LengthUnit.INCHES)

                        .add(

                                new Length(
                                        1.0,
                                        LengthUnit.FEET));

        Length expected =
                new Length(
                        24.0,
                        LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    @Test
    public void testAddYardsAndFeet() {

        Length result =
                new Length(
                        1.0,
                        LengthUnit.YARDS)

                        .add(

                                new Length(
                                        3.0,
                                        LengthUnit.FEET));

        Length expected =
                new Length(
                        2.0,
                        LengthUnit.YARDS);

        assertEquals(expected, result);
    }

    @Test
    public void testAdditionCommutativity() {

        Length result1 =
                new Length(
                        1.0,
                        LengthUnit.FEET)

                        .add(

                                new Length(
                                        12.0,
                                        LengthUnit.INCHES));

        Length result2 =
                new Length(
                        12.0,
                        LengthUnit.INCHES)

                        .add(

                                new Length(
                                        1.0,
                                        LengthUnit.FEET));

        assertEquals(result1, result2);
    }

    @Test
    public void testAdditionWithZero() {

        Length result =
                new Length(
                        5.0,
                        LengthUnit.FEET)

                        .add(

                                new Length(
                                        0.0,
                                        LengthUnit.FEET));

        Length expected =
                new Length(
                        5.0,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testAdditionWithNegativeValues() {

        Length result =
                new Length(
                        5.0,
                        LengthUnit.FEET)

                        .add(

                                new Length(
                                        -2.0,
                                        LengthUnit.FEET));

        Length expected =
                new Length(
                        3.0,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    // =====================================================
    // UC7 - TARGET UNIT ADDITION TESTS
    // =====================================================

    @Test
    public void testAddition_TargetUnit_Feet() {

        Length result =
                new Length(
                        1.0,
                        LengthUnit.FEET)

                        .add(

                                new Length(
                                        12.0,
                                        LengthUnit.INCHES),

                                LengthUnit.FEET);

        Length expected =
                new Length(
                        2.0,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testAddition_TargetUnit_Inches() {

        Length result =
                new Length(
                        1.0,
                        LengthUnit.FEET)

                        .add(

                                new Length(
                                        12.0,
                                        LengthUnit.INCHES),

                                LengthUnit.INCHES);

        Length expected =
                new Length(
                        24.0,
                        LengthUnit.INCHES);

        assertEquals(expected, result);
    }
    // =====================================================
// UC7 - EXPLICIT TARGET UNIT ADDITION TESTS
// =====================================================

@Test
public void testAddition_ExplicitTargetUnit_Feet() {

    Length result =
            new Length(
                    1.0,
                    LengthUnit.FEET)

                    .add(

                            new Length(
                                    12.0,
                                    LengthUnit.INCHES),

                            LengthUnit.FEET);

    Length expected =
            new Length(
                    2.0,
                    LengthUnit.FEET);

    assertEquals(expected, result);
}

@Test
public void testAddition_ExplicitTargetUnit_Inches() {

    Length result =
            new Length(
                    1.0,
                    LengthUnit.FEET)

                    .add(

                            new Length(
                                    12.0,
                                    LengthUnit.INCHES),

                            LengthUnit.INCHES);

    Length expected =
            new Length(
                    24.0,
                    LengthUnit.INCHES);

    assertEquals(expected, result);
}

@Test
public void testAddition_ExplicitTargetUnit_Yards() {

    Length result =
            new Length(
                    1.0,
                    LengthUnit.FEET)

                    .add(

                            new Length(
                                    12.0,
                                    LengthUnit.INCHES),

                            LengthUnit.YARDS);

    Length expected =
            new Length(
                    0.67,
                    LengthUnit.YARDS);

    assertEquals(expected, result);
}

@Test
public void testAddition_ExplicitTargetUnit_Centimeters() {

    Length result =
            new Length(
                    1.0,
                    LengthUnit.INCHES)

                    .add(

                            new Length(
                                    1.0,
                                    LengthUnit.INCHES),

                            LengthUnit.CENTIMETERS);

    Length expected =
            new Length(
                    5.08,
                    LengthUnit.CENTIMETERS);

    assertEquals(expected, result);
}

@Test
public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {

    Length result =
            new Length(
                    2.0,
                    LengthUnit.YARDS)

                    .add(

                            new Length(
                                    3.0,
                                    LengthUnit.FEET),

                            LengthUnit.YARDS);

    Length expected =
            new Length(
                    3.0,
                    LengthUnit.YARDS);

    assertEquals(expected, result);
}

@Test
public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {

    Length result =
            new Length(
                    2.0,
                    LengthUnit.YARDS)

                    .add(

                            new Length(
                                    3.0,
                                    LengthUnit.FEET),

                            LengthUnit.FEET);

    Length expected =
            new Length(
                    9.0,
                    LengthUnit.FEET);

    assertEquals(expected, result);
}

@Test
public void testAddition_ExplicitTargetUnit_Commutativity() {

    Length result1 =
            new Length(
                    1.0,
                    LengthUnit.FEET)

                    .add(

                            new Length(
                                    12.0,
                                    LengthUnit.INCHES),

                            LengthUnit.YARDS);

    Length result2 =
            new Length(
                    12.0,
                    LengthUnit.INCHES)

                    .add(

                            new Length(
                                    1.0,
                                    LengthUnit.FEET),

                            LengthUnit.YARDS);

    assertEquals(result1, result2);
}

@Test
public void testAddition_ExplicitTargetUnit_WithZero() {

    Length result =
            new Length(
                    5.0,
                    LengthUnit.FEET)

                    .add(

                            new Length(
                                    0.0,
                                    LengthUnit.INCHES),

                            LengthUnit.YARDS);

    Length expected =
            new Length(
                    1.67,
                    LengthUnit.YARDS);

    assertEquals(expected, result);
}

@Test
public void testAddition_ExplicitTargetUnit_NegativeValues() {

    Length result =
            new Length(
                    5.0,
                    LengthUnit.FEET)

                    .add(

                            new Length(
                                    -2.0,
                                    LengthUnit.FEET),

                            LengthUnit.INCHES);

    Length expected =
            new Length(
                    36.0,
                    LengthUnit.INCHES);

    assertEquals(expected, result);
}

@Test
public void testAddition_ExplicitTargetUnit_NullTargetUnit() {

    assertThrows(

            IllegalArgumentException.class,

            () -> new Length(
                    1.0,
                    LengthUnit.FEET)

                    .add(

                            new Length(
                                    12.0,
                                    LengthUnit.INCHES),

                            null));
}

@Test
public void testAddition_ExplicitTargetUnit_LargeToSmallScale() {

    Length result =
            new Length(
                    1000.0,
                    LengthUnit.FEET)

                    .add(

                            new Length(
                                    500.0,
                                    LengthUnit.FEET),

                            LengthUnit.INCHES);

    Length expected =
            new Length(
                    18000.0,
                    LengthUnit.INCHES);

    assertEquals(expected, result);
}

@Test
public void testAddition_ExplicitTargetUnit_SmallToLargeScale() {

    Length result =
            new Length(
                    12.0,
                    LengthUnit.INCHES)

                    .add(

                            new Length(
                                    12.0,
                                    LengthUnit.INCHES),

                            LengthUnit.YARDS);

    Length expected =
            new Length(
                    0.67,
                    LengthUnit.YARDS);

    assertEquals(expected, result);
}

@Test
public void testAddition_ExplicitTargetUnit_AllUnitCombinations() {

    Length feet =
            new Length(
                    1.0,
                    LengthUnit.FEET);

    Length inches =
            new Length(
                    12.0,
                    LengthUnit.INCHES);

    assertEquals(

            new Length(
                    2.0,
                    LengthUnit.FEET),

            feet.add(
                    inches,
                    LengthUnit.FEET));

    assertEquals(

            new Length(
                    24.0,
                    LengthUnit.INCHES),

            feet.add(
                    inches,
                    LengthUnit.INCHES));

    assertEquals(

            new Length(
                    0.67,
                    LengthUnit.YARDS),

            feet.add(
                    inches,
                    LengthUnit.YARDS));

    assertEquals(

            new Length(
                    60.96,
                    LengthUnit.CENTIMETERS),

            feet.add(
                    inches,
                    LengthUnit.CENTIMETERS));
}

@Test
public void testAddition_ExplicitTargetUnit_PrecisionTolerance() {

    Length result =
            new Length(
                    1.0,
                    LengthUnit.FEET)

                    .add(

                            new Length(
                                    12.0,
                                    LengthUnit.INCHES),

                            LengthUnit.YARDS);

    Length expected =
            new Length(
                    0.67,
                    LengthUnit.YARDS);

    assertEquals(expected, result);
}
}
