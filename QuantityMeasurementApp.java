import java.util.Scanner;

public class QuantityMeasurementApp {

    // Feet class
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;

            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Inches class (same logic)
    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;

            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Demonstration methods
    public static void demonstrateFeetEquality() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        System.out.println("Feet Equal? " + f1.equals(f2));
    }

    public static void demonstrateInchesEquality() {
        Inches i1 = new Inches(1.0);
        Inches i2 = new Inches(1.0);
        System.out.println("Inches Equal? " + i1.equals(i2));
    }



public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Feet input
    System.out.print("Enter first value in feet: ");
    double f1Value = sc.nextDouble();

    System.out.print("Enter second value in feet: ");
    double f2Value = sc.nextDouble();

    Feet f1 = new Feet(f1Value);
    Feet f2 = new Feet(f2Value);

    System.out.println("Feet Equal? " + f1.equals(f2));

    // Inches input
    System.out.print("Enter first value in inches: ");
    double i1Value = sc.nextDouble();

    System.out.print("Enter second value in inches: ");
    double i2Value = sc.nextDouble();

    Inches i1 = new Inches(i1Value);
    Inches i2 = new Inches(i2Value);

    System.out.println("Inches Equal? " + i1.equals(i2));

    sc.close();
}
}