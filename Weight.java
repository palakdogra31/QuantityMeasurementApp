package com.apps.quantitymeasurement;

import java.util.Objects;

public class Weight {

    private final double value;
    private final WeightUnit unit;

    // Constructor with validation
    public Weight(double value, WeightUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid weight value");
        }

        this.value = value;
        this.unit = unit;
    }

    // Getter for value
    public double getValue() {
        return value;
    }

    // Getter for unit
    public WeightUnit getUnit() {
        return unit;
    }

    // Equality check
    @Override
public boolean equals(Object o) {

    if (this == o) {
        return true;
    }

    if (o == null ||
        getClass() != o.getClass()) {

        return false;
    }

    Weight thatWeight = (Weight) o;

    double thisBaseValue =
            this.convertToBaseUnit();

    double thatBaseValue =
            thatWeight.convertToBaseUnit();

    return Math.abs(
            thisBaseValue - thatBaseValue)
            < 0.0001;
}
    // HashCode consistent with equals
    @Override
    public int hashCode() {
        return Objects.hash(convertToBaseUnit());
    }

    // Convert to target unit
    public Weight convertTo(WeightUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double weightInKilogram = convertToBaseUnit();

        double convertedValue =
                targetUnit.convertFromBaseUnit(weightInKilogram);

        return new Weight(convertedValue, targetUnit);
    }

    // Add and return result in first operand unit
    public Weight add(Weight weight) {

        return addAndConvert(weight, this.unit);
    }

    // Add with explicit target unit
    public Weight add(Weight weight, WeightUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        return addAndConvert(weight, targetUnit);
    }

    // Convert current weight to base unit (kilogram)
    private double convertToBaseUnit() {

        return unit.convertToBaseUnit(value);
    }

    // Compare two weights internally
    private boolean compare(Weight thatWeight) {

        return Double.compare(
                this.convertToBaseUnit(),
                thatWeight.convertToBaseUnit()
        ) == 0;
    }

    // Helper method for addition and conversion
    private Weight addAndConvert(Weight weight,
                                 WeightUnit targetUnit) {

        double thisWeightInKg = this.convertToBaseUnit();

        double otherWeightInKg = weight.convertToBaseUnit();

        double totalWeightInKg =
                thisWeightInKg + otherWeightInKg;

        double convertedValue =
                targetUnit.convertFromBaseUnit(totalWeightInKg);

        return new Weight(convertedValue, targetUnit);
    }

    @Override
    public String toString() {

        return value + " " + unit;
    }
}