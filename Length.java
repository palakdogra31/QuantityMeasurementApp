public class Length {

    private final double value;
    private final LengthUnit unit;

    // Enum for units
    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // Constructor
    public Length(double value, LengthUnit unit) {

        this.value = value;
        this.unit = unit;
    }

    // Convert everything to inches (base unit)
    private double convertToBaseUnit() {

        return this.value *
                this.unit.getConversionFactor();
    }

    // Equality check
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

        Length other = (Length) obj;

        // Compare converted values
        return Double.compare(
                this.convertToBaseUnit(),
                other.convertToBaseUnit()) == 0;
    }
}