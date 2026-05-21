package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // =====================================================
    // UC1 - FEET EQUALITY
    // =====================================================

    @Test
    public void testFeetEquality_SameValue() {

        Length length1 =
                new Length(1.0,
                        LengthUnit.FEET);

        Length length2 =
                new Length(1.0,
                        LengthUnit.FEET);

        assertEquals(length1, length2);
    }

    @Test
    public void testFeetInequality_DifferentValue() {

        Length length1 =
                new Length(1.0,
                        LengthUnit.FEET);

        Length length2 =
                new Length(2.0,
                        LengthUnit.FEET);

        assertNotEquals(length1, length2);
    }

    @Test
    public void testFeetEquality_SameReference() {

        Length length =
                new Length(1.0,
                        LengthUnit.FEET);

        assertEquals(length, length);
    }

    @Test
    public void testFeetEquality_NullComparison() {

        Length length =
                new Length(1.0,
                        LengthUnit.FEET);

        assertNotEquals(length, null);
    }

    @Test
    public void testFeetEquality_DifferentClass() {

        Length length =
                new Length(1.0,
                        LengthUnit.FEET);

        assertNotEquals(length, "Length");
    }

    // =====================================================
    // UC2 - INCH EQUALITY
    // =====================================================

    @Test
    public void testInchesEquality_SameValue() {

        Length length1 =
                new Length(12.0,
                        LengthUnit.INCHES);

        Length length2 =
                new Length(12.0,
                        LengthUnit.INCHES);

        assertEquals(length1, length2);
    }

    @Test
    public void testInchesInequality_DifferentValue() {

        Length length1 =
                new Length(12.0,
                        LengthUnit.INCHES);

        Length length2 =
                new Length(24.0,
                        LengthUnit.INCHES);

        assertNotEquals(length1, length2);
    }

    @Test
    public void testFeetEqualsTwelveInches() {

        Length feet =
                new Length(1.0,
                        LengthUnit.FEET);

        Length inches =
                new Length(12.0,
                        LengthUnit.INCHES);

        assertEquals(feet, inches);
    }

    @Test
    public void testTwelveInchesEqualsOneFoot() {

        Length inches =
                new Length(12.0,
                        LengthUnit.INCHES);

        Length feet =
                new Length(1.0,
                        LengthUnit.FEET);

        assertEquals(inches, feet);
    }

    // =====================================================
    // UC3 - GENERIC EQUALITY
    // =====================================================

    @Test
    public void testNullComparison() {

        Length length =
                new Length(1.0,
                        LengthUnit.FEET);

        assertFalse(length.equals(null));
    }

    @Test
    public void testSameReferenceComparison() {

        Length length =
                new Length(1.0,
                        LengthUnit.FEET);

        assertTrue(length.equals(length));
    }

    @Test
    public void testDifferentClassComparison() {

        Length length =
                new Length(1.0,
                        LengthUnit.FEET);

        assertFalse(length.equals("test"));
    }

    // =====================================================
    // UC4 - MULTI UNIT SUPPORT
    // =====================================================

    @Test
    public void testOneYardEqualsThreeFeet() {

        Length yard =
                new Length(1.0,
                        LengthUnit.YARDS);

        Length feet =
                new Length(3.0,
                        LengthUnit.FEET);

        assertEquals(yard, feet);
    }

    @Test
    public void testThreeFeetEqualsOneYard() {

        Length feet =
                new Length(3.0,
                        LengthUnit.FEET);

        Length yard =
                new Length(1.0,
                        LengthUnit.YARDS);

        assertEquals(feet, yard);
    }

    @Test
    public void testOneYardEqualsThirtySixInches() {

        Length yard =
                new Length(1.0,
                        LengthUnit.YARDS);

        Length inches =
                new Length(36.0,
                        LengthUnit.INCHES);

        assertEquals(yard, inches);
    }

    @Test
    public void testThirtySixInchesEqualsOneYard() {

        Length inches =
                new Length(36.0,
                        LengthUnit.INCHES);

        Length yard =
                new Length(1.0,
                        LengthUnit.YARDS);

        assertEquals(inches, yard);
    }

    @Test
    public void testThirtyPointFortyEightCentimetersEqualsOneFoot() {

        Length centimeters =
                new Length(30.48,
                        LengthUnit.CENTIMETERS);

        Length foot =
                new Length(1.0,
                        LengthUnit.FEET);

        assertEquals(centimeters, foot);
    }

    @Test
    public void testOneCentimeterEqualsPoint393701Inches() {

        Length centimeters =
                new Length(1.0,
                        LengthUnit.CENTIMETERS);

        Length inches =
                new Length(0.393701,
                        LengthUnit.INCHES);

        assertEquals(centimeters, inches);
    }

    @Test
    public void testMultiUnitEquality() {

        Length feet =
                new Length(1.0,
                        LengthUnit.FEET);

        Length inches =
                new Length(12.0,
                        LengthUnit.INCHES);

        Length centimeters =
                new Length(30.48,
                        LengthUnit.CENTIMETERS);

        assertEquals(feet, inches);
        assertEquals(inches, centimeters);
        assertEquals(feet, centimeters);
    }

    // =====================================================
    // UC5 - CONVERSION
    // =====================================================

    @Test
    public void testConvertFeetToInches() {

        Length result =
                new Length(1.0,
                        LengthUnit.FEET)
                        .convertTo(LengthUnit.INCHES);

        Length expected =
                new Length(12.0,
                        LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertInchesToFeet() {

        Length result =
                new Length(24.0,
                        LengthUnit.INCHES)
                        .convertTo(LengthUnit.FEET);

        Length expected =
                new Length(2.0,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertYardsToFeet() {

        Length result =
                new Length(2.0,
                        LengthUnit.YARDS)
                        .convertTo(LengthUnit.FEET);

        Length expected =
                new Length(6.0,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertCentimetersToInches() {

        Length result =
                new Length(2.54,
                        LengthUnit.CENTIMETERS)
                        .convertTo(LengthUnit.INCHES);

        Length expected =
                new Length(1.0,
                        LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    @Test
    public void testSameUnitConversion() {

        Length result =
                new Length(5.0,
                        LengthUnit.FEET)
                        .convertTo(LengthUnit.FEET);

        Length expected =
                new Length(5.0,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testZeroValueConversion() {

        Length result =
                new Length(0.0,
                        LengthUnit.FEET)
                        .convertTo(LengthUnit.INCHES);

        Length expected =
                new Length(0.0,
                        LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    @Test
    public void testNegativeValueConversion() {

        Length result =
                new Length(-1.0,
                        LengthUnit.FEET)
                        .convertTo(LengthUnit.INCHES);

        Length expected =
                new Length(-12.0,
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
                () -> new Length(1.0, null));
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
    // UC6 - ADDITION
    // =====================================================

    @Test
    public void testAddFeetAndInches() {

        Length result =
                new Length(1.0,
                        LengthUnit.FEET)
                        .add(new Length(
                                12.0,
                                LengthUnit.INCHES));

        Length expected =
                new Length(2.0,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testAddInchesAndFeet() {

        Length result =
                new Length(12.0,
                        LengthUnit.INCHES)
                        .add(new Length(
                                1.0,
                                LengthUnit.FEET));

        Length expected =
                new Length(24.0,
                        LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    @Test
    public void testAddYardsAndFeet() {

        Length result =
                new Length(1.0,
                        LengthUnit.YARDS)
                        .add(new Length(
                                3.0,
                                LengthUnit.FEET));

        Length expected =
                new Length(2.0,
                        LengthUnit.YARDS);

        assertEquals(expected, result);
    }

    @Test
    public void testAdditionCommutativity() {

        Length result1 =
                new Length(1.0,
                        LengthUnit.FEET)
                        .add(new Length(
                                12.0,
                                LengthUnit.INCHES));

        Length result2 =
                new Length(12.0,
                        LengthUnit.INCHES)
                        .add(new Length(
                                1.0,
                                LengthUnit.FEET));

        assertEquals(
                result1.convertTo(LengthUnit.FEET),
                result2.convertTo(LengthUnit.FEET));
    }

    @Test
    public void testAdditionWithZero() {

        Length result =
                new Length(5.0,
                        LengthUnit.FEET)
                        .add(new Length(
                                0.0,
                                LengthUnit.INCHES));

        Length expected =
                new Length(5.0,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testAdditionWithNegativeValues() {

        Length result =
                new Length(5.0,
                        LengthUnit.FEET)
                        .add(new Length(
                                -2.0,
                                LengthUnit.FEET));

        Length expected =
                new Length(3.0,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    // =====================================================
    // UC7 - EXPLICIT TARGET UNIT
    // =====================================================

    @Test
    public void testAddition_TargetUnit_Feet() {

        Length result =
                new Length(1.0,
                        LengthUnit.FEET)
                        .add(
                                new Length(
                                        12.0,
                                        LengthUnit.INCHES),
                                LengthUnit.FEET);

        Length expected =
                new Length(2.0,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    @Test
    public void testAddition_TargetUnit_Inches() {

        Length result =
                new Length(1.0,
                        LengthUnit.FEET)
                        .add(
                                new Length(
                                        12.0,
                                        LengthUnit.INCHES),
                                LengthUnit.INCHES);

        Length expected =
                new Length(24.0,
                        LengthUnit.INCHES);

        assertEquals(expected, result);
    }

    // =====================================================
    // UC9 - WEIGHT EQUALITY
    // =====================================================

    @Test
    public void testEquality_KilogramToKilogram_SameValue() {

        Weight w1 =
                new Weight(1.0,
                        WeightUnit.KILOGRAM);

        Weight w2 =
                new Weight(1.0,
                        WeightUnit.KILOGRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_KilogramToKilogram_DifferentValue() {

        Weight w1 =
                new Weight(1.0,
                        WeightUnit.KILOGRAM);

        Weight w2 =
                new Weight(2.0,
                        WeightUnit.KILOGRAM);

        assertNotEquals(w1, w2);
    }

    @Test
    public void testEquality_KilogramToGram_EquivalentValue() {

        Weight kilogram =
                new Weight(1.0,
                        WeightUnit.KILOGRAM);

        Weight gram =
                new Weight(1000.0,
                        WeightUnit.GRAM);

        assertEquals(kilogram, gram);
    }

    @Test
    public void testEquality_GramToKilogram_EquivalentValue() {

        Weight gram =
                new Weight(1000.0,
                        WeightUnit.GRAM);

        Weight kilogram =
                new Weight(1.0,
                        WeightUnit.KILOGRAM);

        assertEquals(gram, kilogram);
    }

    @Test
    public void testEquality_KilogramToPound_EquivalentValue() {

        Weight kilogram =
                new Weight(1.0,
                        WeightUnit.KILOGRAM);

        Weight pound =
                new Weight(2.20462,
                        WeightUnit.POUND);

        assertEquals(kilogram, pound);
    }

    @Test
    public void testEquality_GramToPound_EquivalentValue() {

        Weight gram =
                new Weight(453.592,
                        WeightUnit.GRAM);

        Weight pound =
                new Weight(1.0,
                        WeightUnit.POUND);

        assertEquals(gram, pound);
    }

    @Test
    public void testEquality_WeightVsLength_Incompatible() {

        Weight weight =
                new Weight(1.0,
                        WeightUnit.KILOGRAM);

        Length length =
                new Length(1.0,
                        LengthUnit.FEET);

        assertNotEquals(weight, length);
    }

    @Test
    public void testEquality_NullComparison() {

        Weight weight =
                new Weight(1.0,
                        WeightUnit.KILOGRAM);

        assertNotEquals(weight, null);
    }

    @Test
    public void testEquality_SameReference() {

        Weight weight =
                new Weight(1.0,
                        WeightUnit.KILOGRAM);

        assertEquals(weight, weight);
    }

    @Test
    public void testEquality_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Weight(
                        1.0,
                        null));
    }

    @Test
    public void testEquality_TransitiveProperty() {

        Weight kilogram =
                new Weight(1.0,
                        WeightUnit.KILOGRAM);

        Weight gram =
                new Weight(1000.0,
                        WeightUnit.GRAM);

        Weight pound =
                new Weight(2.20462,
                        WeightUnit.POUND);

        assertEquals(kilogram, gram);
        assertEquals(gram, pound);
        assertEquals(kilogram, pound);
    }

    @Test
    public void testEquality_ZeroValue() {

        Weight kilogram =
                new Weight(0.0,
                        WeightUnit.KILOGRAM);

        Weight gram =
                new Weight(0.0,
                        WeightUnit.GRAM);

        assertEquals(kilogram, gram);
    }

    @Test
    public void testEquality_NegativeWeight() {

        Weight kilogram =
                new Weight(-1.0,
                        WeightUnit.KILOGRAM);

        Weight gram =
                new Weight(-1000.0,
                        WeightUnit.GRAM);

        assertEquals(kilogram, gram);
    }

    @Test
    public void testEquality_LargeWeightValue() {

        Weight gram =
                new Weight(1000000.0,
                        WeightUnit.GRAM);

        Weight kilogram =
                new Weight(1000.0,
                        WeightUnit.KILOGRAM);

        assertEquals(gram, kilogram);
    }

    @Test
    public void testEquality_SmallWeightValue() {

        Weight kilogram =
                new Weight(0.001,
                        WeightUnit.KILOGRAM);

        Weight gram =
                new Weight(1.0,
                        WeightUnit.GRAM);

        assertEquals(kilogram, gram);
    }

    // =====================================================
    // UC9 - WEIGHT CONVERSION
    // =====================================================

    @Test
    public void testConversion_PoundToKilogram() {

        Weight result =
                new Weight(2.20462,
                        WeightUnit.POUND)
                        .convertTo(
                                WeightUnit.KILOGRAM);

        Weight expected =
                new Weight(1.0,
                        WeightUnit.KILOGRAM);

        assertEquals(expected, result);
    }

    @Test
    public void testConversion_KilogramToPound() {

        Weight result =
                new Weight(1.0,
                        WeightUnit.KILOGRAM)
                        .convertTo(
                                WeightUnit.POUND);

        Weight expected =
                new Weight(2.20462,
                        WeightUnit.POUND);

        assertEquals(expected, result);
    }

    @Test
    public void testConversion_SameUnit() {

        Weight result =
                new Weight(5.0,
                        WeightUnit.KILOGRAM)
                        .convertTo(
                                WeightUnit.KILOGRAM);

        Weight expected =
                new Weight(5.0,
                        WeightUnit.KILOGRAM);

        assertEquals(expected, result);
    }

    @Test
    public void testConversion_ZeroValue() {

        Weight result =
                new Weight(0.0,
                        WeightUnit.KILOGRAM)
                        .convertTo(
                                WeightUnit.GRAM);

        Weight expected =
                new Weight(0.0,
                        WeightUnit.GRAM);

        assertEquals(expected, result);
    }

    @Test
    public void testConversion_NegativeValue() {

        Weight result =
                new Weight(-1.0,
                        WeightUnit.KILOGRAM)
                        .convertTo(
                                WeightUnit.GRAM);

        Weight expected =
                new Weight(-1000.0,
                        WeightUnit.GRAM);

        assertEquals(expected, result);
    }

    @Test
    public void testConversion_RoundTrip() {

        Weight result =
                new Weight(1.5,
                        WeightUnit.KILOGRAM)
                        .convertTo(
                                WeightUnit.GRAM)
                        .convertTo(
                                WeightUnit.KILOGRAM);

        Weight expected =
                new Weight(1.5,
                        WeightUnit.KILOGRAM);

        assertEquals(expected, result);
    }

    // =====================================================
    // UC9 - WEIGHT ADDITION
    // =====================================================

    @Test
    public void testAddition_SameUnit_KilogramPlusKilogram() {

        Weight result =
                new Weight(1.0,
                        WeightUnit.KILOGRAM)
                        .add(new Weight(
                                2.0,
                                WeightUnit.KILOGRAM));

        Weight expected =
                new Weight(3.0,
                        WeightUnit.KILOGRAM);

        assertEquals(expected, result);
    }

    @Test
    public void testAddition_CrossUnit_KilogramPlusGram() {

        Weight result =
                new Weight(1.0,
                        WeightUnit.KILOGRAM)
                        .add(new Weight(
                                1000.0,
                                WeightUnit.GRAM));

        Weight expected =
                new Weight(2.0,
                        WeightUnit.KILOGRAM);

        assertEquals(expected, result);
    }

    @Test
    public void testAddition_CrossUnit_PoundPlusKilogram() {

        Weight result =
                new Weight(2.20462,
                        WeightUnit.POUND)
                        .add(new Weight(
                                1.0,
                                WeightUnit.KILOGRAM));

        Weight expected =
                new Weight(4.40924,
                        WeightUnit.POUND);

        assertEquals(expected, result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Kilogram() {

        Weight result =
                new Weight(1.0,
                        WeightUnit.KILOGRAM)
                        .add(
                                new Weight(
                                        1000.0,
                                        WeightUnit.GRAM),
                                WeightUnit.GRAM);

        Weight expected =
                new Weight(2000.0,
                        WeightUnit.GRAM);

        assertEquals(expected, result);
    }

    @Test
    public void testAddition_Commutativity() {

        Weight result1 =
                new Weight(1.0,
                        WeightUnit.KILOGRAM)
                        .add(new Weight(
                                1000.0,
                                WeightUnit.GRAM));

        Weight result2 =
                new Weight(1000.0,
                        WeightUnit.GRAM)
                        .add(new Weight(
                                1.0,
                                WeightUnit.KILOGRAM));

        assertEquals(
                result1.convertTo(
                        WeightUnit.KILOGRAM),

                result2.convertTo(
                        WeightUnit.KILOGRAM));
    }

    @Test
    public void testAddition_WithZero() {

        Weight result =
                new Weight(5.0,
                        WeightUnit.KILOGRAM)
                        .add(new Weight(
                                0.0,
                                WeightUnit.GRAM));

        Weight expected =
                new Weight(5.0,
                        WeightUnit.KILOGRAM);

        assertEquals(expected, result);
    }

    @Test
    public void testAddition_NegativeValues() {

        Weight result =
                new Weight(5.0,
                        WeightUnit.KILOGRAM)
                        .add(new Weight(
                                -2000.0,
                                WeightUnit.GRAM));

        Weight expected =
                new Weight(3.0,
                        WeightUnit.KILOGRAM);

        assertEquals(expected, result);
    }

    @Test
    public void testAddition_LargeValues() {

        Weight result =
                new Weight(1e6,
                        WeightUnit.KILOGRAM)
                        .add(new Weight(
                                1e6,
                                WeightUnit.KILOGRAM));

        Weight expected =
                new Weight(2e6,
                        WeightUnit.KILOGRAM);

        assertEquals(expected, result);
    }

    // =====================================================
    // UC9 - HASHCODE TESTS
    // =====================================================

    @Test
    public void testHashCode_EqualObjects() {

        Weight w1 =
                new Weight(1.0,
                        WeightUnit.KILOGRAM);

        Weight w2 =
                new Weight(1000.0,
                        WeightUnit.GRAM);

        assertEquals(
                w1.hashCode(),
                w2.hashCode());
    }

    @Test
    public void testHashCode_SameObject() {

        Weight w =
                new Weight(1.0,
                        WeightUnit.KILOGRAM);

        assertEquals(
                w.hashCode(),
                w.hashCode());
    }

    @Test
    public void testHashSetBehavior() {

        HashSet<Weight> set =
                new HashSet<>();

        set.add(new Weight(
                1.0,
                WeightUnit.KILOGRAM));

        set.add(new Weight(
                1000.0,
                WeightUnit.GRAM));

        assertEquals(1, set.size());
    }

    @Test
    public void testHashCode_UnequalObjects() {

        Weight w1 =
                new Weight(1.0,
                        WeightUnit.KILOGRAM);

        Weight w2 =
                new Weight(2.0,
                        WeightUnit.KILOGRAM);

        assertNotEquals(
                w1.hashCode(),
                w2.hashCode());
    }
}
