public class QuantityMeasurementApp {

    // Generic equality method
    public static boolean demonstrateLengthEquality(
            Length l1,
            Length l2) {

        return l1.equals(l2);
    }

    // Generic comparison display
    public static void demonstrateLengthComparison(
            double value1,
            Length.LengthUnit unit1,
            double value2,
            Length.LengthUnit unit2) {

        Length l1 =
                new Length(value1, unit1);

        Length l2 =
                new Length(value2, unit2);

        System.out.println(
                value1 + " " + unit1
                        + " == "
                        + value2 + " " + unit2
                        + " ? "
                        + demonstrateLengthEquality(l1, l2));
    }

    // Main Method
    public static void main(String[] args) {

        // Feet and Inches
        demonstrateLengthComparison(
                1.0,
                Length.LengthUnit.FEET,
                12.0,
                Length.LengthUnit.INCHES);

        // Yard and Inches
        demonstrateLengthComparison(
                1.0,
                Length.LengthUnit.YARDS,
                36.0,
                Length.LengthUnit.INCHES);

        // Yard and Feet
        demonstrateLengthComparison(
                1.0,
                Length.LengthUnit.YARDS,
                3.0,
                Length.LengthUnit.FEET);

        // Centimeters and Inches
        demonstrateLengthComparison(
                1.0,
                Length.LengthUnit.CENTIMETERS,
                0.393701,
                Length.LengthUnit.INCHES);

        // Feet and Yards
        demonstrateLengthComparison(
                6.0,
                Length.LengthUnit.FEET,
                2.0,
                Length.LengthUnit.YARDS);

        // Centimeters and Feet
        demonstrateLengthComparison(
                30.48,
                Length.LengthUnit.CENTIMETERS,
                1.0,
                Length.LengthUnit.FEET);
    }
}