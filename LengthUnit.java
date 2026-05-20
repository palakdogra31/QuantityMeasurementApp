package com.apps.quantitymeasurement;
public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {

        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {

        return conversionFactor;
    }

   public double convertToBaseUnit(double value) {

    return value * conversionFactor;
}

    public double convertFromBaseUnit(
            double baseValue) {

        double convertedValue =
                baseValue / conversionFactor;

        return Math.round(convertedValue * 100.0)
                / 100.0;
    }
}