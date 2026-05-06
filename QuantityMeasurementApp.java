public class QuantityMeasurementApp {

    // Feet class
    public static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            // Same reference check
            if (this == obj)
                return true;

            // Null check
            if (obj == null)
                return false;

            // Type check
            if (this.getClass() != obj.getClass())
                return false;

            Feet other = (Feet) obj;

            // Compare values
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Inches class
    public static class Inches {

        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            // Same reference check
            if (this == obj)
                return true;

            // Null check
            if (obj == null)
                return false;

            // Type check
            if (this.getClass() != obj.getClass())
                return false;

            Inches other = (Inches) obj;

            // Compare values
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Demonstration methods using hardcoded values

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

    // Main method

    public static void main(String[] args) {

        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}
