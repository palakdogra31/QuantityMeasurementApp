import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ---------------- UC1 ----------------

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

    // ---------------- UC2 ----------------

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

    // ---------------- UC3 ----------------

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

    // ---------------- UC4 ----------------

    @Test
    public void testEquality_YardToYard_SameValue() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        Length l2 =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        Length l2 =
                new Length(2.0,
                        Length.LengthUnit.YARDS);

        assertFalse(l1.equals(l2));
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        Length l2 =
                new Length(3.0,
                        Length.LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue() {

        Length l1 =
                new Length(3.0,
                        Length.LengthUnit.FEET);

        Length l2 =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        Length l2 =
                new Length(36.0,
                        Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue() {

        Length l1 =
                new Length(36.0,
                        Length.LengthUnit.INCHES);

        Length l2 =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        Length l2 =
                new Length(2.0,
                        Length.LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }

    @Test
    public void testEquality_centimetersToInches_EquivalentValue() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.CENTIMETERS);

        Length l2 =
                new Length(0.393701,
                        Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_centimetersToFeet_NonEquivalentValue() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.CENTIMETERS);

        Length l2 =
                new Length(1.0,
                        Length.LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        Length l2 =
                new Length(3.0,
                        Length.LengthUnit.FEET);

        Length l3 =
                new Length(36.0,
                        Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));

        assertTrue(l2.equals(l3));

        assertTrue(l1.equals(l3));
    }

    @Test
    public void testEquality_YardSameReference() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        assertTrue(l1.equals(l1));
    }

    @Test
    public void testEquality_YardNullComparison() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.YARDS);

        assertFalse(l1.equals(null));
    }

    @Test
    public void testEquality_CentimetersSameReference() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.CENTIMETERS);

        assertTrue(l1.equals(l1));
    }

    @Test
    public void testEquality_CentimetersNullComparison() {

        Length l1 =
                new Length(1.0,
                        Length.LengthUnit.CENTIMETERS);

        assertFalse(l1.equals(null));
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {

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

    // ---------------- NULL UNIT TESTS ----------------

    @Test
    public void testEquality_YardWithNullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> {

                    new Length(1.0, null);
                });
    }

    @Test
    public void testEquality_CentimetersWithNullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> {

                    new Length(1.0, null);
                });
    }
}