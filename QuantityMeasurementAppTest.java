import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {

        Length l1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length l2 =
                new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testInchesEquality() {

        Length l1 =
                new Length(1.0, Length.LengthUnit.INCHES);

        Length l2 =
                new Length(1.0, Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testFeetInchesComparison() {

        Length l1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length l2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testFeetInequality() {

        Length l1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length l2 =
                new Length(2.0, Length.LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }

    @Test
    public void testInchesInequality() {

        Length l1 =
                new Length(1.0, Length.LengthUnit.INCHES);

        Length l2 =
                new Length(2.0, Length.LengthUnit.INCHES);

        assertFalse(l1.equals(l2));
    }

    @Test
    public void testNullComparison() {

        Length l1 =
                new Length(1.0, Length.LengthUnit.FEET);

        assertFalse(l1.equals(null));
    }

    @Test
    public void testSameReference() {

        Length l1 =
                new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(l1.equals(l1));
    }

    @Test
    public void testDifferentClass() {

        Length l1 =
                new Length(1.0, Length.LengthUnit.FEET);

        assertFalse(l1.equals("test"));
    }
}