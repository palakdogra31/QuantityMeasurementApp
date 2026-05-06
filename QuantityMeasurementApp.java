public class QuantityMeasurementApp {

    // Feet equality
    public static void demonstrateFeetEquality() {

        Length l1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length l2 =
                new Length(1.0, Length.LengthUnit.FEET);

        System.out.println(
                "Feet Equal? " + l1.equals(l2));
    }

    // Inches equality
    public static void demonstrateInchesEquality() {

        Length l1 =
                new Length(1.0, Length.LengthUnit.INCHES);

        Length l2 =
                new Length(1.0, Length.LengthUnit.INCHES);

        System.out.println(
                "Inches Equal? " + l1.equals(l2));
    }

    // Cross-unit comparison
    public static void demonstrateFeetInchesComparison() {

        Length l1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length l2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println(
                "Feet-Inches Equal? " + l1.equals(l2));
    }

    // MAIN METHOD
    public static void main(String[] args) {

        demonstrateFeetEquality();

        demonstrateInchesEquality();

        demonstrateFeetInchesComparison();
    }
}