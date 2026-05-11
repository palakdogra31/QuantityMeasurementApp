package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // UC1 Tests

    @Test
    public void testFeetEquality() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        Length l2 =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testFeetInequality() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        Length l2 =
                new Length(2.0,
                        Length.LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }

    // UC2 Tests

    @Test
    public void testInchesEquality() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.INCHES);

        Length l2 =
                new Length(1.0,
                        Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testFeetInchesComparison() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        Length l2 =
                new Length(12.0,
                        Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testInchesInequality() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.INCHES);

        Length l2 =
                new Length(2.0,
                        Length.LengthUnit.INCHES);

        assertFalse(l1.equals(l2));
    }

    // UC3 Tests

    @Test
    public void testNullComparison() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        assertFalse(l1.equals(null));
    }

    @Test
    public void testSameReference() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        assertTrue(l1.equals(l1));
    }

    @Test
    public void testDifferentClassComparison() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        assertFalse(l1.equals("test"));
    }

    // UC4 Tests

    @Test
    public void yardEquals36Inches() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        Length l2 =
                new Length(36.0,
                        Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void threeFeetEqualsOneYard() {

        Length l1 =
                new Length(3.0,
                        Length.LengthUnit.FEET);

        Length l2 =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void centimeterEqualsPoint393701Inches() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.CENTIMETERS);

        Length l2 =
                new Length(0.393701,
                        Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void centimeterNotEqualToFeet() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.CENTIMETERS);

        Length l2 =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }

    @Test
    public void multiUnitEquality() {

        Length l1 =
                new Length(2.0,
                        Length.LengthUnit.YARDS);

        Length l2 =
                new Length(6.0,
                        Length.LengthUnit.FEET);

        Length l3 =
                new Length(72.0,
                        Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));

        assertTrue(l2.equals(l3));

        assertTrue(l1.equals(l3));
    }
}