package com.quantitymeasurement.enums;

import com.quantitymeasurement.interfaces.IMeasurable;

public enum VolumeUnit implements IMeasurable {

    MILLILITRE(0.001),
    LITRE(1.0),
    GALLON(3.78541);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}