package com.apps.quantitymeasurement;

public enum WeightUnit {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    // Convert current unit to base unit (kilogram)
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    // Convert from base unit (kilogram) to target unit
    public double convertFromBaseUnit(
        double baseValue) {

    double convertedValue =
            baseValue / conversionFactor;

    return Math.round(
            convertedValue * 100000.0)
            / 100000.0;
}
}