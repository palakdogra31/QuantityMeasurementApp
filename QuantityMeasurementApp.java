import java.util.Scanner;

public class QuantityMeasurementApp {

    // Generic method
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    // Feet check
    public static void demonstrateFeetEquality() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        System.out.println("Feet Equal? " + l1.equals(l2));
    }

    // Inches check
    public static void demonstrateInchesEquality() {
        Length l1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.INCHES);
        System.out.println("Inches Equal? " + l1.equals(l2));
    }

    // Cross-unit comparison
    public static void demonstrateFeetInchesComparison() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
        System.out.println("Feet-Inches Equal? " + l1.equals(l2));
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double v1 = readDouble(sc, "Enter first value: ");
        Length.LengthUnit u1 = readUnit(sc, "Enter first unit (FEET/INCHES): ");

        double v2 = readDouble(sc, "Enter second value: ");
        Length.LengthUnit u2 = readUnit(sc, "Enter second unit (FEET/INCHES): ");

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        System.out.println("Are lengths equal? " + l1.equals(l2));

        sc.close();
    }

    // -------- Helper Methods --------

    private static double readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.next();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number.");
            }
        }
    }

    private static Length.LengthUnit readUnit(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.next().toUpperCase();
            try {
                return Length.LengthUnit.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid unit! Please enter FEET or INCHES.");
            }
        }
    }
}