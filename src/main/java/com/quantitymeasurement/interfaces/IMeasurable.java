package com.quantitymeasurement.interfaces;

public interface IMeasurable {

    double getConversionFactor();

    double convertToBaseUnit(double value);
    double convertFromBaseUnit(double baseValue);

    // UC14 Default Method
    default boolean supportsArithmetic() {
        return true;
    }

    // UC14 Default Validation
    default void validateOperationSupport(
            String operation) {

        // Default: Length, Weight, Volume
        // support all arithmetic operations
    }
}