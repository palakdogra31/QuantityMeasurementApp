public class Length {

    private final double value;

    private final LengthUnit unit;

    // Enum for units
    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {

            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {

            return conversionFactor;
        }
    }

    // Constructor
    public Length(double value,
                  LengthUnit unit) {

        if (unit == null) {

            throw new IllegalArgumentException(
                    "Unit cannot be null");
        }

        this.value = value;

        this.unit = unit;
    }

    // Convert to inches
    private double convertToBaseUnit() {

        return this.value
                * this.unit.getConversionFactor();
    }

    // Compare method
    public boolean compare(Length other) {

        double difference =
                Math.abs(
                        this.convertToBaseUnit()
                        - other.convertToBaseUnit());

        return difference < 0.0001;
    }

    // equals override
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {

            return true;
        }

        if (obj == null) {

            return false;
        }

        if (this.getClass() != obj.getClass()) {

            return false;
        }

        Length other = (Length) obj;

        return this.compare(other);
    }
}